package products.liverpool.com.liverpoolproducts.products;

import java.util.List;

import products.liverpool.com.liverpoolproducts.BaseView;
import products.liverpool.com.liverpoolproducts.data.model.entities.Product;

/**
 * Created by ronaldvelasquez on 11/04/17.
 */

public interface ProductsView extends BaseView {

    void showProducts(List<Product> products);
}
