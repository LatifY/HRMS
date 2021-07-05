package latifyilmaz.hrms.dataAccess.abstracts;

import latifyilmaz.hrms.entities.concretes.User;
import latifyilmaz.hrms.entities.dtos.user.UserUpdatePasswordDto;
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

    @Transactional
    @Modifying
    @Query("update User u set u.email=:email where u.id=:id")
    void updateEmail(int id, String email);

    @Transactional
    @Modifying
    @Query("update User u set u.password=(:#{#dto.newPassword}) where u.id=(:#{#dto.id})")
    void updatePassword(UserUpdatePasswordDto dto);
}
