package br.com.god.imd_market.CRUD;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
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

        final List<Produto> produtos = new ArrayList<>();
        while(consulta.moveToNext()) {
            int itemId = consulta.getInt(consulta.getColumnIndexOrThrow("ID_CODIGO_PRODUTO"));
            String nome = consulta.getString(consulta.getColumnIndexOrThrow("NOME"));
            String descricao = consulta.getString(consulta.getColumnIndexOrThrow("DESCRICAO"));
            int estoque = consulta.getInt(consulta.getColumnIndexOrThrow("ESTOQUE"));

            produtos.add(new Produto(itemId, nome, descricao, estoque));
        }

        List<String> produtosParaListView = new ArrayList<>();

        for (Produto produto: produtos) {
            produtosParaListView.add(produto.getNomeProduto());
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, produtosParaListView);
        listViewProducts.setAdapter(adapter);

        consulta.close();

        listViewProducts.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                AlertDialog.Builder builder = new AlertDialog.Builder(ListProductActivity.this);
                builder.setTitle("Item " + (position+1))
                        .setMessage(
                                "Código: " + produtos.get(position).getCodigoProduto() + "\n" +
                                "Nome: " + produtos.get(position).getNomeProduto() + "\n" +
                                "Descrição: " + produtos.get(position).getDescricaoProduto() + "\n" +
                                "Estoque: " + produtos.get(position).getEstoque()
                        )
                        .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {}});
                builder.create().show();
            }
        });
    }
}