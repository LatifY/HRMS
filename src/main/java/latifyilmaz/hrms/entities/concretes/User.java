package latifyilmaz.hrms.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@Table(name="users")
@AllArgsConstructor
@NoArgsConstructor
public class User{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id", nullable = false, unique = true)
    private int id;

    @Column(name="email", nullable = false, unique = true, length = 60)
    private String email;

    //@JsonIgnore
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
