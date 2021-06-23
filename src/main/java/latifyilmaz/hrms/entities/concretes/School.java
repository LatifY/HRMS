package latifyilmaz.hrms.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@Table(name="schools")
@AllArgsConstructor
@NoArgsConstructor
public class School {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id", nullable = false, unique = true)
    private int id;

    @ManyToOne(targetEntity = Resume.class, fetch = FetchType.EAGER)
    @JoinColumn(name = "resume_id")
    @JsonIgnore
    private Resume resume;

    @Column(name = "school_name", nullable = false)
    private String schoolName;

    @Column(name = "school_department", nullable = false)
    private String schoolDepartment;

    @Column(name = "start_year", nullable = false)
    private int startYear;

    @Column(name = "end_year")
    private int endYear;

    public School(Resume resume, String schoolName, String schoolDepartment, int startYear, int endYear){
        this.resume = resume;
        this.schoolName = schoolName;
        this.schoolDepartment = schoolDepartment;
        this.startYear = startYear;
        this.endYear = endYear;
    }
}
