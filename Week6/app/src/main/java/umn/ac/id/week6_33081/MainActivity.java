package umn.ac.id.week6_33081;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button btnW6a, btnW6b, btnW6c;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnW6a = this.findViewById(R.id.btnW6a);
        btnW6b = this.findViewById(R.id.btnW6b);
        btnW6c = this.findViewById(R.id.btnW6c);

        btnW6a.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent week6a = new Intent(MainActivity.this, Week6a.class);
                startActivity(week6a);
            }
        });

        btnW6b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent week6b = new Intent(MainActivity.this, Week6b.class);
                startActivity(week6b);
            }
        });

        btnW6c.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent week6c = new Intent(MainActivity.this, Week6c.class);
                startActivity(week6c);
            }
        });

    }
}