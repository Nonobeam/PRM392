package per.nonobeam.phucnhse183026.lab05_02.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import per.nonobeam.phucnhse183026.lab05_02.R;
import per.nonobeam.phucnhse183026.lab05_02.domain.Module;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {

    private ArrayList<Module> items;

    public Adapter(ArrayList<Module> items) {
        this.items = items;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater layoutInflater = LayoutInflater.from(context);

        View view = layoutInflater.inflate(R.layout.item_list, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Module a = items.get(position);

        holder.image.setImageResource(a.getImage());
        holder.summary.setText(a.getSummary());
        holder.os.setText(a.getOs());
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView image;
        TextView summary;
        TextView os;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            image = itemView.findViewById(R.id.image);
            summary = itemView.findViewById(R.id.summary);
            os = itemView.findViewById(R.id.os);
        }
    }
}
