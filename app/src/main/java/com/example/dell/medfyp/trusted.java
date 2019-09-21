package com.example.dell.medfyp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class trusted extends AppCompatActivity {
    Button email;
    TextView phone;
    Button call;
    Button sms;

public void init()
{
    email=(Button)findViewById(R.id.email);
    email.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent toy=new Intent(trusted.this,sendemail.class);
            startActivity(toy);
        }
    });
}

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trusted);
        phone = (TextView) findViewById(R.id.phone);
init();

        Bundle bnd = getIntent().getExtras();
        if(bnd!=null){
            phone.setText(bnd.getString("phone"));



        }
    call = (Button) findViewById(R.id.call);
        call.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {

            CallUser(phone.getText().toString());


        }
    });

    sms = (Button) findViewById(R.id.sms);
        sms.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            sendSms(phone.getText().toString(),"Salam  Doctor Ahmad!");
        }
    });
}

    public void sendSms(String no,String message) {

        try{
            Intent sendIntent = new Intent(Intent.ACTION_VIEW);

            sendIntent.setData(Uri.parse("sms:"+no));
            sendIntent.putExtra("sms_body", message);
            startActivity(sendIntent);

        }catch (Exception e){}
    }


    public void CallUser(String number) {
        Intent sendIntent = new Intent(Intent.ACTION_CALL);
        sendIntent.setData(Uri.parse("tel:" + number));
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        startActivity(sendIntent);
    }

}
