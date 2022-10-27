package namoo.springjpa.controller.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import lombok.extern.slf4j.Slf4j;
import namoo.springjpa.entity.user.User;
import namoo.springjpa.repository.user.SpringDataJpaUserRepository;

@Controller
@RequestMapping("/users")
public class UserController {
	
	@Autowired
	private SpringDataJpaUserRepository jpaRepository;
	
	// 회원 목록 처리
	@GetMapping
	public String list(@PageableDefault(size = 5, page = 0) Pageable pageable,
					   @RequestParam(required = false, defaultValue = "5") int pageCount,
			           @RequestParam(required = false, defaultValue = "") String value,  
			           Model model) {
		Page<User> pageResults = jpaRepository.findAllByIdContainingOrEmailContaining(value, value, pageable);
		int requestPage = pageResults.getNumber() + 1;
		// 목록별 번호
		int listNo = (requestPage - 1) / pageResults.getSize();
		// 목록별 시작번호, 끝번호 계산
		int startPage = (listNo * pageCount) + 1;
		int endPage = (listNo * pageCount) + pageCount;
		if (endPage > pageResults.getTotalPages()){
			endPage = pageResults.getTotalPages();
		}
		model.addAttribute("requestPage", requestPage);
		model.addAttribute("value", value);
		model.addAttribute("startPage", startPage);
		model.addAttribute("endPage", endPage);
		model.addAttribute("pageResults", pageResults);
		return "user/users";
	}
}

















