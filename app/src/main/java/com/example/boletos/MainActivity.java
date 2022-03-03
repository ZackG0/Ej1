package com.example.boletos;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity
{
    private EditText cantidad;
    private RadioGroup tipo;
    private RadioButton vip, luneta, prefer, general;
    private TextView resultado;
    private Button comprar;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        cantidad=(EditText)findViewById(R.id.cantidad);
        tipo=(RadioGroup)findViewById(R.id.tipo);
        vip=(RadioButton)findViewById(R.id.vip);
        luneta=(RadioButton)findViewById(R.id.luneta);
        prefer=(RadioButton)findViewById(R.id.prefer);
        general=(RadioButton)findViewById(R.id.general);
        resultado=(TextView)findViewById(R.id.resultado);
        comprar=(Button)findViewById(R.id.comprar);
        comprar.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                int num;
                double total;
                num=Integer.parseInt(cantidad.getText().toString());
                if(num==0)
                {
                    resultado.setText("Ingresa la cantidad de boletos");
                }
                if(vip.isChecked())
                {
                    total=(900*num)*1.16;
                    resultado.setText(num+" boletos VIP. Total: $"+total);
                }
                else if(luneta.isChecked())
                {
                    total=(600*num)*1.16;
                    resultado.setText(num+" boletos Luneta. Total: $"+total);
                }
                else if(prefer.isChecked())
                {
                    total=(400*num)*1.16;
                    resultado.setText(num+" boletos Preferente. Total: $"+total);
                }
                else if(general.isChecked())
                {
                    total=(200*num)*1.16;
                    resultado.setText(num+" boletos General. Total: $"+total);
                }
                else
                {
                    resultado.setText("Selecciona algun boleto");
                }
            }
        });
    }
}