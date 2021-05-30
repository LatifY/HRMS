package latifyilmaz.hrms.entities.concretes;

import latifyilmaz.hrms.entities.abstracts.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@Table(name="employers")
@AllArgsConstructor
@NoArgsConstructor
@PrimaryKeyJoinColumn(name = "user_id")
public class Employer extends User {
    @Column(name="company_name", nullable = false)
    private String companyName;

    @Column(name="website", nullable = false, unique = true)
    private String website;

    @Column(name="phone", nullable = false, unique = true)
    private String phone;

    @Column(name="verified_by_system", nullable = false)
    private boolean verifiedBySystem;

    public Employer(String email, String password, boolean verified, String companyName, String website, String phone, boolean verifiedBySystem) {
        super(email, password, verified);
        this.companyName = companyName;
        this.website = website;
        this.phone = phone;
        this.verifiedBySystem = verifiedBySystem;
    }
}
