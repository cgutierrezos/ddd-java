/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package aggregate;

import aggregate.TestAggregate;
import com.cg.ddd.aggregate.domain.aggregateCollection.AggregateCollection;
import java.util.ArrayList;

/**
 *
 * @author cristian b
 */
public class TestAggregateCollection extends AggregateCollection<TestAggregate>{

    public TestAggregateCollection() {
        super(new ArrayList<>());
    }
    
}
