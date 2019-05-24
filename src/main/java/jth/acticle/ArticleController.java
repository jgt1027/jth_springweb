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

	
	@PostMapping("/article/writ")
	public String finsh(Article article,
			@SessionAttribute("MEMBER") Member member) {
	
		article.setUserId(member.getMemberId());
		article.setName(member.getName());
		articleDao.insert(article);
		return "article/writ";
		}
	
	
	
	@GetMapping("/article/read")
	public String read(@RequestParam int articleId,Model model) {
		Article article = articleDao.getArticle(articleId);
		model.addAttribute("article",article);
				return "article/read";
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