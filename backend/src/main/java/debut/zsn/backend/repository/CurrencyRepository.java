package debut.zsn.backend.repository;

import debut.zsn.backend.model.Currency;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CurrencyRepository extends JpaRepository<Currency, Long> {
    List<Currency> findAllByIsDeletedFalse();
    Optional<Currency> findById(Long id);
}
