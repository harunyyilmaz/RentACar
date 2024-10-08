package kodlama.io.rentACar.business.rules;

import kodlama.io.rentACar.core.utilities.mappers.exceptions.BusinessException;
import kodlama.io.rentACar.dataAccess.abstracts.CarRepository;
import kodlama.io.rentACar.entities.concretes.Car;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CarBusinessRules {
    private CarRepository carRepository;

    public void checkIfCarPlateExists(String plate) {
        if (this.carRepository.existsByPlate(plate)) {
            throw new BusinessException("Car plate already exists");
        }
    }
}
