package per.nonobeam.phucnhse183026.lab02;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.textfield.TextInputEditText;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    TextInputEditText minInput, maxInput;
    Button generateButton;
    TextView resultTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        minInput = findViewById(R.id.textInputEditText1);
        maxInput = findViewById(R.id.textInputEditText2);
        generateButton = findViewById(R.id.generate);
        resultTextView = findViewById(R.id.result);

        generateButton.setOnClickListener(v -> {
            String minStr = minInput.getText().toString().trim();
            String maxStr = maxInput.getText().toString().trim();

            int min = Integer.parseInt(minStr);
            int max = Integer.parseInt(maxStr);

            int result = new Random().nextInt((max - min) + 1) + min;
            resultTextView.setText(String.valueOf(result));
        });
    }
}