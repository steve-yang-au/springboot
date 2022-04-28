package com.steve.boot.launch.service;

import com.github.dozermapper.core.Mapper;
import com.steve.boot.launch.dao.db1.Article;
import com.steve.boot.launch.dao.db1.ArticleRepository;
import com.steve.boot.launch.dao.db2.Message;
import com.steve.boot.launch.dao.db2.MessageRepository;
import com.steve.boot.launch.model.ArticleVO;
import com.steve.boot.launch.utils.DozerUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ArticleJPAServiceImpl implements ArticleService{

    @Resource
    private ArticleRepository articleRepository;

    @Resource
    private MessageRepository messageRepository;

    @Resource
    private Mapper dozerMapper;

    @Override
    public void saveArticle(ArticleVO articleVO) {
        Article article = dozerMapper.map(articleVO, Article.class);
        articleRepository.save(article);
        messageRepository.save(new Message(1L,"Steve","12", null,null));
        //int a= 1/0;
    }

    @Override
    public void deleteArticle(Long id) {
        if(id == null){
            //TODO throw a exception
        }
        articleRepository.deleteById(id);
    }

    @Override
    public void updateArticle(ArticleVO articleVO) {
        Optional<Article> article = articleRepository.findById(articleVO.getId());
        if(!article.isPresent()) {
            //TODO throw custom exception
        }
        Article a = new Article();
        //dozerMapper.map(source, destination);
        dozerMapper.map(article.get(), a);
        BeanUtils.copyProperties(articleVO, a, "createTime");
        articleRepository.save(a);
    }

    @Override
    public ArticleVO getArticle(Long id) {
        Optional<Article> article = articleRepository.findById(id);
        if(article.isPresent()) {
            return dozerMapper.map(article.get(), ArticleVO.class);
        }else {
            return null;
        }
    }

    @Override
    public List<ArticleVO> getAll() {
        List<Article> articles = articleRepository.findAll();
        return DozerUtils.mapList(articles, ArticleVO.class);
    }
}
