package com.example.regladeoro;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView contador;
    int c = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        contador = findViewById(R.id.contador);

        new Thread(
                () -> {

                    while (true) {
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        c++;

                        //Puente
                        runOnUiThread(
                                () -> {
                                    contador.setText("" + c);
                                }

                        );


                    }

                }
        ).start();
    }
}
