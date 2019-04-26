package debut.zsn.backend.controller;

import debut.zsn.backend.dto.response.CurrencyToClientDTO;
import debut.zsn.backend.model.Currency;
import debut.zsn.backend.services.CurrencyServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/currency")
public class CurrencyController {

    @Autowired
    private CurrencyServiceImpl currencyService;

    @GetMapping("/getAll")
    public List<CurrencyToClientDTO> getAllCurrency(){
        return currencyService.getAllUndeletedCurrency();
    }
}
