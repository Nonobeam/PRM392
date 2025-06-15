package per.nonobeam.phucnhse183026.lab09_01;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import per.nonobeam.phucnhse183026.lab09_01.database.Database;

public class MainActivity extends AppCompatActivity {
    Database database;
    Button getBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getBtn = findViewById(R.id.getBtn);

        database = new Database(this, "GhiChu.sqlite", null, 1);

        database.QueryData("CREATE TABLE IF NOT EXISTS CongViec(id INTEGER PRIMARY KEY AUTOINCREMENT, TenCV nvarchar(200))");

//        database.QueryData("Insert into CongViec values(1, 'Project Android')");
//        database.QueryData("Insert into CongViec values(2, 'Design App')");

        Cursor dataCongViec = database.GetData("SELECT * FROM CongViec");

        while (dataCongViec.moveToNext()) {
            String ten = dataCongViec.getString(1);
            Toast.makeText(this, ten, Toast.LENGTH_SHORT).show();
        }
    }
}