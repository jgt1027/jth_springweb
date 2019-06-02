package jth.Latter;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;

import jth.chap11.Member;


@Controller
public class LetterController {

	@Autowired
	LetterDao letterDao;


	@GetMapping("/letter/mailReceiver")
	public String listReceived(
			@RequestParam(value = "page", defaultValue = "1") int page,
			@SessionAttribute("MEMBER") Member member, Model model) {

		final int ROWS_PER_PAGE = 20;
		int offset = (page - 1) * ROWS_PER_PAGE;

		List<Letter> letters = letterDao.listLettersReceived(
				member.getMemberId(), offset, ROWS_PER_PAGE);
		int count = letterDao.countLettersReceived(member.getMemberId());

		model.addAttribute("letters", letters);
		model.addAttribute("count", count);
		return "/letter/mailReceiver";
	}


	@GetMapping("/letter/mailSend")
	public String listSent(
			@RequestParam(value = "page", defaultValue = "1") int page,
			@SessionAttribute("MEMBER") Member member, Model model) {


		final int ROWS_PER_PAGE = 20;
		int offset = (page - 1) * ROWS_PER_PAGE;

		List<Letter> letters = letterDao.listLettersSent(member.getMemberId(),
				offset, ROWS_PER_PAGE);
		int count = letterDao.countLettersSent(member.getMemberId());

		model.addAttribute("letters", letters);
		model.addAttribute("count", count);
		return "/letter/mailSend";
	}


	@GetMapping("/letter/mailView")
	public void view(@RequestParam("letterId") String letterId,
			@SessionAttribute("MEMBER") Member member, Model model) {


		Letter letter = letterDao.getLetter(letterId, member.getMemberId());
		model.addAttribute("letter", letter);
	}
	
	@GetMapping("/letter/mailWrite")
	public String write2(@SessionAttribute("MEMBER") Member member, Model model) {

		return "letter/mailWrite";
	}
	
	@PostMapping("/letter/mail")
	public String add(Letter letter,
			@SessionAttribute("MEMBER") Member member) {
		letter.setSenderId(member.getMemberId());
		letter.setSenderName(member.getName());
		letterDao.addLetter(letter);
		return "redirect:/app/letter/mailSend";
	}


@GetMapping("/letter/delete")
public String delete2(
		@RequestParam(value = "mode", required = false) String mode,
		@RequestParam("letterId") String letterId,
		@SessionAttribute("MEMBER") Member member) {
	
	int updatedRows = letterDao.deleteLetter(letterId,
			member.getMemberId());
	if (updatedRows == 0)
		throw new RuntimeException("No Authority!");

	if ("SENT".equals(mode))
		return "redirect:/app/letter/mailSend";
	else
		return "redirect:/app/letter/mailReceiver";
}
}