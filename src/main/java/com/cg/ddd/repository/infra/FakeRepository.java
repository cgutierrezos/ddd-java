/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cg.ddd.repository.infra;

import com.cg.ddd.aggregate.domain.Aggregate;
import com.cg.ddd.aggregate.domain.aggregateCollection.AggregateCollection;
import com.cg.ddd.aggregate.domain.aggregateCollection.AggregateFilter;

import com.cg.ddd.repository.domain.Repository;

/**
 *
 * @author cristian b
 * @param <T>
 */
public abstract class FakeRepository<T extends Aggregate> implements Repository<T>{

    private AggregateCollection<T> aggregates;

    public FakeRepository() {
        this.aggregates = new AggregateCollection<>();
    }
    
    protected FakeRepository(AggregateCollection<T> aggregates){
        this.aggregates = aggregates;
    }
    
    @Override
    public T findOneByID(String id){
        AggregateFilter<T> filter = this.aggregates.filter();
        
        T aggregate = filter.findOneByID(id);
        
        if(aggregate == null){
            return null;
        }
        
        return (T) aggregate.clone();
    }
    
    @Override
    public void create(T aggregate){
        
        if(this.isSaved(aggregate)){
            return;
        }
        
        this.aggregates.add((T) aggregate.clone());
    }
    
    @Override
    public void update(T aggregate){
        
        if(!this.isSaved(aggregate)){
            return;
        }
        
        this.aggregates.remove(aggregate);
        this.aggregates.add((T) aggregate.clone());
        
        
        
//        AggregateFilter<T> filter = this.aggregates.filter();
//        
//        this.aggregates = filter.findMany((T aggregateToFilter) -> {
//            return !aggregate.id().equals(aggregateToFilter.id());
//        });
//        
//        this.aggregates.add(aggregate);
    }
    
    @Override
    public void remove(T aggregate) {
        AggregateFilter<T> filter = this.aggregates.filter();
        
        this.aggregates = filter.findMany((T aggregateToRemove) -> {
            return !aggregate.id().equals(aggregateToRemove.id());
        });
    }
    
    @Override
    public void boot() {
        
    }
    
    public boolean isSaved(T aggregate){
        return this.findOneByID(aggregate.id()) != null;
    }
}
