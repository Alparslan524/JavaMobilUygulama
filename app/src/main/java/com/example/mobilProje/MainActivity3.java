package com.example.mobilProje;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;
import android.os.AsyncTask;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

public class MainActivity3 extends AppCompatActivity {

    private TextView tvExchangeRateDolar;
    private TextView tvExchangeRateEuro;
    private String euroRateStr;
    private String dolarRateStr;
    Button btn;
    Button btn2;
    EditText h1;
    EditText h2;
    RadioGroup rg;
    RadioButton rb1;
    RadioButton rb2;
    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);


        btn= findViewById(R.id.btn);
        btn2= findViewById(R.id.btn2);
        rg= findViewById(R.id.rg);
        rb1= findViewById(R.id.rb1);
        rb2= findViewById(R.id.rb2);
        h1= findViewById(R.id.h1);
        tv= findViewById(R.id.tv);



        tvExchangeRateDolar = findViewById(R.id.textViewDolar);
        tvExchangeRateEuro = findViewById(R.id.textViewEuro);
        // Döviz kuru almak için AsyncTask'i başlat
        FetchExchangeRateTask task = new FetchExchangeRateTask();
        task.execute();


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(rb1.isChecked()) {
                    double a, b, c;
                    a = Double.parseDouble(h1.getText().toString());
                    b = Double.parseDouble(euroRateStr.split(":")[1].trim());
                    c = a * b;

                    tv.setText(String.valueOf(c));
                    Toast.makeText(MainActivity3.this, "Euro bazında hesaplanmıştır.", Toast.LENGTH_SHORT).show();
                }
                if(rb2.isChecked()) {
                    double a, b, c;
                    a = Double.parseDouble(h1.getText().toString());
                    b = Double.parseDouble(dolarRateStr.split(":")[1].trim());
                    c = a * b;

                    tv.setText(String.valueOf(c));
                    Toast.makeText(MainActivity3.this, "Dolar bazında hesaplanmıştır.", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(MainActivity3.this, MainActivity2.class);
                startActivity(i);
                Toast.makeText(MainActivity3.this, "Menüye yönlendiriliyorsunuz.", Toast.LENGTH_SHORT).show();
            }
        });

    }

    private class FetchExchangeRateTask extends AsyncTask<Void, Void, String> {
        @Override
        protected String doInBackground(Void... voids) {
            try {
                // TCMB Döviz Kuru API'sinden verileri almak için HTTP isteği yap
                String apiUrl = "https://api.exchangerate-api.com/v4/latest/TRY";
                return HttpHelper.sendGetRequest(apiUrl);
            } catch (IOException e) {
                e.printStackTrace();
                return null;
            }
        }

        @Override
        protected void onPostExecute(String response) {
            super.onPostExecute(response);

            if (response != null) {
                try {
                    JSONObject jsonObject = new JSONObject(response);
                    JSONObject rates = jsonObject.getJSONObject("rates");

                    // TL/Dolar kurunu al
                    double tryToUsd = 1 / rates.getDouble("USD"); // Burada 1'e bölerek TL/Dolar kurunu elde ediyoruz
                    double tryToEuro = 1/rates.getDouble("EUR");
                    tvExchangeRateDolar.setText("1 Dolar: " + tryToUsd);
                    tvExchangeRateEuro.setText("1 Euro: "+tryToEuro);
                    euroRateStr="1 Euro: " + tryToEuro;
                    dolarRateStr="1 Dolar: " + tryToUsd;
                } catch (JSONException e) {
                    e.printStackTrace();
                    tvExchangeRateDolar.setText("Kur alınamadı.");
                    tvExchangeRateEuro.setText("Kur alınamadı.");
                }
            } else {
                tvExchangeRateDolar.setText("Kur alınamadı.");
                tvExchangeRateEuro.setText("Kur alınamadı.");
            }
        }
    }



}
