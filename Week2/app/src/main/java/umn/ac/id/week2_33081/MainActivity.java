package umn.ac.id.week2_33081;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;


public class MainActivity extends AppCompatActivity {

    EditText nmbr1, nmbr2;
    Button buttonTambah, buttonKurang, buttonKali, buttonBagi;
    TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nmbr1 = (EditText) this.findViewById(R.id.angka1);
        nmbr2 = (EditText) this.findViewById(R.id.angka2);
        buttonTambah = (Button) this.findViewById(R.id.btnTambah);
        buttonKurang = (Button) this.findViewById(R.id.btnKurang);
        buttonKali = (Button) this.findViewById(R.id.btnKali);
        buttonBagi = (Button) this.findViewById(R.id.btnBagi);
        result = (TextView) this.findViewById(R.id.hasil);

        buttonTambah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hitung('+');
            }
        });

        buttonKurang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hitung('-');
            }
        });

        buttonKali.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hitung('*');
            }
        });

        buttonBagi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hitung('/');
            }
        });
    }

    protected void hitung(char operator){
        double operand1 = Double.parseDouble(nmbr1.getText().toString()); //karna nmbr1 merupakan string maka harus dirubah ke double
        double operand2 = Double.parseDouble(nmbr2.getText().toString()); //karna nmbre2 juga merupakan string maka harus diubah ke double
        // perubahan atribut bertujuan untuk dapat melakukan operasi + - * /

        double count = 0.0; //Tidak perlu melakukan perubahan apa" di result karena kita hanya akan menampilkan hasil

        switch(operator){
            case('+') : count = operand1 + operand2;
                break;
            case('-') : count = operand1 - operand2;
                break;
            case('*') : count = operand1 * operand2;
                break;
            case('/') : count = operand1 / operand2;
                break;
        }
        result.setText(String.valueOf(count));
    }

}