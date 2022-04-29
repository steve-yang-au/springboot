package com.steve.boot.launch.service;

import com.github.dozermapper.core.Mapper;
import com.steve.boot.launch.mapper.db1.Article;
import com.steve.boot.launch.mapper.db1.ArticleMapper;
import com.steve.boot.launch.mapper.db2.Message;
import com.steve.boot.launch.mapper.db2.MessageMapper;
import com.steve.boot.launch.model.ArticleVO;
import com.steve.boot.launch.utils.DozerUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Service
public class ArticleServiceImpl implements ArticleService{

    @Resource
    ArticleMapper articleMapper;

    @Resource
    MessageMapper messageMapper;

    @Resource
    private Mapper dozerMapper;


    @Override
    @Transactional
    public void saveArticle(ArticleVO articleVO) {
        Article article = dozerMapper.map(articleVO, Article.class);
        article.setCreateTime(new Date());
        article.setUpdateTime(new Date());
        articleMapper.saveArticle(article);
        messageMapper.saveMessage(new Message(null, "ness", "condds", new Date(), new Date()));
        int i = 1/0;
    }

    @Override
    public void deleteArticle(Long id) {
        if(id == null){
            //TODO throw a exception
        }
        articleMapper.deleteArticle(id);
    }

    @Override
    public void updateArticle(ArticleVO articleVO) {
        Article article = articleMapper.getArticle(articleVO.getId());
        if(article == null) {
            //TODO throw custom exception
        }
        Article a = new Article();
        //dozerMapper.map(source, destination);
        dozerMapper.map(article, a);
        BeanUtils.copyProperties(articleVO, a, "createTime");
        a.setUpdateTime(new Date());
        a.setUpdateTime(new Date());
        articleMapper.updateArticle(a);
    }

    @Override
    public ArticleVO getArticle(Long id) {
        Article article = articleMapper.getArticle(id);
        if(article != null) {
            return dozerMapper.map(article, ArticleVO.class);
        }else {
            return null;
        }
    }

    @Override
    public List<ArticleVO> getAll() {
        List<Article> articles = articleMapper.getAll();
        return DozerUtils.mapList(articles, ArticleVO.class);
    }
}
