package kodlama.io.rentACar.business.rules;

import kodlama.io.rentACar.core.utilities.mappers.exceptions.BusinessException;
import kodlama.io.rentACar.dataAccess.abstracts.ModelRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ModelBusinessRules {
    private ModelRepository modelRepository;

    public void checkIfModelNameExists(String name) {
        if (this.modelRepository.existsByName(name)) {
            throw new BusinessException("Model name already exists"); // java exception types arastir.
        }
    }
}
