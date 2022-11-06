package com.example.appfull;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import com.example.appfull.Json.MyInfo;

public class welcome_to_the_jungle extends AppCompatActivity {
    private TextView user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome_to_the_jungle);
        String aux = null;
        MyInfo info = null;
        Object object = null;
        user = findViewById(R.id.presId);
        Intent intent = getIntent();
        if (intent != null){
            aux = intent.getStringExtra("Usuario");
            if (aux != null && aux.length()>0){
                user.setText(aux);
            }
            if (intent.getExtras() != null) {
                object = intent.getExtras().get("MyInfo");
                if (object != null) {
                    if (object instanceof MyInfo){
                        info = (MyInfo) object;
                        user.setText("Hola " + info.getUsuario() + ":D");
                    }
                }
            }
        }


    }
}