package per.nonobeam.phucnhse183026.lab09_05.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import per.nonobeam.phucnhse183026.lab09_05.MainActivity;
import per.nonobeam.phucnhse183026.lab09_05.R;
import per.nonobeam.phucnhse183026.lab09_05.domain.CongViec;

public class CongViecAdapter extends BaseAdapter {
    private MainActivity context;
    private int layout;
    private List<CongViec> congViecList;

    public CongViecAdapter(MainActivity  context, int layout, List<CongViec> congViecList) {
        this.context = context;
        this.layout = layout;
        this.congViecList = congViecList;
    }

    @Override
    public int getCount() {
        return congViecList.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    private class ViewHolder {
        TextView txtTen;
        ImageView imgDelete, imgEdit;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        ViewHolder holder;
        if (view == null) {
            holder = new ViewHolder();
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(layout, null);
            holder.txtTen = view.findViewById(R.id.textviewTen);
            holder.imgDelete = view.findViewById(R.id.imageviewDelete);
            holder.imgEdit = view.findViewById(R.id.imageviewEdit);
            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }
        CongViec congViec = congViecList.get(position);
        holder.txtTen.setText(congViec.getTenCV());

        holder.imgEdit.setOnClickListener(v -> context.DialogSuaCongViec(congViec.getTenCV(), congViec.getIdCV()));
        holder.imgDelete.setOnClickListener(v -> context.DialogXoaCongViec(congViec.getTenCV(), congViec.getIdCV()));

        return view;
    }
}
