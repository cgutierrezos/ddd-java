/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.cg.ddd.repository.domain;

import com.cg.ddd.aggregate.domain.Aggregate;

/**
 *
 * @author cristian b
 * @param <T>
 */
public interface Repository<T extends Aggregate> {
    
    public T findOneByID(String id);
    
    public void create(T aggregate);
    
    public void update(T aggregate);
    
    public void remove(T aggregate);
    
    public void boot();
}
