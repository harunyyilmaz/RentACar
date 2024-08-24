package kodlama.io.rentACar;

import kodlama.io.rentACar.core.utilities.mappers.exceptions.BusinessException;
import kodlama.io.rentACar.core.utilities.mappers.exceptions.ProblemDetails;
import kodlama.io.rentACar.core.utilities.mappers.exceptions.ValidationProblemDetails;
import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.lang.reflect.Field;
import java.util.HashMap;

@SpringBootApplication
@RestControllerAdvice
public class RentACarApplication {

    public static void main(String[] args) {

        SpringApplication.run(RentACarApplication.class, args);
    }

    @ExceptionHandler
    @ResponseStatus(code= HttpStatus.BAD_REQUEST)
    public ProblemDetails handleBusinessException(BusinessException businessException){
        ProblemDetails problemDetails=new ProblemDetails();
        problemDetails.setMessage(businessException.getMessage());

        return problemDetails;
    }

    @ExceptionHandler
    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    public ProblemDetails handleValidationException(MethodArgumentNotValidException methodArgumentNotValidException){
        ValidationProblemDetails validationProblemdetails = new ValidationProblemDetails();
        validationProblemdetails.setMessage("Validation. Exception");
        validationProblemdetails.setValidationErrors(new HashMap<String,String>());

        for (FieldError fieldError : methodArgumentNotValidException.getBindingResult().getFieldErrors()){
            validationProblemdetails.getValidationErrors().put(fieldError.getField(), fieldError.getDefaultMessage());
        }


        return validationProblemdetails;
    }

    @Bean
    public ModelMapper getModelMapper(){
        return new ModelMapper();
    }


}
