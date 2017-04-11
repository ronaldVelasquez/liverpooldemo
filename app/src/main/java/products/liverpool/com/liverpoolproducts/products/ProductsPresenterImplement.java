package products.liverpool.com.liverpoolproducts.products;

import android.text.TextUtils;

import java.util.List;

import products.liverpool.com.liverpoolproducts.GetProductsLoaded;
import products.liverpool.com.liverpoolproducts.data.model.entities.Product;

/**
 * Created by ronaldvelasquez on 11/04/17.
 */

public class ProductsPresenterImplement implements ProductsPresenter{
    private ProductsView view;
    private ProductsInteractor interactor;

    @Override
    public void addView(ProductsView view) {
        this.view = view;
        interactor = new ProductInteractorImplement();
    }

    @Override
    public void searchByCategory(String categoryName) {
        if (TextUtils.isEmpty(categoryName)) {
            view.showError("Debes agregar una categoría");
        } else {
            view.showLoading();
            interactor.getProductsByCategoryName(new GetProductsLoaded() {
                @Override
                public void onProductLoaded(List<Product> products) {
                    view.hideLoading();
                    view.showProducts(products);
                }

                @Override
                public void onErrorLoaded(String error) {
                    view.hideLoading();
                    view.showError(error);
                }
            }, categoryName);
        }
    }
}
