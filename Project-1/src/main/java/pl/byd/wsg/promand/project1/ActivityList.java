package pl.byd.wsg.promand.project1;

/**
 * Created by Tommy on 13.3.2014.
 */
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;


public class ActivityList extends Activity {
    private final String TAG = "MyActivity";
    private ArrayList<String> values = new ArrayList<String>();
    private ArrayList<Integer> stars = new ArrayList<Integer>();
    private ArrayList<Boolean> hoursfilter = new ArrayList<Boolean>();
    private ArrayList<Boolean> moneyfilter = new ArrayList<Boolean>();
    private ArrayList<Boolean> invalidfilter = new ArrayList<Boolean>();
    private ArrayList<Boolean> babyfilter = new ArrayList<Boolean>();
    private ArrayList<Boolean> commentfilter = new ArrayList<Boolean>();
    private ArrayList<Boolean> photofilter = new ArrayList<Boolean>();

    private ListAdapter adapter;

    Button addButton;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListView listView = (ListView) findViewById(R.id.myList);
        adapter = new ListAdapter(this, values, stars, hoursfilter, moneyfilter, invalidfilter, babyfilter, commentfilter, photofilter);
        listView.setAdapter(adapter);

        values.add("Didlaukio street 59");
        values.add("Akmenų g. 6");
        values.add("Rodūnios Road 10a");
        values.add("Latviu str. 7");
        values.add("Katedros Sq. 1");
        values.add("Vilniaus g. 23");
        values.add("Konstitucijos pr. 20A");
        values.add("Smolensko str. 10");
        values.add("Sodų g. 22");

        stars.add(2);
        stars.add(1);
        stars.add(4);
        stars.add(5);
        stars.add(2);
        stars.add(3);
        stars.add(1);
        stars.add(5);
        stars.add(2);

        hoursfilter.add(true);
        hoursfilter.add(false);
        hoursfilter.add(false);
        hoursfilter.add(true);
        hoursfilter.add(true);
        hoursfilter.add(false);
        hoursfilter.add(true);
        hoursfilter.add(false);
        hoursfilter.add(false);

        moneyfilter.add(false);
        moneyfilter.add(false);
        moneyfilter.add(true);
        moneyfilter.add(false);
        moneyfilter.add(true);
        moneyfilter.add(true);
        moneyfilter.add(true);
        moneyfilter.add(true);
        moneyfilter.add(false);

        invalidfilter.add(true);
        invalidfilter.add(true);
        invalidfilter.add(false);
        invalidfilter.add(false);
        invalidfilter.add(false);
        invalidfilter.add(true);
        invalidfilter.add(false);
        invalidfilter.add(true);
        invalidfilter.add(true);

        babyfilter.add(true);
        babyfilter.add(false);
        babyfilter.add(false);
        babyfilter.add(true);
        babyfilter.add(false);
        babyfilter.add(true);
        babyfilter.add(false);
        babyfilter.add(true);
        babyfilter.add(true);

        commentfilter.add(true);
        commentfilter.add(false);
        commentfilter.add(false);
        commentfilter.add(true);
        commentfilter.add(false);
        commentfilter.add(true);
        commentfilter.add(false);
        commentfilter.add(true);
        commentfilter.add(true);

        photofilter.add(true);
        photofilter.add(false);
        photofilter.add(false);
        photofilter.add(true);
        photofilter.add(false);
        photofilter.add(true);
        photofilter.add(false);
        photofilter.add(true);
        photofilter.add(true);

        addListenerOnButton();
    }

    public void addListenerOnButton() {
        final Context context = this;
        addButton = (Button) findViewById(R.id.addButton2);
        addButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {

                Intent intent = new Intent(context, AddToiletActivity.class);
                startActivity(intent);
            }
        });

    }

    public void addAddress(String x) {
        values.add(x);
    }
    public void addStars(Integer x) {
        stars.add(x);
    }
    public void addHours(Boolean x) {
        hoursfilter.add(x);
    }
    public void addMoney(Boolean x) {
        moneyfilter.add(x);
    }
    public void addInvalid(Boolean x) {
        invalidfilter.add(x);
    }
    public void addBabies(Boolean x) {
        babyfilter.add(x);
    }

    public void addComment(Boolean x) {
        commentfilter.add(x);
    }

    public void addPhoto(Boolean x) {
        photofilter.add(x);
    }


}
