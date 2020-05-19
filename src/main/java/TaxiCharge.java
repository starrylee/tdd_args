import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaxiCharge {
    private static final String REGEX_DISTANCE = "(\\d+)(kilometers)";
    private static final String REGEX_TIME = "waiting(\\d+)(minutes)";
    private final Integer value;
    private final String unit;

    public TaxiCharge(Integer value, String unit) {
        this.value = value;
        this.unit = unit;
    }

    public static TaxiCharge getInstance(String taxiChargeAsText) {
        TaxiCharge taxiDistanceCharge = getInstance(taxiChargeAsText, REGEX_DISTANCE);
        if (taxiDistanceCharge != null) {
            return new TaxiDistanceCharge(taxiDistanceCharge.value, taxiDistanceCharge.unit);
        }
        TaxiCharge taxiTimeCharge = getInstance(taxiChargeAsText, REGEX_TIME);
        if (taxiTimeCharge != null) {
            return new TaxiTimeCharge(taxiTimeCharge.value, taxiTimeCharge.unit);
        }
        throw new UnsupportedFormatException(taxiChargeAsText);
    }

    private static TaxiCharge getInstance(String taxiChargeAsText, String regex) {
        Matcher matcher = Pattern.compile(regex).matcher(taxiChargeAsText);
        if (matcher.find()) {
            return new TaxiCharge(Integer.valueOf(matcher.group(1)), matcher.group(2));
        }
        return null;
    }

    public int value() {
        return value;
    }

    public String unit() {
        return unit;
    }

    public Money charge() {
        throw new NotImplementedException();
    }

}
