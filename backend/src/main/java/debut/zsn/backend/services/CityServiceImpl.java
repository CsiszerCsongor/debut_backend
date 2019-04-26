package debut.zsn.backend.services;

import debut.zsn.backend.model.City;
import debut.zsn.backend.model.Country;
import debut.zsn.backend.repository.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityServiceImpl implements CityService{
    @Autowired
    private CityRepository cityRepository;

    @Override
    public List<City> getAllUndeletedCity(Country country) {
        return cityRepository.findByIsDeletedFalseAndCountry(country);
    }
}
