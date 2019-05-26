package jth.acticle;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository("articleDao")
public class ArticleDaoIp implements ArticleDao {


	static final String INSERT = "INSERT article(title, content, userId, name) VALUES (?,?,?,?)";
	static final String SELECT_ALL="SELECT  articleId, title,userId, name, content, udate FROM article ORDER BY articleId desc LIMIT ?,?";
	static final String COUNT_ALL="SELECT count(articleId) count FROM article";
	static final String GET_ARTICLE = "SELECT articleId,userId ,title, content, name, udate FROM article WHERE articleId = ?";
	static final String DELETE ="delete from article where articleId=?";
	static final String UPDATE = "update article set title=?, content=? where articleId=?";
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	final RowMapper<Article> articleRowMapper = new BeanPropertyRowMapper<>(Article.class);
	

	@Override
	public List<Article> selectAll(int offset, int count) {
		// TODO Auto-generated method stub
		return jdbcTemplate.query(SELECT_ALL, articleRowMapper, offset, count);
		
	}

	@Override
	public Article getArticle(String articleId) {
		// TODO Auto-generated method stub
		return jdbcTemplate.queryForObject(GET_ARTICLE,
				articleRowMapper, articleId);
	}

	@Override
	public void insert(Article article) {
		jdbcTemplate.update(INSERT, article.getTitle(),
				article.getContent(), article.getUserId(), article.getName());
		}
	

	@Override
	public void delete(Article article) {
		// TODO Auto-generated method stub
		jdbcTemplate.update(DELETE,article.getArticleId());
		
	}

	@Override
	public void update(Article article) {
		// TODO Auto-generated method stub
		jdbcTemplate.update(UPDATE, article.getTitle(),article.getContent(),article.getArticleId());
	}

	@Override
	public int countAll() {
		// TODO Auto-generated method stub
		return jdbcTemplate.queryForObject(COUNT_ALL,Integer.class);
	}

}
