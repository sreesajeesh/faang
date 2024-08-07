package javaeight.collections;

import java.util.Objects;

public class Product implements Comparable<Product>{

    private Integer id;

    public Product(Integer id) {
        this.id = id;
    }
    public int getId() {
        return id;
    }
    @Override
    public String toString() {
        return "Product{" + "id=" + id + '}';
    }

    @Override
    public boolean equals(Object o) {
        if(o instanceof Product){
            Product otherProduct = (Product)o;
            if(Objects.equals(id, otherProduct.id)){
                return true;
            }
        }
        return false;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + id;
        return hash;
    }

    @Override
    public int compareTo(Product o) {
        //return id.compareTo(o.id);
        return 0;
    }
}
