package br.com.god.imd_market.UserAuthentication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import br.com.god.imd_market.MainActivity;
import br.com.god.imd_market.R;

public class LoginActivity extends AppCompatActivity {

    EditText et_UserName, et_PassWordName;
    Button btn_SignIn, btn_SignOn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        this.et_UserName = findViewById(R.id.et_UserName);
        this.et_PassWordName = findViewById(R.id.et_PassWordName);
        this.btn_SignIn = findViewById(R.id.btn_SignIn);
        this.btn_SignOn = findViewById(R.id.btn_SignOn);

        this.OnClickListenerSignIn(btn_SignIn, et_UserName, et_PassWordName);
        this.OnClickListenerSignOn(btn_SignOn);

    }

    private void OnClickListenerSignIn(Button btn_SignIn, EditText et_UserName, EditText et_PassWordName) {
        btn_SignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }

    private void OnClickListenerSignOn(Button btn_SignOn) {
        btn_SignOn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }


}