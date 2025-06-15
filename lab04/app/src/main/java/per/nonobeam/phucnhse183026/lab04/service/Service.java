package per.nonobeam.phucnhse183026.lab04.service;

import android.content.Context;

import per.nonobeam.phucnhse183026.lab04.adapter.Adapter;
import per.nonobeam.phucnhse183026.lab04.database.DatabaseHelper;
import per.nonobeam.phucnhse183026.lab04.domain.Items;


public class Service {
    private final DatabaseHelper dbHelper;
    private final Adapter adapter;

    public Service(Context context) {
        this.dbHelper = new DatabaseHelper(context);
        this.adapter = new Adapter(context, dbHelper.getAll());
    }

    public Adapter getAdapter() {
        return adapter;
    }

    public void add(String name) {
        Items a = dbHelper.insert(name);
        adapter.add(a);
        adapter.notifyDataSetChanged();
    }

    public void update(int position, String string) {
        Items a = adapter.getItem(position);
        a.setName(string);
        adapter.notifyDataSetChanged();
    }

    public void delete(int position) {
        Items a = adapter.getItem(position);
        dbHelper.deleteById(a.getId());
        adapter.remove(a);
        adapter.notifyDataSetChanged();
    }

    public Items getItemNameAt(int position) {
        return adapter.getItem(position);
    }
}
