package pl.byd.wsg.promand.project1;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class ProfileActivity extends Activity {
    private static ArrayList<String> comments = new ArrayList<String>();
    private ArrayAdapter<String> listAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        comments.add("By Charles - Great toilet!");
        comments.add("By Laura - Very clean");
        comments.add("By Richard - I recommend this toilet");
        Bundle extras = getIntent().getExtras();

        String tempAddress = extras.getString("tempAddress");
        int tempStars = extras.getInt("tempStars");
        boolean tempHoursFilter = extras.getBoolean("tempHoursFilter");
        boolean tempMoneyFilter = extras.getBoolean("tempMoneyFilter");
        boolean tempInvalidFilter = extras.getBoolean("tempInvalidFilter");
        boolean tempBabyFilter = extras.getBoolean("tempBabyFilter");
        boolean tempCommentFilter = extras.getBoolean("tempCommentFilter");
        boolean tempPhotoFilter = extras.getBoolean("tempPhotoFilter");

        TextView txt = (TextView) this.findViewById(R.id.toiletAddress);
        ImageView star = (ImageView) this.findViewById(R.id.starempty);
        ImageView star2 = (ImageView) this.findViewById(R.id.starempty2);
        ImageView star3 = (ImageView) this.findViewById(R.id.starempty3);
        ImageView star4 = (ImageView) this.findViewById(R.id.starempty4);
        ImageView star5 = (ImageView) this.findViewById(R.id.starempty5);
        ImageView hour = (ImageView) this.findViewById(R.id.hour);
        ImageView euro = (ImageView) this.findViewById(R.id.euro);
        ImageView invalid = (ImageView) this.findViewById(R.id.invalid);
        ImageView baby = (ImageView) this.findViewById(R.id.baby);
        ImageView photo = (ImageView) this.findViewById(R.id.photo);


        txt.setText(tempAddress);

        if(tempStars == 1) {
            star.setImageResource(R.drawable.star3);
            star2.setImageResource(R.drawable.emptystar2);
            star3.setImageResource(R.drawable.emptystar2);
            star4.setImageResource(R.drawable.emptystar2);
            star5.setImageResource(R.drawable.emptystar2);
        } else if (tempStars == 2) {
            star.setImageResource(R.drawable.star3);
            star2.setImageResource(R.drawable.star3);
            star3.setImageResource(R.drawable.emptystar2);
            star4.setImageResource(R.drawable.emptystar2);
            star5.setImageResource(R.drawable.emptystar2);
        } else if(tempStars == 3) {
            star.setImageResource(R.drawable.star3);
            star2.setImageResource(R.drawable.star3);
            star3.setImageResource(R.drawable.star3);
            star4.setImageResource(R.drawable.emptystar2);
            star5.setImageResource(R.drawable.emptystar2);
        } else if(tempStars == 4) {
            star.setImageResource(R.drawable.star3);
            star2.setImageResource(R.drawable.star3);
            star3.setImageResource(R.drawable.star3);
            star4.setImageResource(R.drawable.star3);
            star5.setImageResource(R.drawable.emptystar2);
        } else if(tempStars == 5) {
            star.setImageResource(R.drawable.star3);
            star2.setImageResource(R.drawable.star3);
            star3.setImageResource(R.drawable.star3);
            star4.setImageResource(R.drawable.star3);
            star5.setImageResource(R.drawable.star3);
        }  else {
            star.setImageResource(R.drawable.emptystar2);
            star2.setImageResource(R.drawable.emptystar2);
            star3.setImageResource(R.drawable.emptystar2);
            star4.setImageResource(R.drawable.emptystar2);
            star5.setImageResource(R.drawable.emptystar2);
        }

        if (tempHoursFilter) {
            hour.setImageResource(R.drawable.hoursbetter);
        } else {
            hour.setImageResource(R.drawable.hourscancelled);
        }
        if (tempMoneyFilter) {
            euro.setImageResource(R.drawable.euro);
        } else {
            euro.setImageResource(R.drawable.eurocancelled);
        }
        if (tempInvalidFilter) {
            invalid.setImageResource(R.drawable.invalid);
        } else {
            invalid.setImageResource(R.drawable.invalidcancelled);
        }
        if (tempBabyFilter) {
            baby.setImageResource(R.drawable.baby);
        } else {
            baby.setImageResource(R.drawable.babycancelled);
        }
        if (tempPhotoFilter) {
            photo.setImageResource(R.drawable.toiletexample);
            Button btn = (Button) this.findViewById(R.id.btnadd);
            btn.setVisibility(View.GONE);
        } else {
            photo.setImageResource(R.drawable.nopicture);
            TextView photoTxt = (TextView) this.findViewById(R.id.photoText);
            photoTxt.setText("No photo");
        }

        if(tempCommentFilter) {
            ListView listView = (ListView)this.findViewById(R.id.commentslist);
            listAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, comments);
            listView.setAdapter(listAdapter);
            //listAdapter.notifyDataSetChanged();
        } else {
            TextView commentsTxt = (TextView) this.findViewById(R.id.commenttext);
            commentsTxt.setText("No comments");
            ListView comments = (ListView) this.findViewById(R.id.commentslist);
            comments.setVisibility(View.GONE);
        }

        Button reportButton = (Button) findViewById(R.id.report);

        reportButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent intent = new Intent(getApplicationContext(), ReportActivity.class);
                startActivity(intent);
            }
        });
    }

    /**
     * Set up the {@link android.app.ActionBar}, if the API is available.
     */
    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    private void setupActionBar() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
            getActionBar().setDisplayHomeAsUpEnabled(true);
        }
    }

    /*

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
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

    public void comment(View button) {
        EditText editName = (EditText)this.findViewById(R.id.nameText);
        EditText editText = (EditText)this.findViewById(R.id.editText);

        String name = editName.getText().toString();
        String comment = editText.getText().toString();

        String done = "By "+name+" - "+comment;

        comments.add(done);
        editName.setText("");
        editText.setText("");
        listAdapter.notifyDataSetChanged();
    }
}
