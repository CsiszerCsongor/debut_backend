package debut.zsn.backend.controller;

import debut.zsn.backend.dto.response.CountryFromClientDTO;
import debut.zsn.backend.model.Country;
import debut.zsn.backend.services.CountryService;
import debut.zsn.backend.services.CountryServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/country")
public class CountryController {
    @Autowired
    private CountryServiceImpl countryService;

    @GetMapping("/getAll")
    public List<CountryFromClientDTO> getAllUndeletedCountries(){
        return new CountryFromClientDTO().changeCountriesToDTO(countryService.getAllUndeletedCountries());
    }
}
