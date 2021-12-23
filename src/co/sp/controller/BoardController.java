package co.sp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import co.sp.beans.Page;
import co.sp.beans.Pet_event;
import co.sp.service.BoardService;

@Controller
public class BoardController {

	@Autowired
	private BoardService boardService;
	
	@GetMapping("/event/list")
	public String notice_list(@RequestParam(value = "page", defaultValue = "1") int page,
			   Model model) {
		
		List<Pet_event> eventList = boardService.allEventList(page);
		model.addAttribute("eventList", eventList);

		Page pageBean = boardService.getEventCnt(page);
		model.addAttribute("pageBean", pageBean);

		model.addAttribute("page", page);
		
		
		return "event/list";
	}
	
	@GetMapping("/event/detail")
	public String event_detail(@RequestParam("board_index") long board_index,
							@RequestParam("page") int page, Model model) {
		
		
		
		Pet_event event = boardService.getEventInfo(board_index);
		
		if(event.getEvent_img_url()!=null) {
			String [] img_url = event.getEvent_img_url().split("[|]");
			model.addAttribute("img_url", img_url);
		}else {
			model.addAttribute("img_url", "no");
		}
		
		
		
		model.addAttribute("event", event);
		model.addAttribute("page", page);
		
		return "event/detail";
	}
	
}
