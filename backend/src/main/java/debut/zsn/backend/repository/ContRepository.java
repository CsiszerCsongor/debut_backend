package debut.zsn.backend.repository;

import debut.zsn.backend.model.Cont;
import debut.zsn.backend.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContRepository extends JpaRepository<Cont, Long> {
    Cont[] findAllByUser(User user);
}
