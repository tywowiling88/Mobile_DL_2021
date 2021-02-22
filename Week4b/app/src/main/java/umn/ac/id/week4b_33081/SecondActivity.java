package umn.ac.id.week4b_33081;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {
    private EditText etTulisan;
    private Button btnGantiTulisan;
    private TextView tvTulisan;

    String errorMessage = "Tidak Mengisi Apa - Apa";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        etTulisan = findViewById(R.id.Fragment_etTulisan);
        btnGantiTulisan = findViewById(R.id.Fragment_btnGantiTulisan);
        tvTulisan = findViewById(R.id.Fragment_tvInitial);

        btnGantiTulisan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String tulisan = etTulisan.getText().toString();
                if (tulisan.isEmpty()){
                    tvTulisan.setText(errorMessage);
                }else {
                    tvTulisan.setText(tulisan);
                }
            }
        });
    }
}