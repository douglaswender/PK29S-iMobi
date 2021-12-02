/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.imobi.model;

import java.sql.Timestamp;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author dglsw
 */
public class Imovel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String description;
    private Endereco endereco;
    private Timestamp timestamp ;
    private boolean isFavorite;

    public Imovel() {
    }

    public Imovel(int id, String description, Endereco endereco, Timestamp timestamp, boolean isFavorite) {
        this.id = id;
        this.description = description;
        this.endereco = endereco;
        this.timestamp = timestamp;
        this.isFavorite = isFavorite;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public Timestamp getLastChange() {
        return timestamp;
    }

    public void setLastChange(Timestamp lastChange) {
        this.timestamp = lastChange;
    }
    
    
}
