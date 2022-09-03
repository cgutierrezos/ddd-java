/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package repository;

import aggregate.TestAggregate;
import aggregate.TestAggregateBuilder;
import aggregate.aggregateVO.TestAggregateBaaVO;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.RepeatedTest;

/**
 *
 * @author cristian b
 */
public class RepositoryTest {
    
    private final Faker faker;
    private final TestAggregateBuilder builder;
    
    public RepositoryTest() {
        this.faker = new Faker();
        this.builder  = new TestAggregateBuilder(this.faker);
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }
    
    @RepeatedTest(10)
    @Test
    public void create(){
        
        TestRepository repository = new TestRepository();
        
        TestAggregate test = this.builder.build();
        
        repository.create(test);
        
        TestAggregate createdTest = repository.findOneByID(test.id());
        
        assertTrue(createdTest.id().equals(test.id()));
        assertTrue(createdTest.foo().equals(test.foo()));
        assertTrue(createdTest.baa().equals(test.baa()));
        assertTrue(createdTest.createdat().equals(test.createdat()));
        assertTrue(createdTest.updatedAt().equals(test.updatedAt()));  
        assertTrue(repository.isSaved(test));
        
    }
    
    @RepeatedTest(10)
    @Test
    public void update(){
        
        TestRepository repository = new TestRepository();
        
        TestAggregate test = this.builder.build();
        
        repository.create(test);
        
        TestAggregate createdTest = repository.findOneByID(test.id());
        
        createdTest.changeBaa(new TestAggregateBaaVO(this.faker.lorem().word()));
        createdTest.update();
        
        repository.update(createdTest);
        
        TestAggregate updatedTest = repository.findOneByID(test.id());
        
        assertTrue(updatedTest.id().equals(createdTest.id()));
        assertTrue(updatedTest.foo().equals(createdTest.foo()));
        assertTrue(!updatedTest.baa().equals(test.baa()));
        assertTrue(updatedTest.createdat().equals(createdTest.createdat()));
        assertTrue(updatedTest.updatedAt().equals(createdTest.updatedAt()));        
        assertTrue(repository.isSaved(test));
        
    }
    
    @RepeatedTest(10)
    @Test
    public void remove(){
        
        TestRepository repository = new TestRepository();
        
        TestAggregate test = this.builder.build();
        
        repository.create(test);
        
        TestAggregate createdTest = repository.findOneByID(test.id());
        
        repository.remove(test);
        
        TestAggregate deletedTest = repository.findOneByID(test.id());
        
        assertTrue(createdTest.id().equals(test.id()));
        assertTrue(createdTest.foo().equals(test.foo()));
        assertTrue(createdTest.baa().equals(test.baa()));
        assertTrue(createdTest.createdat().equals(test.createdat()));
        assertTrue(createdTest.updatedAt().equals(test.updatedAt()));  
        assertTrue(!repository.isSaved(test));
        assertTrue(deletedTest == null);
        
    }
    
    
}
