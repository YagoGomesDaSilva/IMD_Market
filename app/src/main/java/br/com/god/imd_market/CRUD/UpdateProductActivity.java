package br.com.god.imd_market.CRUD;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
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

public class UpdateProductActivity extends AppCompatActivity {
    Button btn_Update_CRUD, btn_BackUpdate_CRUD;

    TextView codigoProdutoAtt, nomeProdutoAtt, descricaoProdutoAtt, estoqueProdutoAtt;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_product);

        this.codigoProdutoAtt = findViewById(R.id.codigoProdutoAtt);
        this.nomeProdutoAtt = findViewById(R.id.nomeProdutoAtt);
        this.descricaoProdutoAtt = findViewById(R.id.descricaoProdutoAtt);
        this.estoqueProdutoAtt = findViewById(R.id.estoqueProdutoAtt);

        this.btn_Update_CRUD = findViewById(R.id.btn_Update_CRUD);
        this.btn_BackUpdate_CRUD = findViewById(R.id.btn_BackUpdate_CRUD);

        this.setOnClickListenerUpdate( btn_Update_CRUD, codigoProdutoAtt, nomeProdutoAtt, descricaoProdutoAtt, estoqueProdutoAtt);
        setOnClickListenerBack(btn_BackUpdate_CRUD);
    }

    private void setOnClickListenerUpdate(Button btn, TextView codigoProdutoAtt,TextView nomeProdutoAtt, TextView  descricaoProdutoAtt, TextView  estoqueProdutoAtt){
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                BancoAdmin admin = new BancoAdmin(UpdateProductActivity.this, "BancoProdutos", null, 1);
                SQLiteDatabase banco = admin.getWritableDatabase();

                if( ! codigoProdutoAtt.getText().toString().isEmpty() )
                {
                    ContentValues transaction = new ContentValues();
                    transaction.put("ID_CODIGO_PRODUTO", codigoProdutoAtt.getText().toString());
                    transaction.put("NOME", nomeProdutoAtt.getText().toString());
                    transaction.put("DESCRICAO", descricaoProdutoAtt.getText().toString());
                    transaction.put("ESTOQUE", estoqueProdutoAtt.getText().toString());

                    banco.update("PRODUTOS", transaction,"ID_CODIGO_PRODUTO =" + codigoProdutoAtt.getText().toString(),null);
                    banco.close();

                    Toast.makeText(UpdateProductActivity.this, "Atualizado com sucesso!", Toast.LENGTH_LONG).show();
                    codigoProdutoAtt.setText("");
                    nomeProdutoAtt.setText("");
                    descricaoProdutoAtt.setText("");
                    estoqueProdutoAtt.setText("");

                }
                else {
                    Toast.makeText(UpdateProductActivity.this, "Preencha o codigo do produto !", Toast.LENGTH_LONG).show();
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