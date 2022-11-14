package com.example.appfull;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.appfull.Json.MyInfo;
import com.example.appfull.Json.MyData;
import com.example.appfull.MyAdapter.MyAdapter;

import java.util.ArrayList;
import java.util.List;

public class welcome_to_the_jungle extends AppCompatActivity {
    private ListView listView;
    private List<MyData> list;
    private TextView user;
    private int []imagen = { R.drawable.coladegato,R.drawable.zombot,R.drawable.lanzaguisantes,R.drawable.lanzamaiz};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome_to_the_jungle);
        String aux = null;
        MyInfo info = null;
        MyData myData = null;
        Object object = null;
        user = findViewById(R.id.presId);
        listView = (ListView) findViewById(R.id.listViewId);
        list = new ArrayList<MyData>();
        Intent intent = getIntent();

        for (int i = 0; i < 4; i++){
            myData = new MyData();
            myData.setContra(String.format("Contraseña: %d",(int)(Math.random()*10000)));

            if (i == 0){
                myData.setRed(String.format( "Rabo de gato"));
                myData.setImage(imagen[0]);
            }
            if (i == 1){
                myData.setRed(String.format( "Zombot"));
                myData.setImage(imagen[1]);
            }
            if (i == 2){
                myData.setRed(String.format( "Lanzaguisante" ));
                myData.setImage(imagen[2]);
            }
            if (i == 3){
                myData.setRed(String.format( "Lanzamaiz" ));
                myData.setImage(imagen[3]);
            }
            list.add(myData);
        }
        MyAdapter myAdapter = new MyAdapter(list, getBaseContext());
        listView.setAdapter(myAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l)
            {
                toast( i );
            }
        });


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
        private void toast(int i){
            Toast.makeText(getBaseContext(), list.get(i).getContra(),Toast.LENGTH_SHORT).show();
        }
    }
