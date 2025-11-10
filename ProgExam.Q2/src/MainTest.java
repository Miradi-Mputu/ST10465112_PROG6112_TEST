import org.junit.Test;
import static org.junit.Assert.*;
public class MainTest {
//ChatGPT was used in the editing of the unit testing
    @Test
    public void GetSalesOverLimit_ReturnsNumberOfSales() {
        int[] sampleSales = {200, 300, 700, 800, 150};
        ProductSales ps = new ProductSales(sampleSales);
        int result = ps.GetSalesOverLimit();
        assertEquals("Should return the number of sales above 500", 2, result);
    }

    @Test
    public void GetSalesUnderLimit_ReturnsNumberOfSales() {
        int[] sampleSales = {200, 300, 700, 800, 150};
        ProductSales ps = new ProductSales(sampleSales);
        int result = ps.GetSalesUnderLimit();
        assertEquals("Should return the number of sales under or equal to 500", 3, result);
    }
}