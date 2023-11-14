package br.com.god.imd_market;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import br.com.god.imd_market.CRUD.DeleteProductActivity;
import br.com.god.imd_market.CRUD.ListProductActivity;
import br.com.god.imd_market.CRUD.RegisterProductActivity;
import br.com.god.imd_market.CRUD.UpdateProductActivity;

public class MainActivity extends AppCompatActivity {

    Button btn_RegisterProduct, btn_ListProduct, btn_DeleteProduct, btn_UpdateProduct;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.btn_RegisterProduct = findViewById(R.id.btn_RegisterProduct);
        this.btn_ListProduct = findViewById(R.id.btn_ListProduct);
        this.btn_DeleteProduct = findViewById(R.id.btn_DeleteProduct);
        this.btn_UpdateProduct = findViewById(R.id.btn_UpdateProduct);

        OnClickListenerSetCRUD(this.btn_RegisterProduct, RegisterProductActivity.class );
        OnClickListenerSetCRUD(this.btn_ListProduct, ListProductActivity.class);
        OnClickListenerSetCRUD(this.btn_DeleteProduct, DeleteProductActivity.class);
        OnClickListenerSetCRUD(this.btn_UpdateProduct, UpdateProductActivity.class );
    }

    private void OnClickListenerSetCRUD(Button btn, Class<?> cls ) {
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, cls);
                startActivity(intent);
                finish();
            }
        });
    }
}