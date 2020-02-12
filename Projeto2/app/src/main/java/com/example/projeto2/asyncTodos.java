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


public class asyncTodos extends AsyncTask<Void, Void,List<Aluno>>
{
    private static String urlConsultaTodos     = "http://192.168.25.10:8080/WSRestServidor/webresources/generic/consulta";

    public asyncTodos()
    {

    }

    @Override
    protected List<Aluno> doInBackground(Void... voids)
    {
        try
        {
            URL objURL = new URL(urlConsultaTodos);
            HttpURLConnection con = (HttpURLConnection) objURL.openConnection();

            con.setRequestMethod("GET");
            int responseCode = con.getResponseCode();

            BufferedReader br =
                    new BufferedReader(new InputStreamReader(con.getInputStream()));

            Gson gson = new Gson();

            List<Aluno> retorno = gson.fromJson(br, new TypeToken<List<Aluno>>() {
            }.getType());


            br.close();
            con.disconnect();

            return retorno;
        } catch(Exception e)
        {
            e.printStackTrace();
            List<Aluno> a = null;
            a.add(new Aluno(1,"aaa","bbb"));
            return a;
        }
    }


}
