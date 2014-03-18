package pl.byd.wsg.promand.project1;

/**
 * Created by Tommy on 16.3.2014.
 */
import android.app.Activity;
import android.content.Context;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.Window;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RatingBar;

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

    @Override
    public void onCreate(Bundle savedInstanceState) {
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);


        addListenerOnButton();

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