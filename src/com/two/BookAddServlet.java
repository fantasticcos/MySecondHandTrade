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
				//��Part�����ͷ����Ϣ�л���ϴ��ļ���
				String header = file.getHeader("content-disposition");
				//���ϴ��ļ����з�����ļ�����չ��
				String filename =((header.split(";")[2]).split("=")[1]).replaceAll("\"", "");
				String extname = filename.substring(filename.lastIndexOf('.'));
				//�����µ��ļ���
				String newfilename = "pic"+acc+extname;
				//�����ϴ��ĵ�ַ
				String uploadpath = getServletContext().getRealPath("/img");
				System.out.println("getServletContext().getRealPath:    "+uploadpath);
				String uploadpath2="D:\\CodeBase2.0\\TwoHand\\WebContent\\img";
				PrintWriter out=response.getWriter();
				//����ϴ�
				try{
					file.write(uploadpath2+File.separator+newfilename);
					
					
				}catch (IOException e) {
					e.printStackTrace();
				}
//				FileInputStream inputStream=null;       //�����ֽ�������
//				FileOutputStream outputStream=null;   	//�����ֽ������
//				try {
//					inputStream=new FileInputStream(uploadpath2+File.separator+newfilename);	//ָ���ֽ�������Ҫ��ȡ���ļ�
//					outputStream=new FileOutputStream(uploadpath+File.separator+newfilename);	//ָ��������ɺ��ļ�����λ�ü�����
//					int len=0;	//����һ��������������ʾ��ȡ�����ֽ���
//					byte [] buf=new byte[1024];	//�����ֽ����飬�����洢�������ֽ�
//					while((len=inputStream.read(buf))!=-1) {	//ѭ����ȡ���������ļ�ĩβʱ�������¶����ȡ�����ļ�����ʱread�����᷵��-1����ʾ����û�����ݣ��Ѿ����ꣻ		
//						outputStream.write(buf, 0, len);	//���ļ��������write������ʼ����д��buf��ʾ���ֽ�����byteд����0��ʾ������ĵ�0��λ�ÿ�ʼд��len��ʾд�����ٸ�
//					}
//					System.err.println("���Ƴɹ�");
//				} catch (Exception e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//				finally {
//					try {
//						inputStream.close();	//�ر�������
//					} catch (IOException e1) {
//						// TODO Auto-generated catch block
//						e1.printStackTrace();
//					}
//					if(outputStream!=null) {	//�ж���������Ƿ�գ���Ϊ�յĻ�ˢ�����
//						try {
//							outputStream.flush();
//						} catch (IOException e) {
//							// TODO Auto-generated catch block
//							e.printStackTrace();
//						}
//					}
//					try {
//						outputStream.close();	//�ر������
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
				//���������ļ�����SqlSessionFactory
				SqlSessionFactory ssf = new SqlSessionFactoryBuilder().build(config);
				//ͨ��SqlSessionFactory����SqlSession
				SqlSession s = ssf.openSession();
				s.insert("mapper.UserMapper.adduser", u);
				s.commit();
				s.close();
				
				response.sendRedirect("Login.jsp");
	}

}
