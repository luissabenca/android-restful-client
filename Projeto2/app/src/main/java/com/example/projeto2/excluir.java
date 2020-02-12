package com.example.projeto2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Button;
import android.view.View;

public class excluir extends AppCompatActivity {

    TextView txtResultado;
    EditText edRa;
    Button btnExcluir;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_excluir);


        txtResultado = findViewById(R.id.txtResultado);
        final EditText edRa = findViewById(R.id.edRa);
        btnExcluir = findViewById(R.id.btnExcluir);


        btnExcluir.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                if(!edRa.getText().equals(""))
                {
                    try
                    {
                        Informacao retorno = new asyncExcluir(Integer.parseInt(edRa.getText().toString())).execute().get();
                        txtResultado.setText("Resultado:"+ retorno.getInformacao());
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
