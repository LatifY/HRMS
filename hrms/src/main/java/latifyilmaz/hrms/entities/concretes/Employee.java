package latifyilmaz.hrms.entities.concretes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name="Employees")
@AllArgsConstructor
@NoArgsConstructor
public class Employee {
    @Id
    @Column(name="UserId", nullable = false)
    private int userId;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="UserId")
    private User user;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="PositionId", referencedColumnName = "id")
    private Position position;

    @Column(name="CompanyName", nullable = false)
    private String firstName;

    @Column(name="Website", nullable = false)
    private String lastName;

    @Column(name="Phone", nullable = false)
    private String tcNo;

    @Column(name="VerifiedBySystem", nullable = false)
    private Date dateOfBirth;


    public Employee(int userId, String firstName, String lastName, String tcNo, Date dateOfBirth){
        this.userId = userId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.tcNo = tcNo;
        this.dateOfBirth = dateOfBirth;
    }
}
