package products.liverpool.com.liverpoolproducts.products;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

import products.liverpool.com.liverpoolproducts.R;
import products.liverpool.com.liverpoolproducts.data.model.entities.Product;

/**
 * Created by ronaldvelasquez on 11/04/17.
 */

public class RVProductsAdapter extends RecyclerView.Adapter<RVProductsAdapter.VHProducts> {
    private List<Product> products;


    public RVProductsAdapter() {
        products = new ArrayList<>();
    }

    public void addProducts(List<Product> products) {
        this.products.clear();
        this.products.addAll(products);
        notifyDataSetChanged();
    }


    @Override
    public VHProducts onCreateViewHolder(ViewGroup parent, int viewType) {
        return new VHProducts(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_product, parent, false));
    }

    @Override
    public void onBindViewHolder(VHProducts holder, int position) {
        Product p = products.get(position);
        holder.textNameProduct.setText(p.getTitle());
        holder.textPriceProduct.setText(p.getPrice());
        Glide.with(holder.itemView.getContext()).load(p.getImage()).into(holder.imageProduct);
    }

    @Override
    public int getItemCount() {
        return products.size();
    }

    public void clear() {
        products.clear();
        notifyDataSetChanged();
    }

    class VHProducts extends RecyclerView.ViewHolder {
        private ImageView imageProduct;
        private TextView textNameProduct;
        private TextView textPriceProduct;
        public VHProducts(View itemView) {
            super(itemView);
            imageProduct = (ImageView) itemView.findViewById(R.id.image_product);
            textNameProduct = (TextView) itemView.findViewById(R.id.text_name_product);
            textPriceProduct = (TextView) itemView.findViewById(R.id.text_price_product);
        }
    }
}
