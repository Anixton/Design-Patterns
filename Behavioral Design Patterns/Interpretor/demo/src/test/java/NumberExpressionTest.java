import implementation.NumberExpression;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import org.junit.jupiter.api.Test;

public class NumberExpressionTest {
    @Test
    public void testInterpret() {
        NumberExpression numberExpression = new NumberExpression(5);
        assertEquals(5, numberExpression.interpret());
    }
}
