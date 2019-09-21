package com.example.dell.medfyp;


import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class register extends Activity {
    EditText editText_last_name;
    Button editText_phone;
    Button editText_email;
    EditText editText_fname;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        editText_fname = (EditText) findViewById(R.id.editText_fname);
        editText_last_name = (EditText) findViewById(R.id.editText_lasname);
        editText_email = findViewById(R.id.editText_email);
        editText_phone = findViewById(R.id.editText_phone);
        Button buttonSend = findViewById(R.id.buttonSend);
        buttonSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(register.this, "You have been Registered Successfully!", Toast.LENGTH_SHORT).show();
            }
        });

    }


}