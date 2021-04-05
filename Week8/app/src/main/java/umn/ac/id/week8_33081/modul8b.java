package umn.ac.id.week8_33081;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class modul8b extends AppCompatActivity {
    TextView tvCounter;
    Button btnHitam, btnMerah, btnBiru, btnHijau, btnTambahCounter, btnResetCounter;

    private int mCount = 0;
    private int mWarna;
    private Context context;

    private final String COUNTER_KEY = "counter";
    private final String WARNA_KEY = "warna";

    private SharedPreferences mPreferences;
    private String sharedPreFile;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modul8b);

        tvCounter = (TextView) findViewById(R.id.tvCounter);
        btnHitam = findViewById(R.id.btnHitam);
        btnMerah = findViewById(R.id.btnMerah);
        btnBiru = findViewById(R.id.btnBiru);
        btnHijau = findViewById(R.id.btnHijau);
        btnTambahCounter = findViewById(R.id.btnTambahCounter);
        btnResetCounter = findViewById(R.id.btnResetCounter);

        context = this;

        tambahCounter();

        resetCounter();

/*        if (savedInstanceState != null) {
            mCount = savedInstanceState.getInt(COUNTER_KEY);
            if (mCount != 0) {
                tvCounter.setText(String.valueOf(mCount));
            }
            mWarna = savedInstanceState.getInt(WARNA_KEY);
            tvCounter.setBackgroundColor(mWarna);
        }*/

        sharedPreFile = context.getPackageName();
        mPreferences = getSharedPreferences(sharedPreFile, MODE_PRIVATE);
        mCount = mPreferences.getInt(COUNTER_KEY, 0);
        tvCounter.setText(String.valueOf(mCount));

        mWarna = mPreferences.getInt(WARNA_KEY, mWarna);
        tvCounter.setBackgroundColor(mWarna);
    }


    private void resetCounter() {
        btnResetCounter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCount = 0;
                tvCounter.setText(String.valueOf(mCount));
                mWarna = ContextCompat.getColor(context, R.color.yellow);
                tvCounter.setBackgroundColor(mWarna);
            }
        });
    }

    private void tambahCounter() {
        btnTambahCounter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCount++;
                tvCounter.setText(String.valueOf(mCount));
            }
        });
    }

    public void gantiWarnaBackground(View view) {
        int warna = ((ColorDrawable)view.getBackground()).getColor();
        mWarna = warna;
        tvCounter.setBackgroundColor(warna);
    }

/*    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(COUNTER_KEY, mCount);
        outState.putInt(WARNA_KEY, mWarna);
    }*/

    @Override
    protected void onPause() {
        super.onPause();
        SharedPreferences.Editor preferencesEditor = mPreferences.edit();
        preferencesEditor.putInt(COUNTER_KEY, mCount);
        preferencesEditor.putInt(WARNA_KEY, mWarna);
        preferencesEditor.apply();
    }
}