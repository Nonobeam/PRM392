package per.nonobeam.phucnhse183026.lab04;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import per.nonobeam.phucnhse183026.lab04.service.Service;

public class DrinkActivity extends AppCompatActivity {

    String[] drinks = {"Pepsi", "Heineken", "Tiger", "Sài Gòn Đỏ"};
    String selectedDrink = null;
    Service service;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drink);
        service = new Service(this);

        ListView listView = findViewById(R.id.lvDrink);
        Button btnOrder = findViewById(R.id.btnOrderDrink);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_single_choice, drinks);
        listView.setAdapter(adapter);
        listView.setChoiceMode(ListView.CHOICE_MODE_SINGLE);

        listView.setOnItemClickListener((parent, view, position, id) -> selectedDrink = drinks[position]);

        btnOrder.setOnClickListener(v -> {
            if (selectedDrink != null) {
                service.add(selectedDrink);

                Intent intent = new Intent(this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
