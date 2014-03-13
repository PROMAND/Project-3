package pl.byd.wsg.promand.project1;

/**
 * Created by Tommy on 13.3.2014.
 */
import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;


public class ActivityList extends Activity {
    private final String TAG = "MyActivity";
    private String[] values = new String[]{"Didlaukio street 59", "Akmenų g. 6", "Rodūnios Road 10a",
            "Latviu str. 7", "Katedros Sq. 1", "Vilniaus g. 23", "Konstitucijos pr. 20A", "Smolensko str. 10", "Sodų g. 22", "Gedimino av. 12"};
    private int[] stars = new int[]{3,4,5,2,1,5,3,0,2,2};

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListView listView = (ListView) findViewById(R.id.myList);
        ListAdapter adapter = new ListAdapter(this, values, stars);
        listView.setAdapter(adapter);
    }
}
