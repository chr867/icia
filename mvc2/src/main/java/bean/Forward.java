package bean;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

//포워딩 정보
@Getter
@Setter
@Accessors(chain = true)
public class Forward {
	//true: redirect 포워딩
	//false: dispatcher 포워딩
	
	private boolean isRedirect; //=false
	private String path; //null //뷰페이지 또는 url
	
}
