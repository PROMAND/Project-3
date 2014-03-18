package pl.byd.wsg.promand.project1;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.view.Window;
import android.widget.CheckBox;

public class FilterActivity extends ActionBarActivity {
    @Override
    protected void onCreate( Bundle savedInstanceState){
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_filter);

        changeBackground(R.id.filterShowBabies);
        changeBackground(R.id.filterShowPayd);
        changeBackground(R.id.filterShowSpecialNeeds);
        changeBackground(R.id.filterShowHours);

    }



    private void changeBackground(int buttonID)
    {

        final CheckBox button = (CheckBox)findViewById(buttonID);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                if(button.isChecked()){
                    button.setBackgroundResource(R.drawable.buttonfilterselected);
                }
                if(!button.isChecked()){
                    button.setBackgroundResource(R.drawable.buttonfilterunselected);
                }

            }

        });
    }
}











