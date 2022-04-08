package line2.line2_back2.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import line2.line2_back2.user.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByLoginNameAndPassword(String loginName, String passwrod);
}
