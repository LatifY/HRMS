package latifyilmaz.hrms.entities.concretes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@Table(name = "Personels")
@AllArgsConstructor
@NoArgsConstructor
public class Personel {
    @Id
    @Column(name = "UserId", nullable = false)
    private int userId;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "UserId")
    private User user;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name ="RoleId", referencedColumnName = "id")
    private Role role;

    @Column(name = "FirstName", nullable = false)
    private String firstName;

    @Column(name = "LastName", nullable = false)
    private String lastName;

    public Personel(int userId, String firstName, String lastName){
        this.userId = userId;
        this.firstName = firstName;
        this.lastName = lastName;
    }
}
