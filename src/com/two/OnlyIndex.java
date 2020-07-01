package com.two;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.two.body.User;

/**
 * Servlet Filter implementation class OnlyIndex
 */
@WebFilter(filterName="/OnlyIndex", urlPatterns= {"/hadbuyed.jsp","/haddistried.jsp","/showCart.jsp","/distrubute.jsp","/AddCart"}, initParams= {@WebInitParam(name="backurl",value="error.jsp")})
public class OnlyIndex implements Filter {
	String backUrl;
    /**
     * Default constructor. 
     */
    public OnlyIndex() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here
		HttpServletRequest httpRequest=(HttpServletRequest)request;
		HttpServletResponse httpResponse=(HttpServletResponse)response;
		//获取Session对象
		HttpSession session = httpRequest.getSession();
		User u=(User)session.getAttribute("user");
		// pass the request along the filter chain
		if(u!=null)
		chain.doFilter(request, response);
		else
			httpResponse. sendRedirect(backUrl);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		System.out.println("shemehuishi");
		if(fConfig.getInitParameter("backurl")!=null)
		{
		backUrl = fConfig.getInitParameter("backurl");
		}
		else
		backUrl = "error.jsp";
	}

}
