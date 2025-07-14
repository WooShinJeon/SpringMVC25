package org.zerock.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.zerock.domain.BoardVO;
import org.zerock.service.BoardService;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Controller
@Log4j2
@RequestMapping("/board/*")
@AllArgsConstructor
public class BoardController {
	
	private BoardService service;
	
	@GetMapping("/lsit")
	public void list(Model model) {
		log.info("BoardController.list 메서드 실행......");
		
		model.addAttribute("list", service.getList());
	}
	
	@GetMapping("/register")
	public String register() {
		return "/board/register";
	}
	
	@PostMapping("/register")
	public String register(BoardVO board, RedirectAttributes rttr) {
		log.info("BoardController.register 메서드 실행......");
		service.register(board);
		rttr.addFlashAttribute("result", board.getBno());
		return "redirect:/board/list";
	}
	
	@GetMapping({"/get", "/modify"})
	public void get(@RequestParam("bno") Long bno, Model model) {
		log.info("BoardController.get 메서드 실행......");
		model.addAttribute("board", service.get(bno));
	}
	
	@PostMapping("/modify")
	public String modify(BoardVO board, RedirectAttributes rttr) {
		// 프론트에서 수정된 boardvo가 넘어오면 update쿼리가 실행되고 결과가 boolean으로 나옴
		log.info("BoardController.get 메서드 실행......");
		
		if(service.modify(board)) {
			rttr.addFlashAttribute("result", "success");
			// 성공시 프론트에 result라는 이름으로 seccess 값을 1회용으로 보낸다.
		}
		return "redirect:/board/list";
	}
	
	@PostMapping("/remove") //    http://192.168.111.104:80/board/remove
	public String remove(@RequestParam("bno") Long bno, RedirectAttributes rttr) {
		// 프론트에서 삭제할 번호가 넘어오면 delete 쿼리가 실행되고 결과가 boolean으로 나옴
		log.info("BoardController.remove 메서드 실행......");
		
		if(service.remove(bno)) {
			// 서비스에 다녀온 결과가 true면 아래 실행문을 실행한다.
			rttr.addFlashAttribute("result", "success");
		}
		return "redirect:/board/list"; // 처리후 이동 페이지
		
	}
	
}
