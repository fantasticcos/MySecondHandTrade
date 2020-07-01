package com.two;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ValidateServlet
 */
@WebServlet("/ValidateServlet")
public class ValidateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private int width=60;
	private  int height=20;
	private int codeCount=4;
	private int x=0;
	private int fontHeight;
	private int codeY;
	char [] codeSequence= {'a','b','c','d','e','f','g','h','y','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z',
			'A','B','C','D','E','F','G','H','Y','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z','1','2','3','4','5','6','7','8','9','0'};
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ValidateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Random random=new Random();
		
		x=width/(codeCount+1);
		fontHeight=height-2;
		codeY=height-4;
		
		BufferedImage bufflmg = new BufferedImage(width,height,BufferedImage.TYPE_INT_RGB);
		Graphics2D g = bufflmg.createGraphics();
		// ��ͼ�����Ϊ��ɫ
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, width, height);
		//�������壬����Ĵ�СӦ�ø���ͼƬ�ĸ߶�����
		Font font = new Font("Fixedsys", Font.PLAIN, fontHeight);
		// ��������
		g.setFont(font);
		// ���߿�
		g.setColor(Color.BLACK);
		g.drawRect(0, 0, width- 1, height - 1);
		// �������8�������ߣ�ʹͼ���е���֤�벻�ױ���������̽�⵽
		
		
		g.setColor(Color.BLACK);
		for (int i=0;i<8; i++){
			int x = random.nextInt(width);
			int y = random.nextInt(height);
			int xl = random.nextInt(8); 
			int yl = random.nextInt(8);
			g.drawLine(x, y,x+ xl,y + yl); 
		}
		//2�����������
		StringBuffer randomCode = new StringBuffer();
		int red= 0, green=0, blue = 0;
		//�������codeCount�����ֵ���֤��
		for (int i=0; i < codeCount; i++){
		//�õ������������֤������
		String strRand = String.valueOf(codeSequence[random.nextInt(54)]);
		//�����������ɫ������������ɫֵ�����������ÿλ���ֵ���ɫֵ������ͬ
		red = random.nextInt(255);
		green = random.nextInt(255);
		blue = random.nextInt(255);
		//�������������ɫ����֤����Ƶ�ͼ����
		g.setColor(new Color(red, green, blue));
		g.drawString(strRand, (i+ 1)* x, codeY); 
		//���������ĸ�����������- - ��
		randomCode .append(strRand);
		}
		//3�������������session��
		HttpSession session = request.getSession();
		session.setAttribute("validateCode", randomCode.toString());
		//4�����ͼƬ����ֹͼ�񻺴�
		response.setHeader("Pragma", "no-cache" );
		response.setHeader("Cache-Control", "no-cache");
		response.setDateHeader("Expires", 0);
		response.setContentType("image/jpeg");
		ServletOutputStream out=response.getOutputStream();
		ImageIO.write(bufflmg, "jpeg", out);
		out.flush();
		out.close();

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
