/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import aggregate.TestAggregate;
import aggregate.TestAggregateCollection;
import com.cg.ddd.repository.infra.FakeRepository;

/**
 *
 * @author cristian b
 */
public class TestRepository extends FakeRepository<TestAggregate>{

    public TestRepository() {
        super(new TestAggregateCollection());
    }

}
