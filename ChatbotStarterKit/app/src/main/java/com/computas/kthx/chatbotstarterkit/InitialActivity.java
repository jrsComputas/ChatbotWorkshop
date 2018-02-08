package com.computas.kthx.chatbotstarterkit;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.computas.kthx.chatbotstarterkit.precompile.EnterKeyActivity;

/**
 * Created by jrs on 03/10/2017.
 */

public class InitialActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if(BuildConfig.FLAVOR == "precompile"){
            Intent intent = new Intent(this, EnterKeyActivity.class);
            startActivity(intent);
        }
        else{
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        }
    }
}
