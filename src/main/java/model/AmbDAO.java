/**
 * @author Chenya Zhang
 * 07/18/2016
 */
package model;

import databean.AmbBean;
import org.hibernate.*;

import java.util.ArrayList;
import java.util.List;

public class AmbDAO {
        
        public AmbBean findAmbById(int ambId) {
                AmbBean ambBean = null;
                Session session = null;
                Transaction transaction = null;
                
                try {
                        session = HibernateUtil.getSessionFactory().openSession();
                        transaction = session.beginTransaction();
                        
                        ambBean = (AmbBean) session.get(AmbBean.class, ambId);

                        if (!transaction.wasCommitted()) {
                                transaction.commit();
                        }
                } catch (HibernateException ex) {
                        System.out.println("findAmbById HibernateException: " + ex);
                        if (transaction != null) {
                                transaction.rollback();
                        }
                } finally {
                        session.close();
                }
                
                return ambBean;
        }
        
        public void saveNewAmb(AmbBean ambBean) {
                Session session = null;
                Transaction transaction = null;
                
                try {
                        session = HibernateUtil.getSessionFactory().openSession();
                        transaction = session.beginTransaction();
                        
                        session.save(ambBean);

                        if (!transaction.wasCommitted()) {
                                transaction.commit();
                        }
                } catch (HibernateException ex) {
                        System.out.println("saveNewAmb HibernateException: " + ex);
                        if (transaction != null) {
                                transaction.rollback();
                        }
                } finally {
                        session.close();
                }
        }

        public void deleteAmb(AmbBean ambBean) {
                Session session = null;
                Transaction transaction = null;
                
                try {
                        session = HibernateUtil.getSessionFactory().openSession();
                        transaction = session.beginTransaction();

                        session.delete(ambBean);

                        if (!transaction.wasCommitted()) {
                                transaction.commit();
                        }
                } catch (HibernateException ex) {
                        System.out.println("deleteAmb HibernateException: " + ex);
                        if (transaction != null) {
                                transaction.rollback();
                        }
                } finally {
                        session.close();
                }
        }

        public AmbBean findByAmbUserName(String userName) {
                AmbBean ambBean = null;
                Session session = null;
                Transaction transaction = null;
                
                try {
                        session = HibernateUtil.getSessionFactory().openSession();
                        transaction = session.beginTransaction();
                        
                        String hql = "SELECT amb FROM AmbBean amb WHERE amb.userName = :userName";
                        Query query = session.createQuery(hql).setParameter("userName", userName);
                        ambBean = (AmbBean) query.uniqueResult();
                        
                        if (!transaction.wasCommitted()) {
                                transaction.commit();
                        }
                } catch (NonUniqueResultException ex) {
                        System.out.println("findByAmbUserName NonUniqueResultException: " + ex);
                        if (transaction != null) {
                                transaction.rollback();
                        }
                } catch (HibernateException ex) {
                        System.out.println("findByAmbUserName HibernateException: " + ex);
                        if (transaction != null) {
                                transaction.rollback();
                        }
                } finally {
                        session.close();
                }
                
                return ambBean;
        }

        @SuppressWarnings("unchecked")
        public List<AmbBean> loadAllAmbs() {
                List<AmbBean> allAmbs = new ArrayList<AmbBean>();
                Session session = null;
                Transaction transaction = null;
                
                try {
                        session = HibernateUtil.getSessionFactory().openSession();
                        transaction = session.beginTransaction();

                        allAmbs = (List<AmbBean>)session.createCriteria(AmbBean.class).list();

                        if (!transaction.wasCommitted()) {
                                transaction.commit();
                        }
                } catch (HibernateException ex) {
                        System.out.println("loadAllAmbs HibernateException: " + ex);
                        if (transaction != null) {
                                transaction.rollback();
                        }
                } finally {
                        session.close();
                }
                
                return allAmbs;
        }  

// For test purposes:
//
//        public static void main(String[] args) {
//                AmbDAO ambDAO = new AmbDAO();
//                
//                AmbBean ambBean = new AmbBean();
//                ambBean.setUserName("DaBaobao");
//                ambBean.setFirstName("Chenya");
//                ambBean.setLastName("Zhang");
//                
//                String password = "12345";
//                PasswordAuthentication pa = new PasswordAuthentication();
//                String hash = pa.hash(password.toCharArray());
//                System.out.println("hash: " + hash);
//                ambBean.setPassword(hash);
//                String test1 = "123";
//                String test2 = "12345";                
//                System.out.println("test1: " + pa.authenticate(test1.toCharArray(), hash));
//                System.out.println("test2: " + pa.authenticate(test2.toCharArray(), hash));                
//                                
//                ambDAO.saveNewAmb(ambBean);
//        }
}