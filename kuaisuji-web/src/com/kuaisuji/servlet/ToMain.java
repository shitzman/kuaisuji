package com.kuaisuji.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kuaisuji.pojo.Account;
import com.kuaisuji.pojo.User;
import com.kuaisuji.service.AccountService;
import com.kuaisuji.serviceImpl.AccountServiceImpl;

/**
 * Servlet implementation class ToMain
 */
@WebServlet("/ToMain")
public class ToMain extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ToMain() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 获取用户信息
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute("user");
		//获取条件参数
		String type = request.getParameter("type");
		String cid = request.getParameter("cid");
		String all = request.getParameter("all");
		AccountService accountService = new AccountServiceImpl();
		List<Account> allAccountList = null;
		if(type != null && type != "") {
			allAccountList = accountService.getAllAccountByType(user.getUserid(), Integer.parseInt(type));
		}
		if(cid != null && cid != "") {
			allAccountList = accountService.getAllAccountByItem(user.getUserid(), Integer.parseInt(cid));
		}
		
		if(all != null && all != null) {
			allAccountList = accountService.getAllAccount(user.getUserid());
		}
		
		session.setAttribute("allAccountList", allAccountList);//更新allAccountList
		response.sendRedirect("afterlogin/main.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
