package products.liverpool.com.liverpoolproducts.data.model.entities;

/**
 * Created by ronaldvelasquez on 11/04/17.
 */

public class Product {
    private String title;
    private String price;
    private String image;

    public Product(String title, String price, String image) {
        this.title = title;
        this.price = price;
        this.image = image;
    }

    public Product() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
