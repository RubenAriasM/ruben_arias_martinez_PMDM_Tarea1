package com.example.ruben_arias_martinez_pmdm_tarea1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity_Login_1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // VARIABLES
        //BUTTONS
        Button btnLogin = findViewById(R.id.buttonLogin);
        Button btnModify = findViewById(R.id.buttonModifyCredentials);
        //EDIT TEXT
        EditText editUser = findViewById(R.id.editTextName);
        EditText editPassword = findViewById(R.id.editTextPassword);
        //STRINGS CREDENCIALES
        //Keys
        String userKey = "admin";
        String passwordKey = "admin";

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Input keys
                String userInput = editUser.getText().toString();
                String passwordInput = editPassword.getText().toString();


                if(userInput.equals(userKey) && passwordInput.equals(passwordKey)) {
                    Intent i = new Intent(MainActivity_Login_1.this, Login_Correcto_2.class);
                    i.putExtra("name",userInput);
                    //Iniciar Actividad
                    startActivity(i);



                }else if(userInput.equals(userKey)){
                    Toast.makeText(MainActivity_Login_1.this,"Contraseña Incorrecta", Toast.LENGTH_SHORT).show();
                }else if(passwordInput.equals(passwordKey)){
                    Toast.makeText(MainActivity_Login_1.this,"Usuario Incorrecto", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(MainActivity_Login_1.this,"Usuario y Contraseña Incorrectos", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}