package pl.byd.wsg.promand.project1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class ListAdapter extends ArrayAdapter<String> {
    private final Context context;
    private final String[] values;
    private final int[] stars;
    private final boolean[] hoursfilter;
    private final boolean[] moneyfilter;
    private final boolean[] invalidfilter;
    private final boolean[] babyfilter;
    private final boolean[] commentfilter;
    private final boolean[] photofilter;

    public ListAdapter(Context context, String[] values, int[] stars, boolean[] hoursfilter, boolean[] moneyfilter,
                       boolean[] invalidfilter, boolean[] babyfilter, boolean[] commentfilter, boolean[] photofilter) {
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


        textView.setText(values[position]);

        // Change icon based on name
        String s = values[position];


        if(stars[position] == 1) {
            star.setImageResource(R.drawable.star3);
            star2.setImageResource(R.drawable.emptystar2);
            star3.setImageResource(R.drawable.emptystar2);
            star4.setImageResource(R.drawable.emptystar2);
            star5.setImageResource(R.drawable.emptystar2);
        } else if (stars[position] == 2) {
            star.setImageResource(R.drawable.star3);
            star2.setImageResource(R.drawable.star3);
            star3.setImageResource(R.drawable.emptystar2);
            star4.setImageResource(R.drawable.emptystar2);
            star5.setImageResource(R.drawable.emptystar2);
        } else if(stars[position] == 3) {
            star.setImageResource(R.drawable.star3);
            star2.setImageResource(R.drawable.star3);
            star3.setImageResource(R.drawable.star3);
            star4.setImageResource(R.drawable.emptystar2);
            star5.setImageResource(R.drawable.emptystar2);
        } else if(stars[position] == 4) {
            star.setImageResource(R.drawable.star3);
            star2.setImageResource(R.drawable.star3);
            star3.setImageResource(R.drawable.star3);
            star4.setImageResource(R.drawable.star3);
            star5.setImageResource(R.drawable.emptystar2);
        } else if(stars[position] == 5) {
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

        if ((hoursfilter[position]) == true) {
            hour.setImageResource(R.drawable.hoursbetter);
        } else {
            hour.setImageResource(R.drawable.hourscancelled);
        }
        if ((moneyfilter[position]) == true) {
            euro.setImageResource(R.drawable.euro);
        } else {
            euro.setImageResource(R.drawable.eurocancelled);
        }
        if ((invalidfilter[position]) == true) {
            invalid.setImageResource(R.drawable.invalid);
        } else {
            invalid.setImageResource(R.drawable.invalidcancelled);
        }
        if ((babyfilter[position]) == true) {
            baby.setImageResource(R.drawable.baby);
        } else {
            baby.setImageResource(R.drawable.babycancelled);
        }
        if ((commentfilter[position]) == true) {
           comment.setImageResource(R.drawable.comment);
        } else {
            comment.setImageResource(R.drawable.commentcancelled);
        }
        if ((photofilter[position]) == true) {
            camera.setImageResource(R.drawable.camera);
        } else {
            camera.setImageResource(R.drawable.cameracancelled);
        }



        return rowView;
    }
}
