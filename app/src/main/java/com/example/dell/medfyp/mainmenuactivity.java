package com.example.dell.medfyp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;

public class mainmenuactivity extends AppCompatActivity implements View.OnClickListener {
private CardView docto,admn,stak,patient;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mainmenuactivity);
        docto=(CardView)findViewById(R.id.doce);
       admn=(CardView)findViewById(R.id.admiin);
        stak=(CardView)findViewById(R.id.stakh);
        patient=(CardView)findViewById(R.id.pat);



        docto.setOnClickListener(this);
        admn.setOnClickListener(this);
        stak.setOnClickListener(this);
        patient.setOnClickListener(this);




    }

    @Override
    public void onClick(View view) {

        Intent i;
        switch (view.getId())
        {
            case R.id.doce:i = new Intent(this,doctorlog.class);startActivity(i);break;
            case R.id.admiin:i = new Intent(this,adminlog.class);startActivity(i);break;
            case R.id.stakh:i = new Intent(this,stakholder.class);startActivity(i);break;
            case R.id.pat:i = new Intent(this,patient.class);startActivity(i);break;
            default:break;
        }


    }
}
