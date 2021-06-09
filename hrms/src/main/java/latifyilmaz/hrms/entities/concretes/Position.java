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
@Table(name="positions")
@AllArgsConstructor
@NoArgsConstructor
public class Position{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id", nullable = false, unique = true)
    private int id;

    @Column(name="position_name", nullable = false, unique = true)
    private String positionName;

    @OneToMany(mappedBy = "position", fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Employee> employees;

    @OneToMany(mappedBy = "position", fetch = FetchType.LAZY)
    @JsonIgnore
    private List<JobAdvertisement> jobAdvertisements;

    public Position(String positionName){
        this.positionName = positionName;
    }
}
