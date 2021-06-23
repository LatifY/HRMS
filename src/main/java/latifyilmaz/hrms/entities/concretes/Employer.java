package latifyilmaz.hrms.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@Table(name="employers")
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties
public class Employer{
    @Id
    @Column(name = "user_id", nullable = false)
    private int userId;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="user_id")
    private User user;

    @Column(name="company_name", nullable = false)
    private String companyName;

    @Column(name="website", nullable = false, unique = true)
    private String website;

    @Column(name="phone", nullable = false, unique = true)
    private String phone;

    @Column(name="verified_by_system", nullable = false)
    private boolean verifiedBySystem;

    public Employer(int userId, String companyName, String website, String phone, boolean verifiedBySystem) {
        this.userId = userId;
        this.companyName = companyName;
        this.website = website;
        this.phone = phone;
        this.verifiedBySystem = verifiedBySystem;
    }
}
