package com.kuaisuji.servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kuaisuji.pojo.Account;
import com.kuaisuji.pojo.Type;
import com.kuaisuji.pojo.User;
import com.kuaisuji.service.AccountService;
import com.kuaisuji.service.TypeService;
import com.kuaisuji.service.UserService;
import com.kuaisuji.serviceImpl.AccountServiceImpl;
import com.kuaisuji.serviceImpl.TypeServiceImpl;
import com.kuaisuji.serviceImpl.UserServiceImpl;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		String useremail = request.getParameter("email");
		String userpassword = request.getParameter("password");
		
		UserService userService = new UserServiceImpl();
		User user = userService.selectUser(useremail, userpassword);
		if(user != null) {
			HttpSession session = request.getSession();
			session.setAttribute("user", user);
			Cookie cookie = new Cookie("JSESSIONID",session.getId());
			cookie.setMaxAge(30*60);	//设置有效时间
			cookie.setPath("/"+request.getContextPath());	//设置有效路径
			
			//加载用户信息
			AccountService accountService = new AccountServiceImpl();
			List<Account> allAccountList = accountService.getAllAccount(user.getUserid());
			session.setAttribute("allAccountList", allAccountList);
			//加载类型辅助信息
			TypeService typeService = new TypeServiceImpl();
			Map<Integer,Type> typeMap = typeService.getAllType();
			session.setAttribute("typeMap", typeMap);
			Map<Integer,Type> typeMapBy0 = new HashMap<Integer,Type>();//account_type为0，即支出项目
			Map<Integer,Type> typeMapBy1 = new HashMap<Integer,Type>();//account_type为1，即收入项目
			for(Integer key : typeMap.keySet()) {
				if(typeMap.get(key).getAccount_type()==0) {
					typeMapBy0.put(key, typeMap.get(key));
				}else {
					typeMapBy1.put(key, typeMap.get(key));
				}
			}
			session.setAttribute("typeMapBy0", typeMapBy0);
			session.setAttribute("typeMapBy1", typeMapBy1);
			
			response.sendRedirect(request.getContextPath()+"/afterlogin/main.jsp");
		}else {
			request.setAttribute("msg", "登陆失败（账号或秘密错误）");
			request.getRequestDispatcher("/login.jsp").forward(request, response);
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
