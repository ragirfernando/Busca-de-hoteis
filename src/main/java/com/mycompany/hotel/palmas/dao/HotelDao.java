/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.hotel.palmas.dao;

import com.mycompany.hotel.palmas.model.Hotel;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

/**
 *
 * @author ragir
 */
public class HotelDao extends JpaDao<Hotel> {

    public HotelDao(EntityManager manager) {
        super(manager, Hotel.class);
    }

    public List<Hotel> buscarHoteisCidade(long id) {
        String jpql = "select h from Hotel as h join h.bairro b where b.cidade.id = :id";
        TypedQuery<Hotel> query = getManager().createQuery(jpql, Hotel.class);
        query.setParameter("id", id);
        return query.getResultList();
    }

    public List<Hotel> buscarHoteisBairro(long id) {
        String jpql = "select h from Hotel as h join h.bairro b where b.id = :id";
        TypedQuery<Hotel> query = getManager().createQuery(jpql, Hotel.class);
        query.setParameter("id", id);
        return query.getResultList();
    }

    public List<Hotel> buscarHoteisCidadeValorCamas(long cidadeId, double valor, int camas) {
        String jpql
                = "select h from Hotel h "
                + " join fetch h.quartos q "
                + " join fetch h.bairro b "
                + "where h.bairro.cidade.id = :p1 and "
                + "q.valor = :p2 and "
                + "q.quantidadeDeCamas = :p3";
        System.out.println("\n\n" + jpql);

        TypedQuery<Hotel> query = getManager().createQuery(jpql, Hotel.class);
        query.setParameter("p1", cidadeId);
        query.setParameter("p2", valor);
        query.setParameter("p3", camas);

        return query.getResultList();
    }

}
