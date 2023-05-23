package com.example.mobilProje;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class appsActivity extends AppCompatActivity {


    Button  btn1;
    Button btn2;
    Button btn3;
    Button btn4;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_apps);


        btn1= findViewById(R.id.button1);
        btn2= findViewById(R.id.button2);
        btn3= findViewById(R.id.button3);
        btn4= findViewById(R.id.button4);


        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent a = new Intent(appsActivity.this, exchangeActivity.class);
                startActivity(a);
                Toast.makeText(appsActivity.this, "Döviz hesaplama açılıyor...", Toast.LENGTH_SHORT).show();




            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                Intent i = new Intent(appsActivity.this, calculatorActivity.class);
                startActivity(i);
                Toast.makeText(appsActivity.this, "Hesap makinesi açılıyor...", Toast.LENGTH_SHORT).show();

            }
        });



        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent c = new Intent(appsActivity.this, mainActivity5.class);
                startActivity(c);
                Toast.makeText(appsActivity.this, "Listview açılıyor...", Toast.LENGTH_SHORT).show();


            }

        });
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                Intent x = new Intent(appsActivity.this, navActivity.class);
                startActivity(x);
                Toast.makeText(appsActivity.this, "Ana menüye dönülüyor...", Toast.LENGTH_SHORT).show();

            }
        });
    }

}