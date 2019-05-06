package debut.zsn.backend.services;

import debut.zsn.backend.model.Country;
import debut.zsn.backend.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CountryServiceImpl implements CountryService {
    @Autowired
    private CountryRepository countryRepository;

    @Override
    public boolean existCountry(String country) {
        return countryRepository.existsByName(country);
    }

    @Override
    public Country save(Country country) {
        return countryRepository.save(country);
    }

    @Override
    public List<Country> save(List<Country> countries) {
        List<Country> tmpList = new ArrayList<>();

        for(int i = 0; i < countries.size(); ++i){
            Country tmp = countryRepository.save(countries.get(i));
            if(tmp == null)
                return null;
            tmpList.add(tmp);
        }
        return tmpList;
    }

    @Override
    public List<Country> getAllUndeletedCountries() {
        return countryRepository.findByIsDeletedFalse();
    }

    @Override
    public Optional<Country> getCountryById(Long id) {
        return countryRepository.findById(id);
    }
}
