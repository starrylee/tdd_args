/**
 * Created with IntelliJ IDEA.
 * User: yli1
 * Date: 5/16/2020
 * Time: 9:31 AM
 */
public class TaxiTimeCharge extends TaxiCharge {

    private static final double RATIO = 0.25;

    public TaxiTimeCharge(int value, String unit) {
        super(value, unit);
    }

    public Money charge() {
        return new Money(value() * RATIO);
    }
}
