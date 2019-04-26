package debut.zsn.backend.model;

import javax.persistence.*;

@Entity
@Table(name="conts")
public class Cont extends BaseEntity{
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name="user_id", nullable = false)
    private User user;
    private float sum;
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name="currency_id", nullable = false)
    private Currency currency;
    private float maxValue;         //maximum value what cont can contain

    public Cont(){}

    public Cont(User user, float sum, Currency currency, float maxValue){
        this.user = user;
        this.sum = sum;
        this.currency = currency;
        this.maxValue = maxValue;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public float getSum() {
        return sum;
    }

    public void setSum(float sum) {
        this.sum = sum;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    public float getMaxValue() {
        return maxValue;
    }

    public void setMaxValue(float maxValue) {
        this.maxValue = maxValue;
    }
}
