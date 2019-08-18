package com.example.hp.mycalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Button one;
    private Button two;
    private Button three;
    private Button four;
    private Button five;
    private Button six;
    private Button seven;
    private Button eight;
    private Button nine;
    private Button zero;
    private Button zzero;
    private Button clear1;
    private Button clear2;
    private Button mod;
    private Button div;
    private Button mul;
    private Button sub;
    private Button add;
    private Button equa;
    private Button dot;
    private TextView input;
    private TextView result;
    private final  char ADDTION='+';
    private final  char SUBTRACTION='-';
    private final  char MULTIPLICATION='*';
    private final  char DIVISION='/';
    private final char MOD='%';
    private final  char EQU=0;


    private double val1=Double.NaN;
    private double val2;

    private char action;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setupUIViews();



        zero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input.setText(input.getText().toString()+"0");
            }
        });

        one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input.setText(input.getText().toString()+"1");
            }
        });

        two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input.setText(input.getText().toString()+"2");
            }
        });

        three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input.setText(input.getText().toString()+"3");
            }
        });

        four.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input.setText(input.getText().toString()+"4");
            }
        });

        five.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input.setText(input.getText().toString()+"5");
            }
        });

        six.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input.setText(input.getText().toString()+"6");
            }
        });

        seven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input.setText(input.getText().toString()+"7");
            }
        });

        eight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input.setText(input.getText().toString()+"8");
            }
        });

        nine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input.setText(input.getText().toString()+"9");
            }
        });

        zzero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input.setText(input.getText().toString()+"00");
            }
        });

        dot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input.setText(input.getText().toString()+".");
            }
        });

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                compute();
                action=ADDTION;
                result.setText(String.valueOf(val1)+"+");
                input.setText(null);


            }
        });



        sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                compute();
                action=SUBTRACTION;
                result.setText(String.valueOf(val1)+"-");
                input.setText(null);



            }


        });



        mul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                compute();
                action=MULTIPLICATION;
                result.setText(String.valueOf(val1)+"*");
                input.setText(null);



            }
        });


        div.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                compute();
                action=DIVISION;
                result.setText(String.valueOf(val1)+"/");
                input.setText(null);


            }
        });



        mod.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                compute();
                action=MOD;
                result.setText(String.valueOf(val1)+"%");
                input.setText(null);


            }
        });



        equa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                equa.setText("=");
                compute();
                action=EQU;
               // result.setText(result.getText().toString()+String.valueOf(val2)+"="+String.valueOf(val1));
                result.setText(String.valueOf(val1));
                input.setText(null);

            }
        });

        clear1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(input.getText().length()>0)
                {
                    CharSequence name=input.getText().toString();
                    input.setText(name.subSequence(0,name.length()-1));

                }
                else
                {
                    val1=Double.NaN;
                    val2=Double.NaN;
                    input.setText(null);
                    result.setText(null);
                }
            }
        });

        clear2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                val1=Double.NaN;
                val2=Double.NaN;
                input.setText(null);
                result.setText(null);
            }
        });


    }

    private void setupUIViews() {

        zero=(Button) findViewById(R.id.btn0);
        one=(Button) findViewById(R.id.btn1);
        two=(Button) findViewById(R.id.btn2);
        three=(Button) findViewById(R.id.btn3);
        four=(Button) findViewById(R.id.btn4);
        five=(Button) findViewById(R.id.btn5);
        six=(Button) findViewById(R.id.btn6);
        seven=(Button) findViewById(R.id.btn7);
        eight=(Button) findViewById(R.id.btn8);
        nine=(Button) findViewById(R.id.btn9);
        zzero=(Button) findViewById(R.id.btn00);
        dot=(Button) findViewById(R.id.btndot);
        equa=(Button) findViewById(R.id.btnequ);
        add=(Button) findViewById(R.id.btnadd);
        sub=(Button) findViewById(R.id.btnsub);
        mul=(Button) findViewById(R.id.btnmul);
        div=(Button) findViewById(R.id.btndiv);
        mod=(Button) findViewById(R.id.btnmod);
        clear1=(Button) findViewById(R.id.btncl);
        clear2=(Button) findViewById(R.id.btnc);
        input=(TextView) findViewById(R.id.input);
        result=(TextView) findViewById(R.id.result);



    }

    private void compute() {
        if(!Double.isNaN(val1)){
            val2=Double.parseDouble(input.getText().toString());

            switch(action)
            {
                case ADDTION:
                    val1=val1+val2;
                    break;
                case SUBTRACTION:
                    val1=val1-val2;
                    break;
                case MULTIPLICATION:
                    val1=val1*val2;
                    break;
                case DIVISION:
                    val1=val1/val2;
                    break;
                case MOD:
                    val1=val1%val2;
                    break;
                case EQU:
                    break;
            }

        }
        else
        {
            val1=Double.parseDouble(input.getText().toString());
        }
    }
}
