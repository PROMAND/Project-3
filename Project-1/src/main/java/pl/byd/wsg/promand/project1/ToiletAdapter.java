package pl.byd.wsg.promand.project1;

/**
 * Created by Ksenija on 20/03/14.
 */

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.List;

public class ToiletAdapter extends ArrayAdapter<JSONGeoname> {



    int resource;
    String response;
    Context context;
    //Initialize adapter
    public ToiletAdapter(Context context, int resource, List<JSONGeoname> toilets) {
        super(context, resource, toilets);
        this.resource=resource;

    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        RelativeLayout listView;
        //Get the current alert object
        JSONGeoname tol = getItem(position);

        //Inflate the view
        if(convertView==null)
        {
            listView = new RelativeLayout(getContext());
            String inflater = Context.LAYOUT_INFLATER_SERVICE;
            LayoutInflater vi;
            vi = (LayoutInflater)getContext().getSystemService(inflater);
            vi.inflate(resource, listView, true);
        }
        else
        {
            listView = (RelativeLayout) convertView;
        }
        //Get the text boxes from the listitem.xml file
        TextView textView = (TextView) listView.findViewById(R.id.address);
        ImageView number = (ImageView) listView.findViewById(R.id.number);
        ImageView arrow = (ImageView) listView.findViewById(R.id.arrow);
        ImageView star = (ImageView) listView.findViewById(R.id.starempty);
        ImageView star2 = (ImageView) listView.findViewById(R.id.starempty2);
        ImageView star3 = (ImageView) listView.findViewById(R.id.starempty3);
        ImageView star4 = (ImageView) listView.findViewById(R.id.starempty4);
        ImageView star5 = (ImageView) listView.findViewById(R.id.starempty5);
        ImageView hour = (ImageView) listView.findViewById(R.id.hour);
        ImageView euro = (ImageView) listView.findViewById(R.id.euro);
        ImageView invalid = (ImageView) listView.findViewById(R.id.invalid);
        ImageView baby = (ImageView) listView.findViewById(R.id.baby);
        ImageView comment = (ImageView) listView.findViewById(R.id.comment);
        ImageView camera = (ImageView) listView.findViewById(R.id.camera);
        ImageView blocker = (ImageView) listView.findViewById(R.id.hiddenFilterController);

        //Assign the appropriate data from our alert object above
        textView.setText(tol.address);

        if ((position +1) == 1) {
            number.setImageResource(R.drawable.number1);
        } else if ((position +1) == 2) {
            number.setImageResource(R.drawable.number2);
        } else if ((position +1) == 3) {
            number.setImageResource(R.drawable.number3);
        } else if ((position +1) == 4) {
            number.setImageResource(R.drawable.number4);
        }  else if ((position +1) == 5) {
            number.setImageResource(R.drawable.number5);
        } else if ((position +1) == 6) {
            number.setImageResource(R.drawable.number6);
        } else if ((position +1) == 7) {
            number.setImageResource(R.drawable.number7);
        } else if ((position +1) == 8) {
            number.setImageResource(R.drawable.number8);
        } else if ((position +1) == 9) {
            number.setImageResource(R.drawable.number9);
        }
        else {
            number.setImageResource(R.drawable.number10);
        }


        if(tol.rating == 1) {
            star.setImageResource(R.drawable.star3);
            star2.setImageResource(R.drawable.emptystar2);
            star3.setImageResource(R.drawable.emptystar2);
            star4.setImageResource(R.drawable.emptystar2);
            star5.setImageResource(R.drawable.emptystar2);
        } else if (tol.rating == 2) {
            star.setImageResource(R.drawable.star3);
            star2.setImageResource(R.drawable.star3);
            star3.setImageResource(R.drawable.emptystar2);
            star4.setImageResource(R.drawable.emptystar2);
            star5.setImageResource(R.drawable.emptystar2);
        } else if(tol.rating == 3) {
            star.setImageResource(R.drawable.star3);
            star2.setImageResource(R.drawable.star3);
            star3.setImageResource(R.drawable.star3);
            star4.setImageResource(R.drawable.emptystar2);
            star5.setImageResource(R.drawable.emptystar2);
        } else if(tol.rating == 4) {
            star.setImageResource(R.drawable.star3);
            star2.setImageResource(R.drawable.star3);
            star3.setImageResource(R.drawable.star3);
            star4.setImageResource(R.drawable.star3);
            star5.setImageResource(R.drawable.emptystar2);
        } else if(tol.rating == 5) {
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

        if ((tol.workingTime) == 1) {
            hour.setImageResource(R.drawable.hoursbetter);
        } else {
            hour.setImageResource(R.drawable.hourscancelled);
        }
        if ((tol.payable) == 1) {
            euro.setImageResource(R.drawable.euro);
        } else {
            euro.setImageResource(R.drawable.eurocancelled);
        }
        if ((tol.suitableForSpecialNeeds) == 1) {
            invalid.setImageResource(R.drawable.invalid);
        } else {
            invalid.setImageResource(R.drawable.invalidcancelled);
        }
        if ((tol.suitableForBabies) == 1) {
            baby.setImageResource(R.drawable.baby);
        } else {
            baby.setImageResource(R.drawable.babycancelled);
        }
        if ((tol.IsComment) == 1) {
            comment.setImageResource(R.drawable.comment);
        } else {
            comment.setImageResource(R.drawable.commentcancelled);
        }

        camera.setImageResource(R.drawable.cameracancelled);


        return listView;
    }

}