package br.com.god.imd_market.CRUD;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import br.com.god.imd_market.MainActivity;
import br.com.god.imd_market.R;

public class UpdateProductActivity extends AppCompatActivity {
    Button btn_Update_CRUD, btn_BackUpdate_CRUD;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_product);

        this.btn_Update_CRUD = findViewById(R.id.btn_Update_CRUD);
        this.btn_BackUpdate_CRUD = findViewById(R.id.btn_BackUpdate_CRUD);

        this.setOnClickListenerUpdate( btn_Update_CRUD);
        setOnClickListenerBack(btn_BackUpdate_CRUD);
    }

    private void setOnClickListenerUpdate(Button btn ){
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