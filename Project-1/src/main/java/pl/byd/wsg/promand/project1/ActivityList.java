package pl.byd.wsg.promand.project1;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.location.LocationManager;
import android.os.AsyncTask;
import android.support.v7.app.ActionBarActivity;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;
import com.google.gson.Gson;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;


public class ActivityList extends ActionBarActivity {

    private GoogleMap map;
    private ArrayList<String> values = new ArrayList<String>();
    private ArrayList<Integer> stars = new ArrayList<Integer>();
    private ArrayList<Integer> hoursfilter = new ArrayList<Integer>();
    private ArrayList<Integer> moneyfilter = new ArrayList<Integer>();
    private ArrayList<Integer> invalidfilter = new ArrayList<Integer>();
    private ArrayList<Integer> babyfilter = new ArrayList<Integer>();
    private ArrayList<Integer> commentfilter = new ArrayList<Integer>();
    private ArrayList<Integer> photofilter = new ArrayList<Integer>();


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button filterButton = (Button) findViewById(R.id.filters);

        filterButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                    Intent intent = new Intent(getApplicationContext(), FilterActivity.class);
                    startActivity(intent);
            }
        });

        Button addButton = (Button) findViewById(R.id.add);

        addButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){

                final LocationManager manager = (LocationManager) getSystemService( Context.LOCATION_SERVICE );

                if ( !manager.isProviderEnabled( LocationManager.GPS_PROVIDER ) ) {
                    buildAlertMessageNoGps();
                }
                else{
                    Intent intent = new Intent(getApplicationContext(), AddToiletActivity.class);
                    startActivity(intent);
                }
            }
        });

        map = ((MapFragment) getFragmentManager().findFragmentById(R.id.map)).getMap();
        map.setMyLocationEnabled(true);

        final String url = "http://promand.comoj.com/index.php?action=GetEntireTable&tablename=toiletinfo&api_key=4dbdb6281eda089ac926b65179ff4c29e417f6ec";

        new fetchData().execute(url);

        ListView listView = (ListView) findViewById(R.id.myList);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> av, View v, final int position, long id) {
                Intent in = new Intent(getApplicationContext(), ProfileActivity.class);
                in.putExtra("tempAddress", values.get(position));
                in.putExtra("tempStars", stars.get(position));
                in.putExtra("tempHoursFilter", hoursfilter.get(position));
                in.putExtra("tempMoneyFilter", moneyfilter.get(position));
                in.putExtra("tempInvalidFilter", invalidfilter.get(position));
                in.putExtra("tempBabyFilter", babyfilter.get(position));
                in.putExtra("tempCommentFilter", commentfilter.get(position));
                in.putExtra("tempPhotoFilter", photofilter.get(position));
                startActivity(in);
            }

        });
    }

    //@Override
    //public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        //getMenuInflater().inflate(R.menu.welcome, menu);
        //return true;
    //}

    /*@Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
    */


    // fetching live data
    // rename it showJSON to use this one.
    // attention URL doesn't work anymore because
    // we exceeded the number of times for the free version

    public void showJSON(View button) {//<--- needed
        // the url we'll be getting the data from
        // we'll be filtering by a few parameters the webserver expects
        final String url = "http://promand.comoj.com/index.php?action=GetEntireTable&tablename=toiletinfo&api_key=4dbdb6281eda089ac926b65179ff4c29e417f6ec";

        new fetchData().execute(url);
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {

        public PlaceholderFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.activity_main, container, false);
            return rootView;
        }
    }

    class fetchData extends AsyncTask<String, Void, JSONResponse> {//< backtoundas
        private Exception exception;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();

            Toast.makeText(ActivityList.this, "Pre execution", Toast.LENGTH_SHORT).show();
        }

        protected JSONResponse doInBackground(String... urls) {
            try {
                InputStream source = null;

                // fetch the data from the URL
                HttpResponse reply = new DefaultHttpClient().execute(new HttpGet(urls[0]));

                // determine the HTTP status code
                final int replyStatus = reply.getStatusLine().getStatusCode();

                // we got an error back from the server or maybe the connection is down
                if (replyStatus != HttpStatus.SC_OK) {
                    exception = new Exception("HTTP");
                    return null;
                }

                // if the HTTP request was successful
                // get the contents of the reply
                source = reply.getEntity().getContent();

                // read the JSON string that came as a reply
                Reader reader = new InputStreamReader(source);

                // our JSON helper parser instance reads the string
                // formatting it to our Java equivalent
                return new Gson().fromJson(reader, JSONResponse.class);
            } catch (Exception e) {
                this.exception = e;
                return null;
            }
        }

        @Override
        protected void onPostExecute(JSONResponse parsedResponse) {//<<----list view creation
            Toast.makeText(ActivityList.this, "Finished Async", Toast.LENGTH_SHORT).show();


            if (exception != null) {
            }

            // creating a list of all Geonames found
            List<JSONGeoname> parsedResults = parsedResponse.groceries;


            //faking the rating with random numbers
            for (JSONGeoname result : parsedResults) {
                result.rating = new Random().nextInt(6);
                values.add(result.address);
                stars.add(result.rating);
                hoursfilter.add(result.workingTime);
                moneyfilter.add(result.payable);
                invalidfilter.add(result.suitableForSpecialNeeds);
                babyfilter.add(result.suitableForBabies);
                commentfilter.add(result.IsComment);
                photofilter.add(0);
            }


            ListView listView = (ListView) findViewById(R.id.myList);
            ToiletAdapter adapter = new ToiletAdapter(ActivityList.this,
                    R.layout.list, parsedResults);

            listView.setAdapter(adapter);

        }
    }

    private void buildAlertMessageNoGps() {
        final AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Your GPS seems to be disabled, do you want to enable it?")
                .setCancelable(false)
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    public void onClick(@SuppressWarnings("unused") final DialogInterface dialog, @SuppressWarnings("unused") final int id) {
                        startActivity(new Intent(android.provider.Settings.ACTION_LOCATION_SOURCE_SETTINGS));
                    }
                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    public void onClick(final DialogInterface dialog, @SuppressWarnings("unused") final int id) {
                        dialog.cancel();
                    }
                });
        final AlertDialog alert = builder.create();
        alert.show();
    }
}

