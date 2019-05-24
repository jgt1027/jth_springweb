package jth.chap13;


import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;

import jth.chap11.Member;
import jth.chap11.MemberDao;

@Controller
public class MemberController {

	@Autowired
	MemberDao memberDao;

	@RequestMapping("/member/memberinfo")
	public String memberInfo(@SessionAttribute("MEMBER") Member member) {
		

		return "member/memberinfo";
	}

	@RequestMapping("/member/changePwdForm")
	public String changePwdForm(@SessionAttribute("MEMBER") Member member) {


		return "member/changePwdForm";
	}

	@PostMapping("/member/changePwd")
	public String submit(
			@RequestParam("currentPassword") String currentPassword,
			@RequestParam("newPassword") String newPassword,
			@SessionAttribute("MEMBER") Member member, Model model) {

		int updatedRows = memberDao.changePassword(member.getMemberId(),
				currentPassword, newPassword);
		if (updatedRows > 0) {
			return "member/changedPwd";
		} else {
			model.addAttribute("mode", "FAILURE");
			return "member/changePwdForm";
		}
	}
}