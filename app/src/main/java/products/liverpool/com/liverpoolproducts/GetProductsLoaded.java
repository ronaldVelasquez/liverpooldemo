package products.liverpool.com.liverpoolproducts;

import java.util.List;

import products.liverpool.com.liverpoolproducts.data.model.entities.Product;

/**
 * Created by ronaldvelasquez on 11/04/17.
 */

public interface GetProductsLoaded {
    void onProductLoaded(List<Product> products);

    void onErrorLoaded(String error);
}
