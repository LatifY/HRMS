package latifyilmaz.hrms.entities.abstracts;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Table(name="users")
@Inheritance(strategy = InheritanceType.JOINED)
@AllArgsConstructor
@NoArgsConstructor
@MappedSuperclass
public class User{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id", nullable = false, unique = true)
    private int id;

    @Column(name="email", nullable = false, unique = true, length = 60)
    private String email;

    @Column(name="password", nullable = false, length = 60)
    private String password;

    @Column(name="verified", nullable = false)
    private boolean verified;

    public User(String email, String password, boolean verified){
        this.email = email;
        this.password = password;
        this.verified = verified;
    }

}
