package com.steve.boot.launch.service;

import com.github.dozermapper.core.Mapper;
import com.steve.boot.launch.dao.mapper.Article;
import com.steve.boot.launch.dao.mapper.ArticleMapper;
import com.steve.boot.launch.model.ArticleVO;
import com.steve.boot.launch.utils.DozerUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Service
public class ArticleServiceImpl implements ArticleService{

    @Resource
    ArticleMapper articleMapper;

    @Resource
    private Mapper dozerMapper;

    public static final String CACHE_OBJECT = "article";  //缓存名称
    public static final String CACHE_LIST_KEY  = "\"list\"";
    @CacheEvict(value = CACHE_OBJECT,key = CACHE_LIST_KEY)   //删除List集合缓存
    @Override
    public void saveArticle(ArticleVO articleVO) {
        Article article = dozerMapper.map(articleVO, Article.class);
        article.setCreateTime(new Date());
        article.setUpdateTime(new Date());
        articleMapper.saveArticle(article);
    }
    @Caching(evict = {
            @CacheEvict(value = CACHE_OBJECT,key = CACHE_LIST_KEY),   //删除List集合缓存
            @CacheEvict(value = CACHE_OBJECT,key = "#id")  //删除单条记录缓存
    })
    @Override
    public void deleteArticle(Long id) {
        Assert.notNull(id,"sorry,this article does not exist or may have been deleted,the deleting is not available.");
        articleMapper.deleteArticle(id);
    }
    @Caching(evict = {
            @CacheEvict(value = CACHE_OBJECT,key = CACHE_LIST_KEY),   //删除List集合缓存
            @CacheEvict(value = CACHE_OBJECT,key = "#articleVO.getId()")  //删除单条记录缓存
    })
//    @CachePut(value = CACHE_OBJECT,key = "#article.getId()")
//    @CacheEvict(value = CACHE_OBJECT,key = CACHE_LIST_KEY)
    @Override
    public void updateArticle(ArticleVO articleVO) {
        Article article = articleMapper.getArticle(articleVO.getId());
        Assert.notNull(article,"sorry,this article does not exist or may have been deleted,the updating is not available.");
        Article a = new Article();
        //dozerMapper.map(source, destination);
        dozerMapper.map(article, a);
        BeanUtils.copyProperties(articleVO, a, "createTime");
        a.setUpdateTime(new Date());
        a.setUpdateTime(new Date());
        articleMapper.updateArticle(a);
    }
    @Cacheable(value=CACHE_OBJECT, key = "#id", sync = true)
    @Override
    public ArticleVO getArticle(Long id) {
        Article article = articleMapper.getArticle(id);
        if(article != null) {
            return dozerMapper.map(article, ArticleVO.class);
        }else {
            return null;
        }
    }
    @Cacheable(value = CACHE_OBJECT,key = CACHE_LIST_KEY, sync = true)
    @Override
    public List<ArticleVO> getAll() {
        List<Article> articles = articleMapper.getAll();
        return DozerUtils.mapList(articles, ArticleVO.class);
    }
}
