package br.com.god.imd_market.CRUD;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import br.com.god.imd_market.MainActivity;
import br.com.god.imd_market.R;

public class RegisterProductActivity extends AppCompatActivity {

    Button btn_Register_CRUD, btn_BackRegister_CRUD;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_product);

        this.btn_Register_CRUD = findViewById(R.id.btn_Register_CRUD);
        this.btn_BackRegister_CRUD = findViewById(R.id.btn_BackRegister_CRUD);

        this.setOnClickListenerRegister( btn_Register_CRUD);
        setOnClickListenerBack(btn_BackRegister_CRUD);
    }

    private void setOnClickListenerRegister(Button btn ){
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BackIntent();
            }
        });
    }

    private void setOnClickListenerBack(Button btn ){
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BackIntent();
            }
        });
    }

    private void BackIntent() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }
}