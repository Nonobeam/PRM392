package per.nonobeam.phucnhse183026.lab02_02;

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
    TextInputEditText first, second;
    Button plus;
    Button minus;
    Button multiply;
    Button divide;
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

        first = findViewById(R.id.textInputEditText1);
        second = findViewById(R.id.textInputEditText2);
        plus = findViewById(R.id.plus);
        minus = findViewById(R.id.minus);
        multiply = findViewById(R.id.multiply);
        divide = findViewById(R.id.divide);
        resultTextView = findViewById(R.id.result);

        plus.setOnClickListener(v -> calculate('+'));
        minus.setOnClickListener(v -> calculate('-'));
        multiply.setOnClickListener(v -> calculate('*'));
        divide.setOnClickListener(v -> calculate('/'));
    }

    private void calculate(char operator) {
        String firstStr = first.getText().toString().trim();
        String secondStr = second.getText().toString().trim();

        if (firstStr.isEmpty() || secondStr.isEmpty()) {
            resultTextView.setText("Please enter both numbers.");
            return;
        }

        double num1 = Double.parseDouble(firstStr);
        double num2 = Double.parseDouble(secondStr);
        double result = 0;

        switch (operator) {
            case '+': result = num1 + num2; break;
            case '-': result = num1 - num2; break;
            case '*': result = num1 * num2; break;
            case '/':
                if (num2 == 0) {
                    resultTextView.setText("Cannot divide by zero.");
                    return;
                }
                result = num1 / num2;
                break;
        }

        resultTextView.setText(String.valueOf(result));
    }
}