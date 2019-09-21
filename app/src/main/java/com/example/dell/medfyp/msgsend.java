package com.example.dell.medfyp;

import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.Manifest;
import android.app.Activity;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.telephony.SmsManager;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.widget.Toolbar;


public class msgsend extends AppCompatActivity {
    private DrawerLayout d;
    private ActionBarDrawerToggle d_t;
    private final static int permission = 111;
    String no;
    Button back;

    PendingIntent s_intent, d_intent;
    BroadcastReceiver s_rec, d_rec,r_rec;
    String r = "\\d+";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_msgsend);

        Button b = (Button) findViewById(R.id.button);
        b.setEnabled(false);
        //set_nav_bar();
        if(check_permission(Manifest.permission.SEND_SMS))
        {
            b.setEnabled(true);
        }
        else{
            ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.SEND_SMS},permission);
        }
        s_intent = PendingIntent.getBroadcast(this,0,new Intent("SMS Sent"),0);
        d_intent = PendingIntent.getBroadcast(this,0,new Intent("SMS Delivered"),0);



    }


    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String permissions[], @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode) {
            case permission: {
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    Button b = (Button) findViewById(R.id.button);
                    b.setEnabled(true);


                } else {

                    Intent i = new Intent(getApplicationContext(),msgsend.class);
                    i.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
                    startActivity(i);
                    finish();
                }
                break;
            }
        }
    }

    public boolean check_permission(String string)
    {
        int cp=ContextCompat.checkSelfPermission(this,string);
        return cp==PackageManager.PERMISSION_GRANTED;
    }
    @Override
    protected void onResume()
    {
        super.onResume();

        IntentFilter intentFilter = new IntentFilter("SmsMessage.intent.MAIN");
        s_rec= new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                switch (getResultCode())
                {

                    case    Activity.RESULT_OK:
                        Toast.makeText(getApplicationContext(), "SMS sent.",
                                Toast.LENGTH_LONG).show();
                        break;

                    case SmsManager.RESULT_ERROR_GENERIC_FAILURE:
                        Toast.makeText(getApplicationContext(), "Generic Failure.",
                                Toast.LENGTH_LONG).show();
                        break;





                    case SmsManager.RESULT_ERROR_NO_SERVICE:
                        Toast.makeText(getApplicationContext(), "Service Not Availible.",
                                Toast.LENGTH_LONG).show();
                        break;



                    case SmsManager.RESULT_ERROR_NULL_PDU:
                        Toast.makeText(getApplicationContext(), "Generic Failure.",
                                Toast.LENGTH_LONG).show();
                        break;


                    case SmsManager.RESULT_ERROR_RADIO_OFF:
                        Toast.makeText(getApplicationContext(), "Radio OFF.",
                                Toast.LENGTH_LONG).show();
                        break;





                }
            }
        };
        d_rec=new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                switch (getResultCode())
                {
                    case Activity.RESULT_OK:
                        Toast.makeText(getApplicationContext(), "SMS Delivered.",
                                Toast.LENGTH_LONG).show();
                        break;
                    case Activity.RESULT_CANCELED:

                        Toast.makeText(getApplicationContext(), "Failed to Deliver Delivered.",
                                Toast.LENGTH_LONG).show();
                        break;
                }

            }
        };


        registerReceiver(s_rec,new IntentFilter("SMS Sent Successfully!"));
        registerReceiver(d_rec,new IntentFilter("SMS Delivered Successfully!"));
        registerReceiver(r_rec,intentFilter);
    }





    @Override
    protected void onPause()
    {
        unregisterReceiver(s_rec);
        unregisterReceiver(d_rec);
        unregisterReceiver(r_rec);

        super.onPause();
    }
    public void send_sms(View v)
    {

        no = "Kindly Visit The Clinic!";

        SmsManager manager = SmsManager.getDefault();
        manager.sendTextMessage("+923415615279", null, no, s_intent, d_intent);
        Toast.makeText(getApplicationContext(), "SMS sent Successfully!.",
                Toast.LENGTH_LONG).show();
    }



}
