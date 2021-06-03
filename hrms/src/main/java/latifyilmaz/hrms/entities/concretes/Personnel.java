package latifyilmaz.hrms.entities.concretes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@Table(name = "personnels")
@AllArgsConstructor
@NoArgsConstructor
public class Personnel{
    @Id
    @Column(name = "user_id", nullable = false)
    private int userId;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="user_id")
    private User user;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    public Personnel(int userId, String firstName, String lastName){
        this.userId = userId;
        this.firstName = firstName;
        this.lastName = lastName;
    }
}
