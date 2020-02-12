package com.example.projeto2;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.*;
import android.content.Intent;

public class MainActivity extends AppCompatActivity
{

    Button btnTodos;
    Button btnRa;
    Button btnInserir;
    Button btnEditar;
    Button btnExcluir;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnTodos = (Button) findViewById(R.id.btnTodos);
        btnTodos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(MainActivity.this,consultaTodos.class);
                startActivity(intent);

            }
        });

        btnRa = (Button) findViewById(R.id.btnRa);
        btnRa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(MainActivity.this,consultaRa.class);
                startActivity(intent);

            }
        });

        btnInserir = (Button) findViewById(R.id.btnInserir);
        btnInserir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(MainActivity.this,inserir.class);
                startActivity(intent);

            }
        });

        btnEditar = (Button) findViewById(R.id.btnEditar);
        btnEditar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(MainActivity.this,editar.class);
                startActivity(intent);

            }
        });

        btnExcluir = (Button) findViewById(R.id.btnExcluir);
        btnExcluir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(MainActivity.this,excluir.class);
                startActivity(intent);

            }
        });

    }
}
