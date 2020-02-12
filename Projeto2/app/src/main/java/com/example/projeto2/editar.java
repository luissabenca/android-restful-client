package com.example.projeto2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Button;
import android.view.View;

public class editar extends AppCompatActivity {

    TextView txtResultado;
    EditText edRa;
    EditText edNome;
    EditText edEmail;
    Button btnAlterar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editar);

        txtResultado = findViewById(R.id.txtResultado);
        final EditText edRa = findViewById(R.id.edRa);
        final EditText edNome = findViewById(R.id.edNome);
        final EditText edEmail = findViewById(R.id.edEmail);
        btnAlterar = findViewById(R.id.btnAlterar);

        btnAlterar.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                if(!edRa.getText().equals("") & !edNome.getText().equals("") & !edEmail.getText().equals(""))
                {
                    try
                    {
                        Aluno a = new Aluno(Integer.parseInt(edRa.getText().toString()),edNome.getText().toString(),edEmail.getText().toString());
                        Informacao retorno = new asyncEditar(a).execute().get();
                        txtResultado.setText("Resultado:" + retorno.getInformacao());
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
