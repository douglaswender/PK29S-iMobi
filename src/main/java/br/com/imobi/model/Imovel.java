/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.imobi.model;

import java.sql.Timestamp;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

/**
 *
 * @author dglsw
 */
@Entity
public class Imovel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String description;
    private String endereco;
    private Timestamp lastChange ;
    private boolean favorite;
    @OneToOne
    private Cliente cliente;

    public Imovel() {
    }

    public Imovel(int id, String description, String endereco, Timestamp timestamp, boolean isFavorite, Cliente cliente) {
        this.id = id;
        this.description = description;
        this.endereco = endereco;
        this.lastChange = timestamp;
        this.favorite = isFavorite;
        this.cliente = cliente;
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

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public Timestamp getLastChange() {
        return lastChange;
    }

    public void setLastChange(Timestamp lastChange) {
        this.lastChange = lastChange;
    }


    public boolean isFavorite() {
        return favorite;
    }

    public void setFavorite(boolean isFavorite) {
        this.favorite = isFavorite;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    @Override
    public String toString() {
        return "Imovel{" + "id=" + id + ", description=" + description + ", endereco=" + endereco + ", lastChange=" + lastChange + ", favorite=" + favorite + ", cliente=" + cliente + '}';
    }
    
    
    
}
