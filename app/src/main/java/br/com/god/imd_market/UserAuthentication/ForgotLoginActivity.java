package br.com.god.imd_market.UserAuthentication;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


import androidx.appcompat.app.AppCompatActivity;

import br.com.god.imd_market.MainActivity;
import br.com.god.imd_market.R;

public class ForgotLoginActivity extends AppCompatActivity {

    TextView username, oldPassword, newPassword;
    Button btn_update_login, btn_Back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_login);

        this.username = findViewById(R.id.username);
        this.newPassword = findViewById(R.id.newPassword);

        this.btn_update_login = findViewById(R.id.btn_update_login);
        this.btn_Back = findViewById(R.id.btn_back_forgot);

        this.OnClickListenerUpdate(btn_update_login);
        this.OnClickListenerBack(btn_Back);
    }

    private void OnClickListenerBack(Button btn_forgot) {
        btn_forgot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                BackIntent();
            }
        });
    }

    private void OnClickListenerUpdate(Button btn_update_login){
        btn_update_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences credentials = getSharedPreferences("credentials", Context.MODE_PRIVATE);

                String credential = credentials.getString(username.getText().toString(), "");

                if(credential.isEmpty()){
                    Toast.makeText(ForgotLoginActivity.this, "Login inexistente!", Toast.LENGTH_LONG).show();
                    return;
                }
                else if(newPassword.getText().toString().isEmpty()){
                    Toast.makeText(ForgotLoginActivity.this, "Preencha a nova senha!", Toast.LENGTH_LONG).show();
                    return;
                }

                SharedPreferences.Editor editor = credentials.edit();
                editor.putString(username.getText().toString(), newPassword.getText().toString());
                editor.apply();

                Toast.makeText(ForgotLoginActivity.this, "Senha atualizada!", Toast.LENGTH_LONG).show();

                Intent intent = new Intent(ForgotLoginActivity.this, LoginActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }

    private void BackIntent() {
        Intent intent = new Intent(ForgotLoginActivity.this, LoginActivity.class);
        startActivity(intent);
        finish();
    }
}