package com.mycompany.hotel.palmas.model;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Hotel implements Cadastro{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private long id;
    private String nome;
    
    @ManyToOne
    private Bairro bairro;
    
    @OneToMany(mappedBy = "hotel")
    private List<Quarto> quartos;

    public List<Quarto> getQuartos() {
        return quartos;
    }

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

    /**
     * @param quartos the quartos to set
     */
    public void setQuartos(List<Quarto> quartos) {
        this.quartos = quartos;
    }
}
