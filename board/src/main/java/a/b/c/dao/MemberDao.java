package a.b.c.dao;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import a.b.c.spring.MyBatis;

@Repository
public class MemberDao {

	@Autowired
	MyBatis mybatis;
	public boolean access(Map<String, String> mb) {
		mybatis.setOpen("open");
		mybatis.setOpen("close");
		System.out.println(mybatis.getOpen());
		return true;
	}
	
}
