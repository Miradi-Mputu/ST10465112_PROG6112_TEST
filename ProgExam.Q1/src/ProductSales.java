public class ProductSales implements IProduct{
    public int total = 0;
    @Override
    public int TotalSales(int[][] productSales) {

        for (int[] yearSales : productSales) {
            for (int sale : yearSales) {
                total += sale;
            }
        }
        return total;

    }

    @Override
        public double AverageSales(int[][] productSales) {
            int count = 0;
            for (int[] yearSales : productSales) {
                count += yearSales.length;
            }

            if (count == 0) {
                return 0.0;
            }
            return (double) total / count;
        }



    @Override
    public int MaxSales(int[][] productSales) {
        int max = Integer.MIN_VALUE;

        for (int[] yearSales : productSales) {
            for (int sale : yearSales) {
                if (sale > max) {
                    max = sale;
                }
            }
        }
        return max;
    }

    @Override
    public int MinSales(int[][] productSales) {
        int min = Integer.MAX_VALUE;

        for (int[] yearSales : productSales) {
            for (int sale : yearSales) {
                if (sale < min) {
                    min = sale;
                }
            }
        }
        return min;
    }
}





