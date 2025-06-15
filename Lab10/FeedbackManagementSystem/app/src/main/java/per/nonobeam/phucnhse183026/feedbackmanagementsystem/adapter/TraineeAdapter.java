package per.nonobeam.phucnhse183026.feedbackmanagementsystem.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import per.nonobeam.phucnhse183026.feedbackmanagementsystem.R;
import per.nonobeam.phucnhse183026.feedbackmanagementsystem.model.Trainee;

public class TraineeAdapter extends RecyclerView.Adapter<TraineeAdapter.TraineeViewHolder> {

    private List<Trainee> traineeList;
    private final OnTraineeActionListener actionListener;

    public interface OnTraineeActionListener {
        void onEdit(Trainee trainee);
        void onDelete(Trainee trainee);
    }

    public TraineeAdapter(List<Trainee> traineeList, OnTraineeActionListener listener) {
        this.traineeList = traineeList;
        this.actionListener = listener;
    }

    @Override
    public TraineeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_trainee, parent, false);
        return new TraineeViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TraineeViewHolder holder, int position) {
        Trainee trainee = traineeList.get(position);
        holder.bind(trainee);
    }

    @Override
    public int getItemCount() {
        return traineeList != null ? traineeList.size() : 0;
    }

    public void updateList(List<Trainee> newList) {
        this.traineeList = newList;
        notifyDataSetChanged();
    }

    class TraineeViewHolder extends RecyclerView.ViewHolder {

        TextView tvName, tvEmail, tvPhone, tvGender;
        Button btnEdit, btnDelete;

        public TraineeViewHolder(@NonNull View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.tvName);
            tvEmail = itemView.findViewById(R.id.tvEmail);
            tvPhone = itemView.findViewById(R.id.tvPhone);
            tvGender = itemView.findViewById(R.id.tvGender);
            btnEdit = itemView.findViewById(R.id.btnEdit);
            btnDelete = itemView.findViewById(R.id.btnDelete);
        }

        public void bind(Trainee trainee) {
            tvName.setText("Name: " + trainee.getName());
            tvEmail.setText("Email: " + trainee.getEmail());
            tvPhone.setText("Phone: " + trainee.getPhone());
            tvGender.setText("Gender: " + trainee.getGender());

            btnEdit.setOnClickListener(v -> actionListener.onEdit(trainee));
            btnDelete.setOnClickListener(v -> actionListener.onDelete(trainee));
        }
    }
}
