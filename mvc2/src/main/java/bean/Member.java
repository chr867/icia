package bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

@AllArgsConstructor //모든 파라미터를 받는 생성자
@NoArgsConstructor // 기본생성자
@Data
@Getter
@Setter
@Accessors(chain = true)
public class Member {
	private String id; 
	private String pw; 
	private String name; 
	private String gender; 
}
