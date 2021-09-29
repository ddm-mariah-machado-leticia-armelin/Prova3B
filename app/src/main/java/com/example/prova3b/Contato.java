package com.example.prova3b;

public class Contato {

    private String nome;
    private Float nota1;
    private Float nota2;
    private Float media;

    public Contato ( String nome, Float nota1, Float nota2, Float media ) {

        this.nome = nome;
        this.nota1 = nota1;
        this.nota2 = nota2;
        this.media = media;
    }

    public String getNome() {

        return nome;
    }

    public Float getNota1() {

        return nota1;
    }

    public Float getNota2() {

        return nota2;
    }
    public Float getMedia() {
        media= nota1 + nota2/2;

        return media;
    }
}

