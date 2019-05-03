package debut.zsn.backend.repository;

import debut.zsn.backend.model.Cont;
import debut.zsn.backend.model.Currency;
import debut.zsn.backend.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ContRepository extends JpaRepository<Cont, Long> {
    Cont[] findAllByUserAndIsDeletedFalse(User user);
    Optional<Cont> findByUserAndCurrencyAndIsDeletedFalse(User user, Currency currency);
    Optional<Cont> findByUserAndName(User user, String name);
}
