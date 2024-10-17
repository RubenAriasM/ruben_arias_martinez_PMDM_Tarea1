package com.example.ruben_arias_martinez_pmdm_tarea1;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Login_Correcto_2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login_correcto2);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        //Button
        ImageButton btnImageTutorials = findViewById(R.id.imageButtonTutorialsPoint);
        Button btnAlarm = findViewById(R.id.buttonPonerAlarma);
        //Text View
        TextView tvWelcome = findViewById(R.id.textViewBienvenido);

        //recover data

        Bundle extras = getIntent().getExtras();

        String name = extras.getString("name");

        tvWelcome.setText(tvWelcome.getText() + name);

        btnImageTutorials.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //INTERNET URL
                String url="https://www.tutorialspoint.com/android/index.htm";
                Intent intentUrl = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                startActivity(intentUrl);
            }
        });

        btnAlarm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Login_Correcto_2.this, Poner_Alarma_3.class);
                //Iniciar Actividad
                startActivity(i);
            }
        });


    }
}