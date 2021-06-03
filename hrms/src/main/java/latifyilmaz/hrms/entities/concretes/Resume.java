package latifyilmaz.hrms.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
    private Employee employee;

    @Column(name = "github_url")
    private String githubUrl;

    @Column(name = "linkedin_url")
    private String linkedinUrl;

    @Column(name = "description")
    private String description;



    @OneToMany(mappedBy = "resume")
    private List<Ability> abilities;

    @OneToMany(mappedBy = "resume")
    private List<Image> images;

    @OneToMany(mappedBy = "resume")
    private List<School> schools;

    @OneToMany(mappedBy = "resume")
    private List<JobExperience> jobExperiences;

    @OneToMany(mappedBy = "resume")
    private List<Language> languages;


    public Resume(Employee employee, String githubUrl, String linkedinUrl, String description, List<Ability> abilities, List<Image> images, List<School> schools, List<JobExperience> jobExperiences, List<Language> languages) {
        this.employee = employee;
        this.githubUrl = githubUrl;
        this.linkedinUrl = linkedinUrl;
        this.description = description;
        this.abilities = abilities;
        this.images = images;
        this.schools = schools;
        this.jobExperiences = jobExperiences;
        this.languages = languages;
    }
}
