package umn.ac.id.week5_33081;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;

public class MainActivity extends AppCompatActivity {
    private RadioGroup rgBentuk;
    private RadioButton rbPilih;
    private SeekBar sbRed, sbGreen, sbBlue;
    private ImageButton imgbtnColor;
    private CustomView customView;

    private String bentuk;
    private int red = 0, green = 0, blue = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rgBentuk = findViewById(R.id.rgBentuk);
        sbRed = findViewById(R.id.sbRed);
        sbGreen = findViewById(R.id.sbGreen);
        sbBlue = findViewById(R.id.sbBlue);
        imgbtnColor = findViewById(R.id.imgbtnWarna);

        customView = findViewById(R.id.customView);
        customView = new CustomView(this);

        rgBentuk.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                int intRb = rgBentuk.getCheckedRadioButtonId();
                rbPilih = findViewById(intRb);
                bentuk = rbPilih.getText().toString();
                customView.gantiBentuk(bentuk);
            }
        });

        sbRed.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            red = sbRed.getProgress();
            customView.gantiWarna(red, green, blue);
            imgbtnColor.setBackgroundColor(Color.rgb(red, green, blue));
            }
        });

        sbGreen.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            green = sbGreen.getProgress();
            customView.gantiWarna(red, green, blue);
            imgbtnColor.setBackgroundColor(Color.rgb(red, green, blue));
            }
        });

        sbBlue.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            blue = sbBlue.getProgress();
            customView.gantiWarna(red, green, blue);
            imgbtnColor.setBackgroundColor(Color.rgb(red, green, blue));
            }
        });





    }
}