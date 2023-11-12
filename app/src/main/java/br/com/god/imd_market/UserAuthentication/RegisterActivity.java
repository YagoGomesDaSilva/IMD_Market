package br.com.god.imd_market.UserAuthentication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import br.com.god.imd_market.MainActivity;
import br.com.god.imd_market.R;

public class RegisterActivity extends AppCompatActivity {
    EditText et_UserName, et_PassWordName;
    Button btn_Register, btn_Back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        this.et_UserName = findViewById(R.id.et_UserName_SignOn);
        this.et_PassWordName = findViewById(R.id.et_PassWordName_SignOn);
        this.btn_Register = findViewById(R.id.btn_Register_SignOn);
        this.btn_Back = findViewById(R.id.btn_Back_SignOn);

        this.OnClickListenerRegister(btn_Register, et_UserName, et_PassWordName);
        this.OnClickListenerBack(btn_Back);

    }

    private void OnClickListenerRegister(Button btn_SignIn, EditText et_UserName, EditText et_PassWordName) {
        btn_Register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences credentials = getSharedPreferences("credentials", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = credentials.edit();
                editor.putString(et_UserName.getText().toString(), et_PassWordName.getText().toString());
                editor.commit();
                Toast.makeText(RegisterActivity.this, "Login salvo!", Toast.LENGTH_LONG).show();
                BackIntent();
            }
        });
    }

    private void OnClickListenerBack(Button btn_SignOn) {
        btn_SignOn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                BackIntent();
            }
        });
    }

    private void BackIntent() {
        Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
        startActivity(intent);
        finish();
    }

}