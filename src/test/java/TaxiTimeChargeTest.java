import org.hamcrest.core.Is;
import org.junit.Test;

import static org.junit.Assert.assertThat;

/**
 * Created with IntelliJ IDEA.
 * User: yli1
 * Date: 5/16/2020
 * Time: 9:32 AM
 */
public class TaxiTimeChargeTest {
    @Test
    public void should_create_taxi_time_out_of_text() {
        TaxiCharge taxiTime = TaxiCharge.getInstance("waiting0minutes");
        assertThat(taxiTime.value(), Is.is(0));
        assertThat(taxiTime.unit(), Is.is("minutes"));

        TaxiCharge taxiTimeCase2 = TaxiCharge.getInstance("waiting5minutes");
        assertThat(taxiTimeCase2.value(), Is.is(5));
        assertThat(taxiTimeCase2.unit(), Is.is("minutes"));
    }

    @Test
    public void should_charge_for_waiting_time() {
        TaxiCharge taxiTime = TaxiCharge.getInstance("waiting4minutes");
        assertThat(taxiTime.charge(), Is.is(new Money(1)));

        TaxiCharge taxiTimeCase2 = TaxiCharge.getInstance("waiting10minutes");
        assertThat(taxiTimeCase2.charge(), Is.is(new Money(2.5)));

    }

    @Test(expected = UnsupportedFormatException.class)
    public void should_throw_exception_when_format_is_not_correct() {
        TaxiCharge.getInstance("waiting4seconds");
    }
}