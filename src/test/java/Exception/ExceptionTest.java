/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package Exception;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.RepeatedTest;

/**
 *
 * @author cristian b
 */
public class ExceptionTest {
    
    public ExceptionTest() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }
    
    @RepeatedTest(10)
    @Test
    public void exceptionThrows() {
        
        TestNotFoundException  e = assertThrows(TestNotFoundException.class, () -> {
            throw new TestNotFoundException();
        });
        
        
        assertTrue(e.statusCode() == 404);
        assertTrue(e.getMessage().equals("Test not found"));
    }
    
    
}
