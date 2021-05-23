package latifyilmaz.hrms.entities.concretes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@Table(name="Employers")
@AllArgsConstructor
@NoArgsConstructor
public class Employer{
    @Id
    @Column(name="UserId", nullable = false)
    private int userId;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="UserId")
    private User user;

    @Column(name="CompanyName", nullable = false)
    private String companyName;

    @Column(name="Website", nullable = false)
    private String website;

    @Column(name="Phone", nullable = false)
    private String phone;

    @Column(name="VerifiedBySystem", nullable = false)
    private boolean verifiedBySystem;

    public Employer(int userId, String companyName, String website, String phone, boolean verifiedBySystem){
        this.userId = userId;
        this.companyName = companyName;
        this.website = website;
        this.phone = phone;
        this.verifiedBySystem = verifiedBySystem;
    }

}
