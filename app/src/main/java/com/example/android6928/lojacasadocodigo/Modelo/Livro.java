package com.example.android6928.lojacasadocodigo.Modelo;

import com.example.android6928.lojacasadocodigo.Modelo.Autor;

import java.io.Serializable;
import java.util.List;

/**
 * Created by android6928 on 31/07/17.
 */

//determinando a entidade com o GREENDOWN, e ele faz o get e set sozinho

//DETERMINA A ENTIDADE
//@Entity
public class Livro implements Serializable{
    //OBRIGATORIO
    //@Id
    private long id;
    //DEFINI COMO NOT NULL
    //@NotNull
    private String nome;

    private String descricao;
    //FORÇAR O NOME
    //@Property("NUMERO_PAGINAS")
    private int numPag;
    private String dataPublicacao;
    //definir como único
    //@Unique
    private String ISBN;
    private double valorFisico;
    private double valorVirtual;
    private double valorDoisJuntos;
    private String urlFoto;
    //para não persisitir
    //@Transient
    private List<Autor> autores;
    //persistencia do metodo
    //@Keep

    /*public void setNome()
    {

    }*/


    public String getDataPublicacao() {
        return dataPublicacao;
    }

    public void setDataPublicacao(String dataPublicacao) {
        this.dataPublicacao = dataPublicacao;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getNumPag() {
        return numPag;
    }

    public void setNumPag(int numPag) {
        this.numPag = numPag;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public double getValorFisico() {
        return valorFisico;
    }

    public void setValorFisico(double valorFisico) {
        this.valorFisico = valorFisico;
    }

    public double getValorVirtual() {
        return valorVirtual;
    }

    public void setValorVirtual(double valorVirtual) {
        this.valorVirtual = valorVirtual;
    }

    public double getValorDoisJuntos() {
        return valorDoisJuntos;
    }

    public void setValorDoisJuntos(double valorDoisJuntos) {
        this.valorDoisJuntos = valorDoisJuntos;
    }

    public String getUrlFoto() {
        return urlFoto;
    }

    public void setUrlFoto(String urlFoto) {
        this.urlFoto = urlFoto;
    }

    public List<Autor> getAutores() {
        return autores;
    }

    public void setAutores(List<Autor> autores) {
        this.autores = autores;
    }

}
