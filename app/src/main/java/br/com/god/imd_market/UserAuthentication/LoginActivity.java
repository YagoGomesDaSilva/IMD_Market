package br.com.god.imd_market.UserAuthentication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import br.com.god.imd_market.MainActivity;
import br.com.god.imd_market.R;

public class LoginActivity extends AppCompatActivity {

    EditText et_UserName, et_PassWordName;
    Button btn_SignIn, btn_SignOn;
    TextView btn_forgot_login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        this.et_UserName = findViewById(R.id.et_UserName);
        this.et_PassWordName = findViewById(R.id.et_PassWordName);
        this.btn_SignIn = findViewById(R.id.btn_SignIn);
        this.btn_SignOn = findViewById(R.id.btn_SignOn);
        this.btn_forgot_login = findViewById(R.id.btn_forgot_login);

        this.OnClickListenerSignIn(btn_SignIn, et_UserName, et_PassWordName);
        this.OnClickListenerSignOn(btn_SignOn);
        this.OnClickListenerForgotLogin(btn_forgot_login);

        SharedPreferences sharedPreferences = getSharedPreferences("initialCredentials", Context.MODE_PRIVATE);

        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("admin", "admin");
        editor.clear();
        editor.commit();
    }

    private void OnClickListenerSignIn(Button btn_SignIn, EditText et_UserName, EditText et_PassWordName) {
        btn_SignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences credentials = getSharedPreferences("credentials", Context.MODE_PRIVATE);

                String credential = credentials.getString(et_UserName.getText().toString(), "");
                if(credential.isEmpty()){
                        Toast.makeText(LoginActivity.this, "Login inexistente!", Toast.LENGTH_LONG).show();
                    return;
                }
                else if(!credential.equals(et_PassWordName.getText().toString())){
                    Toast.makeText(LoginActivity.this, "Login ou senha incorretos!", Toast.LENGTH_LONG).show();
                    return;
                }

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

    private void OnClickListenerForgotLogin(TextView btn_forgot_login){
        btn_forgot_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, ForgotLoginActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }


}