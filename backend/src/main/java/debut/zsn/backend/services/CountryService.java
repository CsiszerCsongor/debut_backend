package debut.zsn.backend.services;

import debut.zsn.backend.model.Country;

import java.util.List;
import java.util.Optional;

public interface CountryService {
    List<Country> getAllUndeletedCountries();
    Optional<Country> getCountryById(Long id);
}
