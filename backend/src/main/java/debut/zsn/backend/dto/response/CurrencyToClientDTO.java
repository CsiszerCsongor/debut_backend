package debut.zsn.backend.dto.response;

import debut.zsn.backend.model.Currency;

import java.util.ArrayList;
import java.util.List;

public class CurrencyToClientDTO {
    private Long id;
    private String name;

    public CurrencyToClientDTO(){}

    public CurrencyToClientDTO(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public CurrencyToClientDTO(Currency currency){
        this.id = currency.getId();
        this.name = currency.getName();
    }

    public List<CurrencyToClientDTO> currencyListToCurrencyToClientDTO(List<Currency> curencies){
        List<CurrencyToClientDTO> tmpList = new ArrayList<>();

        for(int i = 0; i < curencies.size(); ++i){
            tmpList.add(new CurrencyToClientDTO(curencies.get(i)));
        }

        return tmpList;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
