/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cg.ddd.aggregate.domain.aggregateCollection;

import com.cg.ddd.aggregate.domain.Aggregate;
import java.util.Collection;
import java.util.Iterator;

/**
 *
 * @author cristian b
 */
public class AggregateIterator<T extends Aggregate> {
    
    private final Iterator<T> iterator;
    
    public interface EachCallback<T extends Aggregate> {
        public void each(T aggregate);
    }

    public AggregateIterator(Collection<T> aggregates) {
        this.iterator = aggregates.iterator();
    }

    public boolean hasNext() {
        return this.iterator.hasNext();
    }
    
    public T next(){
        if(!this.hasNext()){
            return null;
        }
        
        return this.iterator.next();
    }
    
    public void each(EachCallback<T> callback){
        while (this.hasNext()) {
            callback.each(this.next());
        }
    }
}
