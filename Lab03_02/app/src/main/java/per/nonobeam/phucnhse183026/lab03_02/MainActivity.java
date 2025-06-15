package per.nonobeam.phucnhse183026.lab03_02;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import per.nonobeam.phucnhse183026.lab03_02.domain.Item;
import per.nonobeam.phucnhse183026.lab03_02.service.Service;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText name;
    private EditText description;
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
        description = findViewById(R.id.description);
        create = findViewById(R.id.add);
        update = findViewById(R.id.update);
        delete = findViewById(R.id.delete);
        views = findViewById(R.id.result);


        create.setOnClickListener(this);
        update.setOnClickListener(this);
        delete.setOnClickListener(this);

        service = new Service(this);
        views.setAdapter(service.getUserAdapter());

        views.setOnItemClickListener((parent, view, position, id) -> {
            selectedPosition = position;

            if (previouslySelectedView != null) {
                previouslySelectedView.setBackgroundColor(ContextCompat.getColor(previouslySelectedView.getContext(), android.R.color.transparent));
            }
            if (view != null) {
                int backgroundColor = ContextCompat.getColor(view.getContext(), android.R.color.darker_gray);
                view.setBackgroundColor(backgroundColor);
                previouslySelectedView = view;
            }

            Item item = service.getItemAt(position);
            name.setText(item.getName());
            description.setText(item.getDescription());
        });
    }

    private boolean checkInput() {
        if (TextUtils.isEmpty(name.getText().toString())) {
            name.setError(REQUIRE);
            description.setError(REQUIRE);
            return false;
        }

        return true;
    }

    private void add()
    {
        if (checkInput()) {
            service.add(name.getText().toString(), description.getText().toString());
            name.setText("");
            description.setText("");
        }
    }

    private void update() {
        if (!checkInput()) {
            return;
        }
        if (selectedPosition != -1) {
            service.update(selectedPosition, name.getText().toString(), description.getText().toString());
            name.setText("");
            description.setText("");
            selectedPosition = -1;
        }
    }

    private void delete() {
        if (selectedPosition != -1) {
            service.delete(selectedPosition);
            name.setText("");
            description.setText("");
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
