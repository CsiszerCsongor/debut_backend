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
