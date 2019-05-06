package debut.zsn.backend.services;

import debut.zsn.backend.model.Country;

import java.util.List;
import java.util.Optional;

public interface CountryService {
    boolean existCountry(String country);
    Country save(Country country);
    List<Country> save(List<Country> countries);
    List<Country> getAllUndeletedCountries();
    Optional<Country> getCountryById(Long id);
}
