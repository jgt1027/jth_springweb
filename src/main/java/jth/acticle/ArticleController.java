package jth.acticle;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class ArticleController {

	@Autowired
	ArticleDao articleDao;
	
	static final Logger logger = LogManager.getLogger();
	
	@RequestMapping("/list")
	public String main() {
		return "list";
	}
	
	@GetMapping("/register/write")
	public void write() {
		logger.info("get write");
	}

	@PostMapping("/register/write")
	public void add(Article article) {
		}
	
	@PostMapping("/register/writ")
	public String finsh(Article article) {
		articleDao.insert(article);
		logger.info("post write ");
		return "/register/writ";
		}
	
	
	
	@GetMapping("/register/read")
	public String read(@RequestParam int articleId,Model model) {
		Article article = articleDao.getArticle(articleId);
		model.addAttribute("article",article);
				return "/register/read";
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