package br.com.god.imd_market.CRUD;

import androidx.appcompat.app.AlertDialog;
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
import br.com.god.imd_market.UserAuthentication.RegisterActivity;

public class RegisterProductActivity extends AppCompatActivity {

    Button btn_Register_CRUD, btn_BackRegister_CRUD;

    TextView codigoProduto, nomeProduto, descricaoProduto, estoqueProduto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_product);

        this.codigoProduto = findViewById(R.id.codigoProduto);
        this.nomeProduto = findViewById(R.id.nomeProduto);
        this.descricaoProduto = findViewById(R.id.descricaoProduto);
        this.estoqueProduto = findViewById(R.id.estoqueProduto);

        this.btn_Register_CRUD = findViewById(R.id.btn_Register_CRUD);
        this.btn_BackRegister_CRUD = findViewById(R.id.btn_BackRegister_CRUD);

        this.setOnClickListenerRegister(btn_Register_CRUD, codigoProduto, nomeProduto, descricaoProduto, estoqueProduto);
        setOnClickListenerBack(btn_BackRegister_CRUD);
    }

    private void setOnClickListenerRegister(Button btn, TextView codigoProduto, TextView nomeProduto, TextView descricaoProduto, TextView estoqueProduto ){

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BancoAdmin admin = new BancoAdmin(RegisterProductActivity.this, "BancoProdutos", null, 1);
                SQLiteDatabase banco = admin.getWritableDatabase();

                if(  !( codigoProduto.getText().toString().isEmpty()
                        && nomeProduto.getText().toString().isEmpty()
                        && descricaoProduto.getText().toString().isEmpty()
                        && estoqueProduto.getText().toString().isEmpty()) )
                {
                    ContentValues transaction = new ContentValues();
                    transaction.put("ID_CODIGO_PRODUTO", codigoProduto.getText().toString());
                    transaction.put("NOME", nomeProduto.getText().toString());
                    transaction.put("DESCRICAO", descricaoProduto.getText().toString());
                    transaction.put("ESTOQUE", estoqueProduto.getText().toString());

                    banco.insert("PRODUTOS", null, transaction);
                    banco.close();
                    //createAlertDialog(codigoProduto, nomeProduto, descricaoProduto, estoqueProduto,"OK");

                    Toast.makeText(RegisterProductActivity.this, "Salvo com sucesso!", Toast.LENGTH_LONG).show();
                    codigoProduto.setText("");
                    nomeProduto.setText("");
                    descricaoProduto.setText("");
                    estoqueProduto.setText("");

                }
                else {
                    Toast.makeText(RegisterProductActivity.this, "Preencha todos os campos!", Toast.LENGTH_LONG).show();
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
/*
    void createAlertDialog(TextView codigoProduto, TextView nomeProduto, TextView descricaoProduto, TextView estoqueProduto, String btnMessage){

        String mainMessage = codigoProduto.getText().toString() + "\n" +
                             nomeProduto.getText().toString() + "\n" +
                             descricaoProduto.getText().toString() + "\n" +
                             estoqueProduto.getText().toString();


        AlertDialog.Builder ad = new AlertDialog.Builder(this);
        ad.setCancelable(false);
        ad.setMessage(mainMessage);
        ad.setNeutralButton(btnMessage, null);
        ad.show();
    }
    */
}