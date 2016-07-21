/**
 * @author Chenya Zhang
 * 07/18/2016
 */
package databean;

import javax.persistence.*;

@Entity
@Table(name = "AMB",
       uniqueConstraints = {
                @UniqueConstraint(columnNames = "userName"),
                @UniqueConstraint(columnNames = "email")
        })
public class AmbBean {
        // Private fields
        
        @Id @GeneratedValue
        @Column(name = "ambId")
        private int ambId; // PK
        
        @Column(name = "userName")
        private String userName;
        
        @Column(name = "firstName")
        private String firstName;
        
        @Column(name = "lastName")
        private String lastName;
        
        @Column(name = "email")
        private String email;
        
        @Column(name = "phone")
        private String phone;
        
        @Column(name = "password")
        private String password;
        
        @Column(name = "city")
        private String city;
        
        @Column(name = "zipCode")
        private String zipCode;
        
        @Column(name = "cookie")
        private String cookie;
        
        // Public getters and setters for all private fields
        public int getAmbId() {
                return ambId;
        }

        public void setAmbId(int ambId) {
                this.ambId = ambId;
        }

        public String getUserName() {
                return userName;
        }

        public void setUserName(String userName) {
                this.userName = userName;
        }

        public String getFirstName() {
                return firstName;
        }

        public void setFirstName(String firstName) {
                this.firstName = firstName;
        }

        public String getLastName() {
                return lastName;
        }

        public void setLastName(String lastName) {
                this.lastName = lastName;
        }

        public String getEmail() {
                return email;
        }

        public void setEmail(String email) {
                this.email = email;
        }

        public String getPhone() {
                return phone;
        }

        public void setPhone(String phone) {
                this.phone = phone;
        }

        public String getPassword() {
                return password;
        }

        public void setPassword(String password) {
                this.password = password;
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
        
        public String getCookie() {
                return cookie;
        }

        public void setCookie(String cookie) {
                this.cookie = cookie;
        }
}
