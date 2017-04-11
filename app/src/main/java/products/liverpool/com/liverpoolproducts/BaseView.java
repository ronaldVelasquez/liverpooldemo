package products.liverpool.com.liverpoolproducts;

/**
 * Created by ronaldvelasquez on 11/04/17.
 */

public interface BaseView {
    void showLoading();

    void hideLoading();

    void showError(String error);
}
