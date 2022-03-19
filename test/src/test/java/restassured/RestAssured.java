package restassured;

import org.junit.Test;
import static com.google.common.truth.Truth.assertThat;

public class RestAssured {
    @Test
    public void Test_this() {
        assertThat("bing").isEqualTo("bing");
    }

    @Test
    public void Test_this2() {
        assertThat("bing").isEqualTo("bing");
    }
}
