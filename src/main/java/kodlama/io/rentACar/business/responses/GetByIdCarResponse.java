package kodlama.io.rentACar.business.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetByIdCarResponse {

    private int carId;
    private String plate;
    private double dailyPrice;
    private int modelYear;
    private String state;
    private int modelId;
    private String modelName;
    private int brandId;
    private String brandName;
}
