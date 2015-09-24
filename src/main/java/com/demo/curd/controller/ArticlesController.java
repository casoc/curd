package com.demo.curd.controller;

import com.demo.curd.entity.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Map;

import static org.springframework.web.bind.annotation.RequestMethod.*;

@Controller
public class ArticlesController {

    @Autowired
    private HibernateTemplate hibernateTemplate;

    @RequestMapping(value = "/articles", method = GET)
    public String index(Map<String, List<Article>> map) {
        List<Article> list = hibernateTemplate.find("from Article article");
        map.put("articles", list);
        return "website/index";
    }

    @RequestMapping(value = "/articles/new", method = GET)
    public String newArticle(Map<String, Article> map) {
        map.put("article", new Article());
        return "website/new";
    }

    @RequestMapping(value = "/articles", method = POST)
    public String create(Map<String, List<Article>> map, Article article) {
        hibernateTemplate.save(article);
        return index(map);
    }

    @RequestMapping(value = "/article/{id}/edit", method = GET)
    public String edit(Map<String, Article> map, @PathVariable Integer id) {
        Article article = hibernateTemplate.get(Article.class, id);
        map.put("article", article);
        return "website/edit";
    }

    @RequestMapping(value = "/articles", method = PUT)
    public String update(Map<String, List<Article>> map, Article article) {
        hibernateTemplate.saveOrUpdate(article);
        return index(map);
    }

    @RequestMapping(value = "/article/{id}/delete", method = GET)
    public String delete(Map<String, List<Article>> map, @PathVariable Integer id) {
        List<Article> list = hibernateTemplate.find("from Article artile where artile.id=?", id);
        hibernateTemplate.delete(list.get(0));
        return index(map);
    }

    public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
        this.hibernateTemplate = hibernateTemplate;
    }
}
