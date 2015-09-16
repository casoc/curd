package com.demo.curd.controller;

import com.demo.curd.entity.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

import static org.springframework.web.bind.annotation.RequestMethod.*;

@Controller
public class ArticlesController {

    @Autowired
    private HibernateTemplate hibernateTemplate;

    @RequestMapping(value = "/article/{id}", method = GET)
    public String show(Map<String, Article> map, @RequestParam(required = true) Integer id) {
        Article article = hibernateTemplate.get(Article.class, id);
        map.put("article", article);
        return "show";
    }

    @RequestMapping(value = "/articles", method = GET)
    public String index(Map<String, List<Article>> map) {
        List<Article> list = hibernateTemplate.find("from Article article");
        map.put("articles", list);
        return "show";
    }

    @RequestMapping(value = "/articles/new", method = GET)
    public String newArticle() {
        return "website/new";
    }

    @RequestMapping(value = "/articles", method = POST)
    public String create(Map<String, Article> map, @RequestParam Article article) {
        hibernateTemplate.save(article);
        map.put("article", article);
        return "show";
    }

    @RequestMapping(value = "/article/{id}/edit", method = GET)
    public String edit(Map<String, Article> map, @RequestParam Integer id) {
        Article article = hibernateTemplate.get(Article.class, id);
        map.put("article", article);
        return "edit";
    }

    @RequestMapping(value = "/articles", method = PUT)
    public String update(Map<String, Article> map, @RequestParam Article id) {
        return "show";
    }

    public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
        this.hibernateTemplate = hibernateTemplate;
    }
}
