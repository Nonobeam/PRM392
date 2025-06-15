package per.nonobeam.phucnhse183026.lab04;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import per.nonobeam.phucnhse183026.lab04.service.Service;

public class MainActivity extends AppCompatActivity {

    Service service;
    TextView order;
    ListView views;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        order = findViewById(R.id.order);
        views = findViewById(R.id.result);

        Button btnChooseFood = findViewById(R.id.food);
        Button btnChooseDrink = findViewById(R.id.drink);

        btnChooseFood.setOnClickListener(v -> {
            Intent intent = new Intent(this, FoodActivity.class);
            startActivity(intent);
        });

        btnChooseDrink.setOnClickListener(v -> {
            Intent intent = new Intent(this, DrinkActivity.class);
            startActivity(intent);
        });

        service = new Service(this);
        views.setAdapter(service.getAdapter());
    }
}