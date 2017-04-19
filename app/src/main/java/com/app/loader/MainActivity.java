package com.app.loader;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.app.loader.app.AppActivity;
import com.app.loader.sms.SmsActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById( R.id.sms).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity( new Intent( MainActivity.this , SmsActivity.class ));
            }
        });

        findViewById( R.id.app).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity( new Intent( MainActivity.this , AppActivity.class ));
            }
        });
    }
}
