package debut.zsn.backend.services;

import debut.zsn.backend.dto.response.CurrencyToClientDTO;
import debut.zsn.backend.model.Currency;
import debut.zsn.backend.repository.CurrencyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CurrencyServiceImpl implements CurrencyService {
    @Autowired
    private CurrencyRepository currencyRepository;

    @Override
    public boolean existCurrency(String name) {
        return currencyRepository.existsByName(name);
    }

    @Override
    public boolean save(Currency currency) {
        Currency tmp = currencyRepository.save(currency);
        if(tmp != null)
            return true;
        return false;
    }

    @Override
    public boolean save(List<Currency> currencies) {
        for(int i = 0; i < currencies.size(); ++i){
            Currency tmp = currencyRepository.save(currencies.get(i));
            if(tmp == null){
                return false;
            }
        }
        return true;
    }

    @Override
    public List<CurrencyToClientDTO> getAllUndeletedCurrency() {
        List<Currency> currencies = currencyRepository.findAllByIsDeletedFalse();
        return new CurrencyToClientDTO().currencyListToCurrencyToClientDTO(currencyRepository.findAll());
    }

    @Override
    public Currency getById(Long id) {
        Optional<Currency> tmp = currencyRepository.findById(id);
        if(tmp.isPresent()){
            return tmp.get();
        }

        return null;
    }
}
