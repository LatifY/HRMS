package latifyilmaz.hrms.entities.concretes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@Table(name="Roles")
@AllArgsConstructor
@NoArgsConstructor
public class Role{
    @Id
    @GeneratedValue
    @Column(name="Id")
    private int id;

    @Column(name="RoleName")
    private String roleName;
}
