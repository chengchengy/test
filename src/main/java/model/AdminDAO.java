/**
 * @author Chenya Zhang
 * 07/18/2016
 */
package model;

import databean.AdminBean;
import org.hibernate.*;

import java.util.ArrayList;
import java.util.List;

public class AdminDAO {
        
        public AdminBean findAdminById(int adminId) {
                AdminBean adminBean = null;
                Session session = null;
                Transaction transaction = null;
                
                try {
                        session = HibernateUtil.getSessionFactory().openSession();
                        transaction = session.beginTransaction();
                        
                        adminBean = (AdminBean) session.get(AdminBean.class, adminId);

                        if (!transaction.wasCommitted()) {
                                transaction.commit();
                        }
                } catch (HibernateException ex) {
                        System.out.println("findPersonById HibernateException: " + ex);
                        if (transaction != null) {
                                transaction.rollback();
                        }
                } finally {
                        session.close();
                }
                
                return adminBean;
        }
        
        public void saveNewAdmin(AdminBean adminBean) {
                Session session = null;
                Transaction transaction = null;
                
                try {
                        session = HibernateUtil.getSessionFactory().openSession();
                        transaction = session.beginTransaction();

                        session.save(adminBean);
                        
                        if (!transaction.wasCommitted()) {
                                transaction.commit();
                        }
                } catch (HibernateException ex) {
                        System.out.println("saveNewAdmin HibernateException: " + ex);
                        if (transaction != null) {
                                transaction.rollback();
                        }
                } finally {
                        session.close();
                }
        }

        public void deleteAdmin(AdminBean adminBean) {
                Session session = null;
                Transaction transaction = null;
                
                try {
                        session = HibernateUtil.getSessionFactory().openSession();
                        transaction = session.beginTransaction();

                        session.delete(adminBean);

                        if (!transaction.wasCommitted()) {
                                transaction.commit();
                        }
                } catch (HibernateException ex) {
                        System.out.println("deleteAdmin HibernateException: " + ex);
                        if (transaction != null) {
                                transaction.rollback();
                        }
                } finally {
                        session.close();
                }
        }

        public AdminBean findByAdminUserName(String userName) {
                AdminBean adminBean = null;
                Session session = null;
                Transaction transaction = null;
                
                try {
                        session = HibernateUtil.getSessionFactory().openSession();
                        transaction = session.beginTransaction();
                        
                        String hql = "SELECT admin FROM AdminBean admin WHERE admin.userName = :userName";
                        Query query = session.createQuery(hql).setParameter("userName", userName);
                        adminBean = (AdminBean) query.uniqueResult();
                        
                        if (!transaction.wasCommitted()) {
                                transaction.commit();
                        }
                } catch (NonUniqueResultException ex) {
                        System.out.println("findByPersonName NonUniqueResultException: " + ex);
                        if (transaction != null) {
                                transaction.rollback();
                        }
                } catch (HibernateException ex) {
                        System.out.println("findByPersonName HibernateException: " + ex);
                        if (transaction != null) {
                                transaction.rollback();
                        }
                } finally {
                        session.close();
                }
                
                return adminBean;
        }

        @SuppressWarnings("unchecked")
        public List<AdminBean> loadAllAdmins() {
                List<AdminBean> allAdmins = new ArrayList<AdminBean>();
                Session session = null;
                Transaction transaction = null;
                
                try {
                        session = HibernateUtil.getSessionFactory().openSession();
                        transaction = session.beginTransaction();

                        allAdmins = (List<AdminBean>)session.createCriteria(AdminBean.class).list();

                        if (!transaction.wasCommitted()) {
                                transaction.commit();
                        }
                } catch (HibernateException ex) {
                        System.out.println("loadAllAdmins HibernateException: " + ex);
                        if (transaction != null) {
                                transaction.rollback();
                        }
                } finally {
                        session.close();
                }
                
                return allAdmins;
        }

//  For test purposes:
//
//        public static void main(String[] args) {
//                AdminDAO adminDAO = new AdminDAO();
//                
//                AdminBean adminBean = new AdminBean();
//                adminBean.setUserName("Baobao3");
//                adminBean.setFirstName("Chenya");
//                adminBean.setLastName("Zhang");
//                
//                String password = "12345";
//                PasswordAuthentication pa = new PasswordAuthentication();
//                String hash = pa.hash(password.toCharArray());
//                System.out.println("hash: " + hash);
//                adminBean.setPassword(hash);
//                String test1 = "123";
//                String test2 = "12345";                
//                System.out.println("test1: " + pa.authenticate(test1.toCharArray(), hash));
//                System.out.println("test2: " + pa.authenticate(test2.toCharArray(), hash));                
//                                
//                adminDAO.saveNewAdmin(adminBean);
//        }
}