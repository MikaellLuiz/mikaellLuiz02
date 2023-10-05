package com.example.mikaelluiz02;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class memoryActivity extends AppCompatActivity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_memory);

        int memoria = getIntent().getIntExtra("memoria", 0);

        TextView txv = (TextView) this.findViewById(R.id.txv);
        txv.setText(String.valueOf(memoria));

        Button backBt = (Button) this.findViewById(R.id.backBt);
        backBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(memoryActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });

    }
}
