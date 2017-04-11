package products.liverpool.com.liverpoolproducts.products;

import java.util.ArrayList;
import java.util.List;

import products.liverpool.com.liverpoolproducts.GetProductsLoaded;
import products.liverpool.com.liverpoolproducts.data.model.entities.Product;
import products.liverpool.com.liverpoolproducts.data.model.response.ListProductsResponse;
import products.liverpool.com.liverpoolproducts.data.retrofit.ApiRetrofitClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by ronaldvelasquez on 11/04/17.
 */

public class ProductInteractorImplement implements ProductsInteractor {
    @Override
    public void getProductsByCategoryName(final GetProductsLoaded getProductsLoaded, String categoryName) {
        Call<ListProductsResponse> call = ApiRetrofitClient.getApiClient().getProductsByCategory(categoryName, "json");
        call.enqueue(new Callback<ListProductsResponse>() {
            @Override
            public void onResponse(Call<ListProductsResponse> call, Response<ListProductsResponse> response) {
                try {
                    if (response.isSuccessful()) {
                        ListProductsResponse.Content content = response.body().contents.get(0);
                        ListProductsResponse.MainContent mainContent = content.getMainContent().get(3);
                        ListProductsResponse.Contents contents = mainContent.contents.get(0);
                        List<ListProductsResponse.Records> records = contents.getRecords();
                        List<Product> products = new ArrayList<Product>();
                        for (ListProductsResponse.Records r : records) {
                            Product product = new Product();
                            product.setImage(r.attributes.getThumbnailImage().get(0));
                            product.setPrice(r.attributes.getPrice().get(0));
                            product.setTitle(r.attributes.getDisplaynAME().get(0));
                            products.add(product);
                        }

                        getProductsLoaded.onProductLoaded(products);
                    } else {
                        getProductsLoaded.onErrorLoaded(response.errorBody().string());
                    }

                } catch (Exception e) {
                    e.printStackTrace();
                    getProductsLoaded.onErrorLoaded(e.getMessage());
                }

            }

            @Override
            public void onFailure(Call<ListProductsResponse> call, Throwable t) {
                getProductsLoaded.onErrorLoaded("Failure");
            }
        });
    }
}
