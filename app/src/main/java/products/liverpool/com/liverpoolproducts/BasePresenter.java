package products.liverpool.com.liverpoolproducts;

/**
 * Created by ronaldvelasquez on 11/04/17.
 */

public interface BasePresenter<T> {
    void addView(T view);
}
