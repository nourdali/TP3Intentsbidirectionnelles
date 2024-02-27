package com.example.tp3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView text;

    EditText msg;
    Button btn;
    static final int REQUEST = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        text = findViewById(R.id.text);
        msg = findViewById(R.id.message);
        btn = findViewById(R.id.button);


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String result = msg.getText().toString();
                if(result.isEmpty()) {

                    Toast.makeText(MainActivity.this, "message vide", Toast.LENGTH_LONG).show();

                }else{
                    Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                    intent.putExtra("message", result);

                    startActivityForResult(intent, REQUEST);

                }
            }
        });
    }

    @Override
    protected void onActivityResult(int Code, int resultCode, Intent data) {
        super.onActivityResult(Code, resultCode, data);
        if (Code == REQUEST && resultCode == RESULT_OK) {
            String Message = data.getStringExtra("message");
            if (Message.equals("")) {

                Toast.makeText(MainActivity.this, "Réponse vide", Toast.LENGTH_LONG).show();

            } else {
                text.setText(Message);
            }
        }
    }



}