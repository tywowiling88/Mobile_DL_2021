package umn.ac.id.week4_33081;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private EditText etIsian, etUrl;
    private Button btnKirim, btnBrowse;
    private TextView psnBalasan;

    String http = "http://";
    String com = ".com";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etIsian = findViewById(R.id.isian);
        etUrl = findViewById(R.id.url);
        btnKirim = findViewById(R.id.buttonKirim);
        btnBrowse = findViewById(R.id.buttonBrowse);
        psnBalasan = findViewById(R.id.pesanBalasan);



                 /*1. Implicit Inten For Browsing*/
        btnBrowse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String linkText = etUrl.getText().toString();
                if (linkText.isEmpty()){
                    linkText = "http://www.umn.ac.id/";
                }

                else if (linkText.contains(http) && linkText.contains(com)) {
                    linkText = linkText;
                }

                /* 1a. Membuat String untuk browsing tidak perlu ada http:// */
                else if(linkText.contains(http)) {
                    linkText = linkText + com;
                }
                /* End Of 1a.*/

                /*1b. Membuat String untuk browsing tidak perlu ada .com*/
                else if(linkText.contains(com)) {
                    linkText = http + linkText;
                }
                /* End Of 1b.*/

                /*1c. Membuat String untuk browsing tidak perlu ada http:// dan .com */
                else {
                    linkText = http + linkText + com;
                }
                /*End Of 1c.*/

                Intent browseIntent = new Intent(Intent.ACTION_VIEW);
                browseIntent.setData(Uri.parse(linkText));
                startActivity(browseIntent);
            }
        });
                /*END OF 1. IMPLICIT INTENT FOR BROWSING*/

                /*2. EKSPLISIT INTENT FOR KIRIM PESAN KE ACTIVITY DUA*/
        btnKirim.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentEksplisit = new Intent(MainActivity.this, ActivityDua.class);
                String pesanDariMain = etIsian.getText().toString();
                intentEksplisit.putExtra("PesanDariMain", pesanDariMain);
                startActivityForResult(intentEksplisit, 1);
            }
        });
                /*END OF 2. EKSPLISIT INTENT FOR KIRIM PESAN KE ACTIVITY DUA*/

                /*Menerima Pesan Balasan Dari Activity Dua*/

    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1){
            if (resultCode == RESULT_OK){
                String Jawaban = data.getStringExtra("PesanBalasan");
                psnBalasan.setText(Jawaban);
            }
        }
    }


}