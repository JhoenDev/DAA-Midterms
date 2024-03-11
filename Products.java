import java.io.*;
import java.util.*;

public class Products {
    private String name;
    private Double weight;
    private Double amount;

    public void setName(String name) {
        this.name = name;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getName() {
        return name;
    }

    public Double getWeight() {
        return weight;
    }

    public Double getAmount() {
        return amount;
    }

    @Override
    public String toString() {
        return String.format("%-25s %-15.1f %.2f", this.name, this.weight, this.amount);
    }
}