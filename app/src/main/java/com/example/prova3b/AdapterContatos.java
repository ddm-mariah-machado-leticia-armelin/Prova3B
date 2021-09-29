package com.example.prova3b;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class AdapterContatos extends ArrayAdapter<Contato> {

    // atributos:

    // contexto
    private Context context;

    // arraylist de objetos do tipo Contato
    private ArrayList<Contato> contatos;

    public AdapterContatos(Context context, ArrayList<Contato> contatos) {

        // super:
        // contexto, layout do item da lista, arraylist com os itens
        super(context, R.layout.item_lista, contatos);

        // guarda o contexto no atributo correspondente
        this.context = context;

        // guarda o arraylist com os itens no atributo correspondente
        this.contatos = contatos;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        // recuperar um objeto "inflador” de layouts...
        LayoutInflater li = LayoutInflater.from(parent.getContext());

        // "inflando" o xml do item da lista, gerando sua visualização (view)
        View itemView = li.inflate(R.layout.item_lista, parent, false);

        // pegando os objetos gráficos dentro do xml do item da lista
        TextView lblNome = itemView.findViewById(R.id.lblNome);
        TextView lblNota1 = itemView.findViewById(R.id.lblNota1);
        TextView lblNota2 = itemView.findViewById(R.id.lblNota2);

        // colocando dados neste item
        // o objeto esta no índice 'position'
        lblNome.setText(contatos.get(position).getNome());
        lblNota1.setText(contatos.get(position).getNota1());
        lblNota2.setText(contatos.get(position).getNota2());

        // a view do item da lista está montada!!
        // é só devolver
        return itemView;
    }

}
