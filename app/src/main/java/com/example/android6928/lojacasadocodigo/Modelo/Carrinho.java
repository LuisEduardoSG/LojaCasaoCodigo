package com.example.android6928.lojacasadocodigo.Modelo;

import com.example.android6928.lojacasadocodigo.Modelo.Item;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * Created by android6928 on 03/08/17.
 */

public class Carrinho implements Serializable{

    private List<Item> itens = new ArrayList<Item>();

    //private double total = 0;


    public void adciona (Item item){
        itens.add(item);
        //total = total + item.getValor();
    }

    public void adcionaMuitos (List<Item> itensNovos){

        itens.addAll(itensNovos);
        //total = total + i.getValor();
    }

    public void remove (Item item){
        itens.remove(item);
    }

    public void limpa (){
        itens.clear();
    }

    public List<Item> getItens (){
        return Collections.unmodifiableList(itens);
    }
/*
    public double getTotal() {
        return total;
    }*/
}
