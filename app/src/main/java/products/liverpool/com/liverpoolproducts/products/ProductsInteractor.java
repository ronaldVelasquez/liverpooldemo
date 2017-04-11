package products.liverpool.com.liverpoolproducts.products;

import products.liverpool.com.liverpoolproducts.GetProductsLoaded;

/**
 * Created by ronaldvelasquez on 11/04/17.
 */

public interface ProductsInteractor {
    void getProductsByCategoryName(GetProductsLoaded getProductsLoaded, String categoryName);
}
