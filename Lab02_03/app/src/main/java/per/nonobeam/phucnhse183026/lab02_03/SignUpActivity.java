package per.nonobeam.phucnhse183026.lab02_03;

import static android.app.ProgressDialog.show;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class SignUpActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText username;
    private EditText password;
    private EditText confirmPassword;
    private TextView tvNotAccountYet;
    private Button btnSignUp;

    private final String REQUIRE = "Require";

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        confirmPassword = findViewById(R.id.confirmPassword);
        tvNotAccountYet = findViewById(R.id.alreadyAccount);
        btnSignUp = findViewById(R.id.btnSignUp);

        tvNotAccountYet.setOnClickListener(this);
        btnSignUp.setOnClickListener(this);
    }

    private boolean checkInput()
    {
        if (TextUtils.isEmpty(username.getText().toString())) {
            username.setError(REQUIRE);
            return false;
        }

        if (TextUtils. isEmpty(password.getText().toString())) {
            password.setError(REQUIRE);
            return false;
        }

        if (TextUtils. isEmpty(confirmPassword.getText().toString())) {
            confirmPassword.setError(REQUIRE);
            return false;

        }

        if (!TextUtils.equals(password.getText().toString()
                , confirmPassword.getText().toString())) {
            Toast.makeText(this, "Password are not match", Toast.LENGTH_LONG).
            show();
            return false;
        }
        // Valid
        return true;
    }

    private void signUp()
    {
        if (!checkInput())
        {
            return;
        }
    }

    private void signInForm()
    {
        Intent intent = new Intent(this, SignInActivity.class);
        startActivity(intent);
        finish();
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btnSignUp) {
            signUp();
        } else if (v.getId() == R.id.alreadyAccount) {
            signInForm();
        }
    }
}
