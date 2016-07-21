/**
 * @author Chenya Zhang
 * 07/18/2016
 */
package databean;

public class ProductBean {
        // Private fields
        private int productId; // PK
        private int productCategoryId; // FK
        private String productName;

        // Public getters and setters for all private fields
        public int getProductId() {
                return productId;
        }

        public void setProductId(int productId) {
                this.productId = productId;
        }

        public int getProductCategoryId() {
                return productCategoryId;
        }

        public void setProductCategoryId(int productCategoryId) {
                this.productCategoryId = productCategoryId;
        }

        public String getProductName() {
                return productName;
        }

        public void setProductName(String productName) {
                this.productName = productName;
        }
}
