package com.two.body;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import com.two.body.User;
public class MyBatisTest {
	public static void main(String[] args) throws IOException {
		
			//读取配置文件mybatis-config.xml
			InputStream config = Resources.getResourceAsStream("mybatis-config.xml");
			//根据配置文件构建SqlSessionFactory
			SqlSessionFactory ssf = new SqlSessionFactoryBuilder().build(config);
			//通过SqlSessionFactory创建SqlSession
			SqlSession ss = ssf.openSession();
			//SqlSession执行映射文件中定义的SQL，并返回映射结果
			//com.mybatis.mapper.UserMapper.selectUserById为UserMapper.xml中的命名空间+select的id
			//查询一个用户
			User u=new User();
			u.setID("hello");
			u.setPassword("22222");
			User mu = ss.selectOne("mapper.UserMapper.indentify", u);
			System.out.println(mu.getPassword());
			//添加一个用户
			
			
	}
}
