package per.nonobeam.phucnhse183026.feedbackmanagementsystem;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import per.nonobeam.phucnhse183026.feedbackmanagementsystem.model.Trainee;
import per.nonobeam.phucnhse183026.feedbackmanagementsystem.repository.TraineeRepository;
import per.nonobeam.phucnhse183026.feedbackmanagementsystem.service.TraineeService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    TraineeService traineeService;
    EditText etname, etemail, etphone, etgioitinh;
    Button btnSave, btnGoToList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etname = findViewById(R.id.name);
        etemail = findViewById(R.id.email);
        etphone = findViewById(R.id.phone);
        etgioitinh = findViewById(R.id.gender);
        btnSave = findViewById(R.id.btnSave);
        btnSave.setOnClickListener(btn -> save());

        traineeService = TraineeRepository.getTraineeService();

        btnGoToList = findViewById(R.id.btnGoToList);
        btnGoToList.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, TraineeListActivity.class);
            startActivity(intent);
        });
    }

    private void save() {
        String name = etname.getText().toString();
        String email = etemail.getText().toString();
        String phone = etphone.getText().toString();
        String gender = etgioitinh.getText().toString();

        Trainee trainee = new Trainee(name, email, phone, gender);
        try {
            Call<Trainee> call = traineeService.createTrainee(trainee);
            call.enqueue(new Callback<>() {
                @Override
                public void onResponse(Call<Trainee> call, Response<Trainee> response) {
                    if (response.body() != null) {
                        Toast.makeText(MainActivity.this, "Save successfully"
                                , Toast.LENGTH_LONG).show();
                    }

                    Intent intent = new Intent(MainActivity.this, TraineeListActivity.class);
                    startActivity(intent);
                }

                @Override
                public void onFailure(Call<Trainee> call, Throwable t) {
                    Toast.makeText(MainActivity.this, "Save Fail"
                            , Toast.LENGTH_LONG).show();

                }
            });
        } catch (Exception e) {
            Log.d("Loi", e.getMessage());
        }
    }
}