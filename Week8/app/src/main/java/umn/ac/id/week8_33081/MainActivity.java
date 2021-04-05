package umn.ac.id.week8_33081;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button btn8a, btn8b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn8a = findViewById(R.id.btnMod8a);
        btn8b = findViewById(R.id.btnMod8b);

        btn8aIntent();
        btn8bIntent();


    }

    private void btn8aIntent() {
        btn8a.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent8a = new Intent(MainActivity.this, modul8a.class);
                startActivity(intent8a);
            }
        });
    }

    private void btn8bIntent() {
        btn8b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent8b = new Intent(MainActivity.this, modul8b.class);
                startActivity(intent8b);
            }
        });
    }
}