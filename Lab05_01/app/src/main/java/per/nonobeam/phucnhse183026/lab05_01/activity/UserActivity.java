package per.nonobeam.phucnhse183026.lab05_01.activity;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import per.nonobeam.phucnhse183026.lab05_01.R;
import per.nonobeam.phucnhse183026.lab05_01.adapter.UserAdapter;
import per.nonobeam.phucnhse183026.lab05_01.domain.User;

public class UserActivity extends AppCompatActivity {

    ArrayList<User> users;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);

        RecyclerView rvUser = findViewById(R.id.rvUser);

        users = new ArrayList<>();
        users.add(new User("NguyenTT", "Tran Thanh Nguyen", "nguyentt@ptp.edu.vn"));
        users.add(new User("Antv", "Tran Van An", "antv@gmail.com"));
        users.add(new User("BangTT", "Tran Thanh Bang", "bangtt@gmail.com"));
        users.add(new User("KhangTT", "Tran Thanh Khang", "khangtt@gmail.com"));
        users.add(new User("BaoTT", "Nguyen Thanh Bao", "baott@gmail.com"));
        users.add(new User("HuynhVH", "Vo Huy Hung", "huynhvh@gmail.com"));

        UserAdapter adapter = new UserAdapter(users);

        rvUser.setAdapter(adapter);

        rvUser.setLayoutManager(new LinearLayoutManager(this));
    }
}