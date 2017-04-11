package products.liverpool.com.liverpoolproducts.data.model.response;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

import products.liverpool.com.liverpoolproducts.data.model.entities.Product;

public class ListProductsResponse {

    @SerializedName("contents")
    public List<Content> contents;

    public List<Content> getContents() {
        return contents;
    }

    public void setContents(List<Content> contents) {
        this.contents = contents;
    }

    public List<Product> ListProducts() {
      return null;
    }

    public static class Attributes {
        @SerializedName("product.brand")
        public List<String> brand;
        @SerializedName("product.smallImage")
        public List<String> smallImage;
        @SerializedName("product.displayName")
        public List<String> displaynAME;
        @SerializedName("productType")
        public List<String> productType;
        @SerializedName("sku.list_Price")
        public List<String> price;
        @SerializedName("importBook")
        public List<Boolean> importBook;
        @SerializedName("sku.thumbnailImage")
        public List<String> thumbnailImage;

        public List<String> getBrand() {
            return brand;
        }

        public void setBrand(List<String> brand) {
            this.brand = brand;
        }

        public List<String> getSmallImage() {
            return smallImage;
        }

        public void setSmallImage(List<String> smallImage) {
            this.smallImage = smallImage;
        }

        public List<String> getDisplaynAME() {
            return displaynAME;
        }

        public void setDisplaynAME(List<String> displaynAME) {
            this.displaynAME = displaynAME;
        }

        public List<String> getProductType() {
            return productType;
        }

        public void setProductType(List<String> productType) {
            this.productType = productType;
        }

        public List<String> getPrice() {
            return price;
        }

        public void setPrice(List<String> price) {
            this.price = price;
        }

        public List<Boolean> getImportBook() {
            return importBook;
        }

        public void setImportBook(List<Boolean> importBook) {
            this.importBook = importBook;
        }

        public List<String> getThumbnailImage() {
            return thumbnailImage;
        }

        public void setThumbnailImage(List<String> thumbnailImage) {
            this.thumbnailImage = thumbnailImage;
        }
    }

    public static class Records {
        @SerializedName("attributes")
        public Attributes attributes;

        public Attributes getAttributes() {
            return attributes;
        }

        public void setAttributes(Attributes attributes) {
            this.attributes = attributes;
        }
    }

    public static class Contents {
        @SerializedName("totalNumRecs")
        public int totalNumRecs;
        @SerializedName("records")
        public List<Records> records;

        public int getTotalNumRecs() {
            return totalNumRecs;
        }

        public void setTotalNumRecs(int totalNumRecs) {
            this.totalNumRecs = totalNumRecs;
        }

        public List<Records> getRecords() {
            return records;
        }

        public void setRecords(List<Records> records) {
            this.records = records;
        }
    }

    public static class MainContent {
        @SerializedName("contents")
        public List<Contents> contents;

        public List<Contents> getContents() {
            return contents;
        }

        public void setContents(List<Contents> contents) {
            this.contents = contents;
        }
    }

    public static class Content {
        @SerializedName("mainContent")
        public List<MainContent> mainContent;

        public List<MainContent> getMainContent() {
            return mainContent;
        }

        public void setMainContent(List<MainContent> mainContent) {
            this.mainContent = mainContent;
        }
    }
}
