package pl.byd.wsg.promand.project1;

/**
 * Created by Tommy on 16.3.2014.
 */
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationManager;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.util.Log;
import android.view.Window;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.Toast;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpParams;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

import java.util.List;
import java.util.Locale;

public class AddToiletActivity extends Activity {

    private RatingBar ratingBar;
    private Button submit;
    private EditText location2;
    private CheckBox hours;
    private CheckBox money;
    private CheckBox invalid;
    private CheckBox baby;
    ActivityList actList = new ActivityList();
    private Typeface newFont;
    private  EditText Comment;
    private EditText result;
    private Context context=null;
    private ProgressDialog dialog = null;
    private double longitude, latitude;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();

        StrictMode.setThreadPolicy(policy);

        addListenerOnButton();

        context=this;

        result=(EditText)findViewById(R.id.locationHolder);

        dialog = ProgressDialog.show(context, "","Please wait..", true);
        GetCurrentAddress currentadd = new GetCurrentAddress();
        currentadd.execute();
    }

    public  String getAddress(Context ctx, double latitude, double longitude) {
        StringBuilder result = new StringBuilder();

        try {
            Geocoder geocoder = new Geocoder(ctx, Locale.getDefault());
            List<Address> addresses = geocoder.getFromLocation(latitude, longitude, 1);
            if (addresses.size() > 0) {

                String address = addresses.get(0).getAddressLine(0);
                //String city = addresses.get(0).getAddressLine(1);
                //String country = addresses.get(0).getAddressLine(2);

                result.append(address+" ");
                //result.append(city+" ");
                //result.append(country);

            }
        } catch (IOException e) {
            Log.e("tag", e.getMessage());
        }

        return result.toString();
    }

    private class GetCurrentAddress extends AsyncTask<String, Void, String> {

        @Override
        protected String doInBackground(String... urls) {
            LocationManager lm = (LocationManager)getSystemService(Context.LOCATION_SERVICE);
            Location location = lm.getLastKnownLocation(LocationManager.GPS_PROVIDER);
            longitude = location.getLongitude();
            latitude = location.getLatitude();
            String address=	getAddress(context, latitude, longitude);
            return address;
        }

        @Override
        protected void onPostExecute(String resultString) {
            dialog.dismiss();
            result.setText(resultString);

        }
    }

    public void addListenerOnButton() {

        ratingBar = (RatingBar) findViewById(R.id.ratingBar);
        location2 = (EditText) findViewById(R.id.locationHolder);
        hours = (CheckBox) findViewById(R.id.checkBox);
        money = (CheckBox) findViewById(R.id.checkBox2);
        invalid = (CheckBox) findViewById(R.id.checkBox3);
        baby = (CheckBox) findViewById(R.id.checkBox4);
        Comment= (EditText) findViewById(R.id.editText);
        submit = (Button) findViewById(R.id.submit);

        final Context context2 = this;




        submit.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Toast.makeText(AddToiletActivity.this, "INNN", Toast.LENGTH_SHORT).show();
                int isHours;
                int babies;
                int special;
                int isMoney;
                int rating=0;
                //    double latitude=0.0;
                // double longitude=0.0;
                String address;
                String comment="";

                comment=(Comment.getText().toString());
                comment = comment.replaceAll(" ", "+");
                address = (location2.getText().toString());
                address = address.replaceAll(" ", "+");
                rating=((int) ratingBar.getRating());
                if(hours.isChecked()) {
                    isHours=1;
                }
                else {
                    isHours=0;
                }

                if(money.isChecked()) {
                    isMoney=1;
                }
                else {
                    isMoney=0;
                }

                if(invalid.isChecked()) {
                    special=1;
                }
                else {
                    special=0;
                }

                if(baby.isChecked()) {
                    babies=1;
                }
                else {
                    babies=0;
                }

                HttpParams httpParams = new BasicHttpParams();

                HttpClient client = new DefaultHttpClient(httpParams);



                final String AddNewToilet;
                int hasComment=1;
                if(comment.length()>0){
                    //Toast.makeText(AddToiletActivity.this, "IN Comment= "+comment, Toast.LENGTH_SHORT).show();
                    AddNewToilet =  "http://promand.comoj.com/index.php?action=insertToiletInfo&address="+address+"&payable="+isMoney+"&suitableForBabies="+babies+"&suitableForSpecialNeeds="+special+"&workingTime="+isHours+"&isShown=0&latitude="+latitude+"&longitude="+longitude+"&IsComment=1&api_key=4dbdb6281eda089ac926b65179ff4c29e417f6ec";
                } else {
                    //Toast.makeText(AddToiletActivity.this, "IN No Comment= "+comment, Toast.LENGTH_SHORT).show();
                    AddNewToilet =  "http://promand.comoj.com/index.php?action=insertToiletInfo&address="+address+"&payable="+isMoney+"&suitableForBabies="+babies+"&suitableForSpecialNeeds="+special+"&workingTime="+isHours+"&isShown=0&latitude="+latitude+"&longitude="+longitude+"&IsComment=0&api_key=4dbdb6281eda089ac926b65179ff4c29e417f6ec";
                }

                HttpPost request = new HttpPost(AddNewToilet);
                try {
                    HttpResponse response = client.execute(request);

                    String result= ""+ EntityUtils.toString(response.getEntity());
                    result = result.substring(25);
                    result = result.substring(0, result.length()-1);
                    Toast.makeText(AddToiletActivity.this, result, Toast.LENGTH_SHORT).show();
                    Toast.makeText(AddToiletActivity.this, "toilet", Toast.LENGTH_SHORT).show();
                    final String  addRating=  "http://promand.comoj.com/index.php?action=insertRating&rating="+rating+"&_toiletID="+result+"&api_key=4dbdb6281eda089ac926b65179ff4c29e417f6ec";

                    HttpPost request2 = new HttpPost(addRating);
                    try{
                        HttpResponse response2 = client.execute(request2);
                        Toast.makeText(AddToiletActivity.this, "RATING", Toast.LENGTH_SHORT).show();
                    }catch(IOException e){
                        Toast.makeText(AddToiletActivity.this, "FailRating", Toast.LENGTH_SHORT).show();
                    }
                    if(comment.length()>0){
                        final String addComment= "http://promand.comoj.com/index.php?action=insertcomment&comment="+comment+"&_toiletID="+result+"&api_key=4dbdb6281eda089ac926b65179ff4c29e417f6ec";

                        HttpPost request3 = new HttpPost(addComment);
                        try{
                            HttpResponse response3 = client.execute(request3);
                            Toast.makeText(AddToiletActivity.this, "comments", Toast.LENGTH_SHORT).show();

                        }catch (IOException e){
                            Toast.makeText(AddToiletActivity.this, "FailComment", Toast.LENGTH_SHORT).show();
                        }
                    }


                } catch(IOException e){
                    Toast.makeText(AddToiletActivity.this, "Fail", Toast.LENGTH_SHORT).show();
                }

                Intent intent = new Intent(getApplicationContext(),ActivityList.class);
                startActivity(intent);
            }

        });

    }


}