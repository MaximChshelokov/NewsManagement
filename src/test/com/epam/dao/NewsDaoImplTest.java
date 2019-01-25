package com.epam.dao;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.internal.verification.VerificationModeFactory.times;

import com.epam.model.News;
import org.hibernate.IdentifierLoadAccess;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import java.util.Collections;
import java.util.List;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

public class NewsDaoImplTest {

    @Mock
    private SessionFactory sessionFactory;
    @Mock
    private Session session;

    @Rule
    public MockitoRule mockitoRule = MockitoJUnit.rule();

    private News news = new News();
    private static final long TEST_ID = 1L;
    private NewsDaoImpl dao = new NewsDaoImpl();

    @Before
    public void setUp() throws Exception {
        dao.setSessionFactory(sessionFactory);
        when(sessionFactory.getCurrentSession()).thenReturn(session);
    }

    @Test
    public void save() {
        when(session.save(news)).then(n -> {
            ((News) n.getArgument(0)).setId(TEST_ID);
            return null;});
        dao.save(news);
        verify(session, times(1)).save(news);
        assertEquals(news.getId(), TEST_ID);
    }

    @Test
    public void get() {
        when(session.get(News.class, TEST_ID)).thenReturn(news);
        News result = dao.get(TEST_ID);
        verify(session, times(1)).get(News.class, TEST_ID);
        assertEquals(result, news);
    }

    @Test
    public void getAll() {
        CriteriaBuilder cb = mock(CriteriaBuilder.class);
        CriteriaQuery<News> cq = mock(CriteriaQuery.class);
        Root<News> root = mock(Root.class);
        Query<News> query = mock(Query.class);
        when(session.getCriteriaBuilder()).thenReturn(cb);
        when(cb.createQuery(News.class)).thenReturn(cq);
        when(cq.from(News.class)).thenReturn(root);
        when(session.createQuery(cq)).thenReturn(query);
        when(query.getResultList()).thenReturn(Collections.singletonList(news));

        List<News> result = dao.getAll();
        assertEquals(result.get(0), news);
    }

    @Test
    public void update() {
        setILA();
        News newsToUpdate = new News();
        newsToUpdate.setTitle("News");

        dao.update(TEST_ID, newsToUpdate);
        verify(session, times(1)).flush();
        assertEquals(news.getTitle(), newsToUpdate.getTitle());
    }

    @Test
    public void delete() {
        setILA();
        dao.delete(TEST_ID);
        verify(session).delete(news);
    }

    private void setILA() {
        IdentifierLoadAccess<News> ila = mock(IdentifierLoadAccess.class);
        when(session.byId(News.class)).thenReturn(ila);
        when(ila.load(TEST_ID)).thenReturn(news);
    }
}