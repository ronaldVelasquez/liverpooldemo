package products.liverpool.com.liverpoolproducts.products;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.ProgressBar;

import java.util.List;

import products.liverpool.com.liverpoolproducts.R;
import products.liverpool.com.liverpoolproducts.data.CategoryNamePrefrence;
import products.liverpool.com.liverpoolproducts.data.model.entities.Product;
import products.liverpool.com.liverpoolproducts.util.AlertUtil;

public class ProductsActivity extends AppCompatActivity implements ProductsView {
    private AutoCompleteTextView autocompleteProductActivity;
    private Button buttonSearchProductActivity;
    private RecyclerView recyclerProductsActivity;
    private ProductsPresenter presenter;
    private RVProductsAdapter adapter;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_products);
        initView();
        configAutocompleteText();
        configButtonSearch();
        configRecyclerView();
        presenter = new ProductsPresenterImplement();
        presenter.addView(this);
    }

    private void configRecyclerView() {
        adapter = new RVProductsAdapter();
        recyclerProductsActivity.setLayoutManager(new LinearLayoutManager(this));
        recyclerProductsActivity.setAdapter(adapter);
    }

    private void configAutocompleteText() {
        autocompleteProductActivity.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                if (b) {
//                    ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
//                            android.R.layout.simple_dropdown_item_1line, CategoryNamePrefrence.getLastSearch);
//                    CategoryNamePrefrence
                }
            }
        });
    }

    private void initView() {
        autocompleteProductActivity = (AutoCompleteTextView) findViewById(R.id.autocomplete_product_activity);
        buttonSearchProductActivity = (Button) findViewById(R.id.button_search_product_activity);
        recyclerProductsActivity = (RecyclerView) findViewById(R.id.recycler_products_activity);
        progressBar = (ProgressBar) findViewById(R.id.progressbar);
    }

    private void configButtonSearch() {
        buttonSearchProductActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.searchByCategory(autocompleteProductActivity.getText().toString().trim());
            }
        });
    }


    @Override
    public void showLoading() {
        adapter.clear();
        progressBar.setIndeterminate(true);
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideLoading() {
        progressBar.setVisibility(View.GONE);
    }

    @Override
    public void showError(String error) {
        AlertUtil.showMessageAccept(this, null, error, "Aceptar", null);
    }

    @Override
    public void showProducts(List<Product> products) {
        adapter.addProducts(products);
    }
}
