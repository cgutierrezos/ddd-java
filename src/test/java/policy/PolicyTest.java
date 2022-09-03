/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package policy;

import com.cg.ddd.exception.infra.NotFoundException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.RepeatedTest;

/**
 *
 * @author cristian b
 */
public class PolicyTest {
    
    public PolicyTest() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }
    
    @RepeatedTest(10)
    @Test
    public void ensure(){
        
        TestPolicy policy = new TestPolicy();
        
        NotFoundException e = assertThrows(NotFoundException.class, () -> {
            policy.ensure();
        });
        
        assertTrue(e.statusCode() == 404);
        assertTrue(e.getMessage().equals("Not found exception"));
        
    }
    
}
