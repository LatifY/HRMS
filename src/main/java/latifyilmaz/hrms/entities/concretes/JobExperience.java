package latifyilmaz.hrms.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@Table(name="job_experiences")
@AllArgsConstructor
@NoArgsConstructor
public class JobExperience {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id", nullable = false, unique = true)
    private int id;

    @ManyToOne(targetEntity = Resume.class, fetch = FetchType.EAGER)
    @JoinColumn(name = "resume_id")
    @JsonIgnore
    private Resume resume;

    @Column(name = "company_name", nullable = false)
    private String companyName;

    @Column(name = "position_name", nullable = false)
    private String positionName;

    @Column(name = "start_year", nullable = false)
    private int startYear;

    @Column(name = "end_year")
    private int endYear;

    public JobExperience(Resume resume, String companyName, String positionName, int startYear, int endYear){
        this.resume = resume;
        this.companyName = companyName;
        this.positionName = positionName;
        this.startYear = startYear;
        this.endYear = endYear;
    }
}
