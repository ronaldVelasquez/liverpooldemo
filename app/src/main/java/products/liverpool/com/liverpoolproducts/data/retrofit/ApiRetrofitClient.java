package products.liverpool.com.liverpoolproducts.data.retrofit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiRetrofitClient {
    private static RetrofitServiceInterface retrofitServiceInterface;

    public static RetrofitServiceInterface getApiClient() {
        if (retrofitServiceInterface == null) {
            Retrofit restAdapter = new Retrofit.Builder()
                    .baseUrl("https://www.liverpool.com.mx/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(new OkHttpClient())
                    .build();
            retrofitServiceInterface = restAdapter.create(RetrofitServiceInterface.class);
        }
        return retrofitServiceInterface;
    }
}
