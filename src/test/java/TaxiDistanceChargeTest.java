import org.hamcrest.core.Is;
import org.junit.Test;

import static org.junit.Assert.assertThat;

/**
 * Created with IntelliJ IDEA.
 * User: yli1
 * Date: 5/16/2020
 * Time: 9:19 AM
 */
public class TaxiDistanceChargeTest {
    @Test
    public void should_create_taxi_distance_out_of_text() {
        TaxiCharge taxiDistance = TaxiCharge.getInstance("1kilometers");
        assertThat(taxiDistance.value(), Is.is(1));
        assertThat(taxiDistance.unit(), Is.is("kilometers"));
    }

    @Test
    public void should_charge_6_if_distance_less_than_2_kilometers() {
        TaxiCharge taxiDistance = TaxiCharge.getInstance("2kilometers");
        assertThat(taxiDistance.charge(), Is.is(new Money(6)));
    }

    @Test
    public void should_extra_charge_when_longer_than_2_kilometers() {
        TaxiCharge taxiDistance = TaxiCharge.getInstance("3kilometers");
        assertThat(taxiDistance.charge(), Is.is(new Money(6.8)));
    }

    @Test
    public void should_extra_charge_50_percent_when_longer_than_8_kilometers() {
        TaxiCharge taxiDistance = TaxiCharge.getInstance("9kilometers");
        assertThat(taxiDistance.charge(), Is.is(new Money(12)));
    }

    @Test
    public void should_extra_charge_50_percent_when_longer_than_8_kilometers_2() {
        TaxiCharge taxiDistance = TaxiCharge.getInstance("10kilometers");
        assertThat(taxiDistance.charge(), Is.is(new Money(13.2)));
    }
}