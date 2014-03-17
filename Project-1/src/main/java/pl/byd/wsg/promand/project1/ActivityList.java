package pl.byd.wsg.promand.project1;

/**
 * Created by Tommy on 13.3.2014.
 */

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;


public class ActivityList extends Activity {
    private final String TAG = "MyActivity";
    private String[] values = new String[]{"Didlaukio street 59", "Akmenų g. 6", "Rodūnios Road 10a",
            "Latviu str. 7", "Katedros Sq. 1", "Vilniaus g. 23", "Konstitucijos pr. 20A", "Smolensko str. 10", "Sodų g. 22", "Gedimino av. 12"};
    private int[] stars = new int[]{3,4,5,2,1,5,3,0,2,2};
    private boolean[] hoursfilter = new boolean[]{true, false, false, true, false, true, true, true, false, false};
    private boolean[] moneyfilter = new boolean[]{false, true, true, false, true, false, false, true, false, true};
    private boolean[] invalidfilter = new boolean[]{true, false, false, true, true, false, false, false, true, true};
    private boolean[] babyfilter = new boolean[]{false, true, true, true, true, true, false, false, true, false};
    private boolean[] commentfilter = new boolean[]{false, true, true, false, false, true, true, false, true, false};
    private boolean[] photofilter = new boolean[]{true, false, false, false, true, true, true, true, false, true};

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListView listView = (ListView) findViewById(R.id.myList);
        ListAdapter adapter = new ListAdapter(this, values, stars, hoursfilter, moneyfilter, invalidfilter, babyfilter, commentfilter, photofilter);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> av, View v, final int position, long id) {
                Intent in = new Intent(getApplicationContext(), ProfileActivity.class);
                in.putExtra("tempAddress", values[position]);
                in.putExtra("tempStars", stars[position]);
                in.putExtra("tempHoursFilter", hoursfilter[position]);
                in.putExtra("tempMoneyFilter", moneyfilter[position]);
                in.putExtra("tempInvalidFilter", invalidfilter[position]);
                in.putExtra("tempBabyFilter", babyfilter[position]);
                in.putExtra("tempCommentFilter", commentfilter[position]);
                in.putExtra("tempPhotoFilter", photofilter[position]);
                startActivity(in);
            }

        });

        Button startPlaying = (Button) findViewById(R.id.filters);

        startPlaying.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent intent = new Intent(getApplicationContext(), FilterActivity.class);
                startActivity(intent);
            }
        });

        Button addButton = (Button) findViewById(R.id.add);

        addButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent intent = new Intent(getApplicationContext(), AddToiletActivity.class);
                startActivity(intent);
            }
        });

    }
}
