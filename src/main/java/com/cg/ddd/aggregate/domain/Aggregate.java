/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cg.ddd.aggregate.domain;

import com.cg.ddd.aggregate.domain.aggregateVO.AggregateIDVO;
import com.cg.ddd.aggregate.domain.aggregateVO.AggregateTimeStampVO;
import java.util.Date;

/**
 *
 * @author cristian b
 */
public abstract class Aggregate {
    
    private final AggregateIDVO idVO;
    private AggregateTimeStampVO timeStampVO;

    /**
     *
     * @param idVO
     */
    public Aggregate(AggregateIDVO idVO) {
        this.idVO = idVO;
        this.timeStampVO = new AggregateTimeStampVO();
    }

    /**
     *
     * @param idVO
     * @param timeStampVO
     */
    public Aggregate(AggregateIDVO idVO, AggregateTimeStampVO timeStampVO) {
        this.idVO = idVO;
        this.timeStampVO = timeStampVO;
    }
    
    /**
     *
     * @return
     */
    public String id() {
        return this.idVO.id();
    }
    
    /**
     *
     * @return
     */
    public Date createdat() {
        return this.timeStampVO.createdAt();
    }
    
    /**
     *
     * @return
     */
    public Date updatedAt() {
        return this.timeStampVO.updatedAt();
    }
    
    /**
     *
     */
    public void update() {
        this.timeStampVO = this.timeStampVO.update();
    }

    
    @Override
    public abstract Aggregate clone();
}
