package debut.zsn.backend.dbInitializers;

import debut.zsn.backend.dto.request.SignUpDTO;
import debut.zsn.backend.model.*;
import debut.zsn.backend.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@ConditionalOnProperty(name = "app.init-db", havingValue = "true")
public class mysqlInitializer implements CommandLineRunner {
    @Autowired
    private CurrencyServiceImpl currencyService;

    @Autowired
    private RoleServiceImpl roleService;

    @Autowired
    private CountryServiceImpl countryService;

    @Autowired CityServiceImpl cityService;

    private List<Country> countryList;

    @Override
    public void run(String... args) throws Exception {
        if(!saveCurrencies()){
            System.out.println("Can't save currencies into database! Maybe there are initial datas!");
        }
        if(!saveRoles()){
            System.out.println("Can't save roles into database! Maybe there are initial datas!");
        }
        if(!saveCountries()){
            System.out.println("Can't save countries into database! Maybe there are initial datas!");
        }
        if(!saveCities()){
            System.out.println("Can't save cities into database! Maybe there are initial datas!");
        }
    }

    private boolean saveCurrencies(){
        if(!currencyService.existCurrency("EURO")){         //ha nem letezik, akkor mentse el csak
            List<Currency> currencies = new ArrayList<>();
            currencies.add(new Currency("EURO"));
            currencies.add(new Currency("RON"));
            currencies.add(new Currency("HUF"));
            currencies.add(new Currency("BOB"));
            currencies.add(new Currency("BRL"));

            return currencyService.save(currencies);
        }
        return true;
    }

    private boolean saveRoles(){
        if(!roleService.existRoleName(RoleName.ROLE_ADMIN)){        //ha nem letezik, akkor mentse el csak a role-okat
            List<Role> roles = new ArrayList<>();
            roles.add(new Role(RoleName.ROLE_USER));
            roles.add(new Role(RoleName.ROLE_ADMIN));

            return roleService.save(roles);
        }
        return false;
    }

    private boolean saveCountries(){
        if(!countryService.existCountry("Romania")){
            List<Country> countries = new ArrayList<>();
            countries.add(new Country("Romania", false));
            countries.add(new Country("Hungary", false));
            countries.add(new Country("Brazil", false));
            countries.add(new Country("Belgium", false));
            countries.add(new Country("Bolivia", false));

            this.countryList = countryService.save(countries);

            if(this.countryList != null)
                return  true;
        }
        return false;
    }

    private boolean saveCities(){
        if(!cityService.existCity("Budapest")){
            List<City> cities = new ArrayList<>();

            // Romania
            cities.add(new City("Miercurea-Ciuc", countryList.get(0), false));
            cities.add(new City("Cluj-Napoca", countryList.get(0), false));
            cities.add(new City("Brasov", countryList.get(0), false));

            // Hungary
            cities.add(new City("Budapest", countryList.get(1), false));
            cities.add(new City("Debrecen", countryList.get(1), false));
            cities.add(new City("Pécs", countryList.get(1), false));

            // Brazil
            cities.add(new City("Rio de Janeiro", countryList.get(2), false));
            cities.add(new City("Salvador da Bahia", countryList.get(2), false));
            cities.add(new City("Recife", countryList.get(2), false));

            // Belgium
            cities.add(new City("Gent", countryList.get(3), false));
            cities.add(new City("Brugge", countryList.get(3), false));
            cities.add(new City("Leuwen", countryList.get(3), false));

            // Bolivia
            cities.add(new City("La Paz", countryList.get(4), false));
            cities.add(new City("El Alto", countryList.get(4), false));
            cities.add(new City("Tarija", countryList.get(4), false));

            return cityService.save(cities);
        }
        return false;
    }
}
