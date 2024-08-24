package kodlama.io.rentACar.webApi.controllers;

import jakarta.validation.Valid;
import kodlama.io.rentACar.business.abstracts.CustomerService;
import kodlama.io.rentACar.business.requests.CreateCustomerRequest;
import kodlama.io.rentACar.business.requests.UpdateCustomerRequest;
import kodlama.io.rentACar.business.responses.GetAllCustomersResponse;
import kodlama.io.rentACar.business.responses.GetByIdCustomerResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/customers")
@AllArgsConstructor
public class CustomersController {
    private CustomerService customerService;

    @GetMapping
    public List<GetAllCustomersResponse> getAll(){
        return this.customerService.getAll();
    }
    @GetMapping("/{id}")
    public GetByIdCustomerResponse getById(@PathVariable int id){
        return this.customerService.getById(id);
    }
    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public void add(@RequestBody @Valid CreateCustomerRequest createCustomerRequest){
        this.customerService.add(createCustomerRequest);
    }
    @PutMapping
    public void update(@RequestBody @Valid UpdateCustomerRequest updateCustomerRequest){
        this.customerService.update(updateCustomerRequest);
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id){
        this.customerService.delete(id);
    }

}
