package com.mycompany.hotel.palmas.dao;

import com.mycompany.hotel.palmas.model.Cadastro;

public interface Dao <T extends Cadastro>{
    T findById(long id);
    boolean delete(T entity);
    boolean deleteId(long id);
    long salvar(T entity);
    long atualizar(T entity);
}
