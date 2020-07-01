package com.two;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.HashMap;

import javax.servlet.ServletConfig;
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

import com.two.body.User;


/**
 * Servlet implementation class BookAddServlet
 */
@WebServlet("/BookAddServlet")
@MultipartConfig
public class BookAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private ServletConfig config;
    /**
     * @see HttpServlet#HttpServlet()
     */
    
    public BookAddServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=UTF-8");
				String acc=request.getParameter("acc");
				String acc2=request.getParameter("2acc");
				String pwd=request.getParameter("pwd");
				System.out.print(acc);
				Part file = request.getPart("pic");
				Part file2 = request.getPart("pic");
				//从Part对象的头部信息中获得上传文件名
				String header = file.getHeader("content-disposition");
				//从上传文件名中分离出文件的扩展名
				String filename =((header.split(";")[2]).split("=")[1]).replaceAll("\"", "");
				String extname = filename.substring(filename.lastIndexOf('.'));
				//构造新的文件名
				String newfilename = "pic"+acc+extname;
				//设置上传的地址
				String uploadpath = getServletContext().getRealPath("/img");
				System.out.println("getServletContext().getRealPath:    "+uploadpath);
				String uploadpath2="D:\\CodeBase2.0\\TwoHand\\WebContent\\img";
				PrintWriter out=response.getWriter();
				//完成上传
				try{
					file.write(uploadpath2+File.separator+newfilename);
					
					
				}catch (IOException e) {
					e.printStackTrace();
				}
//				FileInputStream inputStream=null;       //创建字节输入流
//				FileOutputStream outputStream=null;   	//创建字节输出流
//				try {
//					inputStream=new FileInputStream(uploadpath2+File.separator+newfilename);	//指定字节输入流要读取的文件
//					outputStream=new FileOutputStream(uploadpath+File.separator+newfilename);	//指定复制完成后文件所在位置及名称
//					int len=0;	//定义一个变量，用来表示读取到的字节数
//					byte [] buf=new byte[1024];	//定义字节数组，用来存储读到的字节
//					while((len=inputStream.read(buf))!=-1) {	//循环读取，当读到文件末尾时，再往下读会读取不到文件，这时read方法会返回-1，表示后面没有内容，已经读完；		
//						outputStream.write(buf, 0, len);	//用文件输出流的write方法开始往外写，buf表示将字节数组byte写出，0表示从数组的第0个位置开始写，len表示写出多少个
//					}
//					System.err.println("复制成功");
//				} catch (Exception e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//				finally {
//					try {
//						inputStream.close();	//关闭输入流
//					} catch (IOException e1) {
//						// TODO Auto-generated catch block
//						e1.printStackTrace();
//					}
//					if(outputStream!=null) {	//判断输出流中是否空，不为空的话刷新清空
//						try {
//							outputStream.flush();
//						} catch (IOException e) {
//							// TODO Auto-generated catch block
//							e.printStackTrace();
//						}
//					}
//					try {
//						outputStream.close();	//关闭输出流
//					} catch (IOException e) {
//						// TODO Auto-generated catch block
//						e.printStackTrace();
//					}
//				}
			


				User u=new User();
				u.setAcc(acc2);
				u.setID(acc);
				u.setPic("img/"+newfilename);
				u.setPassword(pwd);
				
				InputStream config = Resources.getResourceAsStream("mybatis-config.xml");
				//根据配置文件构建SqlSessionFactory
				SqlSessionFactory ssf = new SqlSessionFactoryBuilder().build(config);
				//通过SqlSessionFactory创建SqlSession
				SqlSession s = ssf.openSession();
				s.insert("mapper.UserMapper.adduser", u);
				s.commit();
				s.close();
				
				response.sendRedirect("Login.jsp");
	}

}
