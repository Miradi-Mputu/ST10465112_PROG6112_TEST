import java.text.DecimalFormat;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

                int[][] salesData = {
                        {300, 150, 700},
                        {250, 200, 600}
                };

                ProductSales salesCalculator = new ProductSales();

                int totalSales = salesCalculator.TotalSales(salesData);
                double averageSales = salesCalculator.AverageSales(salesData);
                int maxSale = salesCalculator. MaxSales(salesData);
                int minSale = salesCalculator. MinSales(salesData);


        System.out.println("---------------------------------------------");
        System.out.println("PRODUCT SALES REPORT - 2026");
        System.out.println("----------------------------------------");
        System.out.printf("Total sales:  %12d%n", totalSales);
        System.out.printf("Average sales: %11s%n",averageSales);
        System.out.printf("Maximum sale:  %12d%n", maxSale);
        System.out.printf("Minimum sale:  %12d%n", minSale);
        System.out.println("-------------------------------------------");
    }
        }


