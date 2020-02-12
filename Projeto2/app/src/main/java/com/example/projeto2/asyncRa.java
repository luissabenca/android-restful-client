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

public class asyncRa extends AsyncTask<Void, Void,Aluno>
{
    private static String urlConsultaRa     = "http://192.168.25.10:8080/WSRestServidor/webresources/generic/consultaRa/";
    private static int ra;

    public asyncRa(int x)
    {
        this.ra=x;
    }

    @Override
    protected Aluno doInBackground(Void... voids)
    {
        try
        {
            URL objURL = new URL(urlConsultaRa + this.ra);
            HttpURLConnection con = (HttpURLConnection) objURL.openConnection();

            con.setRequestMethod("GET");
            int responseCode = con.getResponseCode();

            BufferedReader br =
                    new BufferedReader(new InputStreamReader(con.getInputStream()));

            Gson gson = new Gson();

            Aluno retorno = gson.fromJson(br, Aluno.class);


            br.close();
            con.disconnect();

            return retorno;
        } catch(Exception e)
        {
            Aluno retorno = new Aluno(0,"erro","erro");
            return retorno;
        }
    }


}
