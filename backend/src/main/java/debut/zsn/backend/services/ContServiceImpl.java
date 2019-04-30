package debut.zsn.backend.services;

import debut.zsn.backend.dto.request.CreateContDTO;
import debut.zsn.backend.dto.response.ContToClient;
import debut.zsn.backend.dto.response.ResponseMessage;
import debut.zsn.backend.dto.response.ResponseMessageCont;
import debut.zsn.backend.model.Cont;
import debut.zsn.backend.model.Currency;
import debut.zsn.backend.model.User;
import debut.zsn.backend.repository.ContRepository;
import debut.zsn.backend.repository.CurrencyRepository;
import debut.zsn.backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Random;

@Service
public class ContServiceImpl implements ContService {
    @Autowired
    private ContRepository contRepository;

    @Autowired
    private CurrencyRepository currencyRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public boolean save(Cont cont) {
        return false;
    }

    @Override
    public ResponseEntity<?> save(CreateContDTO createContDTO) {
        Cont cont = new Cont();
        //kene tudjam az orszagot, hogy meg tudjam hatarozni az orszagkodot. Most a BT-rol masolom az orszagkodot
        String countryCode = "RO23";
        String bankCode = "FKBK"; //FaKeBanK
        Optional<Currency> currencyOptional = currencyRepository.findById(createContDTO.getCurrencyId());
        Currency currency;
        if(currencyOptional.isPresent()){
            currency = currencyOptional.get();
        }
        else{
            return new ResponseEntity<>(new ResponseMessageCont("Currency doesn't exist!!", null),
                    HttpStatus.BAD_REQUEST);
        }

        Optional<User> userOptional = userRepository.findByUsername(createContDTO.getUsername());
        User user;
        if(userOptional.isPresent()){
            user = userOptional.get();
        }
        else{
            return new ResponseEntity<>(new ResponseMessage("Username doesn't exist!!", null),
                    HttpStatus.BAD_REQUEST);
        }

        Optional<Cont> checkContAndUser = contRepository.findByUserAndCurrencyAndIsDeletedFalse(user, currency);

        if(checkContAndUser.isPresent()){
            return new ResponseEntity<>(new ResponseMessage("The user already own cont with this currency!", null),
                    HttpStatus.BAD_REQUEST);
        }

        Random rand = new Random();
        Integer firstPart = rand.nextInt(9999999) + 1000000;
        Integer secondPart = rand.nextInt(999999) + 100000;



        cont.setName(countryCode + bankCode + currency.getName() + firstPart.toString() + secondPart.toString());
        cont.setUser(user);
        cont.setCurrency(currency);
        cont.setSum(0);
        if(currency.getName().equals("EURO"))
            cont.setMaxValue(100000);
        if(currency.getName().equals("RON"))
            cont.setMaxValue(450000);
        if(currency.getName().equals("HUF"))
            cont.setMaxValue(31000000);
        if(currency.getName().equals("BOB"))
            cont.setMaxValue(771000);
        if(currency.getName().equals("BRL"))
            cont.setMaxValue(439000);

        cont = contRepository.save(cont);

        ContToClient contToClient = new ContToClient(cont, currency);

        return new ResponseEntity<>(new ResponseMessageCont("Cont saved successful!", contToClient),
                HttpStatus.OK);
    }


}
