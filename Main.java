import java.io.*;
import java.util.*;

public class Main {

    public static ArrayList<Integer> selectionSortInt(ArrayList<Integer> arr) {
        for (int i = 0; i < arr.size(); i++) {
            System.out.printf("\n---\nPass no: %d\n---\n", i + 1);
            System.out.println(arr + "\n");

            int minIdx = i;
            System.out.printf("Current Minimum: [%d] %d\n", minIdx, arr.get(minIdx));

            for (int j = i + 1; j < arr.size(); j++) {

                System.out.printf("Comparing [%d] %d with [%d] %d...\n", i, arr.get(i), j, arr.get(j));

                if (arr.get(j) < arr.get(minIdx)) {
                    minIdx = j;
                    System.out.printf("\nNew Minimum Detected...\n");
                    System.out.printf("Current Minimum: [%d] %d\n\n", minIdx, arr.get(minIdx));
                }
            }

            if (arr.get(i) != arr.get(minIdx)) {
                // swap
                System.out.printf("Swapping [%d] %d with [%d] %d...\n", i, arr.get(i), minIdx, arr.get(minIdx));
                int temp = arr.get(i);
                arr.set(i, arr.get(minIdx));
                arr.set(minIdx, temp);

                System.out.println(arr + "\n");
            }

        }
        return arr;
    }

    public static ArrayList<String> selectionSortStr(ArrayList<String> arr) {
        for (int i = 0; i < arr.size(); i++) {
            System.out.printf("\n---\nPass no: %d\n---\n", i + 1);
            System.out.println(arr + "\n");

            int minIdx = i;
            System.out.printf("Current Minimum: [%d] %s\n", minIdx, arr.get(minIdx));

            for (int j = i + 1; j < arr.size(); j++) {

                System.out.printf("Comparing [%d] %s with [%d] %s...\n", i, arr.get(i), j, arr.get(j));
                if (compareStr(arr.get(minIdx), arr.get(j)) == arr.get(j)) {
                    minIdx = j;
                }

            }

            if (arr.get(i) != arr.get(minIdx)) {
                // swap
                System.out.printf("\nSwapping [%d] %s with [%d] %s...\n", i, arr.get(i), minIdx, arr.get(minIdx));
                String temp = arr.get(i);
                arr.set(i, arr.get(minIdx));
                arr.set(minIdx, temp);

                System.out.println(arr + "\n");
            }

        }
        return arr;
    }

    public static String compareStr(String str1, String str2) {

        String min = str1;
        int size = str1.length();

        // compare lengths
        if (size > str2.length()) {
            size = str2.length();
            min = str2;
        }

        for (int i = 0; i < size; i++) {
            System.out.printf("Comparing [%d] (str1)%s with (str2)%s...\n", i, str1.toLowerCase().charAt(i),
                    str2.toLowerCase().charAt(i));

            if (str1.toLowerCase().charAt(i) > str2.toLowerCase().charAt(i)) {
                System.out.printf("\nNew Minimum Detected...\n");
                System.out.printf("Current Minimum: %s\n\n", str2);
                return str2;
            } else if ((str1.toLowerCase().charAt(i) < str2.toLowerCase().charAt(i))) {
                return str1;
            }
        }

        if (min == str2) {
            System.out.printf("\nNew Minimum Detected...\n");
            System.out.printf("Current Minimum: %s\n\n", str2);
        }
        return min;
    }

    public static void sortName() {
        Products temp = new Products();
        for (int i = 0; i < productsDA.getProductsList().size(); i++) {
            System.out.printf("\n---\nPass no: %d\n---\n", i + 1);
            productsDA.print();

            int minIdx = i;
            System.out.printf("Current Minimum: [%d] %s\n", minIdx, productsDA.getProductsList().get(minIdx).getName());

            for (int j = i + 1; j < productsDA.getProductsList().size(); j++) {

                System.out.printf("Comparing [%d] %s with [%d] %s...\n", i,
                        productsDA.getProductsList().get(i).getName(), j,
                        productsDA.getProductsList().get(j).getName());
                if (compareStr(productsDA.getProductsList().get(minIdx).getName(),
                        productsDA.getProductsList().get(j).getName()) == productsDA.getProductsList().get(j)
                                .getName()) {
                    minIdx = j;
                }

            }

            if (productsDA.getProductsList().get(i).getName() != productsDA.getProductsList().get(minIdx).getName()) {
                // swap
                System.out.printf("\nSwapping [%d] %s with [%d] %s...\n", i,
                        productsDA.getProductsList().get(i).getName(), minIdx,
                        productsDA.getProductsList().get(minIdx).getName());
                temp = productsDA.getProductsList().get(i);
                productsDA.getProductsList().set(i, productsDA.getProductsList().get(minIdx));
                productsDA.getProductsList().set(minIdx, temp);
            }
        }
        System.out.println("\nSorted by Name:\n");
        productsDA.print();
    }

