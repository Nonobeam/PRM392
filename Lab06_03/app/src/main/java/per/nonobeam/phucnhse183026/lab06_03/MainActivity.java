package per.nonobeam.phucnhse183026.lab06_03;

import android.graphics.Color;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.PopupMenu;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import org.jetbrains.annotations.NotNull;

public class MainActivity extends AppCompatActivity {

    Button btnMenu;
    ConstraintLayout main;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnMenu = findViewById(R.id.buttonMenu);
        main = findViewById(R.id.main);

        registerForContextMenu(btnMenu);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        getMenuInflater().inflate(R.menu.menu_popup, menu);
        super.onCreateContextMenu(menu, v, menuInfo);
    }

    @Override
    public boolean onContextItemSelected(@NotNull MenuItem item) {
        int op = item.getItemId();
        if (op == R.id.menuDo) {
            main.setBackgroundColor(Color.RED);
        } else if (op == R.id.menuVang) {
            main.setBackgroundColor(Color.YELLOW);
        } else if (op == R.id.menuXanh) {
            main.setBackgroundColor(Color.BLUE);
        }

        return super.onContextItemSelected(item);
    }
}