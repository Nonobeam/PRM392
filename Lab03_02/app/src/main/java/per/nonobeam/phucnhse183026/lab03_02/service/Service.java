package per.nonobeam.phucnhse183026.lab03_02.service;

import android.content.Context;

import per.nonobeam.phucnhse183026.lab03_02.adapter.UserAdapter;
import per.nonobeam.phucnhse183026.lab03_02.database.DatabaseHelper;
import per.nonobeam.phucnhse183026.lab03_02.domain.Item;

public class Service {
    private final DatabaseHelper dbHelper;
    private final UserAdapter userAdapter;

    public Service(Context context) {
        this.dbHelper = new DatabaseHelper(context);
        this.userAdapter = new UserAdapter(context, dbHelper.getAllUsers());
    }

    public UserAdapter getUserAdapter() {
        return userAdapter;
    }

    public void add(String name, String des) {
        Item item = dbHelper.insertUser(name, des);
        userAdapter.add(item);
        userAdapter.notifyDataSetChanged();
    }

    public void update(int position, String string, String des) {
        Item item = userAdapter.getItem(position);
        item.setName(string);
        item.setDescription(des);
        userAdapter.notifyDataSetChanged();
    }

    public void delete(int position) {
        Item item = userAdapter.getItem(position);
        dbHelper.deleteUserById(item.getId());
        userAdapter.remove(item);
        userAdapter.notifyDataSetChanged();
    }

    public Item getItemAt(int position) {
        return userAdapter.getItem(position);
    }
}
