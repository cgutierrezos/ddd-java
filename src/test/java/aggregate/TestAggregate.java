/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package aggregate;

import aggregate.aggregateVO.TestAggregateBaaVO;
import aggregate.aggregateVO.TestAggregateFooVO;
import aggregate.aggregateVO.TestAggregateIDVO;
import com.cg.ddd.aggregate.domain.Aggregate;
import com.cg.ddd.aggregate.domain.aggregateVO.AggregateTimeStampVO;

/**
 *
 * @author cristian b
 */
public class TestAggregate extends Aggregate {

    private final TestAggregateFooVO fooVO;
    private TestAggregateBaaVO baaVO;

    public TestAggregate(TestAggregateIDVO idVO, TestAggregateFooVO fooVO, TestAggregateBaaVO baaVO) {
        super(idVO);
        this.fooVO = fooVO;
        this.baaVO = baaVO;
    }
    
    public TestAggregate(TestAggregateIDVO idVO, TestAggregateFooVO fooVO) {
        super(idVO);
        this.fooVO = fooVO;
        this.baaVO = new TestAggregateBaaVO("");
    }

    public TestAggregate(TestAggregateIDVO idVO, TestAggregateFooVO fooVO, TestAggregateBaaVO baaVO, AggregateTimeStampVO timeStampVO) {
        super(idVO, timeStampVO);
        this.fooVO = fooVO;
        this.baaVO = baaVO;
    }
    
    public String foo() {
        return this.fooVO.foo();
    }
    
    public String baa() {
        return this.baaVO.baa();
    }
    
    
    public String fooBaa() {
        return String.format("%s %s", this.foo(), this.baa());
    }
    
    public void changeBaa(TestAggregateBaaVO baaVO){
        this.baaVO = baaVO;
    }

     /**
     *
     * @return
     */
    @Override
    public Aggregate clone() {
        return new TestAggregate(
                new TestAggregateIDVO(this.id()), 
                new TestAggregateFooVO(this.foo()), 
                new TestAggregateBaaVO(this.baa()), 
                new AggregateTimeStampVO(this.createdat(), this.updatedAt())
        );
    }

    
}
