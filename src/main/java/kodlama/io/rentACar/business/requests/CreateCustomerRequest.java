package kodlama.io.rentACar.business.requests;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateCustomerRequest {

    @NotNull
    @NotBlank
    @Size(min = 5,max = 20)
    private String userName;
    @NotNull
    @NotBlank
    @Size(min = 8,max = 24)
    private String password;
    @NotNull
    @NotBlank
    private String Email;
}
