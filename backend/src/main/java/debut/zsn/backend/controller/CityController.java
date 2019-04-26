package debut.zsn.backend.controller;

import debut.zsn.backend.dto.response.CityToClientDTO;
import debut.zsn.backend.model.City;
import debut.zsn.backend.model.Country;
import debut.zsn.backend.services.CityServiceImpl;
import debut.zsn.backend.services.CountryServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/city")
public class CityController {

    @Autowired
    private CityServiceImpl cityService;

    @Autowired
    private CountryServiceImpl countryService;

    @GetMapping("/getAllFromCountry/{id}")
    public List<CityToClientDTO> getAllCitiesFromCountry(@PathVariable Long id){
        Optional<Country> country = countryService.getCountryById(id);
        if(country.isPresent()){
            List<City> cities = cityService.getAllUndeletedCity(country.get());
            CityToClientDTO converter = new CityToClientDTO();
            List<CityToClientDTO> citiesDTO = converter.changeCityListToCityDTO(cities);
            return citiesDTO;
        }
        return null;
    }

}
