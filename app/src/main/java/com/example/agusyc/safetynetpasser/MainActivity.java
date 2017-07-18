package com.example.agusyc.safetynetpasser;


import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Toast;

import java.io.IOException;

public class MainActivity extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.btnHack).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Runtime.getRuntime().exec("su -c resetprop --delete init.svc.magisk_pfs");
                    Runtime.getRuntime().exec("su -c resetprop --delete init.svc.magisk_pfsd");
                    Runtime.getRuntime().exec("su -c resetprop --delete init.svc.magisk_service");
                    Runtime.getRuntime().exec("su -c resetprop --delete persist.magisk.hide");
                    Toast.makeText(getApplicationContext(), "SafetyNet should be working now. Go check!", Toast.LENGTH_LONG).show();
                } catch (IOException e) {
                    Toast.makeText(getApplicationContext(), "SafetyNet could not be hacked correctly! :(", Toast.LENGTH_LONG).show();
                    e.printStackTrace();
                }
            }
        });
    }
}
