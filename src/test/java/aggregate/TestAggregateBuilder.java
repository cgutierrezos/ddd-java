/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package aggregate;

import aggregate.aggregateVO.TestAggregateBaaVO;
import aggregate.aggregateVO.TestAggregateFooVO;
import aggregate.aggregateVO.TestAggregateIDVO;
import com.cg.ddd.aggregate.domain.aggregateVO.AggregateTimeStampVO;
import com.github.javafaker.Faker;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author cristian b
 */
public class TestAggregateBuilder {
    
    private final Faker faker;

    public TestAggregateBuilder(Faker faker) {
        this.faker = faker;
    }
    
    public TestAggregate build(){
        return new TestAggregate(
                new TestAggregateIDVO(this.faker.internet().uuid()), 
                new TestAggregateFooVO(this.faker.lorem().word()), 
                new TestAggregateBaaVO(this.faker.lorem().word()), 
                new AggregateTimeStampVO(new Date(), this.faker.date().future(1, TimeUnit.DAYS))
        );
    }
    
    public TestAggregateCollection build(int number){
        TestAggregateCollection aggregates = new TestAggregateCollection();
        
        for (int i = 0; i < number; i++) {
            aggregates.add(this.build());
        }
        
        return aggregates;
    }
}
