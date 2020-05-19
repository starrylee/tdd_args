/**
 * Created with IntelliJ IDEA.
 * User: yli1
 * Date: 5/16/2020
 * Time: 9:19 AM
 */
public class TaxiDistanceCharge extends TaxiCharge {

    public TaxiDistanceCharge(int value, String unit) {
        super(value, unit);
    }


    public Money charge() {
        if (value() > 2) {
            double chargeWhenOverTwoKilometers = 6 + (value() - 2) * 0.8;
            return value() > 8 ? new Money(chargeWhenOverTwoKilometers + (value() - 8) * 0.8 * 0.5) : new Money(chargeWhenOverTwoKilometers);
        }
        return new Money(6);
    }
}
