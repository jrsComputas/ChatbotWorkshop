package com.computas.kthx.chatbotstarterkit.precompile;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.computas.kthx.chatbotstarterkit.MainActivity;
import com.computas.kthx.chatbotstarterkit.R;

/**
 * Created by jrs on 03/10/2017.
 */

public class EnterKeyActivity extends AppCompatActivity {

    public static final String API_AI_KEY = "apiAiKey";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_initial);
        Button submitButton = (Button)findViewById(R.id.btn_submit);
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToMainActivity();
            }
        });
    }

    private void goToMainActivity(){
        EditText editText = (EditText)findViewById(R.id.editText);
        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra(API_AI_KEY, editText.getText().toString());
        startActivity(intent);
    }
}
