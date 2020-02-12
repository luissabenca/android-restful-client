package com.example.projeto2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Button;
import android.view.View;

public class consultaRa extends AppCompatActivity {

    TextView txtResultado;
    EditText edRa;
    Button btnConsultar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consulta_ra);

        txtResultado = findViewById(R.id.txrResultado);
        final EditText edRa = findViewById(R.id.edRa);
        btnConsultar = findViewById(R.id.btnConsultar);


        btnConsultar.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                if(!edRa.getText().equals(""))
                {
                    try
                    {
                        Aluno retorno = new asyncRa(Integer.parseInt(edRa.getText().toString())).execute().get();
                        txtResultado.setText("Resultado:"+ retorno.toString());
                    }
                    catch(Exception e)
                    {
                        txtResultado.setText("erro");
                    }
                }
                else
                {
                    txtResultado.setText("Por favor insira dados validos");
                }
            }
        });
    }
}
