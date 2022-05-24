package ru.mirea.netelev.looper;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Message;
import android.view.View;

import java.util.concurrent.ThreadLocalRandom;

public class MainActivity extends AppCompatActivity {
    MyLooper myLooper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        MyLooper myLooper = new MyLooper();
        myLooper.start();
    }
    public void onClick(View view) {
        Message msg = new Message();
        Bundle bundle = new Bundle();
        bundle.putString("KEY", "mirea");
        bundle.putString("OCC", "prosecutor");
        bundle.putInt("AGE", ThreadLocalRandom.current().nextInt(1, 100));

        try {
            Thread.sleep(ThreadLocalRandom.current().nextInt(1, 100));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        msg.setData(bundle);
        if (myLooper != null) {
            myLooper.handler.sendMessage(msg);
        }
    }
}