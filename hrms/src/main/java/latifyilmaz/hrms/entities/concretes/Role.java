package latifyilmaz.hrms.entities.concretes;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name="Roles")
public class Role{
    @Id
    @GeneratedValue
    @Column(name="Id")
    private int id;

    @Column(name="RoleName")
    private String roleName;

    public Role(){}
    public Role(int id, String roleName){
        super();
        this.id = id;
        this.roleName = roleName;
    }

}
