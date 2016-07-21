/**
 * @author Chenya Zhang
 * 07/18/2016
 */
package databean;

public class ProductCategoryBean {
        // Private fields
        private int productCategoryId; // PK
        private String productCategoryName;

        // Public getters and setters for all private fields
        public int getProductCategoryId() {
                return productCategoryId;
        }

        public void setProductCategoryId(int productCategoryId) {
                this.productCategoryId = productCategoryId;
        }

        public String getProductCategoryName() {
                return productCategoryName;
        }

        public void setProductCategoryName(String productCategoryName) {
                this.productCategoryName = productCategoryName;
        }
}
