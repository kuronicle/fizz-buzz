package net.kuronicle;

import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.*;

import org.junit.Test;
import junitx.util.PrivateAccessor;

public class FizzBuzzTest {

    @Test
    public void convertFizzBuzzメソッドで引数が正の整数の場合に数値をFizzBuzzに変換する() throws Throwable {
        Class<?>[] paramClasses = { int.class };

        for (int i = 1; i <= 100; i++) {
            Object[] params = { i };
            String actual = (String) PrivateAccessor.invoke(FizzBuzz.class,
                    "convertFizzBuzz", paramClasses, params);

            if (i % (3 * 5) == 0) {
                assertThat(actual, is("FizzBuzz"));
            } else if (i % 3 == 0) {
                assertThat(actual, is("Fizz"));
            } else if (i % 5 == 0) {
                assertThat(actual, is("Buzz"));
            } else {
                assertThat(actual, is("" + i));
            }
        }
    }
    
    @Test(expected=IllegalArgumentException.class)
    public void convertFizzBuzzメソッドで引数が0以下の場合にIllegalArgumentExceptionを送出する() throws Throwable {
        Class<?>[] paramClasses = { int.class };
        Object[] params = { 0 };
        String actual = (String) PrivateAccessor.invoke(FizzBuzz.class, "convertFizzBuzz", paramClasses, params);
    }
}
