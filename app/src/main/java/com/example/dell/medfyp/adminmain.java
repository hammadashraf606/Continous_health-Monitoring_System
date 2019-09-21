package com.example.dell.medfyp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;

public class adminmain extends AppCompatActivity implements View.OnClickListener {
    private CardView addpat,viewpat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adminmain);
        addpat=(CardView)findViewById(R.id.addpat);
        addpat.setOnClickListener(this);
        viewpat=(CardView)findViewById(R.id.viewpat);
        viewpat.setOnClickListener(this);


    }

    @Override
    public void onClick(View view) {
        Intent i;
        switch (view.getId())
        {
            case R.id.addpat:i = new Intent(this,patientcheck.class);startActivity(i);break;
            case R.id.viewpat:i = new Intent(this,patientcheck.class);startActivity(i);break;

            default:break;
        }

    }
}
