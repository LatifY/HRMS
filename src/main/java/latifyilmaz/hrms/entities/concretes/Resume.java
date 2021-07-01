package latifyilmaz.hrms.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@EqualsAndHashCode(callSuper = false)
@Table(name="resumes")
@AllArgsConstructor
@NoArgsConstructor
public class Resume {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id", nullable = false, unique = true)
    private int id;

    @ManyToOne()
    @JoinColumn(name = "employee_id")
    @JsonIgnoreProperties
    private Employee employee;

    @Column(name = "github_url")
    private String githubUrl;

    @Column(name = "linkedin_url")
    private String linkedinUrl;

    @Column(name = "description", length = 1000)
    private String description;



    @OneToMany(mappedBy = "resume")
    @JsonIgnoreProperties
    private List<Ability> abilities;

    @OneToMany(mappedBy = "resume")
    @JsonIgnoreProperties
    private List<Image> images;

    @OneToMany(mappedBy = "resume")
    @JsonIgnoreProperties
    private List<School> schools;

    @OneToMany(mappedBy = "resume")
    @JsonIgnoreProperties
    private List<JobExperience> jobExperiences;

    @OneToMany(mappedBy = "resume")
    @JsonIgnoreProperties
    private List<Language> languages;


    public Resume(Employee employee, String githubUrl, String linkedinUrl, String description) {
        this.employee = employee;
        this.githubUrl = githubUrl;
        this.linkedinUrl = linkedinUrl;
        this.description = description;
    }
}
