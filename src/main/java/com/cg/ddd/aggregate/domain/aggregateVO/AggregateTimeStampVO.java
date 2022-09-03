/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cg.ddd.aggregate.domain.aggregateVO;

import java.util.Date;

/**
 *
 * @author cristian b
 */
public class AggregateTimeStampVO {
    
    private final Date createdAt;
    private final Date updatedAt;

    public AggregateTimeStampVO() {
        this.createdAt = new Date();
        this.updatedAt = this.createdAt;
    }

    public AggregateTimeStampVO(Date createdAt, Date updatedAt) {
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }
    
    public Date createdAt() {
        return this.createdAt;
    }
    
    public Date updatedAt() {
        return this.updatedAt;
    }
    
    
    public AggregateTimeStampVO update() {
        return new AggregateTimeStampVO(this.createdAt, new Date());
    }
    
}
