package kodlama.io.rentACar.business.requests;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateModelRequest {
    @NonNull
    @NotBlank
    @Size(min = 3,max = 20)
    private String name;
    @NotNull
    @NotBlank
    private int brandId;
}
