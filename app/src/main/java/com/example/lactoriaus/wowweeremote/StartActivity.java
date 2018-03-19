package com.example.lactoriaus.wowweeremote;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class StartActivity extends AppCompatActivity {

    public static final String IP = "127.0.0.1";
    public static final String PORT = "8883";
    EditText iptxt;
    EditText porttxt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
        Button btnstart = findViewById(R.id.btnstart);
        iptxt = findViewById(R.id.iptxt);
        porttxt = findViewById(R.id.porttxt);
        btnstart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                launchActivity();
            }
        });
    }
    private void launchActivity() {
        Intent intent = new Intent(this, RemoteActivity.class);
        String portnumber;
        String ipnumber;
        ipnumber = iptxt.getText().toString();
        portnumber = porttxt.getText().toString();
        intent.putExtra(PORT, portnumber);
        intent.putExtra(IP, ipnumber);
        startActivity(intent);
    }
}
