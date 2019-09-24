package com.kuaisuji.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kuaisuji.pojo.User;
import com.kuaisuji.service.UserService;
import com.kuaisuji.serviceImpl.UserServiceImpl;

/**
 * Servlet implementation class AddUser
 */
@WebServlet("/AddUser")
public class AddUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddUser() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String useremail = request.getParameter("email");
		String username = request.getParameter("nikename");
		String userpassword = request.getParameter("password");
		String userip = request.getRemoteAddr();	//��ȡ�û�ip;��ʹ��localhostʱ����
		User user = new User(useremail,username,userpassword,userip);
		
		UserService userService = new UserServiceImpl();
		if(userService.checkUser(user.getUseremail())){
			request.setAttribute("msg", "������ע�ᣬ������������");
			request.getRequestDispatcher("reg.jsp").forward(request, response);
		}else{
			int flag = userService.addUser(user);
			if(flag>0) {
				request.setAttribute("useremail", useremail);
				request.setAttribute("msg", "ע��ɹ������¼");
				request.getRequestDispatcher("login.jsp").forward(request, response);
			}else {
				request.setAttribute("msg", "ע��ʧ��");
				request.getRequestDispatcher("reg.jsp").forward(request, response);
			}
			
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
