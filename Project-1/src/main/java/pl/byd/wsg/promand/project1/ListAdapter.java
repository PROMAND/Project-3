package pl.byd.wsg.promand.project1;

/**
 * Created by Tommy on 13.3.2014.
 */
import pl.byd.wsg.promand.project1.R;

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

    public ListAdapter(Context context, String[] values, int[] stars) {
        super(context, R.layout.list, values);
        this.context = context;
        this.values = values;
        this.stars = stars;
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

        textView.setText(values[position]);

        // Change icon based on name
        String s = values[position];


        if(stars[position] == 1) {
            star.setImageResource(R.drawable.star);
            star2.setImageResource(R.drawable.starempty);
            star3.setImageResource(R.drawable.starempty);
            star4.setImageResource(R.drawable.starempty);
            star5.setImageResource(R.drawable.starempty);
        } else if (stars[position] == 2) {
            star.setImageResource(R.drawable.star);
            star2.setImageResource(R.drawable.star);
            star3.setImageResource(R.drawable.starempty);
            star4.setImageResource(R.drawable.starempty);
            star5.setImageResource(R.drawable.starempty);
        } else if(stars[position] == 3) {
            star.setImageResource(R.drawable.star);
            star2.setImageResource(R.drawable.star);
            star3.setImageResource(R.drawable.star);
            star4.setImageResource(R.drawable.starempty);
            star5.setImageResource(R.drawable.starempty);
        } else if(stars[position] == 4) {
            star.setImageResource(R.drawable.star);
            star2.setImageResource(R.drawable.star);
            star3.setImageResource(R.drawable.star);
            star4.setImageResource(R.drawable.star);
            star5.setImageResource(R.drawable.starempty);
        } else if(stars[position] == 5) {
            star.setImageResource(R.drawable.star);
            star2.setImageResource(R.drawable.star);
            star3.setImageResource(R.drawable.star);
            star4.setImageResource(R.drawable.star);
            star5.setImageResource(R.drawable.star);
        }  else {
            star.setImageResource(R.drawable.starempty);
            star2.setImageResource(R.drawable.starempty);
            star3.setImageResource(R.drawable.starempty);
            star4.setImageResource(R.drawable.starempty);
            star5.setImageResource(R.drawable.starempty);
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



        return rowView;
    }
}
