package control;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import model.Project;
import model.User;
import dataaccess.TaskManagerDAO;

/**
 * Servlet implementation class SearchUsersAjax
 */
@WebServlet("/searchusers.do")
public class SearchUsersAjax extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public SearchUsersAjax() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
        response.setContentType("text/html");
        response.setHeader("Cache-control", "no-cache, no-store");
        response.setHeader("Pragma", "no-cache");
        response.setHeader("Expires", "-1");
        
        JSONObject arrayObj = new JSONObject();
        
        String query = request.getParameter("term");
        System.out.println(query);
        
        TaskManagerDAO dao = new TaskManagerDAO();
        ArrayList<String> users = dao.getUserList(query);
        
        for(String user : users) {
            arrayObj.put(user, user);
        }
        
        out.println(arrayObj.toString());
        out.close();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int project_id = Integer.parseInt(request.getParameter("project"));
		String message = "";
		RequestDispatcher rd;
		String name = request.getParameter("user");
		TaskManagerDAO dao = new TaskManagerDAO();
		User user;
		if (name.indexOf('@') == -1){
			user = dao.retrieveUserByNickname(name);
		}
		else {
			user = dao.retrieveUser(name);
		}
		Project project = dao.retrieveProject(project_id);
		
		int result = dao.addUserToProject(user, project);
		if (result == 1) {
			message = "User Added.";
			System.out.println(message);
		}
		else if (result == 0) {
			message = "That user is already assigned to this project.";
			System.out.println(message);
		}
		else {
			message = "User Not Found.";
			System.out.println(message);
		}
		DataOutputStream out = new DataOutputStream(response.getOutputStream());
		response.setContentType("text/plain");
		out.writeBytes(message);
	}

}
