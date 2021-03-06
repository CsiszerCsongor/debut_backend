package debut.zsn.backend.services;

import debut.zsn.backend.dto.request.SignUpDTO;
import debut.zsn.backend.dto.request.UpdateDataDTO;
import debut.zsn.backend.dto.response.ContToClient;
import debut.zsn.backend.dto.response.ResponseMessage;
import debut.zsn.backend.dto.response.UserToAdmin;
import debut.zsn.backend.model.*;
import debut.zsn.backend.model.Currency;
import debut.zsn.backend.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UserServiceImpl implements UserService {
    Random rand = new Random();

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private StreetServiceImpl streetService;

    @Autowired
    private CityRepository cityRepository;

    @Autowired
    private ContRepository contRepository;

    @Autowired
    private PasswordEncoder encoder;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private CurrencyServiceImpl currencyService;

    @Autowired
    private CountryServiceImpl countryService;

    @Override
    public User save() {
        return null;
    }

    @Override
    public User save(User item) {
        item.setUsername(item.getFirstName().substring(0,1) + item.getLastName().substring(0,1) + (rand.nextInt(899999) + 100000));
        return userRepository.save(item);
    }

    @Override
    public ResponseEntity<?> save(SignUpDTO item){
        if (userRepository.existsByEmail(item.getEmail())) {
            return new ResponseEntity<>(new ResponseMessage("Fail -> Email is already in use!", null),
                    HttpStatus.BAD_REQUEST);
        }
        Currency currency = currencyService.getById(item.getCurrency());

        if(currency == null){
            return new ResponseEntity<>(new ResponseMessage("Fail -> Wrong information!", null),
                    HttpStatus.BAD_REQUEST);
        }

        String username = item.getFirstName().substring(0,1) + item.getLastName().substring(0,1) + (new Random().nextInt(899999) + 100000);
        while(userRepository.existsByUsername(username)){
            username = item.getFirstName().substring(0,1) + item.getLastName().substring(0,1) + (new Random().nextInt(899999) + 100000);
        }

        City city = cityRepository.findCityById(item.getCity());
        Street street = new Street();
        street.setCity(city);
        street.setName(item.getStreet());
        street = streetService.save(street);

        User user = new User(item.getFirstName(),item.getLastName(),street,item.getTelephone(),
                item.getCnp(), item.getSerie(), item.getCnpNr(), item.getHouseNumber(),
                item.getApartman(), username, item.getEmail(),
                encoder.encode(item.getPassword()));

        Set<String> strRoles = item.getRole();
        Set<Role> roles = new HashSet<>();

        strRoles.forEach(role -> {
            switch (role) {
                case "Admin":
                    Role adminRole = roleRepository.findByName(RoleName.ROLE_ADMIN)
                            .orElseThrow(() -> new RuntimeException("Fail! -> Cause: User Role not find."));
                    roles.add(adminRole);
                    break;
                default:
                    Role userRole = roleRepository.findByName(RoleName.ROLE_USER)
                            .orElseThrow(() -> new RuntimeException("Fail! -> Cause: User Role not find."));
                    roles.add(userRole);
            }
        });

        user.setRoles(roles);
        User savedUser = userRepository.save(user);
        if(savedUser == null){
            return new ResponseEntity<>(new ResponseMessage("User registered failed!", null), HttpStatus.BAD_REQUEST);
        }

        if(item.getRole().toArray()[0].equals("User")){
            Cont cont = new Cont(user, 0, currency, 1000000);
        }

        return new ResponseEntity<>(new ResponseMessage("User registered successfully!", savedUser), HttpStatus.OK);
    }

    @Override
    public Optional<User> findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public User getCity(Long index) {
        return userRepository.getOne(index);
    }

    @Override
    public User update(User item) {
        return userRepository.save(item);
    }

    @Override
    public void delete(User item) {
        item.setDeleted(true);
        userRepository.save(item);
    }

    @Override
    public List<User> getAll() {
        return null;
    }

    @Override
    public boolean checkTelephone(String telephone){
        if(telephone == null || telephone == ""){
            return false;
        }
        return userRepository.existsByTelephone(telephone);
    }

    @Override
    public boolean checkEmail(String email){
        if(email == null || email == ""){
            return false;
        }
        return userRepository.existsByEmail(email);
    }

    @Override
    public boolean checkCNP(String cnp){
        if(cnp == null || cnp == ""){
            return false;
        }
        return userRepository.existsByCnp(cnp);
    }

    @Override
    public Cont[] getUserConts(String username) {
        Optional<User> userOptional = userRepository.findByUsername(username);
        if(userOptional.isPresent()){
            contRepository.findAllByUserAndIsDeletedFalse(userOptional.get());
        }
        return null;

    }

    @Override
    public UserToAdmin getUserByCnp(String cnp) {
        UserToAdmin userToAdmin = new UserToAdmin();
        Optional<User> tmpUser = userRepository.findByCnp(cnp);

        if(!tmpUser.isPresent()){
            return null;
        }
        User user = tmpUser.get();

        userToAdmin.setFirstName(user.getFirstName());
        userToAdmin.setLastName(user.getLastName());

        userToAdmin.setStreet(user.getStreet().getName());
        userToAdmin.setTelephone(user.getTelephone());
        userToAdmin.setCnp(user.getCnp());
        userToAdmin.setSerie(user.getSerie());
        userToAdmin.setCnpNr(user.getCnpNr());
        userToAdmin.setHouseNumber(user.getHouseNumber());
        userToAdmin.setApartman(user.getApartman());
        userToAdmin.setUsername(user.getUsername());
        userToAdmin.setEmail(user.getEmail());

        Cont[] conts = contRepository.findAllByUserAndIsDeletedFalse(user);
        ContToClient[] contsToClient = new ContToClient[conts.length];

        if(conts.length != 0){
            for(int i = 0; i < conts.length; ++i){
                contsToClient[i] = new ContToClient(conts[i],conts[i].getCurrency());
            }
        }

        userToAdmin.setConts(contsToClient);

        return userToAdmin;
    }

    @Override
    public String updateUserFirstName(UpdateDataDTO updateData) {
        Optional<User> userOptional = userRepository.findByCnp(updateData.getUserCnp());

        if(userOptional.isPresent()){
            User user = userOptional.get();
            user.setFirstName(updateData.getDataString());
            User tmp = userRepository.save(user);
            if(tmp.getFirstName().equals(updateData.getDataString())){
                return "Success";
            }

            return "Failed";
        }

        return "Failed";
    }

    @Override
    public String getOwnCNP(String username) {
        Optional<User> userOptional = userRepository.findByUsername(username);
        if(userOptional.isPresent()){
            return userOptional.get().getCnp();
        }

        return "Failed";
    }
}
