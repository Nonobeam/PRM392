package per.nonobeam.phucnhse183026.lab03_02.adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;

import java.util.List;

import per.nonobeam.phucnhse183026.lab03_02.R;
import per.nonobeam.phucnhse183026.lab03_02.domain.Item;

public class UserAdapter extends ArrayAdapter<Item> {
    private final Context context;
    private final List<Item> items;

    public UserAdapter(Context context, List<Item> items) {
        super(context, 0, items);
        this.context = context;
        this.items = items;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, @NonNull ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.list_item_user, parent, false);
        }

        Item item = getItem(position);

        TextView nameText = convertView.findViewById(R.id.text_name);
        TextView descriptionText = convertView.findViewById(R.id.text_description);

        if (item != null) {
            nameText.setText(item.getName());
            descriptionText.setText(item.getDescription());
        }

        return convertView;
    }
}
