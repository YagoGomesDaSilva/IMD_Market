package br.com.god.imd_market.CRUD;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import br.com.god.imd_market.DataBase.BancoAdmin;
import br.com.god.imd_market.MainActivity;
import br.com.god.imd_market.R;
import br.com.god.imd_market.UserAuthentication.LoginActivity;
import br.com.god.imd_market.UserAuthentication.RegisterActivity;

public class DeleteProductActivity extends AppCompatActivity {

    Button btn_Delete_CRUD, btn_BackDelete_CRUD;

    TextView codigoProdutoExcluir;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete_product);

        this.btn_Delete_CRUD = findViewById(R.id.btn_Delete_CRUD);
        this.btn_BackDelete_CRUD = findViewById(R.id.btn_BackDelete_CRUD);

        this.codigoProdutoExcluir = findViewById(R.id.codigoProdutoExcluir);

        this.setOnClickListenerDelete( btn_Delete_CRUD);
        setOnClickListenerBack(btn_BackDelete_CRUD);
    }

    private void setOnClickListenerDelete(Button btn ){
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BancoAdmin admin = new BancoAdmin(DeleteProductActivity.this, "BancoProdutos", null, 1);
                SQLiteDatabase banco = admin.getWritableDatabase();

                int deletedRows = banco.delete("PRODUTOS", "ID_CODIGO_PRODUTO = ?", new String[]{codigoProdutoExcluir.getText().toString()});
                banco.close();

                if(deletedRows < 1) {
                    Toast.makeText(DeleteProductActivity.this, "Código do produto não encontrado!", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(DeleteProductActivity.this, "Produto excluído com sucesso!", Toast.LENGTH_LONG).show();
                    BackIntent();
                }
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