package per.nonobeam.phucnhse183026.lab06_02;

import android.os.Bundle;
import android.widget.Button;
import android.widget.PopupMenu;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    Button btnMenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnMenu = findViewById(R.id.buttonMenu);

        btnMenu.setOnClickListener(view -> ShowMenu());
    }

    private void ShowMenu() {
        PopupMenu popupMenu = new PopupMenu(this, btnMenu);
        popupMenu.getMenuInflater().inflate(R.menu.menu_popup, popupMenu.getMenu());

        popupMenu.setOnMenuItemClickListener(item -> {
            int id = item.getItemId();
            if (id == R.id.menuThem) {
                btnMenu.setText("Menu Them");
            } else if (id == R.id.menuSua) {
                btnMenu.setText("Menu Sua");
            } else if (id == R.id.menuXoa) {
                btnMenu.setText("Menu Xoa");
            } else {
                return false;
            }
            return true;
        });

        popupMenu.show();
    }
}