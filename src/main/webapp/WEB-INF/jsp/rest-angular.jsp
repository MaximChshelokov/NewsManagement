<%@page contentType="text/html;charset = UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@page isELIgnored="false" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<t:generic>
    <jsp:attribute name="title"><spring:message code="application.news-list.title"/></jsp:attribute>
    <jsp:attribute name="content">
        <!--    View a news     -->
        <div ng-if="view_visible === true">
            <article class="expanded">
                <h2>{{news.title}}</h2>
                <div class="article-info">
                    <spring:message code="application.news-list.posted"/>
                    {{news.date | date: "dd-MM-yyyy"}}
                </div>
                <h5>{{news.brief}}</h5>
                <p>{{news.content}}</p>
            </article>
        </div>
        <!--    Edit/add news   -->
        <div ng-if="form_visible === true">
            <article class="expanded">
                <fieldset>
                    <form>
                        <div>
                            <label for="title"><spring:message code="application.common.title"/></label>
                            <input id="title" ng-model="news.title" />
                            <div ng-if="errors !== null" class="error">{{errors.title}}</div>
                        </div>
                        <div>
                            <label for="date"><spring:message code="application.common.date"/></label>
                            <input type="date" id="date" ng-model="news.date"/>
                        <div ng-if="errors !== null" class="error">{{errors.date}}</div>
                        </div>>
                        <div>
                            <label for="brief"><spring:message code="application.common.brief"/></label>
                            <textarea id="brief" cols="60" rows="5" ng-model="news.brief"></textarea><br/>
                        <div ng-if="errors !== null" class="error">{{errors.brief}}</div>
                        </div>
                        <div>
                            <label for="content"><spring:message code="application.common.content"/></label>
                            <textarea id="content" cols="60" rows="10" ng-model="news.content"></textarea><br/>
                        <div ng-if="errors !== null" class="error">{{errors.content}}</div>
                        </div>
                        <div ng-if="news.id === 0">
                            <a ng-click="addNews(news.title,news.date,news.brief,news.content)" class="button">
                                <spring:message code="application.common.submit"/></a>
                        </div>
                        <div ng-if="news.id !== 0">
                            <a ng-click="updateNews(news.id,news.title,news.date,news.brief,news.content)"
                               class="button">
                                <spring:message code="application.common.submit"/></a>
                        </div>
                    </form>
                </fieldset>

            </article>
        </div>
        <!--    News list   -->
        <div ng-if="feed_visible === true">
            <div ng-repeat="news in news_list">
                <article class="expanded">
                    <h2>{{news.title}}</h2>
                    <div class="article-info">
                        <spring:message code="application.news-list.posted"/>
                        {{news.date | date: "dd-MM-yyyy"}}
                    </div>
                    <h5>{{news.brief}}</h5>
                    <p>{{news.content}}</p>

                    <div class="leftstr">
                        <a ng-click="viewNews($index)" class="button"><spring:message
                                code="application.news-list.view"/></a>
                    </div>
                    <div class="rightstr">
                        <a ng-click="editNews($index)" class="button"><spring:message
                                code="application.news-list.edit"/></a>
                        <a confirmed-click="deleteNews($index)" class="button button-reversed"
                           ng-confirm-click="Are you sure you want to delete news?"><spring:message
                                code="application.news-list.delete"/></a>
                    </div>
                    <div style="clear: left"></div>
                </article>
            </div>
        </div>
    </jsp:attribute>
</t:generic>