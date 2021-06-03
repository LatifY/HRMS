package latifyilmaz.hrms.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@Table(name="abilities")
@AllArgsConstructor
@NoArgsConstructor
public class Ability {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id", nullable = false, unique = true)
    private int id;

    @ManyToOne(targetEntity = Resume.class, fetch = FetchType.EAGER)
    @JoinColumn(name = "resume_id")
    @JsonIgnore
    private Resume resume;

    @Column(name = "ability_name", nullable = false)
    private String abilityName;

    public Ability(Resume resume, String abilityName){
        this.resume = resume;
        this.abilityName = abilityName;
    }
}