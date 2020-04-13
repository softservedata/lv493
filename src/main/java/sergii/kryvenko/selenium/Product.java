package sergii.kryvenko.selenium;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "oc_product")
public class Product {

    @Id
    @OneToOne(mappedBy = "id", cascade = { CascadeType.DETACH,
            CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH })
    private ProductDescriprion id;

    @Column(name = "price")
    private float price;

    @Column(name = "quantity")
    private int quantity;

    public Product() {
    }

    public Product(float price, int quantity) {
        this.price = price;
        this.quantity = quantity;
    }

    public ProductDescriprion getId() {
        return id;
    }

    public void setId(ProductDescriprion id) {
        this.id = id;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Product [id=" + id + ", price=" + price + ", quantity="
                + quantity + "]";
    }

}