    public static void sortWeight() {
        Products temp = new Products();
        for (int i = 0; i < productsDA.getProductsList().size(); i++) {
            System.out.printf("\n---\nPass no: %d\n---\n", i + 1);
            productsDA.print();

            int minIdx = i;
            System.out.printf("Current Minimum: [%d] %f\n", minIdx,
                    productsDA.getProductsList().get(minIdx).getWeight());

            for (int j = i + 1; j < productsDA.getProductsList().size(); j++) {

                System.out.printf("Comparing [%d] %f with [%d] %f...\n", i,
                        productsDA.getProductsList().get(i).getWeight(), j,
                        productsDA.getProductsList().get(j).getWeight());

                if (productsDA.getProductsList().get(j).getWeight() < productsDA.getProductsList().get(minIdx)
                        .getWeight()) {
                    minIdx = j;
                    System.out.printf("\nNew Minimum Detected...\n");
                    System.out.printf("Current Minimum: [%d] %f\n\n", minIdx,
                            productsDA.getProductsList().get(minIdx).getWeight());
                }
            }

            if (productsDA.getProductsList().get(i).getWeight() != productsDA.getProductsList().get(minIdx)
                    .getWeight()) {
                // swap
                System.out.printf("\nSwapping [%d] %f with [%d] %f...\n", i,
                        productsDA.getProductsList().get(i).getWeight(), minIdx,
                        productsDA.getProductsList().get(minIdx).getWeight());

                temp = productsDA.getProductsList().get(i);
                productsDA.getProductsList().set(i, productsDA.getProductsList().get(minIdx));
                productsDA.getProductsList().set(minIdx, temp);
            }
        }
        System.out.println("\nSorted by Weight:\n");
        productsDA.print();
    }

    public static void sortAmount() {
        Products temp = new Products();
        for (int i = 0; i < productsDA.getProductsList().size(); i++) {
            System.out.printf("\n---\nPass no: %d\n---\n", i + 1);
            productsDA.print();

            int minIdx = i;
            System.out.printf("Current Minimum: [%d] %f\n", minIdx,
                    productsDA.getProductsList().get(minIdx).getAmount());

            for (int j = i + 1; j < productsDA.getProductsList().size(); j++) {

                System.out.printf("Comparing [%d] %f with [%d] %f...\n", i,
                        productsDA.getProductsList().get(i).getAmount(), j,
                        productsDA.getProductsList().get(j).getAmount());

                if (productsDA.getProductsList().get(j).getAmount() < productsDA.getProductsList().get(minIdx)
                        .getAmount()) {
                    minIdx = j;
                    System.out.printf("\nNew Minimum Detected...\n");
                    System.out.printf("Current Minimum: [%d] %f\n\n", minIdx,
                            productsDA.getProductsList().get(minIdx).getAmount());
                }
            }

            if (productsDA.getProductsList().get(i).getAmount() != productsDA.getProductsList().get(minIdx)
                    .getAmount()) {
                // swap
                System.out.printf("\nSwapping [%d] %f with [%d] %f...\n", i,
                        productsDA.getProductsList().get(i).getAmount(), minIdx,
                        productsDA.getProductsList().get(minIdx).getAmount());

                temp = productsDA.getProductsList().get(i);
                productsDA.getProductsList().set(i, productsDA.getProductsList().get(minIdx));
                productsDA.getProductsList().set(minIdx, temp);
            }
        }
        System.out.println("\nSorted by Amount:\n");
        productsDA.print();
    }

    static ProductsDA productsDA;

    public static void main(String[] args) throws FileNotFoundException {
        productsDA = new ProductsDA();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("\n\n[1] Name [2] Weight [3] Amount\nSort with: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    sortName();
                    break;
                case 2:
                    sortWeight();
                    break;
                case 3:
                    sortAmount();
                    break;

                default:
                    break;
            }
        }
    }
}
