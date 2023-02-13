package a.b.c.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import a.b.c.dao.MemberDao;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
@Data
//@RequiredArgsConstructor : @NonNull or final 필드값을 이용해 생성자 생성
@Service //IoC에 등록
public class MemberMM {

	@Autowired
	private /*@NonNull*/ final  MemberDao mDao;
			
	public boolean access(Map<String, String> mb) {
		return mDao.access(mb);
	}
	
}
