package com.mycompany.hotel.palmas.dao;

import javax.persistence.EntityManager;
import com.mycompany.hotel.palmas.model.Cadastro;
import java.util.List;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

public class JpaDao<T extends Cadastro> implements Dao<T> {

    private final EntityManager manager;
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
    public List<T> buscarHoteisCidade(long id) {
        String jpql = "select h from " + classe.getSimpleName() + " as h join h.bairro b where b.cidade.id = :id";
        TypedQuery<T> query = manager.createQuery(jpql, classe);
        query.setParameter("id", id);
        return query.getResultList();
    }

    @Override
    public List<T> buscarHoteisBairro(long id) {
        String jpql = "select h from " + classe.getSimpleName() + " as h join h.bairro b where b.id = :id";
        TypedQuery<T> query = manager.createQuery(jpql, classe);
        query.setParameter("id", id);
        return query.getResultList();
    }

    @Override
    public List<T> buscarHoteisCidadeValorCamas(long id, double valor, int camas) {
        String jpql = "select h from "+classe.getSimpleName()+" as h "
                + "where h.bairro.id in (select bairro.id from Bairro bairro where bairro.cidade.id = :id) "
                + "and h.id in "
                + "(select quarto.h.id from Quarto quarto "
                + "where quarto.valor = :valor and "
                + "quarto.quantidadeDeCamas = :quantidadeDeCamas)";
        Query query = manager.createQuery(jpql, classe);
        query.setParameter("id", id);
        query.setParameter("valor", valor);
        query.setParameter("quantidadeDeCamas", camas);
        return query.getResultList();
    }

    @Override
    public boolean delete(T entity) {
        manager.remove(entity);
        return true;
    }

    @Override
    public boolean delete(int id) {
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
