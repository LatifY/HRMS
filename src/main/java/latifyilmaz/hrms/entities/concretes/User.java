package latifyilmaz.hrms.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

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

    @Column(name="userType", nullable = false, length = 60)
    private String userType;

    public User(String email, String password, boolean verified, String userType){
        this.email = email;
        this.password = password;
        this.verified = verified;
        this.userType = userType;
    }

}
