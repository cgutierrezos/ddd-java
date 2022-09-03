/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cg.ddd.exception.infra;

import com.cg.ddd.exception.domain.DomainException;

/**
 *
 * @author cristian b
 */
public class NotFoundException extends DomainException {

    public NotFoundException(String message) {
        super(message);
    }

    public NotFoundException() {
        super("Not found exception");
    }

    @Override
    public int statusCode() {
        return 404;
    }
    
    
    

    
  
    
    
}
