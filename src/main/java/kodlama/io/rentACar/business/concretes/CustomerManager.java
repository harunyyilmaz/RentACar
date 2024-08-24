package kodlama.io.rentACar.business.concretes;

import kodlama.io.rentACar.business.abstracts.CustomerService;
import kodlama.io.rentACar.business.requests.CreateCustomerRequest;
import kodlama.io.rentACar.business.requests.UpdateCustomerRequest;
import kodlama.io.rentACar.business.responses.GetAllCustomersResponse;
import kodlama.io.rentACar.business.responses.GetByIdCustomerResponse;
import kodlama.io.rentACar.business.rules.CustomerBusinessRules;
import kodlama.io.rentACar.core.utilities.mappers.ModelMapperService;
import kodlama.io.rentACar.dataAccess.abstracts.CustomerRepository;
import kodlama.io.rentACar.entities.concretes.Customer;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.Callable;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CustomerManager implements CustomerService {
    private CustomerRepository customerRepository;
    private ModelMapperService modelMapperService;
    private CustomerBusinessRules customerBusinessRules;

    @Override
    public List<GetAllCustomersResponse> getAll() {
        List<Customer> customers = this.customerRepository.findAll();
        List<GetAllCustomersResponse> getAllCustomersResponses = customers.stream()
                .map(customer -> this.modelMapperService.forResponse()
                        .map(customer, GetAllCustomersResponse.class)).collect(Collectors.toList());
        return getAllCustomersResponses;
    }

    @Override
    public GetByIdCustomerResponse getById(int id) {
        Customer customer = this.customerRepository.findById(id).orElseThrow();
        GetByIdCustomerResponse getByIdCustomerResponse = this.modelMapperService.forResponse().map(customer, GetByIdCustomerResponse.class);
        return getByIdCustomerResponse;
    }

    @Override
    public void add(CreateCustomerRequest createCustomerRequest) {

        this.customerBusinessRules.checkIfCustomerExists(createCustomerRequest.getUserName());

        Customer customer = this.modelMapperService.forRequest().map(createCustomerRequest, Customer.class);
        this.customerRepository.save(customer);

    }

    @Override
    public void update(UpdateCustomerRequest updateCustomerRequest) {
        Customer customer = this.modelMapperService.forRequest().map(updateCustomerRequest, Customer.class);
        this.customerRepository.save(customer);
    }

    @Override
    public void delete(int id) {
        this.customerRepository.deleteById(id);
    }
}
