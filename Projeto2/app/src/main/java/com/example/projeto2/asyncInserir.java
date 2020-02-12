package com.example.projeto2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.lang.reflect.Array;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;
import com.google.gson.*;
import com.google.gson.reflect.TypeToken;

import android.os.AsyncTask;
import android.widget.ListView;
import android.widget.ProgressBar;

import java.util.List;

public class asyncInserir  extends AsyncTask<Void, Void,Informacao>
{
    private static String urlIncluirAluno      = "http://192.168.25.10:8080/WSRestServidor/webresources/generic/incluirAluno/";
    private static int ra;
    private static String nome;
    private static String emailAluno;

    public asyncInserir(Aluno a)
    {
        this.ra=a.getRa();
        this.nome = a.getNome();
        this.emailAluno = a.getEmailAluno();
    }

    @Override
    protected Informacao doInBackground(Void... voids)
    {
        try
        {
            URL objURL = new URL(urlIncluirAluno);
            HttpURLConnection con = (HttpURLConnection) objURL.openConnection();

            con.setDoOutput(true);

            con.setRequestMethod("POST");
            con.setRequestProperty("Content-Type", "application/json");

            Gson gson = new Gson();
            //Formata em json o item da lista a ser inserido com POST
            String output = gson.toJson(new Aluno(this.ra,this.nome,this.emailAluno));

            //Pega a conexão aberta em con (getOutputStream()) e faz OutputStream, ouseja, faz o fluxo de dados do cliente para o servidor
            OutputStream os = con.getOutputStream();

            //Escreve o output tranformado em Bytes
            os.write(output.getBytes());


            int responseCode = con.getResponseCode();
            //Se retornar 200 significa que deu certo

            //Armazena o retorno do método POST do servidor
            BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream()));

            Informacao retorno = gson.fromJson(br, Informacao.class);

            br.close();
            con.disconnect();
            return retorno;
        } catch(Exception e)
        {
            Informacao retorno = new Informacao("erro");
            return retorno;
        }
    }


}
