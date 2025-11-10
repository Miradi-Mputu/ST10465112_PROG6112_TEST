public interface IProductSales {
    int[][] GetProductsSales();
    int GetTotalSales();
    double GetAverageSales();
    int GetSalesOverLimit();
    int GetSalesUnderLimit();
    int GetProductsProcessed();
}
