/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package aggregate;

import aggregate.aggregateVO.TestAggregateBaaVO;
import aggregate.aggregateVO.TestAggregateFooVO;
import aggregate.aggregateVO.TestAggregateIDVO;
import com.cg.ddd.aggregate.domain.aggregateVO.AggregateTimeStampVO;
import com.github.javafaker.Faker;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.RepeatedTest;

/**
 *
 * @author cristian b
 */
public class AggregateTest {
    
    private final Faker faker;
    
    public AggregateTest() {
        this.faker = new Faker();
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }
    
    @RepeatedTest(10)
    @Test
    public void buildAggregate() {
        String id = this.faker.internet().uuid();
        String foo = this.faker.lorem().word();
        String baa = this.faker.lorem().word();
        Date createdAt = this.faker.date().past(360, TimeUnit.DAYS);
        Date updatedAt = this.faker.date().past(30, TimeUnit.DAYS);
        
        TestAggregate test = new TestAggregate(
                new TestAggregateIDVO(id), 
                new TestAggregateFooVO(foo), 
                new TestAggregateBaaVO(baa), 
                new AggregateTimeStampVO(createdAt, updatedAt)
        );
        
        assertTrue(id.equals(test.id()));
        assertTrue(foo.equals(test.foo()));
        assertTrue(baa.equals(test.baa()));
        assertTrue(createdAt.equals(test.createdat()));
        assertTrue(updatedAt.equals(test.updatedAt())); 
        
    }
    
    @RepeatedTest(10)
    @Test
    public void buildDefaultAggregate() {
        
        Date now = new Date();
        
        String id = this.faker.internet().uuid();
        String foo = this.faker.lorem().word();
        
        TestAggregate test = new TestAggregate(
                new TestAggregateIDVO(id), 
                new TestAggregateFooVO(foo)
        );
        
        assertTrue(id.equals(test.id()));
        assertTrue(foo.equals(test.foo()));
        assertTrue("".equals(test.baa()));
        assertTrue(now.compareTo(test.createdat()) <= 0);
        assertTrue(now.compareTo(test.updatedAt()) <= 0); 
        
    }
    
    @RepeatedTest(10)
    @Test
    public void changeBaa() {
        
        Date now = new Date();
        
        String id = this.faker.internet().uuid();
        String foo = this.faker.lorem().word();
        
        TestAggregate test = new TestAggregate(
                new TestAggregateIDVO(id), 
                new TestAggregateFooVO(foo)
        );
        
        String baa = this.faker.lorem().word();
        
        test.changeBaa(new TestAggregateBaaVO(baa));
        
        assertTrue(id.equals(test.id()));
        assertTrue(foo.equals(test.foo()));
        assertTrue(baa.equals(test.baa()));
        assertTrue(now.compareTo(test.createdat()) <= 0);
        assertTrue(now.compareTo(test.updatedAt()) <= 0); 
        
    }
    
    @RepeatedTest(10)
    @Test
    public void updateAggregate() {
        
        Date now = new Date();
        
        String id = this.faker.internet().uuid();
        String foo = this.faker.lorem().word();
        
        TestAggregate test = new TestAggregate(
                new TestAggregateIDVO(id), 
                new TestAggregateFooVO(foo)
        );
        
        String baa = this.faker.lorem().word();
        
        test.changeBaa(new TestAggregateBaaVO(baa));
        test.update();
        
        assertTrue(id.equals(test.id()));
        assertTrue(foo.equals(test.foo()));
        assertTrue(baa.equals(test.baa()));
        assertTrue(now.compareTo(test.createdat()) <= 0);
        assertTrue(now.compareTo(test.updatedAt()) <= 0); 
        assertTrue(test.createdat().compareTo(test.updatedAt()) <= 0); 
        
    }
}
