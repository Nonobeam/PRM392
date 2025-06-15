package per.nonobeam.phucnhse183026.lab03_01;

import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import per.nonobeam.phucnhse183026.lab03_01.domain.User;
import per.nonobeam.phucnhse183026.lab03_01.service.Service;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText name;
    private Button create;
    private Button update;
    private Button delete;
    private ListView views;

    private Service service;

    private final String REQUIRE = "Require";

    private int selectedPosition = -1;
    private View previouslySelectedView = null;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name = findViewById(R.id.name);
        create = findViewById(R.id.add);
        update = findViewById(R.id.update);
        delete = findViewById(R.id.delete);
        views = findViewById(R.id.result);


        create.setOnClickListener(this);
        update.setOnClickListener(this);
        delete.setOnClickListener(this);

        service = new Service(this);
        views.setAdapter(service.getUserAdapter());

        views.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                selectedPosition = position;

                if (previouslySelectedView != null) {
                    previouslySelectedView.setBackgroundColor(ContextCompat.getColor(previouslySelectedView.getContext(), android.R.color.transparent));
                }
                if (view != null) {
                    int backgroundColor = ContextCompat.getColor(view.getContext(), androidx.cardview.R.color.cardview_dark_background);
                    view.setBackgroundColor(backgroundColor);
                    previouslySelectedView = view;
                }

                User user = service.getItemNameAt(position);
                name.setText(user.getName());
            }
        });
    }

    private boolean checkInput() {
        if (TextUtils.isEmpty(name.getText().toString())) {
            name.setError(REQUIRE);
            return false;
        }

        return true;
    }

    private void add()
    {
        if (checkInput()) {
            service.add(name.getText().toString());
            name.setText("");
        }
    }

    private void update() {
        if (!checkInput()) {
            return;
        }
        if (selectedPosition != -1) {
            service.update(selectedPosition, name.getText().toString());
            name.setText("");
            selectedPosition = -1;
        }
    }

    private void delete() {
        if (selectedPosition != -1) {
            service.delete(selectedPosition);
            name.setText("");
            selectedPosition = -1;
        }
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();

        if (id == R.id.add) {
            add();
        } else if (id == R.id.update) {
            update();
        } else if (id == R.id.delete) {
            delete();
        }
    }
}
