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

public class Modificar_Credenciales_4 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_modificar_credenciales4);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });


        Button btnSaveChanges = findViewById(R.id.buttonSaveChanges);

        EditText etUser = findViewById(R.id.editTextNewUser);
        EditText etPassword = findViewById(R.id.editTextNewPassword);


        btnSaveChanges.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String newUser = etUser.getText().toString();
                String newPassword = etPassword.getText().toString();

                Intent i = new Intent(Modificar_Credenciales_4.this, MainActivity_Login_1.class);

                //Mando al main los valores de new user y password
                i.putExtra("newUser" , newUser);
                i.putExtra("newPassword" , newPassword);
                finish();
                startActivity(i);
            }
        });






    }






}