import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Objects;

/**
 * Created with IntelliJ IDEA.
 * User: yli1
 * Date: 5/16/2020
 * Time: 2:35 PM
 */
public class Money {
    private final BigDecimal rawAmount;
    public Money(double rawAmount) {
        this.rawAmount = new BigDecimal(rawAmount).setScale(2, RoundingMode.HALF_UP);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Money money = (Money) o;
        return Objects.equals(rawAmount, money.rawAmount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(rawAmount);
    }

    @Override
    public String toString() {
        return rawAmount.setScale(0, RoundingMode.HALF_UP) + "yuan";
    }

    public Money add(Money money) {
        return new Money(this.rawAmount.add(money.rawAmount).doubleValue());
    }
}
