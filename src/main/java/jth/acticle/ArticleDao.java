package jth.acticle;

import java.util.List;




public interface ArticleDao {
	List<Article> selectAll(int offset, int count);

	
	Article getArticle(String articleId);
	
	
	void insert(Article article);
		
	void update(Article article);

	void delete(Article article);
	int countAll();
	
}
