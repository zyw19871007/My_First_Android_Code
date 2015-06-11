package com.shadow.zyw.sdu.chapter05forcelogoff;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by shadow on 2015/6/11.
 */
public class LoginActivity extends BaseActivity {
    private EditText user;
    private EditText psw;
    private Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        user = (EditText) findViewById(R.id.login_name);
        psw = (EditText) findViewById(R.id.login_psw);
        btn = (Button) findViewById(R.id.login_btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userstr = String.valueOf(user.getText());
                String pswstr = String.valueOf(psw.getText());
                if (userstr.equals("admin") && pswstr.equals("123")) {
                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                    startActivity(intent);
                } else {
                    Toast.makeText(LoginActivity.this, "login denied",Toast.LENGTH_SHORT).show();
                }
            }
        });


    }
}
