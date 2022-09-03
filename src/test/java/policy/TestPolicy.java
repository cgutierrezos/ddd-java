/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package policy;

import com.cg.ddd.exception.infra.NotFoundException;
import com.cg.ddd.policy.domain.Policy;

/**
 *
 * @author cristian b
 */
public class TestPolicy implements Policy{

    @Override
    public void ensure() throws NotFoundException {
        throw new NotFoundException();
    }
    
}
