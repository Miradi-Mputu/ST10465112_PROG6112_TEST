public class ProductSales implements IProductSales {

    private int[] sales;
    private final int SALES_LIMIT = 500;

    public ProductSales(int[] sales) {
        this.sales = sales;
    }

    @Override
    public int[][] GetProductsSales() {
        return new int[0][];
    }

    //total sales
    @Override
    public int GetTotalSales() {
        int total = 0;
        for (int sale : sales) {
            total += sale;
        }
        return total;
    }

    //average sales
    @Override
    public double GetAverageSales() {
        if (sales.length == 0) {
            return 0;
        }
        return (double) GetTotalSales() / sales.length;
    }

    //sales over limit
    @Override
    public int GetSalesOverLimit() {
        int count = 0;
        for (int sale : sales) {
            if (sale > SALES_LIMIT) {
                count++;
            }
        }
        return count;
    }

    //sales under limit
    @Override
    public int GetSalesUnderLimit() {
        int count = 0;
        for (int sale : sales) {
            if (sale <= SALES_LIMIT) {
                count++;
            }
        }
        return count;
    }

    //years processed
    @Override
    public int GetProductsProcessed() {
        return sales.length;
    }

    //formatted report
    public String getReport() {
        return "Total Sales: " + GetTotalSales() + "\n" +
                "Average Sales: " + GetAverageSales() + "\n" +
                "Sales over limit: " + GetSalesOverLimit() + "\n" +
                "Sales under limit: " + GetSalesUnderLimit() + "\n" +
                "Years Processed: " + GetProductsProcessed() + "\n";
    }
}