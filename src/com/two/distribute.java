package com.two;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.two.body.Goods;
import com.two.body.User;

/**
 * Servlet implementation class distribute
 */
@WebServlet("/distribute")
@MultipartConfig
public class distribute extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public distribute() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=UTF-8");
		String name=request.getParameter("goods");
		String type=request.getParameter("type");
		String price=request.getParameter("price");
		String desc=request.getParameter("desc");
		Part file = request.getPart("pic");
		String acc=((User)(request.getSession().getAttribute("user"))).getAcc();
		String ID=((User)(request.getSession().getAttribute("user"))).getID();
		String header = file.getHeader("content-disposition");
		//从上传文件名中分离出文件的扩展名
		String filename =((header.split(";")[2]).split("=")[1]).replaceAll("\"", "");
		String extname = filename.substring(filename.lastIndexOf('.'));
		//构造新的文件名
		
		LocalDate ld= LocalDate.now();
		LocalTime lt=LocalTime.now();
		int year=ld.getYear();
		int month=ld.getMonthValue();
		int day=ld.getDayOfMonth();
		
		int hour=lt.getHour();
		int minut=lt.getMinute();
		
		String newfilename = year+month+day+hour+minut+ID+extname;
		String uploadpath2="D:\\CodeBase2.0\\TwoHand\\WebContent\\img";
		
		try{
			file.write(uploadpath2+File.separator+newfilename);
			
			
		}catch (IOException e) {
			e.printStackTrace();
		}
		com.two.body.distribute dis=new com.two.body.distribute();
		Goods gd=new Goods();
		dis.setAcc(acc);
		dis.setID(ID);
		dis.setNo(year+month+day+hour+minut+ID);
		dis.setTime(new Timestamp(new Date().getTime()));
		
		gd.setDesc(desc);
		gd.setName(name);
		gd.setNo(year+month+day+hour+minut+ID);
		gd.setPic("img/"+newfilename);
		gd.setPrice(Float.parseFloat(price));
		gd.setType(type);
		
		InputStream config = Resources.getResourceAsStream("mybatis-config.xml");
		//根据配置文件构建SqlSessionFactory
		SqlSessionFactory ssf = new SqlSessionFactoryBuilder().build(config);
		//通过SqlSessionFactory创建SqlSession
		SqlSession s = ssf.openSession();
		s.insert("mapper.UserMapper.addgoods", gd);
		s.insert("mapper.UserMapper.distribute", dis);
		s.commit();
		s.close();
		response.sendRedirect("haddistried.jsp");
	}

}
