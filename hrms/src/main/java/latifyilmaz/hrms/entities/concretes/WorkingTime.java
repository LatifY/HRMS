package latifyilmaz.hrms.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name="working_times")
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler", "jobAdvertisements"})
public class WorkingTime {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id", nullable = false, unique = true)
    private int id;

    @Column(name="working_time_name",nullable=false)
    private String workingTimeName;

    @OneToMany(mappedBy="workingTime",fetch = FetchType.LAZY)
    private List<JobAdvertisement> jobAdvertisements;

    public WorkingTime(String workingTimeName){
        this.workingTimeName = workingTimeName;
    }
}