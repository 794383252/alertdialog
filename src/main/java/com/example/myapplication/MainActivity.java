package com.example.myapplication;

import android.app.Dialog;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button button;
    LayoutInflater inflater;
    TextView textview;
    EditText edittext1;
    EditText edittext2;
    userModel userModel = new userModel();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();

    }

    public void init() {
        button = (Button) findViewById(R.id.button);
        textview = (TextView) findViewById(R.id.textview);

        button.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setTitle("text");
        inflater = (LayoutInflater) MainActivity.this.getSystemService(LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.edittext, null);
        builder.setView(view);
        edittext1 = (EditText) view.findViewById(R.id.edittext1);
        edittext2 = (EditText) view.findViewById(R.id.edittext2);
        builder.setPositiveButton("登录", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                userModel.setUserName(edittext1.getText().toString());
                userModel.setPassword(edittext2.getText().toString());
                textview.setText(userModel.getUserName() + userModel.getPassword());
            }
        });
        builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        builder.show();

    }
}
