package com.epam.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.internal.verification.VerificationModeFactory.times;

import com.epam.dao.NewsDao;
import com.epam.model.News;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import java.util.Collections;
import java.util.List;


public class NewsServiceImplTest {

    @Mock
    private NewsDao dao;

    @Rule
    public MockitoRule mockitoRule = MockitoJUnit.rule();

    private NewsServiceImpl service = new NewsServiceImpl();
    private News news = new News();
    private static final int TEST_ID = 3;

    @Before
    public void init() {
        service.setRepository(dao);
    }

    @Test
    public void addMustReturnTrue() {
        when(dao.save(news)).thenReturn(1L);
        boolean result = service.add(news);
        verify(dao, times(1)).save(news);
        assertTrue(result);
    }

    @Test
    public void addMustReturnFalse() {
        boolean result = service.add(news);
        verify(dao, times(1)).save(news);
        assertFalse(result);
    }

    @Test
    public void getAll() {
        List<News> newsList = Collections.singletonList(news);
        when(dao.getAll()).thenReturn(newsList);
        List<News> result = service.getAll();
        verify(dao, times(1)).getAll();
        assertEquals(newsList, result);
    }

    @Test
    public void get() {
        when(dao.get(TEST_ID)).thenReturn(news);
        News result = service.get(TEST_ID);
        verify(dao, times(1)).get(TEST_ID);
        assertEquals(news, result);
    }

    @Test
    public void update() {
        service.update(TEST_ID, news);
        verify(dao, times(1)).update(TEST_ID, news);
    }

    @Test
    public void delete() {
        service.delete(TEST_ID);
        verify(dao, times(1)).delete(TEST_ID);
    }
}