package debut.zsn.backend.dto.response;

import debut.zsn.backend.model.Cont;
import debut.zsn.backend.model.Currency;

public class ContToClient {
    private Long id;
    private String name;
    private float sum;
    private Long currencyId;
    private String currency;
    private float maxValue;

    public ContToClient() {}

    public ContToClient(Long id, String name, float sum, Long currencyId, String currency, float maxValue) {
        this.id = id;
        this.name = name;
        this.sum = sum;
        this.currencyId = currencyId;
        this.currency = currency;
        this.maxValue = maxValue;
    }

    public ContToClient(Cont cont, Currency currency){
        this.id = cont.getId();
        this.name = cont.getName();
        this.sum = cont.getSum();
        this.maxValue = cont.getMaxValue();
        this.currencyId = currency.getId();
        this.currency = currency.getName();
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

    public float getSum() {
        return sum;
    }

    public void setSum(float sum) {
        this.sum = sum;
    }

    public Long getCurrencyId() {
        return currencyId;
    }

    public void setCurrencyId(Long currencyId) {
        this.currencyId = currencyId;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public float getMaxValue() {
        return maxValue;
    }

    public void setMaxValue(float maxValue) {
        this.maxValue = maxValue;
    }
}
