package com.example.prova3b;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    // atributos referentes aos objetos gráficos
    private EditText txtNome;
    private EditText txtNota1;
    private EditText txtNota2;
    private Button btnAdiciona;
    private Button btnCancela;
    private ListView listaContatos;

    // ArrayList de contatos
    private ArrayList<Contato> contatos = new ArrayList<>();

    // adapter da lista
    private AdapterContatos adaptador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // ligando atributos com os ID dos objetos na interface
        txtNome = findViewById( R.id.txtNome );
        txtNota1 = findViewById( R.id.txtNota1);
        txtNota2 = findViewById( R.id.txtNota2);
        btnAdiciona = findViewById( R.id.btnAdiciona );
        btnCancela = findViewById( R.id.btnCancela );

        listaContatos = findViewById( R.id.listaContatos );

        // criando e associando escutador do botão
        btnAdiciona.setOnClickListener( new EscutadorBotao() );

        // configurando a lista:

        // criando adaptador
        adaptador = new AdapterContatos( this, contatos );

        // associando o adaptador a lista
        listaContatos.setAdapter( adaptador );

        //Configurar os escutadores de cliques na lista;

        //Criando o objeto escutador de cliques na lista
        //Lembrando, como a classe desse objeto implementou
        //duas interfaces, esse objeto tem dois comportamenos,
        //isto eh, ele escuta clique simples e clique longo.

        EscutadorLista el = new EscutadorLista();

        // configurar a lista com o escutador de cliques comuns
        listaContatos.setOnItemClickListener(el);
        // configurar a lista para aceitar cliques longos
        listaContatos.setLongClickable( true );
        // configurar a lista com o escutador de cliques longos
        listaContatos.setOnItemLongClickListener(el);
    }

    // classe interna do escutador do clique no botão adiciona
    private class EscutadorBotao implements View.OnClickListener {

        @Override
        public void onClick(View view) {

            // variaveis para auxilio
            String nome;
            Float nota1;
            Float nota2;
            Float media = null;

            // pegando dados nas caixas de texto
            nome = txtNome.getText().toString();
            nota1 = Float.valueOf(txtNota1.getText().toString());
            nota2 = Float.valueOf(txtNota2.getText().toString());

            // criando objeto Contato
            Contato c = new Contato( nome, nota1, nota2,media );

            // inserindo no ArrayList
            contatos.add( c );

            // avisando o adapter que os dados foram atualizados
            adaptador.notifyDataSetChanged();

            // "limpando" a interface, para a próxima digitação
            txtNome.setText("");
            txtNota1.setText("");
            txtNota2.setText("");

            //Toast.makeText(MainActivity.this, "", Toast.LENGTH_SHORT).show();
        }
    }

    /// Classe interna do escutador de cliques  na lista

    private class EscutadorLista implements AdapterView.OnItemClickListener,
                                            AdapterView.OnItemLongClickListener {
        @Override
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
            // O parâmetro i é o número do item clicado ...

            Contato c = contatos.get(i);

            String msg= "";

            msg = msg +"Nome:" + c.getNome() + "\n";
            msg = msg +"Nota1:" + c.getNota1() + "\n";
            msg = msg +"Nota2:" + c.getNota2() + "\n";
            msg = msg +"Média:" + c.getMedia() + "\n";



            Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_LONG).show();
        }
        @Override
        public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
            // remover o item de índice i do ArrayList
            contatos.remove( i );
            // avisar o adapter que o arraylist mudou
            adaptador.notifyDataSetChanged();
            // mensagem informativa
            Toast.makeText(MainActivity.this, "Item apagado!", Toast.LENGTH_LONG).show();
            // receita de bolo: retornar true, indicando que o evento foi tratado.
            // se retornar false, vai querer tratar clique comum também
            return true;
        }
    }
}
