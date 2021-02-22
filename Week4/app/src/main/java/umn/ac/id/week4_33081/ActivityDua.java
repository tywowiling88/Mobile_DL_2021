package umn.ac.id.week4_33081;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class ActivityDua extends AppCompatActivity {

    private TextView psnDiterima;
    private EditText psnBalik;
    private Button krmBalik;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dua);

        psnDiterima = findViewById(R.id.pesanDiterima);
        psnBalik = findViewById(R.id.pesanBalik);
        krmBalik = findViewById(R.id.kirimBalik);

        Intent mainIntent = getIntent();
        String pesanDiterima = mainIntent.getStringExtra("PesanDariMain");
        psnDiterima.setText(pesanDiterima);

/*        krmBalik.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent balasPesan = new Intent();
                String pesanBalasan = psnBalik.getText().toString();
                balasPesan.putExtra("PesanBalasan", pesanBalasan);
                setResult(RESULT_OK, balasPesan);
                finish();
            }
        });*/
    }

        public void kirimBalik(View view) {
            Intent balasPesan = new Intent();
            String pesanBalasan = psnBalik.getText().toString();
            balasPesan.putExtra("PesanBalasan", pesanBalasan);
            setResult(RESULT_OK, balasPesan);
            finish();
        }


}