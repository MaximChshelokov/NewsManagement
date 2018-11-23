<%@page contentType="text/html;charset = UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@page isELIgnored="false" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<t:generic>
    <jsp:attribute name="title"><spring:message code="application.news-list.title"/></jsp:attribute>
    <jsp:attribute name="content">
        <div ng-if="view_visible === true">
            <article class="expanded">
                <h2>{{news.title}}</h2>
                <div class="article-info">
                    <spring:message code="application.news-list.posted"/>
                    {{news.date}}
                </div>
                <h5>{{news.brief}}</h5>
                <p>{{news.content}}</p>
            </article>
        </div>
        <div ng-if="form_visible === true">
            <article class="expanded">
                <fieldset>
                    <form>
                        <p>
                            <label for="title"><spring:message code="application.common.title"/></label>
                            <input id="title" ng-model="news.title"/>
                        </p>
                        <p>
                            <label for="date"><spring:message code="application.common.date"/></label>
                            <input type="date" id="date" ng-model="news.date"/>
                        </p>
                        <p>
                            <label for="brief"><spring:message code="application.common.brief"/></label>
                            <textarea id="brief" cols="60" rows="5" ng-model="news.brief"></textarea><br/>
                        </p>
                        <p>
                            <label for="content"><spring:message code="application.common.content"/></label>
                            <textarea id="content" cols="60" rows="10" ng-model="news.content"></textarea><br/>
                        </p>
                        <p>
                            <a ng-click="addNews(news.title,news.date,news.brief,news.content)" class="button">
                                <spring:message code="application.common.submit"/></a>
                        </p>
                    </form>
                </fieldset>

            </article>
        </div>
        <div ng-if="feed_visible === true">
            <div ng-repeat="news in news_list">
                <article class="expanded">
                    <h2>{{news.title}}</h2>
                    <div class="article-info">
                        <spring:message code="application.news-list.posted"/>
                        {{news.date}}
                    </div>
                    <h5>{{news.brief}}</h5>
                    <p>{{news.content}}</p>

                    <div class="leftstr">
                        <a ng-click="getNews('{{news.id}}')" class="button"><spring:message
                                code="application.news-list.view"/></a>
                    </div>
                    <div class="rightstr">
                        <a ng-click="editNews({{news.id}})" class="button"><spring:message
                                code="application.news-list.edit"/></a>
                        <a ng-click="deleteNews({{news.id}})" class="button button-reversed"><spring:message
                                code="application.news-list.delete"/></a>
                    </div>
                    <div style="clear: left"/>
                </article>
            </div>
        </div>
    </jsp:attribute>
</t:generic>