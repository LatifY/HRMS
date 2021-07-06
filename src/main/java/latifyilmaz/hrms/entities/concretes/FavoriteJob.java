package latifyilmaz.hrms.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@Table(name="favorite_jobs")
@AllArgsConstructor
@NoArgsConstructor
public class FavoriteJob {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id", nullable = false, unique = true)
    private int id;

    @ManyToOne(targetEntity = User.class, fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    @JsonIgnore
    private User user;

    @ManyToOne(targetEntity = JobAdvertisement.class, fetch = FetchType.EAGER)
    @JoinColumn(name = "job_advertisement_id")
    @JsonIgnore
    private JobAdvertisement jobAdvertisement;

    public FavoriteJob(User user, JobAdvertisement jobAdvertisement) {
        this.user = user;
        this.jobAdvertisement = jobAdvertisement;
    }
}
