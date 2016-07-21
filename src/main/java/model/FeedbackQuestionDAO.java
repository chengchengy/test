/**
 * @author Chenya Zhang
 * 07/18/2016
 */
package model;

import databean.FeedbackQuestionBean;
import org.hibernate.*;

import java.util.ArrayList;
import java.util.List;

public class FeedbackQuestionDAO {

        public void saveNewFeedbackQuestion(FeedbackQuestionBean feedbackQuestionBean) {
                Session session = null;
                Transaction transaction = null;

                try {
                        session = HibernateUtil.getSessionFactory().openSession();
                        transaction = session.beginTransaction();

                        session.save(feedbackQuestionBean);

                        if (!transaction.wasCommitted()) {
                                transaction.commit();
                        }
                } catch (HibernateException ex) {
                        System.out.println("saveNewFeedbackQuestion HibernateException: " + ex);
                        if (transaction != null) {
                                transaction.rollback();
                        }
                } finally {
                        session.close();
                }
        }

        public void deleteFeedbackQuestion(FeedbackQuestionBean feedbackQuestionBean) {
                Session session = null;
                Transaction transaction = null;

                try {
                        session = HibernateUtil.getSessionFactory().openSession();
                        transaction = session.beginTransaction();

                        session.delete(feedbackQuestionBean);

                        if (!transaction.wasCommitted()) {
                                transaction.commit();
                        }
                } catch (HibernateException ex) {
                        System.out.println("deleteFeedbackQuestion HibernateException: " + ex);
                        if (transaction != null) {
                                transaction.rollback();
                        }
                } finally {
                        session.close();
                }
        }

        public FeedbackQuestionBean findFeedbackQuestionByQuestionId(int fbQuestionId) {
                FeedbackQuestionBean feedbackQuestion = null;
                Session session = null;
                Transaction transaction = null;

                try {
                        session = HibernateUtil.getSessionFactory().openSession();
                        transaction = session.beginTransaction();

                        feedbackQuestion = (FeedbackQuestionBean) session.get(FeedbackQuestionBean.class, fbQuestionId);

                        if (!transaction.wasCommitted()) {
                                transaction.commit();
                        }
                } catch (HibernateException ex) {
                        System.out.println("findFeedbackQuestionByQuestionId HibernateException: " + ex);
                        if (transaction != null) {
                                transaction.rollback();
                        }
                } finally {
                        session.close();
                }

                return feedbackQuestion;
        }
        
        public FeedbackQuestionBean findFeedbackQuestionByQuestion(String question) {
                FeedbackQuestionBean feedbackQuestion = null;
                Session session = null;
                Transaction transaction = null;

                try {
                        session = HibernateUtil.getSessionFactory().openSession();
                        transaction = session.beginTransaction();

                        String hql = "SELECT feedbackQuestion FROM FeedbackQuestionBean feedbackQuestion " 
                                        + "WHERE feedbackQuestion.question = :question";
                        Query query = session.createQuery(hql).setParameter("question", question);
                        feedbackQuestion = (FeedbackQuestionBean) query.uniqueResult();

                        if (!transaction.wasCommitted()) {
                                transaction.commit();
                        }
                } catch (NonUniqueResultException ex) {
                        System.out.println("findfbQuestionIdByQuestion NonUniqueResultException: " + ex);
                        if (transaction != null) {
                                transaction.rollback();
                        }
                } catch (HibernateException ex) {
                        System.out.println("findfbQuestionIdByQuestion HibernateException: " + ex);
                        if (transaction != null) {
                                transaction.rollback();
                        }
                } finally {
                        session.close();
                }

                return feedbackQuestion;
        }

        @SuppressWarnings("unchecked")
        public List<FeedbackQuestionBean> loadAllFeedbackQuestions() {
                List<FeedbackQuestionBean> allFeedbackQuestions = new ArrayList<FeedbackQuestionBean>();
                Session session = null;
                Transaction transaction = null;
                
                try {
                        session = HibernateUtil.getSessionFactory().openSession();
                        transaction = session.beginTransaction();

                        allFeedbackQuestions = (List<FeedbackQuestionBean>) session.createCriteria(FeedbackQuestionBean.class).list();

                        if (!transaction.wasCommitted()) {
                                transaction.commit();
                        }
                } catch (HibernateException ex) {
                        System.out.println("loadAllFeedbackQuestions HibernateException: " + ex);
                        if (transaction != null) {
                                transaction.rollback();
                        }
                } finally {
                        session.close();
                }
                
                return allFeedbackQuestions;
        }
}