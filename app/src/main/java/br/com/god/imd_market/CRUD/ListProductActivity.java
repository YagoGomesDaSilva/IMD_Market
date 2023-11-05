package br.com.god.imd_market.CRUD;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import br.com.god.imd_market.MainActivity;
import br.com.god.imd_market.R;

public class ListProductActivity extends AppCompatActivity {

    Button btn_BackList_CRUD;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_product);

        this.btn_BackList_CRUD = findViewById(R.id.btn_BackList_CRUD);

        setOnClickListenerBack(btn_BackList_CRUD);
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