/**
 * @author Chenya Zhang
 * 07/18/2016
 */
package controller;

import databean.AmbBean;
import databean.FeedbackBean;
import model.FeedbackDAO;
import org.hibernate.HibernateException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

public class SaveFeedbackAction extends Action {
        
        private FeedbackDAO feedbackDAO = new FeedbackDAO();

        @Override
        public String getName() {
                return "saveFeedbackAction.do";
        }

        @Override
        public String perform(HttpServletRequest request) {
                HttpSession session = request.getSession();

                List<String> errors = new ArrayList<String>();
                request.setAttribute("errors", errors);
                
                try {
                        if (session.getAttribute("user") != null && session.getAttribute("user") instanceof AmbBean) {
                                
                                FeedbackBean feedback = new FeedbackBean();
                                feedback.setDemoId(0007);
                                feedback.setFbQuestionId(1);
                                feedback.setAnswer(5);
                                feedback.setTextAnswer("You love me.");
                                feedbackDAO.saveNewFeedback(feedback);

                                request.setAttribute("message", "New feedback is saved successfully.");

                                return "saveFeedbackSuccess.jsp";
                        } else {
                                return "fillFeedback.jsp";
                        }
                } catch (HibernateException ex) {
                        errors.add(ex.getMessage());
                        return "fillFeedback.jsp";
                }
        }
}