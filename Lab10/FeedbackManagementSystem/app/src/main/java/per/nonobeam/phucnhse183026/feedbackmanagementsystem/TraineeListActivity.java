package per.nonobeam.phucnhse183026.feedbackmanagementsystem;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import per.nonobeam.phucnhse183026.feedbackmanagementsystem.adapter.TraineeAdapter;
import per.nonobeam.phucnhse183026.feedbackmanagementsystem.model.Trainee;
import per.nonobeam.phucnhse183026.feedbackmanagementsystem.repository.TraineeRepository;
import per.nonobeam.phucnhse183026.feedbackmanagementsystem.service.TraineeService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TraineeListActivity extends AppCompatActivity {
    TraineeService traineeService;
    RecyclerView recyclerTrainees;
    TraineeAdapter adapter;
    Button btnBackToMain;
    final List<Trainee> traineeList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        traineeService = TraineeRepository.getTraineeService();

        recyclerTrainees = findViewById(R.id.recyclerTrainees);
        recyclerTrainees.setLayoutManager(new LinearLayoutManager(this));

        adapter = new TraineeAdapter(traineeList, new TraineeAdapter.OnTraineeActionListener() {
            @Override
            public void onEdit(Trainee trainee) {
                showEditDialog(trainee);
            }

            @Override
            public void onDelete(Trainee trainee) {
                deleteTraineeById(trainee.getId());
            }
        });

        recyclerTrainees.setAdapter(adapter);

        getAllTrainees();

        btnBackToMain = findViewById(R.id.btnBackToMain);
        btnBackToMain.setOnClickListener(v -> {
            Intent intent = new Intent(TraineeListActivity.this, MainActivity.class);
            startActivity(intent);
        });
    }

    private void getAllTrainees() {
        Call<Trainee[]> call = traineeService.getAllTrainees();
        call.enqueue(new Callback<>() {
            @Override
            public void onResponse(Call<Trainee[]> call, Response<Trainee[]> response) {
                if (response.isSuccessful() && response.body() != null) {
                    traineeList.clear();
                    traineeList.addAll(Arrays.asList(response.body()));
                    adapter.updateList(traineeList);
                }
            }

            @Override
            public void onFailure(Call<Trainee[]> call, Throwable t) {
                Toast.makeText(TraineeListActivity.this, "Failed to load trainees", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void deleteTraineeById(long id) {
        Call<Trainee> call = traineeService.deleteTrainee(id);
        call.enqueue(new Callback<>() {
            @Override
            public void onResponse(Call<Trainee> call, Response<Trainee> response) {
                if (response.isSuccessful()) {
                    Toast.makeText(TraineeListActivity.this, "Deleted", Toast.LENGTH_SHORT).show();
                    getAllTrainees();
                } else {
                    Toast.makeText(TraineeListActivity.this, "Delete failed", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<Trainee> call, Throwable t) {
                Toast.makeText(TraineeListActivity.this, "Error deleting", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void showEditDialog(Trainee trainee) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        View view = getLayoutInflater().inflate(R.layout.dialog_edit_trainee, null);
        builder.setView(view);
        AlertDialog dialog = builder.create();

        EditText editName = view.findViewById(R.id.editName);
        EditText editEmail = view.findViewById(R.id.editEmail);
        EditText editPhone = view.findViewById(R.id.editPhone);
        EditText editGender = view.findViewById(R.id.editGender);
        Button btnUpdate = view.findViewById(R.id.btnUpdate);

        editName.setText(trainee.getName());
        editEmail.setText(trainee.getEmail());
        editPhone.setText(trainee.getPhone());
        editGender.setText(trainee.getGender());

        btnUpdate.setOnClickListener(v -> {
            Trainee updated = new Trainee(
                    trainee.getId(),
                    editName.getText().toString(),
                    editEmail.getText().toString(),
                    editPhone.getText().toString(),
                    editGender.getText().toString()
            );

            traineeService.updateTrainee(trainee.getId(), updated).enqueue(new Callback<>() {
                @Override
                public void onResponse(Call<Trainee> call, Response<Trainee> response) {
                    if (response.isSuccessful()) {
                        Toast.makeText(TraineeListActivity.this, "Updated", Toast.LENGTH_SHORT).show();
                        dialog.dismiss();
                        getAllTrainees();
                    } else {
                        Toast.makeText(TraineeListActivity.this, "Update failed", Toast.LENGTH_SHORT).show();
                    }
                }

                @Override
                public void onFailure(Call<Trainee> call, Throwable t) {
                    Toast.makeText(TraineeListActivity.this, "Error updating", Toast.LENGTH_SHORT).show();
                }
            });
        });

        dialog.show();
    }
}
