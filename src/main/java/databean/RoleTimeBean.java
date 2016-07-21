/**
 * @author Chenya Zhang
 * 07/18/2016
 */
package databean;

import java.util.Date;

public class RoleTimeBean {
        // Private fields
        private int roleTimeId; // PK
        private Date date;
        private Date startTime;
        private Date endTime;
        private int duration;
        private int roleId;

        // Public getters and setters for all private fields
        public int getRoleTimeId() {
                return roleTimeId;
        }

        public void setRoleTimeId(int roleTimeId) {
                this.roleTimeId = roleTimeId;
        }

        public Date getDate() {
                return date;
        }

        public void setDate(Date date) {
                this.date = date;
        }

        public Date getStartTime() {
                return startTime;
        }

        public void setStartTime(Date startTime) {
                this.startTime = startTime;
        }

        public Date getEndTime() {
                return endTime;
        }

        public void setEndTime(Date endTime) {
                this.endTime = endTime;
        }

        public int getDuration() {
                return duration;
        }

        public void setDuration(int duration) {
                this.duration = duration;
        }

        public int getRoleId() {
                return roleId;
        }

        public void setRoleId(int roleId) {
                this.roleId = roleId;
        }
}
