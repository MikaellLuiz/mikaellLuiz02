package com.example.mikaelluiz02;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    public valoresValidados validador(EditText editText1, EditText editText2) {
        String value1 = editText1.getText().toString();
        String value2 = editText2.getText().toString();

        if (value1.isEmpty() || value2.isEmpty()) {
            return null;
        }
        try {
            int num1 = Integer.parseInt(value1);
            int num2 = Integer.parseInt(value2);
            return new valoresValidados(num1,num2);
        } catch (NumberFormatException e) {
            return null;
        }
    }

    public class valoresValidados{
        public int num1;
        public int num2;

        public valoresValidados(int num1, int num2){
            this.num1 = num1;
            this.num2 = num2;
        }

        public int getNum1(){
            return num1;
        }

        public int getNum2(){
            return num2;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button plusBt = (Button)this.findViewById(R.id.plusBt);
        Button subBt = (Button) this.findViewById(R.id.subBt);
        Button btnFinalizar = (Button) this.findViewById(R.id.btnFinalizar);
        EditText editText1 = (EditText) this.findViewById(R.id.editText1);
        EditText editText2 = (EditText) this.findViewById(R.id.editText2);
        editText1.setInputType(InputType.TYPE_CLASS_NUMBER);
        editText2.setInputType(InputType.TYPE_CLASS_NUMBER);
        TextView textView1 = (TextView) this.findViewById(R.id.textView1);
        TextView textView2 = (TextView) this.findViewById(R.id.textView2);

        //Operações
        //soma
        plusBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //esconder o teclado quando clicar no botão
                InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(editText1.getWindowToken(), 0);
                imm.hideSoftInputFromWindow(editText2.getWindowToken(), 0);

                valoresValidados valores = validador(editText1,editText2);
                if(valores != null){
                    int num1 = valores.getNum1();
                    int num2 = valores.getNum2();
                    int resultado = num1 + num2;
                    textView1.setText(String.valueOf(resultado));
                }else{
                     Toast.makeText(getApplicationContext(), "Entradas Invalidas!", Toast.LENGTH_LONG).show();
                 }
            }
        });
        //Subtração
        subBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //esconder o teclado quando clicar no botão
                InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(editText1.getWindowToken(), 0);
                imm.hideSoftInputFromWindow(editText2.getWindowToken(), 0);

                valoresValidados valores = validador(editText1,editText2);
                if(valores != null){
                    int num1 = valores.getNum1();
                    int num2 = valores.getNum2();
                    int resultado = num1 - num2;
                    textView1.setText(String.valueOf(resultado));
                }else{
                    Toast.makeText(getApplicationContext(), "Entradas Invalidas!", Toast.LENGTH_LONG).show();
                }
            }
        });

        //Botão finalizar
        btnFinalizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.exit(0);
            }

        });

        //Responsavel por remover o teclado quando o elemento EditText perde o foco
        View rootView = findViewById(android.R.id.content);
        rootView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editText1.clearFocus();
                editText2.clearFocus();
                InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(editText1.getWindowToken(), 0);
                imm.hideSoftInputFromWindow(editText2.getWindowToken(), 0);

            }
        });
    }

}