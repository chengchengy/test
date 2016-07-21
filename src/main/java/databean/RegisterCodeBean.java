/**
 * @author Chenya Zhang
 * 07/18/2016
 */
package databean;

public class RegisterCodeBean {
        // Private fields
        private String code; // PK
        private boolean usedOrNot;

        // Public getters and setters for all private fields
        public String getCode() {
                return code;
        }

        public void setCode(String code) {
                this.code = code;
        }

        public boolean isUsedOrNot() {
                return usedOrNot;
        }

        public void setUsedOrNot(boolean usedOrNot) {
                this.usedOrNot = usedOrNot;
        }
}
