package debut.zsn.backend.services;

import debut.zsn.backend.dto.response.CurrencyToClientDTO;
import debut.zsn.backend.model.Currency;

import java.util.List;

public interface CurrencyService {
    boolean existCurrency(String name);
    boolean save(Currency currency);
    boolean save(List<Currency> currencies);
    List<CurrencyToClientDTO> getAllUndeletedCurrency();
    Currency getById(Long id);
}
