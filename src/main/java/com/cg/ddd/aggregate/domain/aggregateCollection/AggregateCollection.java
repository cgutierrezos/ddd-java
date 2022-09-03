/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cg.ddd.aggregate.domain.aggregateCollection;

import com.cg.ddd.aggregate.domain.Aggregate;
import java.util.ArrayList;
import java.util.Collection;

/**
 *
 * @author cristian b
 * @param <T>
 */
public class AggregateCollection<T extends Aggregate> {
    
    private final Collection<T> aggregates;

    /**
     *
     */
    public AggregateCollection() {
        this.aggregates = new ArrayList<>();
    }
    
    protected AggregateCollection(Collection<T> aggregates){
        this.aggregates = aggregates;
    }
    
    /**
     *
     * @param aggregate
     */
    public void add(T aggregate) {
        this.aggregates.add(aggregate);
    }
    
    /**
     *
     * @param aggregates
     */
    public void add(AggregateCollection<T> aggregates){
        AggregateIterator<T> iterator = aggregates.iterator();
        
        iterator.each(this::add);
    }
    
    
    public void remove(T aggregate){
        this.aggregates.removeIf((T t) -> {
            return t.id().equals(aggregate.id());
        });
    }
    
    
    
    /**
     *
     * @return
     */
    public AggregateIterator<T> iterator() {
        return new AggregateIterator<>(this.aggregates);
    }
    
    public AggregateFilter<T> filter() {
        return new AggregateFilter<>(this.aggregates);
    }
    
    
    /**
     *
     * @return
     */
    public int size() {
        return this.aggregates.size();
    }
    
    
}
