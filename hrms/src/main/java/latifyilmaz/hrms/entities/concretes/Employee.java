package latifyilmaz.hrms.entities.concretes;

import latifyilmaz.hrms.entities.abstracts.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@Table(name="employees")
@AllArgsConstructor
@NoArgsConstructor
@PrimaryKeyJoinColumn(name = "user_id")
public class Employee extends User {

    @ManyToOne()
    @JoinColumn(name = "position_id")
    private Position position;

    @Column(name="first_name", nullable = false)
    private String firstName;

    @Column(name="last_name", nullable = false)
    private String lastName;

    @Column(name="identity_no", nullable = false, unique = true)
    private String identityNo;

    @Column(name="birth_year", nullable = false)
    private int birthYear;

    public Employee(String email, String password, boolean verified, String firstName, String lastName, String identityNo, int birthYear) {
        super(email, password, verified);
        this.firstName = firstName;
        this.lastName = lastName;
        this.identityNo = identityNo;
        this.birthYear = birthYear;
    }
}
