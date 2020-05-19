import org.hamcrest.core.Is;
import org.junit.Test;

import static org.junit.Assert.assertThat;

/**
 * Created with IntelliJ IDEA.
 * User: yli1
 * Date: 5/16/2020
 * Time: 5:04 PM
 */
public class MoneyTest {

    @Test
    public void should_return_yuan_for_money() {
        assertThat(new Money(1).toString(), Is.is("1yuan"));
        assertThat(new Money(1.4).toString(), Is.is("1yuan"));
        assertThat(new Money(1.5).toString(), Is.is("2yuan"));
    }

    @Test
    public void should_add_money() {
        assertThat(new Money(1).add(new Money(2)), Is.is(new Money(3)));
        assertThat(new Money(1.1).add(new Money(1.2)), Is.is(new Money(2.3)));
    }

    @Test
    public void should_be_equal_when_two_money_object_have_the_same_raw_amount() {
        Money money1 = new Money(1);
        Money money2 = new Money(2);
        assertThat(money1.equals(money1), Is.is(true));
        assertThat(money1.equals(money2), Is.is(false));
        assertThat(money1.hashCode() == money1.hashCode(), Is.is(true));
    }

    @Test
    public void should_not_be_equal_if_the_object_is_not_money() {
        Money money = new Money(1);
        assertThat(money.equals(null), Is.is(false));
        assertThat(money.equals(new Object()), Is.is(false));
    }
}