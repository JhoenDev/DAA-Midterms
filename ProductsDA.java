import java.util.*;
import java.io.*;

public class ProductsDA {
    private ArrayList<Products> productsList;

    public ProductsDA() throws FileNotFoundException {
        // file
        File file = new File("products.txt");
        FileReader fileReader = new FileReader(file);
        Scanner scanner = new Scanner(fileReader);

        // init
        String row;
        String[] value;
        productsList = new ArrayList<Products>();

        // scan
        while (scanner.hasNext()) {
            row = scanner.nextLine();
            value = row.split(",");

            Products products = new Products();
            products.setName(value[0].trim());
            products.setWeight(Double.parseDouble(value[1].trim()));
            products.setAmount(Double.parseDouble(value[2].trim()));

            productsList.add(products);
        }

        // print
        print();

    }

    public ArrayList<Products> getProductsList() {
        return productsList;
    }

    public void print() {
        // print header
        System.out.printf("%-25s %-15s %s", "Product Name", "Weight (kg)", "Amount (P)\n");
        for (Products products : productsList) {
            // print products
            System.out.println(products);
        }
    }

}