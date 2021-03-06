package com.example.david.switchcolor;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.CountDownTimer;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.lang.reflect.Array;
import java.util.Random;

public class SwitchColor extends AppCompatActivity {
    int score=0;
    Button b, b1,b2,b3,b4;
    TextView t1,t2;
    String []color=new String[11];
    String[]colorButtons=new String[4];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_switch_color);
        b=(Button)findViewById(R.id.startButton);
        b1=(Button)findViewById(R.id.button);
        b2=(Button)findViewById(R.id.button2);
        b3=(Button)findViewById(R.id.button3);
        b4=(Button)findViewById(R.id.button4);
        t1=(TextView)findViewById(R.id.textColor);
        t2=(TextView)findViewById(R.id.score);


        b1.setVisibility(View.INVISIBLE);
        b2.setVisibility(View.INVISIBLE);
        b3.setVisibility(View.INVISIBLE);
        b4.setVisibility(View.INVISIBLE);
        t1.setVisibility(View.INVISIBLE);

        createColorNames();
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new CountDownTimer(63000,3000){
                    @Override
                    public void onTick(long millisUntilFinished) {
                        startGame();
                        t2.setText("Score: "+score);
                    }

                    @Override
                    public void onFinish() {
                        AlertDialog.Builder alertDialogBuilder=new AlertDialog.Builder(SwitchColor.this);
                        alertDialogBuilder
                                .setMessage("Game Over \nP1: "+score)
                                .setCancelable(false)
                                .setPositiveButton("New", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        Intent intent=new Intent(getApplicationContext(),SwitchColor.class);
                                        startActivity(intent);
                                        finish();
                                    }
                                }).setNegativeButton("Exit", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                finish();
                            }
                        });
                        AlertDialog alertDialog=alertDialogBuilder.create();
                        alertDialog.show();
                    }
                }.start();
            }
        });


    }
    private void createColorNames(){
        color[0]="BLACK";
        color[10]="GRAY";
        color[2]="RED";
        color[3]="PINK";
        color[4]="ORANGE";
        color[5]="YELLOW";
        color[6]="GREEN";
        color[7]="BLUE";
        color[8]="PURPLE";
        color[9]="BROWN";
        color[1]="GOLD";

       // shuffleColor(color);
        
    }
   private void shuffleColor(){
        Random random=new Random();
        for (int i=0;i<color.length;i++){
            String temp=color[i];
            int index=random.nextInt(11);
            color[i]=color[index];
            color[index]=temp;
        }

    }

    private void startGame(){
        shuffleColor();
        colorButtons[0]=color[0];
        colorButtons[1]=color[1];
        colorButtons[2]=color[2];
        colorButtons[3]=color[3];
        b.setVisibility(View.INVISIBLE);
        b1.setVisibility(View.VISIBLE);
        b2.setVisibility(View.VISIBLE);
        b3.setVisibility(View.VISIBLE);
        b4.setVisibility(View.VISIBLE);
        t1.setVisibility(View.VISIBLE);
        b1.setEnabled(true);
        b2.setEnabled(true);
        b3.setEnabled(true);
        b4.setEnabled(true);
        assignColorText();
        assignColorButton();
        
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                b1.setEnabled(false);
                b2.setEnabled(false);
                b3.setEnabled(false);
                b4.setEnabled(false);
                String textColor=color[0];
                String textButtonColor=colorButtons[0];
                if(textColor.equals(textButtonColor)){
                    score++;
                }
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                b1.setEnabled(false);
                b2.setEnabled(false);
                b3.setEnabled(false);
                b4.setEnabled(false);
                String textColor=color[0];
                String textButtonColor=colorButtons[1];
                if(textColor.equals(textButtonColor)){
                    score++;
                }
            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                b1.setEnabled(false);
                b2.setEnabled(false);
                b3.setEnabled(false);
                b4.setEnabled(false);
                String textColor=color[0];
                String textButtonColor=colorButtons[2];
                if(textColor.equals(textButtonColor)){
                    score++;
                }
            }
        });
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                b1.setEnabled(false);
                b2.setEnabled(false);
                b3.setEnabled(false);
                b4.setEnabled(false);
                String textColor=color[0];
                String textButtonColor=colorButtons[3];
                if(textColor.equals(textButtonColor)){
                    score++;
                }
            }
        });
    }

    private void assignColorText(){
        if(color[0].equals("BLACK")){
            t1.setTextColor(Color.BLACK);
        }else if(color[0].equals("GRAY")){
            t1.setTextColor(Color.GRAY);
        }else if(color[0].equals("RED")){
            t1.setTextColor(Color.RED);
        }else if(color[0].equals("PINK")){
            t1.setTextColor(Color.rgb(255,20,147));
        }else if(color[0].equals("ORANGE")){
            t1.setTextColor(Color.rgb(255,140,0));
        }else if(color[0].equals("YELLOW")){
            t1.setTextColor(Color.YELLOW);
        }else if(color[0].equals("GREEN")){
            t1.setTextColor(Color.GREEN);
        }else if(color[0].equals("BLUE")){
            t1.setTextColor(Color.BLUE);
        }else if(color[0].equals("PURPLE")){
            t1.setTextColor(Color.rgb(128,0,128));
        }else if(color[0].equals("BROWN")){
            t1.setTextColor(Color.rgb(102,51,0));
        }else if(color[0].equals("GOLD")){
            t1.setTextColor(Color.rgb(255,215,0));
        }
        t1.setText(color[1]);
    }
    
    private void assignColorButton(){
        shuffleButtonsColor();
        b1.setTextColor(Color.WHITE);
            if(colorButtons[0].equals("BLACK")){
                b1.setBackgroundColor(Color.BLACK);
            }else if(colorButtons[0].equals("GRAY")){
                b1.setBackgroundColor(Color.GRAY);
            }else if(colorButtons[0].equals("RED")){
                b1.setBackgroundColor(Color.RED);
            }else if(colorButtons[0].equals("PINK")){
                b1.setBackgroundColor(Color.rgb(255,20,147));
            }else if(colorButtons[0].equals("ORANGE")){
                b1.setBackgroundColor(Color.rgb(255,140,0));
            }else if(colorButtons[0].equals("YELLOW")){
                b1.setTextColor(Color.BLACK);
                b1.setBackgroundColor(Color.YELLOW);
            }else if(colorButtons[0].equals("GREEN")){
                b1.setTextColor(Color.BLACK);
                b1.setBackgroundColor(Color.GREEN);
            }else if(colorButtons[0].equals("BLUE")){
                b1.setBackgroundColor(Color.BLUE);
            }else if(colorButtons[0].equals("PURPLE")){
                b1.setBackgroundColor(Color.rgb(128,0,128));
            }else if(colorButtons[0].equals("BROWN")){
                b1.setBackgroundColor(Color.rgb(102,51,0));
            }else if(colorButtons[0].equals("GOLD")){
                b1.setTextColor(Color.BLACK);
                b1.setBackgroundColor(Color.rgb(255,215,0));
            }
            b2.setTextColor(Color.WHITE);
            if(colorButtons[1].equals("BLACK")){
                b2.setBackgroundColor(Color.BLACK);
        }else if(colorButtons[1].equals("GRAY")){
            b2.setBackgroundColor(Color.GRAY);
        }else if(colorButtons[1].equals("RED")){
            b2.setBackgroundColor(Color.RED);
        }else if(colorButtons[1].equals("PINK")){
            b2.setBackgroundColor(Color.rgb(255,20,147));
        }else if(colorButtons[1].equals("ORANGE")){
            b2.setBackgroundColor(Color.rgb(255,140,0));
        }else if(colorButtons[1].equals("YELLOW")){
            b2.setTextColor(Color.BLACK);
            b2.setBackgroundColor(Color.YELLOW);
        }else if(colorButtons[1].equals("GREEN")){
            b2.setTextColor(Color.BLACK);
            b2.setBackgroundColor(Color.GREEN);
        }else if(colorButtons[1].equals("BLUE")){
            b2.setBackgroundColor(Color.BLUE);
        }else if(colorButtons[1].equals("PURPLE")){
            b2.setBackgroundColor(Color.rgb(128,0,128));
        }else if(colorButtons[1].equals("BROWN")){
            b2.setBackgroundColor(Color.rgb(102,51,0));
        }else if(colorButtons[1].equals("GOLD")){
            b2.setTextColor(Color.BLACK);
            b2.setBackgroundColor(Color.rgb(255,215,0));
        }
        b3.setTextColor(Color.WHITE);
        if(colorButtons[2].equals("BLACK")){
            b3.setBackgroundColor(Color.BLACK);
        }else if(colorButtons[2].equals("GRAY")){
            b3.setBackgroundColor(Color.GRAY);
        }else if(colorButtons[2].equals("RED")){
            b3.setBackgroundColor(Color.RED);
        }else if(colorButtons[2].equals("PINK")){
            b3.setBackgroundColor(Color.rgb(255,20,147));
        }else if(colorButtons[2].equals("ORANGE")){
            b3.setBackgroundColor(Color.rgb(255,140,0));
        }else if(colorButtons[2].equals("YELLOW")){
            b3.setTextColor(Color.BLACK);
            b3.setBackgroundColor(Color.YELLOW);
        }else if(colorButtons[2].equals("GREEN")){
            b3.setTextColor(Color.BLACK);
            b3.setBackgroundColor(Color.GREEN);
        }else if(colorButtons[2].equals("BLUE")){
            b3.setBackgroundColor(Color.BLUE);
        }else if(colorButtons[2].equals("PURPLE")){
            b3.setBackgroundColor(Color.rgb(128,0,128));
        }else if(colorButtons[2].equals("BROWN")){
            b3.setBackgroundColor(Color.rgb(102,51,0));
        }else if(colorButtons[2].equals("GOLD")){
            b3.setTextColor(Color.BLACK);
            b3.setBackgroundColor(Color.rgb(255,215,0));
        }
        b4.setTextColor(Color.WHITE);
        if(colorButtons[3].equals("BLACK")){
            b4.setBackgroundColor(Color.BLACK);
        }else if(colorButtons[3].equals("GRAY")){
            b4.setBackgroundColor(Color.GRAY);
        }else if(colorButtons[3].equals("RED")){
            b4.setBackgroundColor(Color.RED);
        }else if(colorButtons[3].equals("PINK")){
            b4.setBackgroundColor(Color.rgb(255,20,147));
        }else if(colorButtons[3].equals("ORANGE")){
            b4.setBackgroundColor(Color.rgb(255,140,0));
        }else if(colorButtons[3].equals("YELLOW")){
            b4.setTextColor(Color.BLACK);
            b4.setBackgroundColor(Color.YELLOW);
        }else if(colorButtons[3].equals("GREEN")){
            b4.setTextColor(Color.BLACK);
            b4.setBackgroundColor(Color.GREEN);
        }else if(colorButtons[3].equals("BLUE")){
            b4.setBackgroundColor(Color.BLUE);
        }else if(colorButtons[3].equals("PURPLE")){
            b4.setBackgroundColor(Color.rgb(128,0,128));
        }else if(colorButtons[3].equals("BROWN")){
            b4.setBackgroundColor(Color.rgb(102,51,0));
        }else if(colorButtons[3].equals("GOLD")){
            b4.setTextColor(Color.BLACK);
            b4.setBackgroundColor(Color.rgb(255,215,0));
        }
        b1.setText(colorButtons[2]);
        b2.setText(colorButtons[1]);
        b3.setText(colorButtons[0]);
        b4.setText(colorButtons[3]);

    }
    private void shuffleButtonsColor(){
        Random random=new Random();
        for(int i=0;i<3;i++){
            int index=random.nextInt(3);
            String temp=colorButtons[i];
            colorButtons[i]=colorButtons[index];
            colorButtons[index]=temp;
        }
    }
    
}
