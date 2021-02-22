package umn.ac.id.week4b_33081;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class ThirdActivity extends AppCompatActivity {

/*    private EditText etTulisan3rd;
    private Button btnGantiTulisan3rd;
    private TextView tvTulisan3rd;

    String errorMessage3rd = "Tidak Mengisi Apa - Apa";*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        Fragment fragmentFirst = new FragmentFirst();
        fragmentTransaction.replace(R.id.third_activity_fragment_1, fragmentFirst);

        Fragment fragmentSecond = new FragmentSecond();
        fragmentTransaction.replace(R.id.third_activity_fragment_2, fragmentSecond);

        fragmentTransaction.commit();

/*        etTulisan3rd = findViewById(R.id.Fragment_etTulisan);
        btnGantiTulisan3rd = findViewById(R.id.Fragment_btnGantiTulisan);
        tvTulisan3rd = findViewById(R.id.Fragment_tvInitial);

        btnGantiTulisan3rd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String tulisan = etTulisan3rd.getText().toString();
                if (tulisan.isEmpty()){
                    tvTulisan3rd.setText(errorMessage3rd);
                }else {
                    tvTulisan3rd.setText(tulisan);
                }
            }
        });*/
    }
}