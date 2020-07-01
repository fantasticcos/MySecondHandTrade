package com.two;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashMap;

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
import com.two.body.User;
import com.two.body.trades;

/**
 * Servlet implementation class DoCarServlet
 */
@WebServlet("/DoCarServlet")
public class DoCarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DoCarServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			HttpSession session=request.getSession();
			ArrayList<Goods> list=(ArrayList<Goods>) session.getAttribute("cartlist");
			request.setCharacterEncoding("utf-8");
			String action=request.getParameter("action");
			

			if(action==null)
				action="manydelete";
			if(action.equals("add"))
			{
				String bookNo=request.getParameter("bookNo");
				String check=request.getParameter("check");
				//Book temp=(Book)books.get(bookNo);
				
				Goods gd=null;
				for(Goods t : list)
				{
					if(t.getNo().equals(bookNo))
						gd=t;
				}
				if(check!=null)
				gd.setChecked(check.equals("yes"));
				gd.setNum(gd.getNum()+1);
				session.setAttribute("cartlist", list);
				
			}
			else if(action.equals("minus"))
			{
				String bookNo=request.getParameter("bookNo");
				String check=request.getParameter("check");
				//Book temp=(Book)books.get(bookNo);
				Goods gd=null;
				for(Goods t : list)
				{
					if(t.getNo().equals(bookNo))
						gd=t;
				}
				
				if(check!=null)
				gd.setChecked(check.equals("yes"));
				if(gd.getNum()>1)
				gd.setNum(gd.getNum()-1);
				session.setAttribute("cartlist", list);
			}
			else if (action.equals("removeone"))
			{
				String bookNo=request.getParameter("bookNo");
				Goods gd=null;
				for(Goods t : list)
				{
					if(t.getNo().equals(bookNo))
						gd=t;
				}
				list.remove(gd);
				
				session.setAttribute("cartlist", list);
			}
			else if(action.equals("manydelete"))
			{
				String [] bookNos=request.getParameterValues("cartCheckBox");
				System.out.println(bookNos);
				for(int i=0;i<bookNos.length;i++)
				{
					for(Goods t : list)
					{
						if(t.getNo().equals(bookNos[i]))
							list.remove(t);
					}
				}
				
				session.setAttribute("cartlist", list);
			}
			else if(action.equals("buyselect"))
			{
				
				InputStream config = Resources.getResourceAsStream("mybatis-config.xml");
				//根据配置文件构建SqlSessionFactory
				SqlSessionFactory ssf = new SqlSessionFactoryBuilder().build(config);
				//通过SqlSessionFactory创建SqlSession
				SqlSession s = ssf.openSession();
				
				String ss=request.getParameter("No");
				String [] Nos=ss.split("a");
				User u=(User) request.getSession().getAttribute("user");
				String ID=u.getID();
				String acc=u.getAcc();
				
				LocalDate ld= LocalDate.now();
				LocalTime lt=LocalTime.now();
				int year=ld.getYear();
				int month=ld.getMonthValue();
				int day=ld.getDayOfMonth();
				
				int hour=lt.getHour();
				int minut=lt.getMinute();
				int i=0;
				for(Goods g:list)
				{
					trades t=new trades();
					t.setAcc(u.getAcc());
					t.setID(u.getID());
					t.setName(g.getName());
					t.setNo(g.getNo());
					t.setTime(new Timestamp(new java.util.Date().getTime()));
					t.setTradeNo(""+year+month+day+hour+minut+i);
					i++;
					s.insert("mapper.UserMapper.addtrades", t);
				}
				s.commit();
				s.close();
				list.clear();
				session.setAttribute("cartlist", list);
				response.setContentType("text/html; charset=UTF-8");
				PrintWriter out = response.getWriter();
				out.println("<script>alert('购买成功! ');window.location='showCart.jsp'; </script>");
			}
			response.sendRedirect("showCart.jsp");
			return;
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
	}

}
