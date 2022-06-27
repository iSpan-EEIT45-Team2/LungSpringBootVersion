package com.eeit45team2.lungspringbootversion.login;

import com.eeit45team2.lungspringbootversion.backend.member.model.MemberBean;
import com.eeit45team2.lungspringbootversion.login.service.LoginService;
import com.eeit45team2.lungspringbootversion.login.service.impl.LoginServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


@WebServlet(
		urlPatterns = { 
				"/login", 
				"/logout"
		}, 
		initParams = { 
				@WebInitParam(name = "IndexPath", value = "/index.jsp"), 
				@WebInitParam(name = "LoginPath", value = "/login.jsp")
		})
public class LoginController2 extends HttpServlet {
	
	/* 我的hibernate版本 + Filter */
	
	private static final long serialVersionUID = 1L;
	private String IndexPath;
	private String LoginPath;
	LoginService loginService;

    public LoginController2() {
    }

	public void init() throws ServletException {
		IndexPath = getInitParameter("IndexPath");
		LoginPath = getInitParameter("LoginPath");
		loginService = new LoginServiceImpl();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 先透過 GET 進到登入頁面
		if(request.getServletPath().equals("/login")){
			//如果Session有user，代表已登入，跳到首頁
			HttpSession session = request.getSession(false); //如果session不存在，傳回null
			if(session!=null && session.getAttribute("user")!=null) {				
					response.sendRedirect(request.getContextPath()+"index.jsp");				
				
			}
			//顯示登入頁
			request.getRequestDispatcher(LoginPath).forward(request, response);
			
		}else if (request.getServletPath().equals("/logout")) {//登出
			request.getSession().invalidate();
			response.sendRedirect(request.getContextPath()+"/login");
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 從登入頁面 透過POST送出登入請求
		request.setCharacterEncoding("UTF-8");	
		response.setContentType("UTF-8");	
		String loginAccount = request.getParameter("loginAccount");
		String loginPassword = request.getParameter("loginPassword");
		
		MemberBean accPassBean = new MemberBean(loginAccount, loginPassword);
		
		boolean CheckLogBoolean = loginService.checkLogin(accPassBean);

		// 如果帳號密碼驗證為真
		if(CheckLogBoolean) {   
			// 找是否有存在的Session
			if(request.getSession(false)!=null) {
				request.changeSessionId();	
			}
			// 取得session
			request.getSession().setAttribute("login", loginAccount);  //login token，傳到其他頁面，用以標示這個帳戶已登入
			System.out.println(request.getParameter("path"));
			if(request.getParameter("path")!=null) {
				response.sendRedirect(request.getContextPath()+request.getParameter("path"));									
			}else {
				response.sendRedirect(request.getContextPath()+"/index.jsp");					
			}
			
		}else {
			request.setAttribute("error", "帳號或密碼錯誤");
			request.getRequestDispatcher(LoginPath).forward(request, response);
		}
		
		
	}

}

	
	
	
	
	


