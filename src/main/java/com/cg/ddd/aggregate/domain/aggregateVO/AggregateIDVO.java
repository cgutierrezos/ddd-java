/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cg.ddd.aggregate.domain.aggregateVO;

/**
 *
 * @author cristian b
 */
public class AggregateIDVO {
    
    private final String id;

    public AggregateIDVO(String id) {
        this.id = id;
    }

    public String id() {
        return this.id;
    }
    
}
