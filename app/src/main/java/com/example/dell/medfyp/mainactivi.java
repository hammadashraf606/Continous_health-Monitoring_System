package com.example.dell.medfyp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ProgressBar;

public class mainactivi extends AppCompatActivity {
    int progress;
    ProgressBar progressBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mainactivi);
        progressBar=(ProgressBar)findViewById(R.id.progressBar);
        new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i=0;i<10;i++)
                {
                    progress +=10;
                    progressBar.setProgress(progress);
                    if(progress == progressBar.getMax())
                    {
                        Intent intent=new Intent(mainactivi.this
                                ,mainmenuactivity.class);
                        startActivity(intent);
                        finish();
                    }
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }


}
