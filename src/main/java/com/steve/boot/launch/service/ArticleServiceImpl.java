package com.steve.boot.launch.service;

import com.github.dozermapper.core.Mapper;
import com.steve.boot.launch.exception.CustomException;
import com.steve.boot.launch.exception.CustomExceptionType;
import com.steve.boot.launch.mapper.Article;
import com.steve.boot.launch.mapper.ArticleMapper;
import com.steve.boot.launch.model.ArticleVO;
import com.steve.boot.launch.utils.DozerUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Service
public class ArticleServiceImpl implements ArticleService{

    @Resource
    ArticleMapper articleMapper;

    @Resource
    private Mapper dozerMapper;


    @Override
    public void saveArticle(ArticleVO articleVO) {
        Article article = dozerMapper.map(articleVO, Article.class);
        article.setCreateTime(new Date());
        articleMapper.saveArticle(article);
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
            throw new CustomException(CustomExceptionType.USER_INPUT_ERROR, "there is no article id for update");
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
