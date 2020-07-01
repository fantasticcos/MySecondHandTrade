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

/**
 * Servlet implementation class deleteGood
 */
@WebServlet("/deleteGood")
public class deleteGood extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public deleteGood() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/plain;charset=utf-8");
		String No=request.getParameter("No");
		String res="删除成功";
		
		InputStream config = Resources.getResourceAsStream("mybatis-config.xml");
		//根据配置文件构建SqlSessionFactory
		SqlSessionFactory ssf = new SqlSessionFactoryBuilder().build(config);
		//通过SqlSessionFactory创建SqlSession
		SqlSession ss = ssf.openSession();
		try {
		ss.delete("mapper.UserMapper.deletegood", No);
		ss.delete("mapper.UserMapper.deletedis", No);
		ss.delete("mapper.UserMapper.deletecom", No);
		ss.commit();
		ss.close();
		}catch(Exception e)
		{
			res="删除异常";
		}
		response.getWriter().write(res);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
