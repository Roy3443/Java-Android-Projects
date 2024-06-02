package com.example.tictactoe;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button button1,button2,button3,button4,button5,button6,button7,button8,button9,reset,reset_score;
    String b1,b2,b3,b4,b5,b6,b7,b8,b9;
    TextView player1,player2;
    int flag=0;
    int score_x=0;
    int score_y=0;
    int count=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button1=findViewById(R.id.button1);
        button2=findViewById(R.id.button2);
        button3=findViewById(R.id.button3);
        button4=findViewById(R.id.button4);
        button5=findViewById(R.id.button5);
        button6=findViewById(R.id.button6);
        button7=findViewById(R.id.button7);
        button8=findViewById(R.id.button8);
        button9=findViewById(R.id.button9);
        reset=findViewById(R.id.reset);
        reset_score=findViewById(R.id.reset_score);
        player1=findViewById(R.id.player1);
        player2=findViewById(R.id.player2);
        player1.setText("Player X: "+score_x);
        player2.setText("Player Y: "+score_y);


        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                restart();
            }
        });

        reset_score.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                score_x=0;
                score_y=0;
                player1.setText("Player X: "+score_x);
                player2.setText("Player Y: "+score_y);
                restart();
            }
        });
    }

    public void update_score(String winner){
        if(winner=="X"){
            score_x+=1;
            player1.setText("Player X: "+score_x);
        }
        else{
            score_y+=1;
            player2.setText("Player Y: "+score_y);
        }
    }
    public void showbox(int case_no){
        AlertDialog.Builder builder=new AlertDialog.Builder(this);
        builder.setTitle("Info");

        switch (case_no){
            case 1:
                builder.setMessage("Congratulations! Winner is:"+b1);
                update_score(b1);
                break;
            case 2:
                builder.setMessage("Congratulations! Winner is:"+b4);
                update_score(b4);
                break;
            case 3:
                builder.setMessage("Congratulations! Winner is:"+b7);
                update_score(b7);
                break;
            case 4:
                builder.setMessage("Congratulations! Winner is:"+b2);
                update_score(b2);
                break;
            case 5:
                builder.setMessage("Congratulations! Winner is:"+b3);
                update_score(b3);
                break;
            case 6:
                builder.setMessage("It's a draw");
                break;


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
    public void Check(View view) {

        Button currentButton = (Button)view;


        if (currentButton.getText().toString().equals("")) {
            count++;

            if (flag == 0) {
                currentButton.setTextColor(Color.RED);
                currentButton.setText("X");
                flag = 1;
            } else {
                currentButton.setTextColor(Color.GREEN);
                currentButton.setText("O");
                flag = 0;
            }
            if (count > 4) {
                b1 = button1.getText().toString();
                b2 = button2.getText().toString();
                b3 = button3.getText().toString();
                b4 = button4.getText().toString();
                b5 = button5.getText().toString();
                b6 = button6.getText().toString();
                b7 = button7.getText().toString();
                b8 = button8.getText().toString();
                b9 = button9.getText().toString();

                if (b1.equals(b2) && b2.equals(b3) && !b1.equals("")) {//1row
                    showbox(1);

                    restart();

                }
                else if (b4.equals(b5) && b5.equals(b6) && !b4.equals("")) {
                    //2row
                    showbox(2);
                    restart();

                }
                else if (b7.equals(b8) && b8.equals(b9) && !b7.equals("")) {
                    //3row
                    showbox(3);
                    restart();

                }
                else if (b1.equals(b4) && b4.equals(b7) && !b1.equals("")) {//1col
                    showbox(1);
                    restart();

                }
                else if (b2.equals(b5) && b5.equals(b8) && !b2.equals("")) {
                    //2col
                    showbox(4);
                    restart();

                }
                else if (b3.equals(b6) && b6.equals(b9) && !b3.equals("")) {
                    //3col
                    showbox(5);
                    restart();


                }
                else if (b1.equals(b5) && b5.equals(b9) && !b1.equals("")) {
                    //1dig
                    showbox(1);
                    restart();

                }
                else if (b3.equals(b5) && b5.equals(b7) && !b3.equals("")) {
                    showbox(5);
                    restart();

                }
                else if (!b1.equals("") && !b2.equals("") && !b3.equals(" ")
                && !b4.equals("") && !b5.equals("") && !b6.equals("")
                && !b7.equals("") && !b8.equals("") && !b9.equals("")) {
                    showbox(6);
                    restart();
                }


            }

        }
    }
    public void restart(){
        button1.setText("");
        button2.setText("");
        button3.setText("");
        button4.setText("");
        button5.setText("");
        button6.setText("");
        button7.setText("");
        button8.setText("");
        button9.setText("");
        flag=0;
        count=0;



    }

}