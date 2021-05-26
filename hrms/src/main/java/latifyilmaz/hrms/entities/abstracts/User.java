package latifyilmaz.hrms.entities.abstracts;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@Table(name="Users")
@Inheritance(strategy=InheritanceType.JOINED)
@AllArgsConstructor
@NoArgsConstructor
public abstract class User{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="Id", nullable = false)
    private int id;

    @Column(name="Email", unique = true, nullable = false)
    private String email;

    @Column(name="Password", nullable = false)
    private String password;

    @Column(name="Verified", nullable = false)
    private boolean verified;

    public User(String email, String password, boolean verified){
        this.email = email;
        this.password = password;
        this.verified = verified;
    }

}
