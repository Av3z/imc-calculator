package me.willyan.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    private Button button;
    private TextView result, result2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final float[] imc = new float[1];
        button = findViewById(R.id.button);
        result = findViewById(R.id.result);
        result2 = findViewById(R.id.result2);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText editPeso = (EditText) findViewById(R.id.editPeso);
                EditText editAltura = (EditText) findViewById(R.id.editAltura);
                float peso = Float.parseFloat(editPeso.getText().toString());
                float altura = Float.parseFloat(editAltura.getText().toString());
                imc[0] = peso / (altura * altura);
                float imcResult = Math.round(imc[0] * 100)/100;

                if(imcResult < 18.5){
                    result.setText("Seu resultado foi: "+ imcResult);
                    result2.setText(" Você está abaixo do peso.");
                }else if (imcResult >= 18.5 && imcResult < 25){
                    result.setText("Seu resultado foi: "+ imcResult);
                    result2.setText(" Você está com o peso adequado.");
                }else if(imcResult >= 25 && imcResult < 30){
                    result.setText("Seu resultado foi: "+ imcResult);
                    result2.setText(" Você está sobrepeso.");
                }else {
                    result.setText("Seu resultado foi: "+ imcResult);
                    result2.setText(" Você está com obesidade.");
                }
            }
        });
    }
}