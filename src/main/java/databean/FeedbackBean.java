/**
 * @author Chenya Zhang
 * 07/18/2016
 */
package databean;

import javax.persistence.*;

@Entity
@Table(name = "FEEDBACK")
public class FeedbackBean {
        // Private fields
        @Id @GeneratedValue
        @Column(name = "feedbackId")
        private int feedbackId; // PK
        
        @Column(name = "demoId")
        private int demoId; // FK
        
        @Column(name = "fbQuestionId")
        private int fbQuestionId; // FK
        
        @Column(name = "answer")
        private int answer;
        
        @Column(name = "textAnswer")
        private String textAnswer;

        // Public getters and setters for all private fields
        public int getFeedbackId() {
                return feedbackId;
        }

        public void setFeedbackId(int feedbackId) {
                this.feedbackId = feedbackId;
        }

        public int getDemoId() {
                return demoId;
        }

        public void setDemoId(int demoId) {
                this.demoId = demoId;
        }

        public int getFbQuestionId() {
                return fbQuestionId;
        }

        public void setFbQuestionId(int fbQuestionId) {
                this.fbQuestionId = fbQuestionId;
        }

        public int getAnswer() {
                return answer;
        }

        public void setAnswer(int answer) {
                this.answer = answer;
        }

        public String getTextAnswer() {
                return textAnswer;
        }

        public void setTextAnswer(String textAnswer) {
                this.textAnswer = textAnswer;
        }
}
