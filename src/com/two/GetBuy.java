package com.two;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.two.body.Goods;
import com.two.body.trades;

public class GetBuy {
	int num=0;
	public int getnum(String no) throws IOException
	{
		//读取配置文件mybatis-config.xml
		InputStream config = Resources.getResourceAsStream("mybatis-config.xml");
		//根据配置文件构建SqlSessionFactory
		SqlSessionFactory ssf = new SqlSessionFactoryBuilder().build(config);
		//通过SqlSessionFactory创建SqlSession
		SqlSession ss = ssf.openSession();
		num=ss.selectOne("mapper.UserMapper.getbuynum", no);
		return this.num;
	}
	public int getcomnum(String no) throws IOException
	{
		InputStream config = Resources.getResourceAsStream("mybatis-config.xml");
		//根据配置文件构建SqlSessionFactory
		SqlSessionFactory ssf = new SqlSessionFactoryBuilder().build(config);
		//通过SqlSessionFactory创建SqlSession
		SqlSession ss = ssf.openSession();
		int n=ss.selectOne("mapper.UserMapper.getcomnum", no);
		System.out.println(n);
		return n;
	}
	public int getbbuynum(String no) throws IOException
	{
		InputStream config = Resources.getResourceAsStream("mybatis-config.xml");
		//根据配置文件构建SqlSessionFactory
		SqlSessionFactory ssf = new SqlSessionFactoryBuilder().build(config);
		//通过SqlSessionFactory创建SqlSession
		SqlSession ss = ssf.openSession();
		int n=ss.selectOne("mapper.UserMapper.getsinglebnum", no);
		return n;
	}
	public int getdisnum(String no) throws IOException
	{
		InputStream config = Resources.getResourceAsStream("mybatis-config.xml");
		//根据配置文件构建SqlSessionFactory
		SqlSessionFactory ssf = new SqlSessionFactoryBuilder().build(config);
		//通过SqlSessionFactory创建SqlSession
		SqlSession ss = ssf.openSession();
		int n=ss.selectOne("mapper.UserMapper.getdisnum", no);
		return n;
	}
	
	public List<trades> getbuyed(String no) throws IOException
	{
		//读取配置文件mybatis-config.xml
		InputStream config = Resources.getResourceAsStream("mybatis-config.xml");
		//根据配置文件构建SqlSessionFactory
		SqlSessionFactory ssf = new SqlSessionFactoryBuilder().build(config);
		//通过SqlSessionFactory创建SqlSession
		SqlSession ss = ssf.openSession();
		List<trades> list=null;
		list=ss.selectList("mapper.UserMapper.buyedlist", no);
		return list ;
	}
	public List<com.two.body.distribute> getdis(String ID) throws IOException
	{
		//读取配置文件mybatis-config.xml
				InputStream config = Resources.getResourceAsStream("mybatis-config.xml");
				//根据配置文件构建SqlSessionFactory
				SqlSessionFactory ssf = new SqlSessionFactoryBuilder().build(config);
				//通过SqlSessionFactory创建SqlSession
				SqlSession ss = ssf.openSession();
				List<com.two.body.distribute> list=null;
				list=ss.selectList("mapper.UserMapper.getdis", ID);
				return list;
	}
	public Goods reflectGoods(String No) throws IOException
	{
		InputStream config = Resources.getResourceAsStream("mybatis-config.xml");
		//根据配置文件构建SqlSessionFactory
		SqlSessionFactory ssf = new SqlSessionFactoryBuilder().build(config);
		//通过SqlSessionFactory创建SqlSession
		SqlSession ss = ssf.openSession();
		Goods g=null;
		g=ss.selectOne("mapper.UserMapper.getmoreinfo", No);
		return g;
	}
}
