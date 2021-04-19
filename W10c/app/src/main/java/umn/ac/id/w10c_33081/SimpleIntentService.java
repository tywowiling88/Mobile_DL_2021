package umn.ac.id.w10c_33081;

import android.app.IntentService;
import android.content.Intent;
import android.util.Log;

import androidx.annotation.Nullable;

public class SimpleIntentService extends IntentService {

    public SimpleIntentService(){
        super("SimpleIntentService");
    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {
        Log.i("INTENTSERVICE", "onHandleIntent: IntentService Dimulai!");
        int n = (int)(Math.random()*50) +10;
        try {
            for (int i = 0; i < n; i++){
                Thread.sleep(200);
                Log.i("INTENTSERVICE", "onHandleIntent: berjalan " + ((int) ((100 * i)/(float) n))+"%");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
