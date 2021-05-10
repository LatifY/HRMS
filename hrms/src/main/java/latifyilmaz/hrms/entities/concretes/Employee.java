/*
Not Finished Yet!
*/

package latifyilmaz.hrms.entities.concretes;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name="Employee")
public class Employee extends User{
    @Id
    @Column(name="UserId")
    private int userId;

    @Column(name="FirstName")
    private String firstName;

    @Column(name="LastName")
    private String lastName;

    @Column(name="TCNo")
    private boolean tcNo;

    public Employee(){}
    public Employee(int id, String email, String password, boolean verified, int userId, String firstName, String lastName, boolean tcNo){
        super(id, email, password, verified);
        this.userId = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.tcNo = tcNo;
    }

}
