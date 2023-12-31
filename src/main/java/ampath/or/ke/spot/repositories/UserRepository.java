package ampath.or.ke.spot.repositories;

import ampath.or.ke.spot.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("userRepository")
public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);
    User findByUsernameAndPassword(String username,String password);
    User findByUsername(String username);
    User findById(int uid);
    User findByUuid(String uuid);
    List<User> findByStatus(int active);
    User findByEmailAndPassword(String email,String password);
    User findByEmailOrUsername(String email,String username);
    List<User> findAll();
}
