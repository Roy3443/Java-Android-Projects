package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.material.button.MaterialButton;
import org.mozilla.javascript.Context;
import org.mozilla.javascript.Scriptable;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    TextView textView1,textView2;
    MaterialButton buttonC,buttonOpen,buttonClose,buttonDivide,button7,button8,button9,buttonMultiply,
    button4,button5,button6,buttonPlus,button1,button2,button3,buttonMinus,
    buttonAC,button0,buttonDot,buttonEquals;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView1=findViewById(R.id.textView1);
        textView2=findViewById(R.id.textView2);

        assignId(buttonC,R.id.btn_back);
        assignId(buttonOpen,R.id.upperlimit);
        assignId(buttonClose,R.id.lowerlimit);
        assignId(buttonDivide,R.id.btn_divide);
        assignId(button7,R.id.btn7);
        assignId(button8,R.id.btn8);
        assignId(button9,R.id.btn9);
        assignId(buttonMultiply,R.id.btn_multiply);
        assignId(button4,R.id.btn4);
        assignId(button5,R.id.btn5);
        assignId(button6,R.id.btn6);
        assignId(buttonPlus,R.id.btn_plus);
        assignId(button1,R.id.btn1);
        assignId(button2,R.id.btn2);
        assignId(button3,R.id.btn3);
        assignId(buttonMinus,R.id.btn_minus);
        assignId(buttonAC,R.id.btn_ac);
        assignId(button0,R.id.btn_0);
        assignId(buttonDot,R.id.btn_dot);
        assignId(buttonEquals,R.id.btn_equal);

    }

    void assignId(MaterialButton btn,int id){
        btn=findViewById(id);
        btn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        MaterialButton button=(MaterialButton) v;
        String butnText=button.getText().toString();
        String data=textView1.getText().toString();

        if(butnText.equals("AC")){
            textView1.setText("");
            textView2.setText("0");
            return;
        }
        if(butnText.equals("U")){
            convert_to_upper();
            return;
        }
        if(butnText.equals("L")){
            convert_to_lower();
            return;
        }
        if(butnText.equals("=")){
            textView1.setText(textView2.getText());
            return;
        }
        if(butnText.equals("C")){
            if(data.length()>1) {
                data = data.substring(0, data.length() - 1);

            }
            else{
                textView1.setText("");
                textView2.setText("0");
                return;
            }
        }

        else {
            data+=butnText;

        }
        textView1.setText(data);
        String finalres=getResult(data);;

        if (!finalres.equals("Error")){
            textView2.setText(finalres);
        }
    }
    public void convert_to_upper(){
        String result_text= textView2.getText().toString();
        if(!result_text.isEmpty()){
            double result_value= Double.parseDouble(result_text);
            double upper_limit= Math.ceil(result_value*1000)/1000;
            DecimalFormat decimalFormat=new DecimalFormat("#.##");
            String result_to_upper=decimalFormat.format(upper_limit);
            textView2.setText(String.valueOf(result_to_upper));
        }
    }
    public void convert_to_lower(){
        String result_text= textView2.getText().toString();
        if(!result_text.isEmpty()){
            double result_value= Double.parseDouble(result_text);
            double lower_limit= Math.floor(result_value*1000)/1000;
            DecimalFormat decimalFormat=new DecimalFormat("#.##");
            String result_to_lower=decimalFormat.format(lower_limit);
            textView2.setText(String.valueOf(result_to_lower));
        }
    }


    String getResult(String data){
        try{
            Context context=Context.enter();
            context.setOptimizationLevel(-1);
            Scriptable scriptable=context.initStandardObjects();
            String finalresult=context.evaluateString(scriptable,data,"Javascript",1,null).toString();
            if(finalresult.endsWith(".0")){
                finalresult=finalresult.replace(".0","");
            }
            return finalresult;

        }
        catch (Exception e){
            return "Error";

        }
    }
}