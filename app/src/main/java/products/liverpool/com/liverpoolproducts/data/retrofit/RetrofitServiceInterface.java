package products.liverpool.com.liverpoolproducts.data.retrofit;

import products.liverpool.com.liverpoolproducts.data.model.response.ListProductsResponse;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface RetrofitServiceInterface {
    @GET("tienda")
    Call<ListProductsResponse> getProductsByCategory(@Query("s") String categoryName, @Query("d3106047a194921c01969dfdec083925") String formatResponse);
}
