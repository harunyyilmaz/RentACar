package kodlama.io.rentACar.business.abstracts;

import kodlama.io.rentACar.business.requests.CreateCustomerRequest;
import kodlama.io.rentACar.business.requests.UpdateCustomerRequest;
import kodlama.io.rentACar.business.responses.GetAllCustomersResponse;
import kodlama.io.rentACar.business.responses.GetByIdCustomerResponse;
import kodlama.io.rentACar.dataAccess.abstracts.CustomerRepository;

import java.util.List;

public interface CustomerService {
    List<GetAllCustomersResponse> getAll();

    GetByIdCustomerResponse getById(int id);

    void add(CreateCustomerRequest createCustomerRequest);

    void update(UpdateCustomerRequest updateCustomerRequest);

    void delete(int id);

}
