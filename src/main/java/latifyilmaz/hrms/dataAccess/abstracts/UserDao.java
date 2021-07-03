package latifyilmaz.hrms.dataAccess.abstracts;

import latifyilmaz.hrms.entities.concretes.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface UserDao extends JpaRepository<User, Integer> {
    User getByEmail(String email);
    User getByEmailAndPassword(String email, String password);

    @Transactional
    @Modifying
    @Query("update User u set u.verified=:verified where u.id=:id")
    void updateVerifiedById(boolean verified, int id);

    @Transactional
    @Modifying
    @Query("update User u set u.verified=:verified where u.email=:email")
    void updateVerifiedByEmail(boolean verified, String email);
}
