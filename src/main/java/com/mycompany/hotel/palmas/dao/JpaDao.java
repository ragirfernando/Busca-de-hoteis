package com.mycompany.hotel.palmas.dao;

import javax.persistence.EntityManager;
import com.mycompany.hotel.palmas.model.Cadastro;
import javax.persistence.TypedQuery;

public class JpaDao<T extends Cadastro> implements Dao<T> {
    private final EntityManager manager;

    public EntityManager getManager() {
        return manager;
    }
    private final Class<T> classe;

    public JpaDao(EntityManager manager, Class<T> classe) {
        this.manager = manager;
        this.classe = classe;
    }

    @Override
    public T findById(long id) {
        String jpql = "select o from " + classe.getSimpleName() + " o where id = :id";
        TypedQuery<T> query = manager.createQuery(jpql, classe);
        query.setParameter("id", id);
        return query.getSingleResult();
    }

    @Override
    public boolean delete(T entity) {
        manager.remove(entity);
        return true;
    }

    @Override
    public boolean deleteId(long id) {
        return delete(findById(id));
    }

    @Override
    public long salvar(T entity) {
        manager.persist(entity);
        return  entity.getId();
    }

    @Override
    public long atualizar(T entity) {
        manager.merge(entity);
        return entity.getId();
    }
    

}
