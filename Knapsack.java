package midterm;
import java.util.Scanner;

public class Knapsack {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double weightLimit;
        do {
            System.out.print("Enter vehicle weight limit (1-15 kilos): ");
            while (!scanner.hasNextDouble()) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.next();
            }
            weightLimit = scanner.nextDouble();
            if (weightLimit < 1 || weightLimit > 15) {
                System.out.println("Weight limit must be between 1 and 15.");
            }
        } while (weightLimit < 1 || weightLimit > 15);

        System.out.println("\n----------------------------------");
        Object[][] productData = displayProductTable();

        System.out.println("\n-----------------------------------------------------------------------");
        System.out.print("Do you want to display all subsets? (Y/N): ");
        String displayChoice = scanner.next();
        if (displayChoice.equalsIgnoreCase("Y")) {
            displaySubsets(productData);
        }

        displayResult(productData, weightLimit);

        scanner.close();
    }

    public static Object[][] displayProductTable() {
        String[] columnNames = {"Product Name", "Weight/Box", "Amount"};
        Object[][] data = {
                {"Canned Goods", 5.0, 450.0},
                {"Cooking Oil", 3.0, 725.0},
                {"Noodles", 2.5, 375.0},
                {"Soap", 7.0, 500.0}
        };

        System.out.printf("%-15s%-13s%-10s%n", columnNames[0], columnNames[1], columnNames[2]);
        System.out.println("----------------------------------");

        for (Object[] row : data) {
            System.out.printf("%-18s%-10.1f%-10.1f%n", row[0], row[1], row[2]);
        }

        return data;
    }

    public static void displaySubsets(Object[][] productData) {
        System.out.println("\n-----------------------------------------------------------------------");
        System.out.println("Subset \t\t\t\t\t  Total Weight   Total Value");
        System.out.println("-----------------------------------------------------------------------");

        int elements = productData.length;
        int totalSubsets = 1 << elements;
        
        for (int size = 0; size <= elements; size++) {
        for (int i = 0; i < totalSubsets; i++) {
        	int count = Integer.bitCount(i);
 
        	if (count == size) {
            double totalWeight = 0;
            double totalValue = 0;
            StringBuilder subset = new StringBuilder();

            for (int j = 0; j < elements; j++) {
                if ((i & (1 << j)) > 0) {
                    subset.append(productData[j][0]);
                    if (subset.length() > 0 && subset.charAt(subset.length() - 1) != ',') {
                        subset.append(", ");
                    }
                    totalWeight += (double) productData[j][1];
                    totalValue += (double) productData[j][2];
                }
            }
            if (subset.length() > 0) {
                subset.deleteCharAt(subset.length() - 2);
            }
            System.out.printf("%-45s %-13.1f %-13.1f%n", subset.toString(), totalWeight, totalValue);
        	}
          }
       }
   }

    public static double[] knapsack(Object[][] productData, double capacity) {
        int n = productData.length;
        double[][] dp = new double[n + 1][(int) (capacity + 1)];
        boolean[][] selected = new boolean[n + 1][(int) (capacity + 1)];

        for (int i = 0; i <= n; i++) {
            for (int w = 0; w <= capacity; w++) {
                if (i == 0 || w == 0) {
                    dp[i][w] = 0;
                } else if ((double) productData[i - 1][1] <= w) {
                    double newValue = (double) productData[i - 1][2] + dp[i - 1][(int) (w - (double) productData[i - 1][1])];
                    if (newValue > dp[i - 1][w]) {
                        dp[i][w] = newValue;
                        selected[i][w] = true;
                    } else {
                        dp[i][w] = dp[i - 1][w];
                    }
                } else {
                    dp[i][w] = dp[i - 1][w];
                }
            }
        }

        double[] selectedIndices = new double[n];
        int index = n;
        int w = (int) capacity;
        int count = 0;
        while (index > 0 && w > 0) {
            if (selected[index][w]) {
                selectedIndices[count++] = index - 1;
                w -= (double) productData[index - 1][1];
            }
            index--;
        }
        if (count == 0) {
            return new double[]{-1};
        }
        double[] trimmedIndices = new double[count];
        for (int i = 0; i < count; i++) {
            trimmedIndices[i] = selectedIndices[i];
        }
        return trimmedIndices;
    }

    public static void displayResult(Object[][] productData, double weightLimit) {
        System.out.println("\n-----------------------------------------------------------------------");
        System.out.println("Subset with Greatest Value:");
        System.out.println("-----------------------------------------------------------------------");

        double[] selectedIndices = knapsack(productData, weightLimit);
        double totalWeight = 0;
        double totalValue = 0;
        StringBuilder subsetBuilder = new StringBuilder();
        for (double index : selectedIndices) {
            int i = (int) index;
            subsetBuilder.append(productData[i][0]).append(", ");
            totalWeight += (double) productData[i][1];
            totalValue += (double) productData[i][2];
        }
        if (subsetBuilder.length() > 0 && subsetBuilder.charAt(subsetBuilder.length() - 2) == ',') {
            subsetBuilder.deleteCharAt(subsetBuilder.length() - 2);
        }
        System.out.println(sortSubset(subsetBuilder.toString()));
        System.out.printf("Total Weight: %.1f%n", totalWeight);
        System.out.printf("Total Value: %.1f%n", totalValue);
    }

    public static String sortSubset(String subsetString) {
        String[] subsetArray = subsetString.split(", ");
        
        int n = subsetArray.length;
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (subsetArray[j].compareTo(subsetArray[minIndex]) < 0) {
                    minIndex = j;
                }
            }
            String temp = subsetArray[minIndex];
            subsetArray[minIndex] = subsetArray[i];
            subsetArray[i] = temp;
        }       
        return String.join(", ", subsetArray);
    }
}