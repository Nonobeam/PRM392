package per.nonobeam.phucnhse183026.lab03_01.service;

import android.content.Context;

import per.nonobeam.phucnhse183026.lab03_01.adapter.UserAdapter;
import per.nonobeam.phucnhse183026.lab03_01.database.DatabaseHelper;
import per.nonobeam.phucnhse183026.lab03_01.domain.User;

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

    public void add(String name) {
        User user = dbHelper.insertUser(name);
        userAdapter.add(user);
        userAdapter.notifyDataSetChanged();
    }

    public void update(int position, String string) {
        User user = userAdapter.getItem(position);
        user.setName(string);
        userAdapter.notifyDataSetChanged();
    }

    public void delete(int position) {
        User user = userAdapter.getItem(position);
        dbHelper.deleteUserById(user.getId());
        userAdapter.remove(user);
        userAdapter.notifyDataSetChanged();
    }

    public User getItemNameAt(int position) {
        return userAdapter.getItem(position);
    }
}
