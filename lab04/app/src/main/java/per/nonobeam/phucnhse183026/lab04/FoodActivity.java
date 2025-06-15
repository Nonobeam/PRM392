package per.nonobeam.phucnhse183026.lab04;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import per.nonobeam.phucnhse183026.lab04.service.Service;

public class FoodActivity extends AppCompatActivity {

    String[] foods = {"Phở Hà Nội", "Bún Bò Huế", "Mì Quảng", "Hủ Tíu Sài Gòn"};
    String selectedFood = null;
    Service service;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food);
        service = new Service(this);

        ListView listView = findViewById(R.id.lvFood);
        Button btnOrder = findViewById(R.id.btnOrderFood);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_single_choice, foods);
        listView.setAdapter(adapter);
        listView.setChoiceMode(ListView.CHOICE_MODE_SINGLE);

        listView.setOnItemClickListener((parent, view, position, id) -> selectedFood = foods[position]);

        btnOrder.setOnClickListener(v -> {
            if (selectedFood != null) {
                service.add(selectedFood);

                Intent intent = new Intent(this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
