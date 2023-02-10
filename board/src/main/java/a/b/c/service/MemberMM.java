package a.b.c.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import a.b.c.dao.MemberDao;

@Service //IoC에 등록
public class MemberMM {

	@Autowired
	private MemberDao mDao;
	
	public boolean access(Map<String, String> mb) {
		return mDao.access(mb);
	}
	
}
