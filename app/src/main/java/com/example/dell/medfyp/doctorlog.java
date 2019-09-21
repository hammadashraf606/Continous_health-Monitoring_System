package com.example.dell.medfyp;

import android.content.Intent;
import android.media.MediaCodec;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.regex.Pattern;





public class doctorlog extends AppCompatActivity {
    private EditText et_name,et_password;
    private String editText2,editText3;

    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctorlog);
        et_name=(EditText)findViewById(R.id.editText2);
        et_password=(EditText)findViewById(R.id.editText3);
        button =(Button)findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                register();
            }
        });
    }






    public  void register()
    {
        intialize();
        if(!validate()
                )
        {
            Toast.makeText(this,"Please Fill the Required information ",Toast.LENGTH_SHORT).show();
        }
        else if(editText3.equals("123") && editText2.equals("123"))
        {
            onsignupsucess();
            Intent intent=new Intent(doctorlog.this,doctordashj.class);
            startActivity(intent);

        }
        else
        {
            Toast.makeText(this,"Sorry The User Or Password is Wrong Try Again! ",Toast.LENGTH_SHORT).show();
        }
    }
    public void onsignupsucess()
    {
        Toast.makeText(this,"Login Success ",Toast.LENGTH_SHORT).show();
    }
    public boolean validate()
    {
        boolean valid=true;
        if(editText2.isEmpty())
        {
            et_name.setError("email");
            valid=false;
        }
        if(editText3.isEmpty())
        {
            et_password.setError("password");
            valid=false;
        }
        return  valid;
    }

    public void intialize()
    {
        editText2=et_name.getText().toString().trim();
        editText3=et_password.getText().toString().trim();

    }





}
