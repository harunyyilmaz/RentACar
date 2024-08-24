package kodlama.io.rentACar.dataAccess.abstracts;

import kodlama.io.rentACar.entities.concretes.Brand;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BrandRepository extends JpaRepository<Brand,Integer> {

    Boolean existsByName(String name); // bu bir jpa keywords dür.

    // spring JPA keywords arasitir.
    // exists Var mi Yok mu Jpa bunu anlar ondan dolayi boolean doner.
    //Brand findByName(String name);
    //List<Brand> findByName(String name);
}
