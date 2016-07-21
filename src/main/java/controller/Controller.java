/**
 * @author Chenya Zhang
 * 07/18/2016
 */
package controller;

import databean.AdminBean;
import databean.AmbBean;
import model.AdminDAO;
import model.AmbDAO;
import org.hibernate.HibernateException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Servlet implementation class Controller
 */
public class Controller extends HttpServlet {
        private static final long serialVersionUID = 1L;
        AdminDAO adminDAO;
        AmbDAO ambDAO;

        /**
         * @see HttpServlet#HttpServlet()
         */
        public Controller() {
                super();
        }

        public void init() throws ServletException {

                Action.add(new SaveFeedbackAction());

                adminDAO = new AdminDAO();
                ambDAO = new AmbDAO();
        }

        /**
         * @see HttpServlet#doGet(HttpServletRequest request,
         *      HttpServletResponse response)
         */
        protected void doGet(HttpServletRequest request, HttpServletResponse response)
                        throws ServletException, IOException {
                String nextPage = performTheAction(request);
                sendToNextPage(nextPage, request, response);
        }

        /**
         * @see HttpServlet#doPost(HttpServletRequest request,
         *      HttpServletResponse response)
         */
        protected void doPost(HttpServletRequest request, HttpServletResponse response)
                        throws ServletException, IOException {
                doGet(request, response);
        }

        private String performTheAction(HttpServletRequest request) {
                HttpSession session = request.getSession(true);
                String servletPath = request.getServletPath();
                String action = getActionName(servletPath);

                if (session.getAttribute("user") == null) {
                        return Action.perform("login.do", request);
                }

                if (action.equals("start")) {
                        if (session.getAttribute("user") instanceof AdminBean)
                                return Action.perform("adminDashboard.do", request);
                        else
                                return Action.perform("ambDashboard.do", request);
                }

                if (session.getAttribute("user") != null && !action.equals("logOut.do")) {
                        if (session.getAttribute("user") instanceof AdminBean) {
                                AdminBean adminBean = (AdminBean) session.getAttribute("user");
                                AdminBean tmp;
                                try {
                                        tmp = adminDAO.findByAdminUserName(adminBean.getUserName());
                                        if (!request.getCookies()[0].getValue().equals(tmp.getCookie())) {
                                                List<String> errors = new ArrayList<String>();
                                                errors.add("Session Terminated!");
                                                request.setAttribute("user", session.getAttribute("user"));
                                                request.setAttribute("errors", errors);
                                                session.setAttribute("user", null);
                                                return "terminated.jsp";
                                        }
                                } catch (HibernateException e) {
                                        e.printStackTrace();
                                        return Action.perform("login.do", request);
                                }

                        } else if (session.getAttribute("user") instanceof AmbBean) {
                                AmbBean ambBean = (AmbBean) session.getAttribute("user");
                                AmbBean tmp;
                                try {
                                        tmp = ambDAO.findByAmbUserName(ambBean.getUserName());
                                        if (!request.getCookies()[0].getValue().equals(tmp.getCookie())) {
                                                List<String> errors = new ArrayList<String>();
                                                errors.add("Session Terminated!");
                                                request.setAttribute("user", session.getAttribute("user"));
                                                request.setAttribute("errors", errors);
                                                session.setAttribute("user", null);
                                                return "terminated.jsp";
                                        }
                                } catch (HibernateException e) {
                                        e.printStackTrace();
                                        return Action.perform("login.do", request);
                                }
                        }
                }
                
                return Action.perform(action, request);
        }

        private void sendToNextPage(String nextPage, HttpServletRequest request, HttpServletResponse response)
                        throws IOException, ServletException {
                if (nextPage == null) {
                        response.sendError(HttpServletResponse.SC_NOT_FOUND, request.getServletPath());
                        return;
                }

                if (nextPage.endsWith(".do")) {
                        response.sendRedirect(nextPage);
                        return;
                }
                
                if (nextPage.endsWith(".jsp") || nextPage.endsWith(".html")) {
                        RequestDispatcher d = request.getRequestDispatcher(nextPage);
                        d.forward(request, response);
                        return;
                }

                throw new ServletException(Controller.class.getName() + ".sendToNextPage(\"" + nextPage
                                + "\"): invalid extension.");
        }

        private String getActionName(String path) {
                int slash = path.lastIndexOf('/');
                return path.substring(slash + 1);
        }
}
