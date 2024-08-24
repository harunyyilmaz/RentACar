package kodlama.io.rentACar.business.rules;

import kodlama.io.rentACar.core.utilities.mappers.exceptions.BusinessException;
import kodlama.io.rentACar.dataAccess.abstracts.CustomerRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class CustomerBusinessRules {
    private CustomerRepository customerRepository;

    public void checkIfCustomerExists(String userName){
        if (this.customerRepository.existsByUserName(userName)){
            throw new BusinessException("User name already exists");
        }
    }
}
