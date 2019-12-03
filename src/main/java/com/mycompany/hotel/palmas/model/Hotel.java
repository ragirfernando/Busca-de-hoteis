package com.mycompany.hotel.palmas.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "hotel")
public class Hotel implements HotelInterface, Serializable{
    @Id
    @GeneratedValue(generator = "id_hotel", strategy = GenerationType.IDENTITY)
    private long id;
    private String nome;
    
    @ManyToMany
    @JoinColumn(columnDefinition = "id_bairro")
    private Bairro bairro;
    
    

    @Override
    public long getId() {
        return id;
    }

    @Override
    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Bairro getBairro() {
        return bairro;
    }

    public void setBairro(Bairro bairro) {
        this.bairro = bairro;
    }

     
    
    
}
