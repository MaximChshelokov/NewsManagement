package com.epam.dao;

import com.epam.model.News;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class NewsDaoImpl implements NewsDao {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public long save(News news) {
        sessionFactory.getCurrentSession().save(news);
        return news.getId();
    }

    @Override
    public News get(long id) {
        return sessionFactory.getCurrentSession().get(News.class, id);
    }

    @Override
    public List<News> getAll() {
        Session session = sessionFactory.getCurrentSession();
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<News> cq = cb.createQuery(News.class);
        Root<News> root = cq.from(News.class);
        cq.select(root);
        Query<News> query = session.createQuery(cq);
        return query.getResultList();
    }

    @Override
    public void update(long id, News news) {
        Session session = sessionFactory.getCurrentSession();
        News news2 = session.byId(News.class).load(id);
        news2.setTitle(news.getTitle());
        news2.setDate(news.getDate());
        news2.setBrief(news.getBrief());
        news2.setContent(news.getContent());
        session.flush();
    }

    @Override
    public void delete(long id) {
        Session session = sessionFactory.getCurrentSession();
        News news = session.byId(News.class).load(id);
        session.delete(news);
    }
}
