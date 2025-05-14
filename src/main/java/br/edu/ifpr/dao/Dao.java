/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package br.edu.ifpr.dao;

import java.util.List;

/**
 *
 * @author rafael
 */
public interface Dao<PK, T> {

    public void create(T entity);

    public T retrieve(PK id);

    public void update(T entity);

    public void delete(PK id);

    public List<T> findAll();
}
