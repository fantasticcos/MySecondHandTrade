package com.two;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.two.body.Goods;

/**
 * Servlet implementation class AddCart
 */
@WebServlet("/AddCart")
public class AddCart extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddCart() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String No=request.getParameter("No");
		HttpSession session=request.getSession();
		
		InputStream config = Resources.getResourceAsStream("mybatis-config.xml");
		//根据配置文件构建SqlSessionFactory
		SqlSessionFactory ssf = new SqlSessionFactoryBuilder().build(config);
		//通过SqlSessionFactory创建SqlSession
		SqlSession ss = ssf.openSession();
		Goods gd=(Goods)ss.selectOne("mapper.UserMapper.getmoreinfo", No);
		if(session.getAttribute("cartlist")==null)
		{
			ArrayList<Goods> list=new ArrayList<Goods>();
			list.add(gd);
			session.setAttribute("cartlist", list);
		}
		else
		{
			ArrayList<Goods> list=(ArrayList<Goods>) session.getAttribute("cartlist");
			if(!list.contains(gd))
			{
				list.add(gd);
			}
			session.setAttribute("cartlist", list);
		}
		System.out.println("确认运行此处");
		request.setAttribute("good", gd);
		request.getRequestDispatcher("detail.jsp").forward(request,response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
