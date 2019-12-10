package com.mycompany.hotel.palmas.config;

import com.mycompany.hotel.palmas.dao.Dao;
import com.mycompany.hotel.palmas.dao.JpaDao;
import java.lang.reflect.ParameterizedType;
import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.InjectionPoint;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.mycompany.hotel.palmas.model.Cadastro;

public class Producers {

    @Produces
    @PersistenceContext
    private EntityManager manager;
    
    @Produces
    public <T extends Cadastro> Dao<T> getDao(InjectionPoint ip){
        ParameterizedType parameterizedType = (ParameterizedType) ip.getType();
       Class classe = (Class ) parameterizedType.getActualTypeArguments()[0];
        return new JpaDao(manager, classe);
    }
}
