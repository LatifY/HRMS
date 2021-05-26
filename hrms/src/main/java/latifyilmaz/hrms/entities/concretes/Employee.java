package latifyilmaz.hrms.entities.concretes;

import latifyilmaz.hrms.entities.abstracts.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@Table(name="Employees")
@AllArgsConstructor
@NoArgsConstructor
public class Employee extends User {
    @Id
    @Column(name="UserId", nullable = false)
    private int userId;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="UserId")
    private User user;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="PositionId", referencedColumnName = "id")
    private Position position;

    @Column(name="FirstName", nullable = false)
    private String firstName;

    @Column(name="LastName", nullable = false)
    private String lastName;

    @Column(name="TCNo", nullable = false)
    private String tcNo;

    @Column(name="DateOfBirthYear", nullable = false)
    private int dateOfBirthYear;

    public Employee(String firstName, String lastName, String tcNo, int dateOfBirthYear, String email, String password){
        super(email,password, false);
        this.firstName = firstName;
        this.lastName = lastName;
        this.tcNo = tcNo;
        this.dateOfBirthYear = dateOfBirthYear;
    }
}
