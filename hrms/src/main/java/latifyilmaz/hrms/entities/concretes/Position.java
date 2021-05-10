package latifyilmaz.hrms.entities.concretes;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name="Positions")
public class Position{
    @Id
    @GeneratedValue
    @Column(name="Id")
    private int id;

    @Column(name="PositionName")
    private String positionName;

    public Position(){}
    public Position(int id, String positionName){
        super();
        this.id = id;
        this.positionName = positionName;
    }

}
