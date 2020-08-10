package com.codingworld.intents;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    public final static String MENSAGEM_ADICIONAL = "com.coding4world.Message";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void novaTelaActivity(View view) {
        Intent messageIntent = new Intent(this, NovaTelaActivity.class);
        messageIntent.putExtra(MENSAGEM_ADICIONAL, "Testing");
        startActivity(messageIntent);
    }
}