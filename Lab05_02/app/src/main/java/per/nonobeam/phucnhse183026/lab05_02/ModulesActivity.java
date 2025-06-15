package per.nonobeam.phucnhse183026.lab05_02;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import per.nonobeam.phucnhse183026.lab05_02.adapter.Adapter;
import per.nonobeam.phucnhse183026.lab05_02.domain.Module;

public class ModulesActivity extends AppCompatActivity {

    ArrayList<Module> modules;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modules);

        RecyclerView rv = findViewById(R.id.rv_modules);

        modules = new ArrayList<>();
        modules.add(new Module(
                R.drawable.module_01,
                "ListView trong Android là một thành phần dùng để nhóm nhiều mục (item)...",
                "Android"));

        modules.add(new Module(
                R.drawable.module_02,
                "Xử lý sự kiện trong iOS. Sau khi các bạn đã biết chi tiết về...",
                "iOS"));

        Adapter adapter = new Adapter(modules);

        rv.setAdapter(adapter);

        rv.setLayoutManager(new LinearLayoutManager(this));
    }
}