package umn.ac.id.week7_33081;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button btnMod7a, btnMod7b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnMod7a = findViewById(R.id.btnMod7a);
        btnMod7b = findViewById(R.id.btnMod7b);

        btnWeek7a();
        btnWeek7b();
    }

    private void btnWeek7a() {
        btnMod7a.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mod7aPage = new Intent(MainActivity.this, Camera.class);
                startActivity(mod7aPage);
            }
        });
    }

    private void btnWeek7b() {
        btnMod7b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mod7bPage = new Intent(MainActivity.this, Modul7b.class);
                startActivity(mod7bPage);
            }
        });
    }

}