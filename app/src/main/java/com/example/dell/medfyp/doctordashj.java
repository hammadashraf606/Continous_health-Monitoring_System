package com.example.dell.medfyp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;

public class doctordashj extends AppCompatActivity implements View.OnClickListener {
    private CardView msg,realtime,profile,trust;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctordashj);
       msg=(CardView)findViewById(R.id.msg);
       msg.setOnClickListener(this);
        realtime=(CardView)findViewById(R.id.realtime);
        realtime.setOnClickListener(this);

        profile=(CardView)findViewById(R.id.profile);
        profile.setOnClickListener(this);
        trust=(CardView)findViewById(R.id.trust);
        trust.setOnClickListener(this);



    }
    @Override
    public void onClick(View view) {

        Intent i;
        switch (view.getId())
        {
            case R.id.msg:i = new Intent(this,msgsend.class);startActivity(i);break;
            case R.id.realtime:i = new Intent(this,montior.class);startActivity(i);break;
            case R.id.profile:i = new Intent(this,doctorprofile.class);startActivity(i);break;
            case R.id.trust:i = new Intent(this,trusted.class);startActivity(i);break;

            default:break;
        }


    }
}
