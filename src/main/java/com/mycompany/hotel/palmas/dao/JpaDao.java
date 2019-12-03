package com.mycompany.hotel.palmas.dao;

import com.mycompany.hotel.palmas.model.HotelInterface;
import javax.persistence.EntityManager;

public class JpaDao <T extends HotelInterface> implements Dao<T>{
    private final EntityManager manager;
    private final Class<T> classe;
    
    public JpaDao(EntityManager manager, Class<T> classe ){
        this.manager = manager;
        this.classe =classe;
    }
}
