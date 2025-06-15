package per.nonobeam.phucnhse183026.lab04.adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;

import java.util.List;

import per.nonobeam.phucnhse183026.lab04.domain.Items;


public class Adapter extends ArrayAdapter<Items> {

    private Context mContext;
    private int selectedPosition = -1;

    public Adapter(Context context, List<Items> allUsers) {
        super(context, 0, allUsers);
        mContext = context;
    }

    public void setSelectedPosition(int position) {
        selectedPosition = position;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, @NonNull ViewGroup parent) {
        Items a = getItem(position);

        if (convertView == null) {
            convertView = LayoutInflater.from(mContext).inflate(android.R.layout.simple_list_item_1, parent, false);
        }

        TextView tv = convertView.findViewById(android.R.id.text1);
        tv.setText(a.getName());

        if (position == selectedPosition) {
            convertView.setBackgroundColor(Color.LTGRAY);
        } else {
            convertView.setBackgroundColor(Color.TRANSPARENT);
        }

        return convertView;
    }
}
