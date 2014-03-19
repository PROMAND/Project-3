package pl.byd.wsg.promand.project1;

/**
 * Created by Tommy on 16.3.2014.
 */
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.graphics.Typeface;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationManager;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.Window;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RatingBar;

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
    private EditText result;
    private Button btngetAddress;
    private Context context=null;
    private ProgressDialog dialog = null;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        addListenerOnButton();

        context=this;

        result=(EditText)findViewById(R.id.locationHolder);

        dialog = ProgressDialog.show(context, "","Please wait..", true);
        GetCurrentAddress currentadd=new GetCurrentAddress();
        currentadd.execute();
    }

    public  String getAddress(Context ctx, double latitude, double longitude) {
        StringBuilder result = new StringBuilder();

        try {
            Geocoder geocoder = new Geocoder(ctx, Locale.getDefault());
            List<Address> addresses = geocoder.getFromLocation(latitude, longitude, 1);
            if (addresses.size() > 0) {

                String address_ = addresses.get(0).getAddressLine(0);
                String city_ = addresses.get(0).getAddressLine(1);
                String country_ = addresses.get(0).getAddressLine(2);

                result.append(address_+" ");
                result.append(city_+" ");
                result.append(country_);

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
            double longitude = location.getLongitude();
            double latitude = location.getLatitude();
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

        submit = (Button) findViewById(R.id.submit);

        final Context context2 = this;

        /*
        submit.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                //add stuff here

                actList.addAddress(location2.getText().toString());
                actList.addStars((int) ratingBar.getRating());
                if(hours.isChecked()) {
                    actList.addHours(true);
                }
                else {
                    actList.addHours(false);
                }

                if(money.isChecked()) {
                    actList.addMoney(true);
                }
                else {
                    actList.addMoney(false);
                }

                if(invalid.isChecked()) {
                    actList.addInvalid(true);
                }
                else {
                    actList.addInvalid(false);
                }

                if(baby.isChecked()) {
                    actList.addBabies(true);
                }
                else {
                    actList.addBabies(false);
                }

                actList.addComment(true);

                actList.addPhoto(true);


                Intent intent = new Intent(context2, ActivityList.class);
                startActivity(intent);

            }

        });

*/
    }

}