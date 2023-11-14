package br.com.god.imd_market.CRUD;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import br.com.god.imd_market.DataBase.BancoAdmin;
import br.com.god.imd_market.MainActivity;
import br.com.god.imd_market.R;
import br.com.god.imd_market.data.Produto;

public class ListProductActivity extends AppCompatActivity {

    Button btn_BackList_CRUD;

    ListView listViewProducts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_product);

        this.btn_BackList_CRUD = findViewById(R.id.btn_BackList_CRUD);

        this.listViewProducts = findViewById(R.id.listViewProducts);

        setOnClickListenerBack(btn_BackList_CRUD);
        listar();
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

    private void listar(){
        BancoAdmin admin = new BancoAdmin(ListProductActivity.this, "BancoProdutos", null, 1);
        SQLiteDatabase banco = admin.getWritableDatabase();

        Cursor consulta = banco.query("PRODUTOS", null, null, null, null, null, null);

        List<Produto> produtos = new ArrayList<>();
        while(consulta.moveToNext()) {
            int itemId = consulta.getInt(consulta.getColumnIndexOrThrow("ID_CODIGO_PRODUTO"));
            String nome = consulta.getString(consulta.getColumnIndexOrThrow("NOME"));
            String descricao = consulta.getString(consulta.getColumnIndexOrThrow("DESCRICAO"));
            int estoque = consulta.getInt(consulta.getColumnIndexOrThrow("ESTOQUE"));

            produtos.add(new Produto(itemId, nome, descricao, estoque));
        }
        //TODO: popular o ListView com o ArrayList de Produtos
        consulta.close();
    }
}