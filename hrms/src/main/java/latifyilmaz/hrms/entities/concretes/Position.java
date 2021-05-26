package latifyilmaz.hrms.entities.concretes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@Table(name="Positions")
@AllArgsConstructor
@NoArgsConstructor
public class Position{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="Id")
    private int id;

    @Column(name="PositionName")
    private String positionName;
}
