package com.example.lactoriaus.wowweeremote;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class RemoteActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_remote);

        Button upBtn = findViewById(R.id.upBtn);
        Button downBtn = findViewById(R.id.downBtn);
        Button leftBtn = findViewById(R.id.leftBtn);
        Button rightBtn = findViewById(R.id.rightBtn);
        Button stopBtn = findViewById(R.id.stopBtn);

        TextView ipTxt = findViewById(R.id.IpTxtBox);
        TextView portTxt = findViewById(R.id.PortTxtBox);
        final TextView asked = findViewById(R.id.asked);

        Intent intent = getIntent();
        final String ipNumber = intent.getStringExtra(StartActivity.IP);
        final String portNumber = intent.getStringExtra(StartActivity.PORT);

        ipTxt.setText("IP:" + ipNumber);
        portTxt.setText("Port:" + portNumber);

        upBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                asked.setText("Forward");
                TcpClient mTcpClient = new TcpClient(ipNumber,portNumber,"fd+");
                mTcpClient.execute();
            }

        });
        leftBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                asked.setText("Left");
                TcpClient mTcpClient = new TcpClient(ipNumber,portNumber,"l+");
                mTcpClient.execute();
            }
        });
        rightBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                asked.setText("Right");
                TcpClient mTcpClient = new TcpClient(ipNumber,portNumber,"r+");
                mTcpClient.execute();;
            }
        });
        downBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                asked.setText("Backward");
                TcpClient mTcpClient = new TcpClient(ipNumber,portNumber,"bd+");
                mTcpClient.execute();
            }
        });
        stopBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                asked.setText("Stop");
                TcpClient mTcpClient = new TcpClient(ipNumber,portNumber,"s+");
                mTcpClient.execute();
            }
        });
    }

}
