package a.b.c;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import a.b.c.service.MemberMM;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Data
@Controller
public class HomeController {
	@Autowired
	private MemberMM mm;
	
	@RequestMapping(value = "/access", method = RequestMethod.GET)
	public String home(Model model, @RequestParam Map<String,String> mb) {
		System.out.println(System.identityHashCode(mb));
		boolean result=mm.access(mb);
		model.addAttribute("msg",result);
		return "home";
	}
	
}
