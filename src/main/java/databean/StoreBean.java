/**
 * @author Chenya Zhang
 * 07/18/2016
 */
package databean;

public class StoreBean {
        // Private fields
        private int storeId; // PK
        private String storeName;
        private String address;
        private String phone;
        private String city;
        private String zipCode;
        private String contactFirstName;
        private String contactLastName;
        private String contactEmail;

        // Public getters and setters for all private fields
        public int getStoreId() {
                return storeId;
        }

        public void setStoreId(int storeId) {
                this.storeId = storeId;
        }

        public String getStoreName() {
                return storeName;
        }

        public void setStoreName(String storeName) {
                this.storeName = storeName;
        }

        public String getAddress() {
                return address;
        }

        public void setAddress(String address) {
                this.address = address;
        }

        public String getPhone() {
                return phone;
        }

        public void setPhone(String phone) {
                this.phone = phone;
        }

        public String getCity() {
                return city;
        }

        public void setCity(String city) {
                this.city = city;
        }

        public String getZipCode() {
                return zipCode;
        }

        public void setZipCode(String zipCode) {
                this.zipCode = zipCode;
        }

        public String getContactFirstName() {
                return contactFirstName;
        }

        public void setContactFirstName(String contactFirstName) {
                this.contactFirstName = contactFirstName;
        }

        public String getContactLastName() {
                return contactLastName;
        }

        public void setContactLastName(String contactLastName) {
                this.contactLastName = contactLastName;
        }

        public String getContactEmail() {
                return contactEmail;
        }

        public void setContactEmail(String contactEmail) {
                this.contactEmail = contactEmail;
        }
}
