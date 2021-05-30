package latifyilmaz.hrms.entities.concretes;

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

    @Column(name="description",nullable=false)
    private String description;

    @ManyToOne(fetch = FetchType.LAZY, cascade={ CascadeType.PERSIST, CascadeType.MERGE })
    @JoinColumn(name="city_id")
    private City city;

    @ManyToOne(fetch = FetchType.LAZY, cascade={ CascadeType.PERSIST, CascadeType.MERGE })
    @JoinColumn(name="position_id")
    private Position position;

    @ManyToOne(fetch = FetchType.LAZY, cascade={ CascadeType.PERSIST, CascadeType.MERGE })
    @JoinColumn(name="employer_id")
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

    public JobAdvertisement(String description, Date releaseDate, Date deadline, int minSalary, int maxSalary, int openPositionsAmount, boolean active) {
        this.description = description;
        this.releaseDate = releaseDate;
        this.deadline = deadline;
        this.minSalary = minSalary;
        this.maxSalary = maxSalary;
        this.openPositionsAmount = openPositionsAmount;
        this.active = active;
    }
}
