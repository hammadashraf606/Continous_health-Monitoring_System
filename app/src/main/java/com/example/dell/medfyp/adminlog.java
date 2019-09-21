package com.example.dell.medfyp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class adminlog extends AppCompatActivity {
    private EditText et_name1, et_password1;
    private String editText2, editText3;

    Button button;
    Button button1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adminlogi);
        et_name1 = (EditText) findViewById(R.id.editText2);
        et_password1 = (EditText) findViewById(R.id.editText3);
        button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                register();
            }
        });
        Button button1 = (Button) findViewById(R.id.register);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(adminlog.this, register.class);
                startActivity(i);
            }
        });
    }

    public void register() {
        intialize();

        if (editText3.equals("123") && editText2.equals("123")) {
            onsignupsucess();
            Intent intent = new Intent(adminlog.this, register.class);
            startActivity(intent);

        } else {
            Toast.makeText(this, "Sorry The User Or Password is Wrong Try Again! ", Toast.LENGTH_SHORT).show();
        }
    }

    public void onsignupsucess() {
        Toast.makeText(this, "Login Success ", Toast.LENGTH_SHORT).show();
    }
//    public boolean validate()
//    {
//        boolean valid=true;
//        if(editText2.isEmpty())
//        {
//            et_name.setError("email");
//            valid=false;
//        }
//        if(editText3.isEmpty())
//        {
//            et_password.setError("password");
//            valid=false;
//        }
//        return  valid;
//    }

    public void intialize() {
        editText2 = et_name1.getText().toString().trim();
        editText3 = et_password1.getText().toString().trim();

    }
}

