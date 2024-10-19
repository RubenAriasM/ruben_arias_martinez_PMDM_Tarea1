package com.example.ruben_arias_martinez_pmdm_tarea1;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
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
        //https://github.com/RubenAriasM/ruben_arias_martinez_PMDM_Tarea1.git
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

        //Compruebo si el bundle existe para poder modificar las credenciales porque si no nada mas se inica la app daria error al
        // no tener esos valores
        Log.i("Mainn", "Antes del Bundle");
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            String newUser = extras.getString("newUser");
            String newPassword = extras.getString("newPassword");

            if (newUser != "" && newPassword != "") {
                userKey = newUser;
                passwordKey = newPassword;
            } else if (newUser != "") {
                userKey = newUser;
                passwordKey = "admin";
            } else if (newPassword != "") {
                userKey = "admin";
                passwordKey = newPassword;
            } else {
                userKey = "admin";
                passwordKey = "admin";
            }
        } else {
            userKey = "admin";
            passwordKey = "admin";
        }




        //INICIAR SESION
        String finalUserKey = userKey;
        String finalPasswordKey = passwordKey;

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Input keys
                String userInput = editUser.getText().toString();
                String passwordInput = editPassword.getText().toString();

                //Comprobaciones si la cotraseñay usuarios son correctos
                //Hago mas comprobaciones de las necesarias para poder personalizar mejor el toast segun lo que falles
                if(userInput.equals(finalUserKey) && passwordInput.equals(finalPasswordKey)) {
                    Intent iIniciarSesion = new Intent(MainActivity_Login_1.this, Login_Correcto_2.class);
                    iIniciarSesion.putExtra("name",userInput);
                    //Iniciar Actividad
                    startActivity(iIniciarSesion);

                }else if(userInput.equals(finalUserKey)){
                    Toast.makeText(MainActivity_Login_1.this,"Contraseña Incorrecta", Toast.LENGTH_SHORT).show();
                }else if(passwordInput.equals(finalPasswordKey)){
                    Toast.makeText(MainActivity_Login_1.this,"Usuario Incorrecto", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(MainActivity_Login_1.this,"Usuario y Contraseña Incorrectos", Toast.LENGTH_SHORT).show();
                }
            }
        });





        //MODIFICAR CREDENCIALES
        btnModify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent iModificarCredenciales = new Intent(MainActivity_Login_1.this, Modificar_Credenciales_4.class);
                startActivity(iModificarCredenciales);
            }
        });

    }
}