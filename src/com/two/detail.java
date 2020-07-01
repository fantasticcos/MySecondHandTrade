package com.two;

import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.two.body.Goods;

/**
 * Servlet implementation class detail
 */
@WebServlet("/detail")
public class detail extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public detail() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		InputStream config = Resources.getResourceAsStream("mybatis-config.xml");
		//���������ļ�����SqlSessionFactory
		SqlSessionFactory ssf = new SqlSessionFactoryBuilder().build(config);
		//ͨ��SqlSessionFactory����SqlSession
		SqlSession ss = ssf.openSession();
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String no=request.getParameter("No");
		
		Goods good =(Goods)ss.selectOne("mapper.UserMapper.getmoreinfo", no);
		if(good==null)
		{
			System.out.println("�Ҳ���");
			response.getWriter().write("��Ʒ�Ҳ�����");
		}
		else
		{
			request.setAttribute("good", good);
			request.getRequestDispatcher("detail.jsp").forward(request,response);
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
