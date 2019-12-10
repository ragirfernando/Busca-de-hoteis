package com.mycompany.hotel.palmas.dao;

import com.mycompany.hotel.palmas.model.Cadastro;
import java.util.List;

public interface Dao <T extends Cadastro>{
    T findById(long id);
    List<T> buscarHoteisCidade(long ind);
    List<T> buscarHoteisBairro(long id);
    List<T> buscarHoteisCidadeValorCamas(long id, double valor, int camas);
    boolean delete(T entity);
    boolean delete(int id);
    long salvar(T entity);
    long atualizar(T entity);
    
}
