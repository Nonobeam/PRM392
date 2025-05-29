package per.nonobeam.phucnhse183026.lab02_03;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SignInActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText username;
    private EditText password;
    private TextView tvNotAccountYet;
    private Button btnSignIn;

    private final String REQUIRE = "Require";

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        tvNotAccountYet = findViewById(R.id.notAccount);
        btnSignIn = findViewById(R.id.btnSignIn);

        tvNotAccountYet.setOnClickListener(this);
        btnSignIn.setOnClickListener(this);
    }

    private boolean checkInput() {
        if (TextUtils.isEmpty(username.getText().toString())) {
            username.setError(REQUIRE);
            return false;
        }

        if (TextUtils.isEmpty(password.getText().toString())) {
            password.setError(REQUIRE);
            return false;
        }

        return true;
    }

    private void signIn()
    {
        if (!checkInput())
        {
            return;
        }

        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }

    private void signUpForm()
    {
        Intent intent = new Intent(this, SignUpActivity.class);
        startActivity(intent);
        finish();
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btnSignIn) {
            signIn();
        } else if (v.getId() == R.id.notAccount) {
            signUpForm();
        }
    }
}
