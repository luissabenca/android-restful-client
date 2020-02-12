package com.example.projeto2;

import java.util.List;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.*;

public class consultaTodos extends AppCompatActivity
{
    ListView lvAlunos;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consulta_todos);

        lvAlunos = findViewById(R.id.lvAlunos);

        try
        {
            List<Aluno> retorno = new asyncTodos().execute().get();
            ArrayAdapter<Aluno> alunosAdapter = new ArrayAdapter<Aluno>(this,android.R.layout.simple_list_item_1,retorno);
            lvAlunos.setAdapter(alunosAdapter);
        }
        catch (Exception e)
        {
        }


    }
}
