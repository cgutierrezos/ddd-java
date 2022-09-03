/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cg.ddd.exception.domain;

/**
 *
 * @author cristian b
 */
public abstract class DomainException extends Exception{
    
    

    public DomainException(String message) {
        super(message);
    }
    
    public abstract int statusCode();
    
}
