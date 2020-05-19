import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created with IntelliJ IDEA.
 * User: yli1
 * Date: 5/16/2020
 * Time: 9:15 AM
 */
public class TaxiItinerary {

    private final List<TaxiCharge> taxiChargeList;

    public TaxiItinerary(String itineraryAsText) {
        taxiChargeList = Arrays.stream(itineraryAsText.split(","))
                .map(TaxiCharge::getInstance).collect(Collectors.toList());
    }

    public String charge() {
        Money money = new Money(0);
        for (TaxiCharge taxiCharge : taxiChargeList) {
            money = money.add(taxiCharge.charge());
        }
        return "charge" + money;
    }

    public int size() {
        return taxiChargeList.size();
    }

    public TaxiCharge get(int i) {
        return taxiChargeList.get(i);
    }
}
