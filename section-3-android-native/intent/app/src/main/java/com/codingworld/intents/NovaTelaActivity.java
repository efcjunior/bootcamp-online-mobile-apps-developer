package com.codingworld.intents;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class NovaTelaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nova_tela);

        Intent intent = getIntent();
        String mensagem = intent.getStringExtra(MainActivity.MENSAGEM_ADICIONAL);
        TextView labelName = findViewById(R.id.textView);
        labelName.setText(mensagem);
    }
}