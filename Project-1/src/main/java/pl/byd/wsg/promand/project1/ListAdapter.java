package pl.byd.wsg.promand.project1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class ListAdapter extends ArrayAdapter<String> {
    private final Context context;
    private final ArrayList<String> values;
    private final ArrayList<Integer> stars;
    private final ArrayList<Boolean> hoursfilter;
    private final ArrayList<Boolean> moneyfilter;
    private final ArrayList<Boolean> invalidfilter;
    private final ArrayList<Boolean> babyfilter;
    private final ArrayList<Boolean> commentfilter;
    private final ArrayList<Boolean> photofilter;

    public ListAdapter(Context context, ArrayList<String> values,  ArrayList<Integer> stars, ArrayList<Boolean> hoursfilter, ArrayList<Boolean> moneyfilter,
                       ArrayList<Boolean> invalidfilter, ArrayList<Boolean> babyfilter, ArrayList<Boolean> commentfilter, ArrayList<Boolean> photofilter) {
        super(context, R.layout.list, values);
        this.context = context;
        this.values = values;
        this.stars = stars;
        this.hoursfilter = hoursfilter;
        this.moneyfilter = moneyfilter;
        this.invalidfilter = invalidfilter;
        this.babyfilter = babyfilter;
        this.commentfilter = commentfilter;
        this.photofilter = photofilter;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View rowView = inflater.inflate(R.layout.list, parent, false);

        //add stuff here to show them on the list
        TextView textView = (TextView) rowView.findViewById(R.id.address);
        ImageView number = (ImageView) rowView.findViewById(R.id.number);
        ImageView arrow = (ImageView) rowView.findViewById(R.id.arrow);
        ImageView star = (ImageView) rowView.findViewById(R.id.starempty);
        ImageView star2 = (ImageView) rowView.findViewById(R.id.starempty2);
        ImageView star3 = (ImageView) rowView.findViewById(R.id.starempty3);
        ImageView star4 = (ImageView) rowView.findViewById(R.id.starempty4);
        ImageView star5 = (ImageView) rowView.findViewById(R.id.starempty5);
        ImageView hour = (ImageView) rowView.findViewById(R.id.hour);
        ImageView euro = (ImageView) rowView.findViewById(R.id.euro);
        ImageView invalid = (ImageView) rowView.findViewById(R.id.invalid);
        ImageView baby = (ImageView) rowView.findViewById(R.id.baby);
        ImageView comment = (ImageView) rowView.findViewById(R.id.comment);
        ImageView camera = (ImageView) rowView.findViewById(R.id.camera);
        ImageView blocker = (ImageView) rowView.findViewById(R.id.hiddenFilterController);


        textView.setText(values.get(position));

        // Change icon based on name
        String s = values.get(position);


        if(stars.get(position) == 1) {
            star.setImageResource(R.drawable.star3);
            star2.setImageResource(R.drawable.emptystar2);
            star3.setImageResource(R.drawable.emptystar2);
            star4.setImageResource(R.drawable.emptystar2);
            star5.setImageResource(R.drawable.emptystar2);
        } else if (stars.get(position) == 2) {
            star.setImageResource(R.drawable.star3);
            star2.setImageResource(R.drawable.star3);
            star3.setImageResource(R.drawable.emptystar2);
            star4.setImageResource(R.drawable.emptystar2);
            star5.setImageResource(R.drawable.emptystar2);
        } else if(stars.get(position) == 3) {
            star.setImageResource(R.drawable.star3);
            star2.setImageResource(R.drawable.star3);
            star3.setImageResource(R.drawable.star3);
            star4.setImageResource(R.drawable.emptystar2);
            star5.setImageResource(R.drawable.emptystar2);
        } else if(stars.get(position) == 4) {
            star.setImageResource(R.drawable.star3);
            star2.setImageResource(R.drawable.star3);
            star3.setImageResource(R.drawable.star3);
            star4.setImageResource(R.drawable.star3);
            star5.setImageResource(R.drawable.emptystar2);
        } else if(stars.get(position) == 5) {
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




        //is there a smarter way to do the selection of the pictures?

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

        if ((hoursfilter.get(position)) == true) {
            hour.setImageResource(R.drawable.hoursbetter);
        } else {
            hour.setImageResource(R.drawable.hourscancelled);
        }
        if ((moneyfilter.get(position)) == true) {
            euro.setImageResource(R.drawable.euro);
        } else {
            euro.setImageResource(R.drawable.eurocancelled);
        }
        if ((invalidfilter.get(position)) == true) {
            invalid.setImageResource(R.drawable.invalid);
        } else {
            invalid.setImageResource(R.drawable.invalidcancelled);
        }
        if ((babyfilter.get(position)) == true) {
            baby.setImageResource(R.drawable.baby);
        } else {
            baby.setImageResource(R.drawable.babycancelled);
        }
        if ((commentfilter.get(position)) == true) {
           comment.setImageResource(R.drawable.comment);
        } else {
            comment.setImageResource(R.drawable.commentcancelled);
        }
        if ((photofilter.get(position)) == true) {
            camera.setImageResource(R.drawable.camera);
        } else {
            camera.setImageResource(R.drawable.cameracancelled);
        }



        return rowView;
    }
}
