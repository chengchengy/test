/**
 * @author Chenya Zhang
 * 07/18/2016
 */
package databean;

import javax.persistence.*;

@Entity
@Table(name = "FEEDBACKQUESTION",
uniqueConstraints = {
         @UniqueConstraint(columnNames = "question")
 })
public class FeedbackQuestionBean {
        // Private fields
        @Id @GeneratedValue
        @Column(name = "fbQuestionId")
        private int fbQuestionId; // PK
        
        @Column(name = "questionType")
        private int questionType;
        
        @Column(name = "question")
        private String question;

        // Public getters and setters for all private fields
        public int getFbQuestionId() {
                return fbQuestionId;
        }

        public void setFbQuestionId(int fbQuestionId) {
                this.fbQuestionId = fbQuestionId;
        }

        public int getQuestionType() {
                return questionType;
        }

        public void setQuestionType(int questionType) {
                this.questionType = questionType;
        }

        public String getQuestion() {
                return question;
        }

        public void setQuestion(String question) {
                this.question = question;
        }
}
