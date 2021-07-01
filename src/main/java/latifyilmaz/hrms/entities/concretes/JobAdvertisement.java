package latifyilmaz.hrms.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name="job_advertisements")
@AllArgsConstructor
@NoArgsConstructor
public class JobAdvertisement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id", nullable = false, unique = true)
    private int id;

    @Column(name="description",nullable=false, length = 1000)
    private String description;

    @ManyToOne()
    @JoinColumn(name = "city_id")
    private City city;

    @ManyToOne()
    @JoinColumn(name = "working_time_id")
    private WorkingTime workingTime;

    @ManyToOne()
    @JoinColumn(name = "position_id")
    private Position position;

    @ManyToOne()
    @JoinColumn(name = "employer_id")
    private Employer employer;

    @Column(name="release_date",nullable=false)
    private Date releaseDate;

    @Column(name="deadline",nullable=false)
    private Date deadline;

    @Column(name="min_salary",nullable=true)
    private int minSalary;

    @Column(name="max_salary",nullable=true)
    private int maxSalary;

    @Column(name="open_positions_amount",nullable=false)
    private int openPositionsAmount;

    @Column(name="active",nullable=false)
    private boolean active;

    @Column(name="confirmed",nullable=false)
    private boolean confirmed;

    public JobAdvertisement(String description, Date releaseDate, Date deadline, int minSalary, int maxSalary, int openPositionsAmount, boolean active, boolean confirmed) {
        this.description = description;
        this.releaseDate = releaseDate;
        this.deadline = deadline;
        this.minSalary = minSalary;
        this.maxSalary = maxSalary;
        this.openPositionsAmount = openPositionsAmount;
        this.active = active;
        this.confirmed = confirmed;
    }
}
