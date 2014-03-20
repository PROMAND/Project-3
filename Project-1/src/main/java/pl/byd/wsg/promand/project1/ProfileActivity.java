package pl.byd.wsg.promand.project1;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;

public class ProfileActivity extends Activity {
    private static ArrayList<String> comments = new ArrayList<String>();
    private ArrayAdapter<String> listAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        /*comments.clear();
        comments.add("By Charles - Great toilet!");
        comments.add("By Laura - Very clean");
        comments.add("By Richard - I recommend this toilet");*/
        Bundle extras = getIntent().getExtras();

        String tempAddress = extras.getString("tempAddress");
        int tempStars = extras.getInt("tempStars");
        int tempHoursFilter = extras.getInt("tempHoursFilter");
        int tempMoneyFilter = extras.getInt("tempMoneyFilter");
        int tempInvalidFilter = extras.getInt("tempInvalidFilter");
        int tempBabyFilter = extras.getInt("tempBabyFilter");
        int tempCommentFilter = extras.getInt("tempCommentFilter");
        int tempPhotoFilter = extras.getInt("tempPhotoFilter");

        TextView txt = (TextView) this.findViewById(R.id.toiletAddress);
        final RatingBar ratingBar = (RatingBar) this.findViewById(R.id.ratingBar);
        /*ImageView star = (ImageView) this.findViewById(R.id.starempty);
        ImageView star2 = (ImageView) this.findViewById(R.id.starempty2);
        ImageView star3 = (ImageView) this.findViewById(R.id.starempty3);
        ImageView star4 = (ImageView) this.findViewById(R.id.starempty4);
        ImageView star5 = (ImageView) this.findViewById(R.id.starempty5);*/
        ImageView hour = (ImageView) this.findViewById(R.id.hour);
        ImageView euro = (ImageView) this.findViewById(R.id.euro);
        ImageView invalid = (ImageView) this.findViewById(R.id.invalid);
        ImageView baby = (ImageView) this.findViewById(R.id.baby);
        ImageView photo = (ImageView) this.findViewById(R.id.photo);


        txt.setText(tempAddress);

        if(tempStars == 1) {
            ratingBar.setRating(1);
        } else if (tempStars == 2) {
            ratingBar.setRating(2);
        } else if(tempStars == 3) {
            ratingBar.setRating(3);
        } else if(tempStars == 4) {
            ratingBar.setRating(4);
        } else if(tempStars == 5) {
            ratingBar.setRating(5);
        }  else {
            ratingBar.setRating(0);
        }

        if (tempHoursFilter==1) {
            hour.setImageResource(R.drawable.hoursbetter);
        } else {
            hour.setImageResource(R.drawable.hourscancelled);
        }
        if (tempMoneyFilter==1) {
            euro.setImageResource(R.drawable.euro);
        } else {
            euro.setImageResource(R.drawable.eurocancelled);
        }
        if (tempInvalidFilter==1) {
            invalid.setImageResource(R.drawable.invalid);
        } else {
            invalid.setImageResource(R.drawable.invalidcancelled);
        }
        if (tempBabyFilter==1) {
            baby.setImageResource(R.drawable.baby);
        } else {
            baby.setImageResource(R.drawable.babycancelled);
        }
        if (tempPhotoFilter==1) {
            photo.setImageResource(R.drawable.toiletexample);
            Button btn = (Button) this.findViewById(R.id.btnadd);
            btn.setVisibility(View.GONE);
        } else {
            photo.setImageResource(R.drawable.nopicture);
            TextView photoTxt = (TextView) this.findViewById(R.id.photoText);
            photoTxt.setText("No photo");
        }

        if(tempCommentFilter==1) {
            ListView listView = (ListView)this.findViewById(R.id.commentslist);
            listAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, comments);
            listView.setAdapter(listAdapter);
            ViewGroup.LayoutParams lp = (ViewGroup.LayoutParams) listView.getLayoutParams();
            Collections.reverse(comments);
            for(int i=0; i<comments.size(); i++) {
                listView = (ListView)this.findViewById(R.id.commentslist);
                //Toast.makeText(ProfileActivity.this, ""+listView.getHeight(), Toast.LENGTH_LONG).show();
                lp.height = lp.height+75;
            }
            listView.setLayoutParams(lp);
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

        final Button voteButton = (Button) findViewById(R.id.vote);

        voteButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                ratingBar.setEnabled(false);
                voteButton.setEnabled(false);
                int tempVote = (int)ratingBar.getRating();
                Toast.makeText(ProfileActivity.this, "Vote submitted "+tempVote, Toast.LENGTH_LONG).show();
            }
        });
    }

    /**
     * Set up the {@link android.app.ActionBar}, if the API is available.
     */
    /*@TargetApi(Build.VERSION_CODES.HONEYCOMB)
    private void setupActionBar() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
            getActionBar().setDisplayHomeAsUpEnabled(true);
        }
    }



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
        button.setEnabled(false);
        TextView commentsTxt = (TextView) this.findViewById(R.id.commenttext);
        String noComments = commentsTxt.getText().toString();
        if((noComments!=null) && (noComments.equals("No comments"))) {
            ListView commentsList = (ListView)this.findViewById(R.id.commentslist);
            listAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, comments);
            commentsList.setAdapter(listAdapter);

            commentsTxt.setText("Comments");
            commentsList.setVisibility(View.VISIBLE);
            EditText editName = (EditText)this.findViewById(R.id.nameText);
            EditText editText = (EditText)this.findViewById(R.id.editText);

            String name = editName.getText().toString();
            String comment = editText.getText().toString();

            String done = "By "+name+" - "+comment;
            //Toast.makeText(this, done, Toast.LENGTH_LONG).show();
            comments.add(done);
            editName.setText("");
            editText.setText("");
            listAdapter.notifyDataSetChanged();
            ViewGroup.LayoutParams lp = (ViewGroup.LayoutParams) commentsList.getLayoutParams();
            lp.height = commentsList.getHeight()+75;
            commentsList.setLayoutParams(lp);
            Toast.makeText(ProfileActivity.this, "Comment added", Toast.LENGTH_LONG).show();
        } else {
            ListView commentsList = (ListView)this.findViewById(R.id.commentslist);
            EditText editName = (EditText)this.findViewById(R.id.nameText);
            EditText editText = (EditText)this.findViewById(R.id.editText);

            String name = editName.getText().toString();
            String comment = editText.getText().toString();

            String done = "By "+name+" - "+comment;

            comments.add(done);
            editName.setText("");
            editText.setText("");
            listAdapter.notifyDataSetChanged();
            ViewGroup.LayoutParams lp = (ViewGroup.LayoutParams) commentsList.getLayoutParams();
            lp.height = commentsList.getHeight()+75;
            commentsList.setLayoutParams(lp);
            Toast.makeText(ProfileActivity.this, "Comment added", Toast.LENGTH_LONG).show();
        }
    }
}