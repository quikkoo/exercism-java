package quikkoo.exercism;

import org.junit.Test;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;

public class HelloWorldTest {

    @Test
    public void testWithoutName() {
        assertThat(HelloWorld.greet(), is("Hello, World!"));
    }

    @Test
    public void testWithEmptyName() {
        assertThat(HelloWorld.greet(""), is("Hello, !"));
    }

    @Test
    public void testWithNameAlice() {
        assertThat(HelloWorld.greet("Alice"), is("Hello, Alice!"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testWitNullName() {
        HelloWorld.greet(null);
        fail();
    }
}
