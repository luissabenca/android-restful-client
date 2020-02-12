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

public class asyncExcluir extends AsyncTask<Void, Void,Informacao>
{
    private static String urlExclui     = "http://192.168.25.10:8080/WSRestServidor/webresources/generic/excluirAluno/";
    private static int ra;

    public asyncExcluir(int x)
    {
        this.ra=x;
    }

    @Override
    protected Informacao doInBackground(Void... voids)
    {
        try
        {
            URL objURL = new URL(urlExclui + this.ra);
            HttpURLConnection con = (HttpURLConnection) objURL.openConnection();

            con.setRequestMethod("GET");
            int responseCode = con.getResponseCode();

            BufferedReader br =
                    new BufferedReader(new InputStreamReader(con.getInputStream()));

            Gson gson = new Gson();

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
