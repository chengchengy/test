/**
 * @author Chenya Zhang
 * 07/18/2016
 */
package databean;

import java.util.Date;

public class DemoBean {
        // Private fields
        private int demoId; // PK
        private int productCategoryId; // FK
        private int storeId; // FK
        private Date demoStartTime;
        private Date demoEndTime;
        private Date demoCheckInTime;
        private Date demoCheckOutTime;
        private String status;
        private String demoMemo;
        private int roleId; // FK

        // Public getters and setters for all private fields
        public int getDemoId() {
                return demoId;
        }

        public void setDemoId(int demoId) {
                this.demoId = demoId;
        }

        public int getProductCategoryId() {
                return productCategoryId;
        }

        public void setProductCategoryId(int productCategoryId) {
                this.productCategoryId = productCategoryId;
        }

        public int getStoreId() {
                return storeId;
        }

        public void setStoreId(int storeId) {
                this.storeId = storeId;
        }

        public Date getDemoStartTime() {
                return demoStartTime;
        }

        public void setDemoStartTime(Date demoStartTime) {
                this.demoStartTime = demoStartTime;
        }

        public Date getDemoEndTime() {
                return demoEndTime;
        }

        public void setDemoEndTime(Date demoEndTime) {
                this.demoEndTime = demoEndTime;
        }

        public Date getDemoCheckInTime() {
                return demoCheckInTime;
        }

        public void setDemoCheckInTime(Date demoCheckInTime) {
                this.demoCheckInTime = demoCheckInTime;
        }

        public Date getDemoCheckOutTime() {
                return demoCheckOutTime;
        }

        public void setDemoCheckOutTime(Date demoCheckOutTime) {
                this.demoCheckOutTime = demoCheckOutTime;
        }

        public String getStatus() {
                return status;
        }

        public void setStatus(String status) {
                this.status = status;
        }

        public String getDemoMemo() {
                return demoMemo;
        }

        public void setDemoMemo(String demoMemo) {
                this.demoMemo = demoMemo;
        }

        public int getRoleId() {
                return roleId;
        }

        public void setRoleId(int roleId) {
                this.roleId = roleId;
        }
}
