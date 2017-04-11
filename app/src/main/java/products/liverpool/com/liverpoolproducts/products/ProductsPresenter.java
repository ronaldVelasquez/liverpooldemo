package products.liverpool.com.liverpoolproducts.products;

import products.liverpool.com.liverpoolproducts.BasePresenter;

/**
 * Created by ronaldvelasquez on 11/04/17.
 */

public interface ProductsPresenter extends BasePresenter<ProductsView> {
    void searchByCategory(String categoryName);
}
