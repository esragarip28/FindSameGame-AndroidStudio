package com.esragarip.findsamegame;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    Button button1,button2,button3,button4,button5,button6,button7,button8,button9,button10,button11;
    Button button12,button13,button14,button15,button16,tryAgain;

    ArrayList<Integer>number=new ArrayList<>();
    ArrayList<Button> buttons=new ArrayList<>();
    int array[]=new int [16];
    LinkedList<Integer> linkedList=new LinkedList<>();
    LinkedList<Button> buttonLinkedList=new LinkedList<>();


    int counter=0;
    static String answer;
    static  int bound=8;
    TextView timeText,result;
    static int [] timeArray=new int[3];
    Handler handler;
    Runnable runnable;
    static int time=0;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        for (int i=1;i<9;i++){
            number.add(i);
            number.add(i);
        }

        button1=findViewById(R.id.button1);
        button2=findViewById(R.id.button2);
        button3=findViewById(R.id.button3);
        button4=findViewById(R.id.button4);
        button5=findViewById(R.id.button5);
        button6=findViewById(R.id.button6);
        button7=findViewById(R.id.button7);
        button8=findViewById(R.id.button8);
        button9=findViewById(R.id.button9);
        button10=findViewById(R.id.button10);
        button11=findViewById(R.id.button11);
        button12=findViewById(R.id.button12);
        button13=findViewById(R.id.button13);
        button14=findViewById(R.id.button14);
        button15=findViewById(R.id.button15);
        button16=findViewById(R.id.button16);
        timeText=findViewById(R.id.timeText);
        result=findViewById(R.id.result);
        tryAgain=findViewById(R.id.tryAgain);
        tryAgain.setEnabled(false);

        buttons.add(button1);
        buttons.add(button2);
        buttons.add(button3);
        buttons.add(button4);
        buttons.add(button5);
        buttons.add(button6);
        buttons.add(button7);
        buttons.add(button8);
        buttons.add(button9);
        buttons.add(button10);
        buttons.add(button11);
        buttons.add(button12);
        buttons.add(button13);
        buttons.add(button14);
        buttons.add(button15);
        buttons.add(button16);


        timeText.setVisibility(View.INVISIBLE);
        Intent intent=getIntent();
        answer=intent.getStringExtra("levelName");
        if (answer.equals("level2")){
            bound=12;
            for (int i=12;i<buttons.size();i++){
                buttons.get(i).setEnabled(false);
                buttons.get(i).setVisibility(View.INVISIBLE);
            }

        }
        else if (answer.equals("level1")){
            bound=8;
            for (int i=8;i<buttons.size();i++){
                buttons.get(i).setEnabled(false);
                buttons.get(i).setVisibility(View.INVISIBLE);
            }

        }
        else if (answer.equals("level3")){
            bound=16;
        }

        else if (answer.equals("level4")){
            bound=8;
            timeText.setVisibility(View.VISIBLE);



            for (int i=8;i<buttons.size();i++){
                buttons.get(i).setEnabled(false);
                buttons.get(i).setVisibility(View.INVISIBLE);
            }
        }
        else if (answer.equals("level5")){

            bound=12;
            timeText.setVisibility(View.VISIBLE);

            for (int i=12;i<buttons.size();i++){
                buttons.get(i).setEnabled(false);
                buttons.get(i).setVisibility(View.INVISIBLE);
            }

        }
        else if (answer.equals("level6")){
            bound=16;
            timeText.setVisibility(View.VISIBLE);

        }
        isFinished();
        int[]array=RandomizeArray();
        changePlace(array);
        hideNumber(); }

    public void exit(View view){
        System.exit(0);

    }
    public void again(View view){
        for(int j=0;j<bound;j++){
            buttons.get(j).setTextSize(0);
        }
        for(int i=0;i<buttons.size();i++){
            buttons.get(i).setEnabled(true);
        }

        int array1[]=RandomizeArray();
        changePlace(array1);
        hideNumber();

        tryAgain.setEnabled(false);
    }
    public void isFinished(){
        handler=new Handler();
        runnable=new Runnable() {
            @Override
            public void run() {
                if (answer.equals("level1")){
                    if (counter==4){
                        tryAgain.setEnabled(true);
                        counter=0;
                    }
                }
                if (answer.equals("level2")){
                    if (counter==6){
                        tryAgain.setEnabled(true);
                        counter=0;
                    }
                }
                if (answer.equals("level3")){
                    if (counter==8){
                        tryAgain.setEnabled(true);
                        counter=0;
                    }
                }

                handler.postDelayed(this,100);
            }
        };
        handler.post(runnable);
    }
    public void Back(View view){
        Intent intent=new Intent(MainActivity.this,LevelActivity.class);
        startActivity(intent);
        finish();

    }

    public void ButtonValue(View view){
        Button button=findViewById(view.getId());
        int value=Integer.parseInt(button.getText().toString());
        button.setTextSize(14);
        button.setTextColor(Color.BLACK);
        if(buttonLinkedList.size()==1){
            if (buttonLinkedList.get(0).getId()!=button.getId()){
                buttonLinkedList.add(button);
                linkedList.add(value);
            }
        }
        else{
            buttonLinkedList.add(button);
            linkedList.add(value);
        }

        if (linkedList.size()==2){
            new CountDownTimer(100,100) {
                @Override
                public void onTick(long l) {

                }

                @Override
                public void onFinish() {

                    if(linkedList.get(0)==linkedList.get(1)){
                        counter++;
                        buttonLinkedList.get(0).setTextSize(14);
                        buttonLinkedList.get(0).setTextColor(Color.BLACK);
                        buttonLinkedList.get(1).setTextSize(14);
                        buttonLinkedList.get(1).setTextColor(Color.BLACK);
                        buttonLinkedList.get(0).setEnabled(false);
                        buttonLinkedList.get(1).setEnabled(false);
                    }
                    else{
                        buttonLinkedList.get(0).setTextSize(0);
                        buttonLinkedList.get(1).setTextSize(0);
                    }
                    linkedList.clear();
                    buttonLinkedList.clear();

                }
            }.start(); }}

    public void changePlace(int [] array){
        for (int i=0;i<bound;i++){
            buttons.get(i).setText(String.valueOf(number.get(array[i])));
            buttons.get(i).setTextSize(14);
        }
    }
    public static int[] RandomizeArray(){
        int a=0;
        int b=0;
        if (answer.equals("level1") || answer.equals("level4")){
            b=8;
        }
        else if (answer.equals("level2") || answer.equals("level5")){
            b=12;
        }
        else if (answer.equals("level3") ||answer.equals("level6")){
            b=16;
        }
        Random rgen = new Random();  // Random number generator
        int size = b-a;
        int[] array = new int[size];

        for(int i=0; i<size; i++){
            array[i] = a+i;
        }

        for (int i=0; i<array.length; i++) {
            int randomPosition = rgen.nextInt(array.length);
            int temp = array[i];
            array[i] = array[randomPosition];
            array[randomPosition] = temp;
        }

        for(int s: array)
            System.out.println(s);
        return array;
    }
    public void hideNumber(){
        int firstTime=10;
        if(answer.equals("level6")){
            firstTime=20;
        }
        else if (answer.equals("level5")){
            firstTime=15;
        }
        timeText.setText("Left: "+firstTime);
        new CountDownTimer(2000, 1000) {
            @Override
            public void onTick(long l) {


            }
            @Override
            public void onFinish() {
                for (int i=0;i<bound;i++){
                    //below,it make button hidden
                    //buttons.get(i).setVisibility(View.INVISIBLE);
                    buttons.get(i).setTextSize(0);
                }
                if (answer.equals("level4")||answer.equals("level5")||answer.equals("level6")){
                    calculateTimeAndScore();
                }

            }

        }.start();
    }
    public void calculateTimeAndScore(){

        long fulltime=10000;
        if (answer.equals("level6")){
            fulltime=20000;
        }
        else if (answer.equals("level5")){
            fulltime=15000;
        }

        new CountDownTimer(fulltime, 1000) {

            @Override
            public void onTick(long l) {
                time=(int)l/1000;

                if (answer.equals("level4")){
                    if (counter!=4){
                        timeText.setText("Left: "+time);
                    }
                    else if (counter==4){
                        tryAgain.setEnabled(true);
                        result.setText("Congratulations...");
                        cancel();
                    } }


                else if (answer.equals("level5")){
                    if (counter!=6){
                        timeText.setText("Left: "+time);
                    }
                    else if (counter==6){
                        tryAgain.setEnabled(true);
                        result.setText("Congratulations...");
                        cancel();
                    }
                }
                else if (answer.equals("level6")){
                    if (counter!=8){
                        timeText.setText("Left: "+time);
                    }
                    else if (counter==8){
                        tryAgain.setEnabled(true);
                        result.setText("Congratulations...");
                        cancel();
                    } }}

            @Override
            public void onFinish() {

                if (answer.equals("level4")){
                    if (counter!=4){
                        result.setText("Time is Up !!!");
                    }
                }
                else if (answer.equals("level5")){
                    if (counter!=6){
                        result.setText("Time is Up !!!");
                    } }
                else if (answer.equals("level6")){
                    if (counter!=8){
                        result.setText("Time is Up !!!");
                    } }

                for (int a=0;a<bound;a++){
                    buttons.get(a).setTextColor(Color.BLACK);
                    buttons.get(a).setTextSize(14);
                    buttons.get(a).setEnabled(false);
                }
                tryAgain.setEnabled(true);
            }
        }.start();
        counter=0;



    }
}


