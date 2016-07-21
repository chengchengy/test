/**
 * @author Chenya Zhang
 * 07/18/2016
 */
package model;

import databean.FeedbackBean;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

public class FeedbackDAO {

        public void saveNewFeedback(FeedbackBean feedbackBean) {
                Session session = null;
                Transaction transaction = null;

                try {
                        session = HibernateUtil.getSessionFactory().openSession();
                        transaction = session.beginTransaction();

                        session.save(feedbackBean);

                        if (!transaction.wasCommitted()) {
                                transaction.commit();
                        }
                } catch (HibernateException ex) {
                        System.out.println("saveNewFeedback HibernateException: " + ex);
                        if (transaction != null) {
                                transaction.rollback();
                        }
                } finally {
                        session.close();
                }
        }

        public void deleteFeedback(FeedbackBean feedbackBean) {
                Session session = null;
                Transaction transaction = null;

                try {
                        session = HibernateUtil.getSessionFactory().openSession();
                        transaction = session.beginTransaction();

                        session.delete(feedbackBean);

                        if (!transaction.wasCommitted()) {
                                transaction.commit();
                        }
                } catch (HibernateException ex) {
                        System.out.println("deleteFeedback HibernateException: " + ex);
                        if (transaction != null) {
                                transaction.rollback();
                        }
                } finally {
                        session.close();
                }
        }

        @SuppressWarnings("unchecked")
        public List<FeedbackBean> findFeedbackByDemoId(int demoId) {
                List<FeedbackBean> feedbackBeans = null;
                Session session = null;
                Transaction transaction = null;

                try {
                        session = HibernateUtil.getSessionFactory().openSession();
                        transaction = session.beginTransaction();

                        String hql = "SELECT feedback FROM FeedbackBean feedback " + "WHERE feedback.demoId = :demoId "
                                        + "ORDER BY feedback.fbQuestionId ASC";
                        Query query = session.createQuery(hql).setParameter("demoId", demoId);
                        feedbackBeans = (List<FeedbackBean>) query.list();

                        if (!transaction.wasCommitted()) {
                                transaction.commit();
                        }
                } catch (HibernateException ex) {
                        System.out.println("findFeedbackByDemoId HibernateException: " + ex);
                        if (transaction != null) {
                                transaction.rollback();
                        }
                } finally {
                        session.close();
                }

                return feedbackBeans;
        }

        @SuppressWarnings("unchecked")
        public List<FeedbackBean> findFeedbackByQuestionId(int fbQuestionId) {
                List<FeedbackBean> feedbackBeans = null;
                Session session = null;
                Transaction transaction = null;
                
                try {
                        session = HibernateUtil.getSessionFactory().openSession();
                        transaction = session.beginTransaction();

                        String hql = "SELECT feedback FROM FeedbackBean feedback "
                                        + "WHERE feedback.fbQuestionId = :fbQuestionId "
                                        + "ORDER BY feedback.demoId ASC";
                        Query query = session.createQuery(hql).setParameter("fbQuestionId", fbQuestionId);
                        feedbackBeans = (List<FeedbackBean>) query.list();

                        if (!transaction.wasCommitted()) {
                                transaction.commit();
                        }
                } catch (HibernateException ex) {
                        System.out.println("findFeedbackByQuestionId HibernateException: " + ex);
                        if (transaction != null) {
                                transaction.rollback();
                        }
                } finally {
                        session.close();
                }
                
                return feedbackBeans;
        }

        @SuppressWarnings("unchecked")
        public List<FeedbackBean> loadAllFeedbacks() {
                List<FeedbackBean> allFeedbacks = new ArrayList<FeedbackBean>();
                Session session = null;
                Transaction transaction = null;
                
                try {
                        session = HibernateUtil.getSessionFactory().openSession();
                        transaction = session.beginTransaction();

                        allFeedbacks = (List<FeedbackBean>) session.createCriteria(FeedbackBean.class).list();

                        if (!transaction.wasCommitted()) {
                                transaction.commit();
                        }
                } catch (HibernateException ex) {
                        System.out.println("loadAllFeedbacks HibernateException: " + ex);
                        if (transaction != null) {
                                transaction.rollback();
                        }
                } finally {
                        session.close();
                }
                
                return allFeedbacks;
        }
}