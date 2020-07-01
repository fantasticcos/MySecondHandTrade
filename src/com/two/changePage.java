package com.two;

import java.io.IOException;
import java.io.InputStream;
import java.net.URLDecoder;
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

import com.two.body.Goods;
import com.two.body.Page;

/**
 * Servlet implementation class changePage
 */
@WebServlet("/changePage")
public class changePage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public changePage() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("application/json;charset=utf-8");
		InputStream config = Resources.getResourceAsStream("mybatis-config.xml");
		//根据配置文件构建SqlSessionFactory
		SqlSessionFactory ssf = new SqlSessionFactoryBuilder().build(config);
		//通过SqlSessionFactory创建SqlSession
		SqlSession ss = ssf.openSession();
		
		int p=Integer.parseInt(request.getParameter("page"));
		String type=request.getParameter("type");
		String search=request.getParameter("search");
		search=URLDecoder.decode(request.getQueryString().split("&")[2].substring(7), "utf-8");
		System.out.println("第几页："+p);
		int pnum=ss.selectOne("mapper.UserMapper.getPageNum");
		List<Goods> goods=null;
		if(search==null||search.equals(""))
			 goods=ss.selectList("mapper.UserMapper.freshtypePage", new Page(p,type));
		else
			 goods=ss.selectList("mapper.UserMapper.findgoods", new Page(p,search,1));
		
		System.out.println("search="+search);
		StringBuffer sb=new StringBuffer();
		sb.append("{ 'page':'"+pnum+"','result' :[");
		for(Goods g :goods)
		{
			System.out.println("yes");
			sb.append("{");
			sb.append("'No':"+"'"+g.getNo()+"',");
			sb.append(" 'type':"+"'"+g.getType()+"',");
			sb.append(" 'name':"+"'"+g.getName()+"',");
			sb.append("'price':"+"'"+g.getPrice()+"',");
			sb.append(" 'desc':"+"'"+g.getDesc()+"',");
			sb.append(" 'comments':"+"'"+g.getComments()+"',");
			sb.append(" 'pic':"+"'"+g.getPic()+"'");
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
		doGet(request, response);
	}

}
