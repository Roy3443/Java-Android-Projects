package com.example.register_and_login;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;

import java.util.Calendar;

public class SignUp extends AppCompatActivity {
    EditText username, useremail, userph, userdob, userpass;
    RadioButton male,female;
    Button button2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        userdob=findViewById(R.id.userdob);
        useremail=findViewById(R.id.useremail);
        userpass=findViewById(R.id.userpass);
        username=findViewById(R.id.username);
        userph=findViewById(R.id.userph);
        button2=findViewById(R.id.button2);
        male=findViewById(R.id.male);
        female=findViewById(R.id.female);

        userdob.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Calendar c=Calendar.getInstance();
                int year=c.get(Calendar.YEAR);
                int month=c.get(Calendar.MONTH);
                int day=c.get(Calendar.YEAR);
                DatePickerDialog datePickerDialog=new DatePickerDialog(SignUp.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                        userdob.setText(i2+"-"+(i1+1)+"-"+i);

                    }
                },year,month,day);
                datePickerDialog.show();
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (validate()) {
                    String got_name=username.getText().toString();
                    String got_email=useremail.getText().toString();
                    String got_pass=userpass.getText().toString();
                    Intent i = new Intent(SignUp.this , Login.class);
                    i.putExtra("name", got_name);
                    i.putExtra("email", got_email);
                    i.putExtra("pass", got_pass);
                    startActivity(i);
                }
            }

        });
    }
    public boolean validate(){
        if(username.getText().toString().equalsIgnoreCase("")){
            showbox(1,username);
            return false;
        }
        else if(useremail.getText().toString().equalsIgnoreCase("")){
            showbox(2,useremail);
            return false;

        }
        else if(userpass.getText().toString().equalsIgnoreCase("")){
            showbox(3,userpass);
            return false;

        }
        else if(userdob.getText().toString().equalsIgnoreCase("")){
            showbox(4,userdob);
            return false;

        }
        else if (userph.getText().toString().equalsIgnoreCase("")) {
            showbox(5,userph);
            return false;

        }
        else if (!male.isChecked() && !female.isChecked()) {
            show_gen_box(6);
            return false;

        }
        return true;
    }
    public void showbox(int caseno, EditText edittxt){
        AlertDialog.Builder builder=new AlertDialog.Builder(this);
        builder.setTitle("Required!");
        switch (caseno){
            case 1: builder.setMessage("Please enter your username");
            break;

            case 2: builder.setMessage("Please enter your email");
            break;

            case 3:builder.setMessage("Please enter your password");
            break;

            case 4:builder.setMessage("Please enter dob");
            break;
            case 5:builder.setMessage("Please enter your phone number");
            break;


        }
        builder.setPositiveButton("Okay", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                edittxt.requestFocus();
                dialogInterface.dismiss();
            }
        });
        AlertDialog alertDialog=builder.create();
        alertDialog.show();
    }
    public void show_gen_box(int case_no){
        AlertDialog.Builder builder=new AlertDialog.Builder(this);
        builder.setTitle("Required!");
        if(case_no==6){
            builder.setMessage("Please enter your gender");
        }
        builder.setPositiveButton("Okay", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        });
        AlertDialog alertDialog=builder.create();
        alertDialog.show();
    }

}