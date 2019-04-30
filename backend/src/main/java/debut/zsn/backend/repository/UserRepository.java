package debut.zsn.backend.repository;

import debut.zsn.backend.model.Cont;
import debut.zsn.backend.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);
    Boolean existsByUsername(String username);
    Boolean existsByEmail(String email);
    Boolean existsByTelephone(String telephone);
    Boolean existsByCnp(String cnp);
    Optional<User> findByCnp(String cnp);
}
