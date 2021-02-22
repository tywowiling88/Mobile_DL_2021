package umn.ac.id.week4b_33081;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private Button btnHalaman1, btnHalaman2;
    private TextView tvNama;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvNama = findViewById(R.id.Nama);
        btnHalaman1 = findViewById(R.id.main_button_change_1);
        btnHalaman2 = findViewById(R.id.main_button_change_2);

        btnHalaman1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intenHalaman1 = new Intent(MainActivity.this, SecondActivity.class);
                startActivity(intenHalaman1);
            }
        });

        btnHalaman2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intenHalaman2 = new Intent(MainActivity.this, ThirdActivity.class);
                startActivity(intenHalaman2);
            }
        });

    }


}