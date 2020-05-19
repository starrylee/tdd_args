import org.junit.Test;

/**
 * Created with IntelliJ IDEA.
 * User: yli1
 * Date: 5/16/2020
 * Time: 10:14 PM
 */
public class TaxiChargeTest {

    @Test(expected = NotImplementedException.class)
    public void should_throw_exception_when_call_charge_method() {
        new TaxiCharge(1, "kilometers").charge();
    }
}