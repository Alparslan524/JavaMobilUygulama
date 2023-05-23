package com.example.mobilProje;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class mainActivity5 extends AppCompatActivity {


    ListView listview;
    ArrayList<String> liste;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);

        listview = findViewById(R.id.liste);
        liste = new ArrayList<>();
        liste.add("Alparslan");
        liste.add("Fatma");
        liste.add("Mehmet");
        liste.add("Ahmet");
        liste.add("Geri");
        ArrayAdapter<String> adapter=new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,android.R.id.text1, liste);
        listview.setAdapter(adapter);
        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (liste.get(position)) {


                    case "Alparslan":
                        Toast.makeText(mainActivity5.this, "id: alparslan | Şifre: 123", Toast.LENGTH_SHORT).show();
                        break;
                    case "Fatma":
                        Toast.makeText(mainActivity5.this, "id: fatma | Şifre: password", Toast.LENGTH_SHORT).show();
                        break;
                    case "Mehmet":
                        Toast.makeText(mainActivity5.this, "id: mehmet | Şifre: 123456789", Toast.LENGTH_SHORT).show();
                        break;
                    case "Ahmet":
                        Toast.makeText(mainActivity5.this, "id: ahmet | Şifre: ahmet4242", Toast.LENGTH_SHORT).show();
                        break;
                    case "Geri":
                        Intent i = new Intent(mainActivity5.this, appsActivity.class);
                        startActivity(i);
                        Toast.makeText(mainActivity5.this, "Menüye Yönlendiriliyorsunuz.", Toast.LENGTH_SHORT).show();
                        break;

                }

            }
        });
    }
}