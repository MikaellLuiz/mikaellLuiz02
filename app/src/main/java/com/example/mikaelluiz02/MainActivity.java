package com.example.mikaelluiz02;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    public int resultado = 0;
    public int memoria = 0;
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
    public EditText editText1;
    public EditText editText2;
    public Button memRecBt;
    public Button memCleBt;
    public TextView textView2;
    public void esconderTeclado() {
        InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(editText1.getWindowToken(), 0);
        imm.hideSoftInputFromWindow(editText2.getWindowToken(), 0);
    }
    //Função resposavel por ativar ou desativar os botões memRec e memCle quando a memoria for igual a 0
    public void onOffBtMemoria(){
        if(memoria != 0){
            memRecBt.setEnabled(true);
            memRecBt.setTextColor(getResources().getColor(R.color.corAtivado));
            memCleBt.setEnabled(true);
            memCleBt.setTextColor(getResources().getColor(R.color.corAtivado));
        }
        if(memoria == 0){
            memRecBt.setEnabled(false);
            memRecBt.setTextColor(getResources().getColor(R.color.corDesativado));
            memCleBt.setEnabled(false);
            memCleBt.setTextColor(getResources().getColor(R.color.corDesativado));
            textView2.setText("");
        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button plusBt = (Button)this.findViewById(R.id.plusBt);
        Button subBt = (Button) this.findViewById(R.id.subBt);
        Button dividerBt = (Button) this.findViewById(R.id.dividerBt);
        Button multipBt = (Button) this.findViewById(R.id.multipBt);

        Button memPlusBt = (Button) this.findViewById(R.id.memPlusBt);
        Button memSubBt = (Button) this.findViewById(R.id.memSubBt);
        memRecBt = (Button) this.findViewById(R.id.memRecBt);
        memCleBt = (Button) this.findViewById(R.id.memCleBt);

        Button MXbt = (Button) this.findViewById(R.id.MXbt);

        Button btnFinalizar = (Button) this.findViewById(R.id.btnFinalizar);

        editText1 = (EditText) this.findViewById(R.id.editText1);
        editText2 = (EditText) this.findViewById(R.id.editText2);
        editText1.setInputType(InputType.TYPE_CLASS_NUMBER);
        editText2.setInputType(InputType.TYPE_CLASS_NUMBER);

        TextView textView1 = (TextView) this.findViewById(R.id.textView1);
        textView2 = (TextView) this.findViewById(R.id.textView2);

        //Operações
        plusBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                esconderTeclado();

                valoresValidados valores = validador(editText1,editText2);
                if(valores != null){
                    int num1 = valores.getNum1();
                    int num2 = valores.getNum2();
                    resultado = num1 + num2;
                    textView1.setText(String.valueOf(resultado));
                }else{
                     Toast.makeText(getApplicationContext(), "Entradas Invalidas!", Toast.LENGTH_LONG).show();
                 }
            }
        });
        subBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                esconderTeclado();

                valoresValidados valores = validador(editText1,editText2);
                if(valores != null){
                    int num1 = valores.getNum1();
                    int num2 = valores.getNum2();
                    resultado = num1 - num2;
                    textView1.setText(String.valueOf(resultado));
                }else{
                    Toast.makeText(getApplicationContext(), "Entradas Invalidas!", Toast.LENGTH_LONG).show();
                }
            }
        });
        dividerBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                esconderTeclado();

                valoresValidados valores = validador(editText1,editText2);
                if(valores != null){
                    int num1 = valores.getNum1();
                    int num2 = valores.getNum2();
                    if (num2 == 0){
                        textView1.setText("Erro. divisão por zero");
                    }else{
                        resultado = num1 / num2;
                        textView1.setText(String.valueOf(resultado));
                    }
                }else{
                    Toast.makeText(getApplicationContext(), "Entradas Invalidas!", Toast.LENGTH_LONG).show();
                }
            }
        });
        multipBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                esconderTeclado();

                valoresValidados valores = validador(editText1,editText2);
                if(valores != null){
                    int num1 = valores.getNum1();
                    int num2 = valores.getNum2();
                    resultado = num1 * num2;
                    textView1.setText(String.valueOf(resultado));
                }else{
                    Toast.makeText(getApplicationContext(), "Entradas Invalidas!", Toast.LENGTH_LONG).show();
                }
            }
        });

        //Memoria
        memPlusBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                esconderTeclado();
                memoria += resultado;
                textView2.setText(String.valueOf(memoria));
                onOffBtMemoria();
            }
        });
        memSubBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                esconderTeclado();
                memoria -= resultado;
                textView2.setText(String.valueOf(memoria));
                onOffBtMemoria();
            }
        });
        memRecBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                esconderTeclado();
                editText1.setText(String.valueOf(memoria));
            }
        });
        memCleBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                esconderTeclado();
                memoria = 0;
                textView2.setText("");
                onOffBtMemoria();
            }
        });

        //botão MX
        MXbt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, memoryActivity.class);
                intent.putExtra("memoria", memoria);
                startActivity(intent);
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
                esconderTeclado();
            }
        });
    }

}