package com.kuaisuji.servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kuaisuji.Dao.AccountDao;
import com.kuaisuji.DaoImpl.AccountDaoImpl;
import com.kuaisuji.pojo.Account;
import com.kuaisuji.pojo.User;

/**
 * Servlet implementation class AddAccount
 */
@WebServlet("/AddAccount")
public class AddAccount extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddAccount() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		request.setCharacterEncoding("utf-8");
		HttpSession session = request.getSession(false);
		if(session == null) response.sendRedirect(request.getContextPath()+"/index.jsp");//未获取到用户session
		User user = (User)session.getAttribute("user");
		AccountDao accountDao = new AccountDaoImpl();
		
		int user_id = user.getUserid();
		int account_type = Integer.parseInt(request.getParameter("type"));
		int account_item = Integer.parseInt(request.getParameter("cid"));
		String account_amount = request.getParameter("money");
		String account_date = request.getParameter("addTime");
		if(account_date == "") {	//当用户未填写时间时，为其自动设置为现在的时间
			Date now = new Date();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			account_date = sdf.format(now);
		}
		String account_remark = request.getParameter("details");
		
		Account account = new Account();
		account.setUser_id(user_id);
		account.setAccount_type(account_type);
		account.setAccount_item(account_item);
		account.setAccount_amount(account_amount);
		account.setAccount_date(account_date);
		account.setAccount_remark(account_remark);
		int flag = accountDao.addAccountDao(account);
		if(flag>0) {
			List<Account> allAccountList = (List<Account>) session.getAttribute("allAccountList");
			allAccountList.add(account);
			response.sendRedirect(request.getContextPath()+"/afterlogin/main.jsp");
		}else {
			response.sendRedirect(request.getContextPath()+"/index.jsp");//添加失败
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
