import org.hamcrest.core.Is;
import org.junit.Test;

import static org.junit.Assert.assertThat;

/**
 * Created with IntelliJ IDEA.
 * User: yli1
 * Date: 5/16/2020
 * Time: 9:27 AM
 */
public class TaxiItineraryTest {
    @Test
    public void should_create_taxi_itinerary_out_of_text() {
        TaxiItinerary taxiItinerary = new TaxiItinerary("1kilometers,waiting0minutes");
        assertThat(taxiItinerary.size(), Is.is(2));
        assertThat(taxiItinerary.get(0).value(), Is.is(1));
        assertThat(taxiItinerary.get(0).unit(), Is.is("kilometers"));
        assertThat(taxiItinerary.get(1).value(), Is.is(0));
        assertThat(taxiItinerary.get(1).unit(), Is.is("minutes"));
    }


    @Test
    public void should_retrieve_total_charge_for_the_trip() {
        TaxiItinerary taxiItinerary = new TaxiItinerary("1kilometers,waiting0minutes");
        assertThat(taxiItinerary.charge(), Is.is("charge6yuan"));

        TaxiItinerary taxiItinerary2 = new TaxiItinerary("3kilometers,waiting0minutes");
        assertThat(taxiItinerary2.charge(), Is.is("charge7yuan"));

        TaxiItinerary taxiItinerary3 = new TaxiItinerary("10kilometers,waiting0minutes");
        assertThat(taxiItinerary3.charge(), Is.is("charge13yuan"));

        TaxiItinerary taxiItinerary4 = new TaxiItinerary("2kilometers,waiting3minutes");
        assertThat(taxiItinerary4.charge(), Is.is("charge7yuan"));

    }
}