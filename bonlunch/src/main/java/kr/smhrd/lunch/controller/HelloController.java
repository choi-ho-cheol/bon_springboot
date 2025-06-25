package kr.smhrd.lunch.controller;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import kr.smhrd.lunch.entity.teamMember;

// 기존 Spring -> 로직을 처리하고 결과를 반환 할 때 view 이름 : String
// @controller -> 화면을 반환할 수 있는 component
// 비동기 통신, 화면이 아니라 데이터'만' 반환 받고자 할 때
// @ResponseBody 추가

@RestController // 해당 컨트롤러는 무조건! 데이터만! 반환하는 컨트롤러다!
public class HelloController {

	// @PathVariavle : url의 경로에 포함되어 전되는 데이터를 변수에 바인딩 하기 위새
	
	// 요청 매핑을 잡을 때!
	// GerMapping("/goods/detail/{id}")
	// 매게변수를 통해 값을 가지고 올 수 있따
	// 메소드명(@Path(int id)
	
	
	@GetMapping("/Hello/{id}")
	public teamMember HelloRest(@PathVariable("id") int id) {
		
		System.out.println("전달받은 id값 : " + id);
		// 데이터를 주로 모두 JSON 객체 형태로 반환
		// 데이터를 주로 JSON 객체 형태로 반환 
		// data-bind -> 데이터를 map, 혹은 list 형태로 전환
		// JSON 객체 형태로 변환하여 화면(View)에 리턴
		
		// front와 back 개발이 완전히 분리된다.
		
		// user -> 이름, 나이, 설명
		teamMember user1 = new teamMember("최호철",27,"남");
		// ArrayList -> 팀원의 데이터를 저장
		ArrayList<teamMember> userList = new ArrayList<teamMember>();
		userList.add(user1);
		userList.add(new teamMember("유준선", 25, "남"));
		userList.add(new teamMember("유은지", 25, "여"));
		userList.add(new teamMember("최효정", 25, "여"));
		
		// @PathVariable -> url로 넘어온 인덱스에 저장된 팀원을
		// 데이터 형태로 전송 0~3까지의 숫자 중에서 들어온 숫자에 따라 
		// 해당 유저 정보를 리턴
		
		
		String result = "Hello Spring";
		
		
		
		return userList.get(id);
	}
	
	
	
	
	
	
}

