package jth.acticle;

import java.util.List;




public interface ArticleDao {
	List<Article> selectAll(int offset, int count);

	
	Article getArticle(int articleId);
	
	
	void insert(Article article);
		
	

	int countAll();
	
}
