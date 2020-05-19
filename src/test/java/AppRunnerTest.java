import org.junit.Test;

/**
 * Created with IntelliJ IDEA.
 * User: yli1
 * Date: 5/16/2020
 * Time: 12:19 AM
 */
public class AppRunnerTest {

    @Test
    public void taxi_charge_acceptance_test() {
        String itineraryAsText = "1kilometers,waiting0minutes";
        TaxiItinerary taxiItinerary = new TaxiItinerary(itineraryAsText);
//        assertThat(taxiItinerary.charge(), Is.is(6));
    }
}
