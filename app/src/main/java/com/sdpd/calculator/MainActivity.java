package com.sdpd.calculator;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;

public class MainActivity extends AppCompatActivity {

    Button button0, button1, button2, button3, button4, button5, button6, button7, button8, button9, buttonReplay, buttonMul, buttonDiv, buttonAdd, buttonSub, buttonEqu, buttonC;
    TextView textDown, textMid, textUp;

    Integer value1=null, value2=null, result=null;

    protected ArrayList<Integer> lastResults = new ArrayList<Integer>();
    int replayIndex = 0;

    Integer calculate(Integer a, Integer b){
        Integer temp=0;
        if(b!=null && a!=null) {
            switch (textMid.getText().toString()) {
                case "+":
                    temp = a + b;
                    break;
                case "-":
                    temp = a - b;
                    break;
                case "*":
                    temp = a * b;
                    break;
                case "/":
                    temp = (!b.equals(0))?a / b : 0;
                    break;
                default:
                    temp = a;
                    break;
            }
        }
        else      temp = (a == null)? b : a ;
        if(a==null && b==null) temp = 0;
        return temp;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button1 = (Button) findViewById(R.id.button1);
        button2 = (Button) findViewById(R.id.button2);
        button3 = (Button) findViewById(R.id.button3);
        button4 = (Button) findViewById(R.id.button4);
        button5 = (Button) findViewById(R.id.button5);
        button6 = (Button) findViewById(R.id.button6);
        button7 = (Button) findViewById(R.id.button7);
        button8 = (Button) findViewById(R.id.button8);
        button9 = (Button) findViewById(R.id.button9);
        button0 = (Button) findViewById(R.id.button0);
        buttonReplay = (Button) findViewById(R.id.buttonReplay);
        buttonMul = (Button) findViewById(R.id.buttonMul);
        buttonDiv = (Button) findViewById(R.id.buttonDiv);
        buttonAdd = (Button) findViewById(R.id.buttonAdd);
        buttonSub = (Button) findViewById(R.id.buttonSub);
        buttonEqu = (Button) findViewById(R.id.buttonEqu);
        buttonC = (Button) findViewById(R.id.buttonC);
        textDown = (TextView) findViewById(R.id.textDown);
        textMid = (TextView) findViewById(R.id.textMid);
        textUp = (TextView) findViewById(R.id.textUp);

        button0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textDown.setText(textDown.getText()+"0");
            }
        });

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textDown.setText(textDown.getText()+"1");
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textDown.setText(textDown.getText()+"2");
            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textDown.setText(textDown.getText()+"3");
            }
        });

        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textDown.setText(textDown.getText()+"4");
            }
        });

        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textDown.setText(textDown.getText()+"5");
            }
        });

        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textDown.setText(textDown.getText()+"6");
            }
        });

        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textDown.setText(textDown.getText()+"7");
            }
        });

        button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textDown.setText(textDown.getText()+"8");
            }
        });

        button9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textDown.setText(textDown.getText()+"9");
            }
        });

        buttonEqu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(textDown.getText().toString() != "") {
                    value2 = Integer.parseInt(textDown.getText().toString());
                }
                else if(textUp.getText().toString() != ""){
                    value1 = Integer.parseInt(textUp.getText().toString());
                }
                else value2 = null;
                result = calculate(value1, value2);
                textUp.setText(Integer.toString(result));
                textMid.setText("");
                textDown.setText("");
                if(lastResults.size()>=5) lastResults.remove(0);
                lastResults.add(result);
                replayIndex = lastResults.size()-1;
                result=null;
                value2 = null;
                value1 = null;
            }
        });

        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(textUp.getText().toString()==""){
                    value1 = textDown.getText().toString().equals("")? 0 : Integer.parseInt(textDown.getText().toString());
                }
                else{
                    if(textDown.getText().toString() != ""){
                        value2 = Integer.parseInt(textDown.getText().toString());
                        value1 = calculate(value1,value2);
                    }
                    else value1 = Integer.parseInt(textUp.getText().toString());
                    value2 = null;
                }
                textUp.setText(Integer.toString(value1));
                textMid.setText("+");
                textDown.setText("");
            }
        });

        buttonSub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                if(textUp.getText().toString()==""){
//                    value1 = Integer.parseInt(textDown.getText().toString());
//                }
//                else{
//                    if(textDown.getText().toString() != ""){
//                        value2 = Integer.parseInt(textDown.getText().toString());
//                        value1 = calculate(value1,value2);
//                    }
//                    else{
//                        value1 = Integer.parseInt(textUp.getText().toString());
//                    }
//                    value2 = null;
//                }
//                textUp.setText(Integer.toString(value1));
//                textMid.setText("-");
//                textDown.setText("");
                boolean down = !textDown.getText().toString().equals(""), up = !textUp.getText().toString().equals(""), mid = !textMid.getText().toString().equals("");
                if(!down && ((mid && up)|| (!mid && !up)) ){
                    textDown.setText("-");
                }
                else{
                    if(!down){
                        value1 = Integer.parseInt(textUp.getText().toString());
                    }
                    else{
                        if(textDown.getText().toString().equals("-")){
                            textDown.setText("");
                        }
                        else if(textUp.getText().toString() != ""){
                            value2 = Integer.parseInt(textDown.getText().toString());
                            value1 = calculate(value1,value2);
                        }
                        else{
                            value1 = Integer.parseInt(textDown.getText().toString());
                        }
                    }
                    textUp.setText(Integer.toString(value1));
                    textMid.setText("-");
                    textDown.setText("");
                }
            }
        });

        buttonMul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(textUp.getText().toString()==""){
                    value1 = textDown.getText().toString().equals("")? 0 : Integer.parseInt(textDown.getText().toString());
                }
                else{
                    if(textDown.getText().toString() != ""){
                        value2 = Integer.parseInt(textDown.getText().toString());
                        value1 = calculate(value1,value2);
                    }
                    else value1 = Integer.parseInt(textUp.getText().toString());
                    value2 = null;
                }
                textUp.setText(Integer.toString(value1));
                textMid.setText("*");
                textDown.setText("");
            }
        });

        buttonDiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(textUp.getText().toString()==""){
                    value1 = textDown.getText().toString().equals("")? 0 : Integer.parseInt(textDown.getText().toString());
                }
                else{
                    if(textDown.getText().toString() != ""){
                        value2 = Integer.parseInt(textDown.getText().toString());
                        value1 = calculate(value1,value2);
                    }
                    else value1 = Integer.parseInt(textUp.getText().toString());
                    value2 = null;
                }
                textUp.setText(Integer.toString(value1));
                textMid.setText("/");
                textDown.setText("");
            }
        });

        buttonC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                value1 = null;
                value2 = null;
                result = null;
                textUp.setText("");
                textMid.setText("");
                textDown.setText("");
            }
        });

        buttonReplay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textUp.setText(Integer.toString(lastResults.get(replayIndex)));
                textMid.setText("");
                textDown.setText("");
                replayIndex--;
                if(replayIndex<0) replayIndex = lastResults.size()-1;
            }
        });

    }
}