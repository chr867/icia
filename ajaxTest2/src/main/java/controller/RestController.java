package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.eclipse.jdt.internal.compiler.codegen.AnnotationTargetTypeConstants;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

@WebServlet({"/member/info","/member/list"})
public class RestController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String cmd=request.getServletPath();
		System.out.println("cmd:"+cmd);
		HashMap<String, String> hMap=new HashMap<>();
		ArrayList<HashMap<String,String>> mList=new ArrayList<>();
		String json = null;
		if(cmd.equals("/member/info")) {
			String param=request.getParameter("data");
			System.out.println(param);
			hMap=new Gson().fromJson(param, 
			new TypeToken<HashMap<String,String>>(){}.getType());
			json=new Gson().toJson(hMap);
			
//			hMap.put("id", request.getParameter("id"));
//			hMap.put("pw", request.getParameter("pw"));
//			json=new Gson().toJson(hMap);
//			System.out.println("json:"+json);
		}else if(cmd.equals("/member/list")) {
			String param=request.getParameter("arr");
			System.out.println(param);
			//fromJson; json-->자바객체
			mList=new Gson().fromJson(param, 
			new TypeToken<ArrayList<HashMap<String,String>>>(){}.getType());
			json=new Gson().toJson(mList);
		}
		
		
		if(json!=null)	response.getWriter().write(json);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

}
