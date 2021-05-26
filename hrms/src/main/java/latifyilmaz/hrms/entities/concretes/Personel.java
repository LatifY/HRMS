package latifyilmaz.hrms.entities.concretes;

import latifyilmaz.hrms.entities.abstracts.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@Table(name = "Personels")
@AllArgsConstructor
@NoArgsConstructor
public class Personel extends User {
    @Id
    @Column(name = "UserId", nullable = false)
    private int userId;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "UserId")
    private User user;

    @Column(name = "FirstName", nullable = false)
    private String firstName;

    @Column(name = "LastName", nullable = false)
    private String lastName;
}
