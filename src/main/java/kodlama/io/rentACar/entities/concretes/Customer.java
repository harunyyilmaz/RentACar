package kodlama.io.rentACar.entities.concretes;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.w3c.dom.stylesheets.LinkStyle;

import java.util.List;

@Table(name = "custors")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "firstName")
    private String firstName;
    @Column(name = "lastName")
    private String lastName;
    @Column(name = "userName",unique = true)
    private String userName;
    @Column(name = "email",unique = true)
    private String email;
    @Column(name = "password",unique = true)
    private String password;
    @Column(name = "nationalIdentityNumber")
    private String nationalIdentityNumber;

    @OneToMany(mappedBy = "customer")
    private List<Car> cars;

}
