import org.junit.Test;
import static org.junit.Assert.*;
//ChatGPT was used in the editing of the unit testing

public class MainTest {

    private int[][] salesData = {
            {300, 150, 700},
            {250, 200, 600}
    };

    @Test
    public void TotalSales_ReturnedTotalSales() {
        ProductSales ps = new ProductSales();
        int result = ps.TotalSales(salesData);
        assertEquals(2200, result);
    }

    @Test
    public void AverageSales_ReturnedAverageSales() {
        ProductSales ps = new ProductSales();
        double result = ps.AverageSales(salesData);
        assertEquals(366.66, result, 0.1);
    }
}