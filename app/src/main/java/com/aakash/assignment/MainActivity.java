package com.aakash.assignment;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;


import android.content.DialogInterface;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    public static final String Tag="Counter";
    public static final String TAG="EditText";
    Button counter;
    int count =0;
    EditText username,password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        username=findViewById(R.id.etUsername);
        password=findViewById(R.id.etPassword);

        counter=findViewById(R.id.btnCounter);

        counter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                count+=1;
                if(count<=2){
                    String user= username.getText().toString().trim();
                    String pass=password.getText().toString().trim();
                    //do something
                    if(!user.isEmpty() && !pass.isEmpty()) {
                        Intent i = new Intent(MainActivity.this, SecondActivity.class);
                        startActivity(i);
                    }
                    else {
                            final Toast counter = Toast.makeText(MainActivity.this, "Fields can't be empty", Toast.LENGTH_SHORT);//if false show the toast
                            counter.show();
                    }
                }
                else{
                    //alert box
                    count =1;
                    AlertDialog.Builder builder1 = new AlertDialog.Builder(MainActivity.this);
                    builder1.setTitle("ALERT");
                    builder1.setIcon(R.drawable.ic_baseline_warning_24);
                    builder1.setMessage("Button Pressed multiple times");
                    builder1.setCancelable(true);

                    builder1.setPositiveButton(
                            "OK",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    dialog.cancel();
                                }
                            });
                    AlertDialog alert1 = builder1.create();
                    alert1.show();
                }
            }
        });

    }
    public void onClickCounter(View view) {
        Log.d(Tag,"Sign in Button Clicked");
    }

    public void onClickUsername(View view) {
        Log.d(TAG,"Username field Clicked");
    }

    public void onClickPassword(View view) {
        Log.d(TAG,"Password field Clicked");
    }
}