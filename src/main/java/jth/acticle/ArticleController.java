package jth.acticle;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;

import jth.chap11.Member;



@Controller
public class ArticleController {

	@Autowired
	ArticleDao articleDao;
	
	Logger logger = LogManager.getLogger();
	
	@RequestMapping("/list")
	public String main() {
		return "list";
	}
	
	@GetMapping("/article/write")
	public String write(@SessionAttribute("MEMBER") Member member) {
		logger.info("get write");
		
		return "article/write";
	}
	
	@GetMapping("/article/delete")
	public String delete2(@RequestParam("articleId") String articleId,Model model
			,@SessionAttribute("MEMBER") Member member) {
		Article article = articleDao.getArticle(articleId);
		if(!member.getMemberId().equals(article.getUserId()))
			return "redirect:/app/article/read?articleId="+articleId;
		
		articleDao.delete(article);
		return "article/delete";
	}
	@PostMapping("/article/writ")
	public String finsh(Article article,
		@SessionAttribute("MEMBER") Member member) {
	
		article.setUserId(member.getMemberId());
		article.setName(member.getName());
		articleDao.insert(article);
		return "article/writ";
		}
	@GetMapping("/article/update")
	public String up(@RequestParam ("articleId")String articleId,Model model,
			@SessionAttribute("MEMBER") Member member) {
	
		Article article = articleDao.getArticle(articleId);
		if(!member.getMemberId().equals(article.getUserId()))
			
			return "redirect:/app/article/read?articleId="+articleId;
		
		model.addAttribute("article",article);
		
		return "article/update";
	}
	@PostMapping("/article/update2")
	public String updat(Article article,@RequestParam("articleId") String articleId,
			@SessionAttribute("MEMBER") Member member) {
		article.setArticleId(articleId);
		articleDao.update(article);
		return "/article/update2";
	}


	@GetMapping("/article/read")
	public String read(@RequestParam String articleId,Model model) {
		Article article = articleDao.getArticle(articleId);
		model.addAttribute("article",article);
				return "/article/read";
		}

	@GetMapping("/list")
	public String list(
			@RequestParam(value = "page", defaultValue = "1") int page,
			Model model) {
		final int COUNT = 100;
		int offset = (page - 1) * COUNT;

		List<Article> articleList = articleDao.selectAll(offset, COUNT);

		int totalCount = articleDao.countAll();

		model.addAttribute("totalCount", totalCount);
		model.addAttribute("aritcle", articleList);
		return "list";
	}
}