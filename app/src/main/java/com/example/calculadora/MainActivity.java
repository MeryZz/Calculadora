package com.example.calculadora;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

/**
 * @author María
 * @version 1.0
 * @since 01-11-2024
 */

/**
 * MainActivity es la clase principal de la aplicación Calculadora.
 * Esta clase actúa como intermediaria entre la interfaz de usuario y la clase Calculator.
 */
public class MainActivity extends AppCompatActivity {

    private TextView pantalla; //El text de la pantalla
    private StringBuilder expression = new StringBuilder(); //Para almacenar la expresión
    private Calculator calculator; // Instancia de Calculator

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        //Pantalla de la calculadora
        pantalla = findViewById(R.id.pantalla);
        //Instancia de Calculator
        calculator = new Calculator();

        /**
         * Inicializa los botones de la calculadora y sus listeners.
         */
        //Botones
        Button btn0 = findViewById(R.id.btn0);
        Button btn1 = findViewById(R.id.btn1);
        Button btn2 = findViewById(R.id.btn2);
        Button btn3 = findViewById(R.id.btn3);
        Button btn4 = findViewById(R.id.btn4);
        Button btn5 = findViewById(R.id.btn5);
        Button btn6 = findViewById(R.id.btn6);
        Button btn7 = findViewById(R.id.btn7);
        Button btn8 = findViewById(R.id.btn8);
        Button btn9 = findViewById(R.id.btn9);
        Button btnSuma = findViewById(R.id.btnSuma);
        Button btnResta = findViewById(R.id.btnResta);
        Button btnMultiplicacion = findViewById(R.id.btnMultiplicacion);
        Button btnDivision = findViewById(R.id.btnDivision);
        Button btnIgual = findViewById(R.id.btnIgual);
        Button btnClear = findViewById(R.id.btnClear);
        Button btnComa = findViewById(R.id.btnComa);

        //Listeners para los botones de números
        View.OnClickListener numberListener = v -> {
            Button b = (Button) v;
            expression.append(b.getText().toString());
            pantalla.setText(expression.toString());
        };

        btn0.setOnClickListener(numberListener);
        btn1.setOnClickListener(numberListener);
        btn2.setOnClickListener(numberListener);
        btn3.setOnClickListener(numberListener);
        btn4.setOnClickListener(numberListener);
        btn5.setOnClickListener(numberListener);
        btn6.setOnClickListener(numberListener);
        btn7.setOnClickListener(numberListener);
        btn8.setOnClickListener(numberListener);
        btn9.setOnClickListener(numberListener);

        //Listeners para los botones de operadores
        View.OnClickListener operatorListener = v -> {
            Button b = (Button) v;
            expression.append(b.getText().toString());
            pantalla.setText(expression.toString());
        };

        btnSuma.setOnClickListener(operatorListener);
        btnResta.setOnClickListener(operatorListener);
        btnMultiplicacion.setOnClickListener(operatorListener);
        btnDivision.setOnClickListener(operatorListener);
        btnComa.setOnClickListener(operatorListener);

        //Listener para el CLEAR
        btnClear.setOnClickListener(v -> {
            expression.setLength(0); //Limpiar
            pantalla.setText("0");
        });

        //Listener para el =
        btnIgual.setOnClickListener(v -> {
            try {
                double result = calculator.calculate(expression.toString()); //Para llamar a la función recursiva
                pantalla.setText(String.valueOf(result));
            } catch (Exception e) {
                pantalla.setText("-1"); //Para errores devolverá el valor -1
                Toast.makeText(MainActivity.this, "Error en la expresión!!!", Toast.LENGTH_SHORT).show();
            }
        });
    }

}