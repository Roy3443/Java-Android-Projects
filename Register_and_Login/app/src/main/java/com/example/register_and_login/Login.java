package com.example.register_and_login;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Login extends AppCompatActivity {
    TextView signup;
//    Button login;
    AppCompatButton login;
    EditText name, email, password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        signup=findViewById(R.id.signup);
        name=findViewById(R.id.name);
        email=findViewById(R.id.email);
        password=findViewById(R.id.password);
        login=findViewById(R.id.login);
        Intent i=getIntent();
        String dis_name=i.getStringExtra("name");
        String dis_email=i.getStringExtra("email");
        String dis_pass=i.getStringExtra("pass");
        name.setText(dis_name);
        email.setText(dis_email);
        password.setText(dis_pass);


        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(validate()) {
                    Intent i = new Intent(Login.this, MainActivity.class);
                    startActivity(i);
                }
            }
        });
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    Intent i = new Intent(Login.this, SignUp.class);
                    startActivity(i);
            }
        });
    }
    public boolean validate(){
        if(name.getText().toString().equalsIgnoreCase("")){
            show_dialogbox(1,name);
            return false;
        }
        else if(email.getText().toString().equalsIgnoreCase("")){
            show_dialogbox(2,email);
            return false;

        }
        else if(password.getText().toString().equalsIgnoreCase("")){
            show_dialogbox(3,password);
            return false;
        }
        return true;
    }
    public void show_dialogbox(int case_no, EditText edit_txt ){
        AlertDialog.Builder builder=new AlertDialog.Builder(this);
        builder.setTitle("Required!");
        if(case_no==1){
            builder.setMessage("Please enter your username");
        }
        else if(case_no==2){
            builder.setMessage("Please enter your email");
        }
        else{
            builder.setMessage("Please enter your password");
        }
        builder.setPositiveButton("Okay", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                edit_txt.requestFocus();
                dialogInterface.dismiss();
            }
        });
        AlertDialog alertDialog= builder.create();
        alertDialog.show();
    }
}