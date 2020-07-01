package com.two;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.two.body.Comments;
import com.two.body.Goods;
import com.two.body.User;

/**
 * Servlet implementation class getcomment
 */
@WebServlet("/getcomment")
public class getcomment extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public getcomment() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		InputStream config = Resources.getResourceAsStream("mybatis-config.xml");
		//根据配置文件构建SqlSessionFactory
		SqlSessionFactory ssf = new SqlSessionFactoryBuilder().build(config);
		//通过SqlSessionFactory创建SqlSession
		SqlSession ss = ssf.openSession();
		request.setCharacterEncoding("utf-8");
		response.setContentType("application/json;charset=utf-8");
		String no=request.getParameter("No");
		List<Comments> list=ss.selectList("mapper.UserMapper.getcomments", no);
		StringBuffer sb=new StringBuffer();
		sb.append("{  'result' :[");
		for(Comments c :list)
		{
			System.out.println("comments");
			sb.append("{");
			sb.append("'ID':"+"'"+c.getID()+"',");
			sb.append(" 'time':"+"'"+c.getTime()+"',");
			sb.append(" 'content':"+"'"+c.getContent()+"'");
			sb.append("},");
		}
		sb.append("{} ] }");
		response.getWriter().write(sb.toString());
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		BufferedReader reader=request.getReader();
		char [] buff=new char [512];
		StringBuffer sb=new StringBuffer();
		int len;
		while((len=reader.read(buff))!=-1)
		{
			sb.append(buff,0,len);
		}
		reader.close();
		String [] get=sb.toString().split("a");
		com.two.body.User user=(User) request.getSession().getAttribute("user");
		Comments com=new Comments();
		com.setID(user.getID());
		com.setNo(get[0]);
		com.setContent(get[1]);
		java.util.Date t=new java.util.Date();
		com.setTime(new java.sql.Date(t.getTime()));
		
		
		InputStream config = Resources.getResourceAsStream("mybatis-config.xml");
		//根据配置文件构建SqlSessionFactory
		SqlSessionFactory ssf = new SqlSessionFactoryBuilder().build(config);
		//通过SqlSessionFactory创建SqlSession
		SqlSession ss = ssf.openSession();
		
		ss.insert("mapper.UserMapper.addcomment", com);
		System.out.println("插入错误?");
		ss.commit();
		ss.close();
	}

}
