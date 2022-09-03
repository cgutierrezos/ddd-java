/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cg.ddd.aggregate.domain.aggregateCollection;

import com.cg.ddd.aggregate.domain.Aggregate;
import java.util.Collection;

/**
 *
 * @author cristian b
 * @param <T>
 */
public class AggregateFilter<T extends Aggregate> {
    
    /**
     *
     * @param <T>
     */
    public interface FilterCallback<T extends Aggregate> {
        public boolean filter(T aggregate);
    }
    
    private final Collection<T> aggregates;

    /**
     *
     * @param aggregates
     */
    public AggregateFilter(Collection<T> aggregates) {
        this.aggregates = aggregates;
    }
    
    
    public T findOneByID(String id){
        return this.findOne((T aggregate) -> {
            return aggregate.id().equals(id);
        });
    }
    
    
    /**
     *
     * @param callback
     * @return
     */
    public T findOne(FilterCallback<T> callback){
        for (T aggregate : this.aggregates) {
            if(callback.filter(aggregate)){
                return aggregate;
            }
        }
        return null;
    }
    
    /**
     *
     * @param callback
     * @return
     */
    public AggregateCollection<T> findMany(FilterCallback<T> callback) {
        
        AggregateCollection<T> filteredAggregates = new AggregateCollection<>();
        
        for (T aggregate : this.aggregates) {
            if(callback.filter(aggregate)){
                filteredAggregates.add(aggregate);
            }
        }
        
        return filteredAggregates;
        
    }
    
}
