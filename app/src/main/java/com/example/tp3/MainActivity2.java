package com.example.tp3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {

    TextView affiche;
    EditText msg2;

    Button btn2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        affiche = findViewById(R.id.afficher);
        msg2 = findViewById(R.id.message2);
        btn2 = findViewById(R.id.button2);

       Intent intent = getIntent();
       String result =intent.getStringExtra("message");
       affiche.setText( "message reçu : " + result);

       btn2.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               String message=msg2.getText().toString();
               Intent i = new Intent();
               i.putExtra("message",message);
               setResult(RESULT_OK,i);
               finish();
           }
       });

    }
}