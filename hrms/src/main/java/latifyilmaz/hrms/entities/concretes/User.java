/*
Not Finished Yet!
*/

package latifyilmaz.hrms.entities.concretes;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name="Users")
public class User{
    @Id
    @GeneratedValue
    @Column(name="Id")
    private int id;

    @Column(name="Email")
    private String email;

    @Column(name="Password")
    private String password;

    @Column(name="Verified")
    private boolean verified;

    public User(){}
    public User(int id, String email, String password, boolean verified){
        super();
        this.id = id;
        this.email = email;
        this.password = password;
        this.verified = verified;
    }

}
