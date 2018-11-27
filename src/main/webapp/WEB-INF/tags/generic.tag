<%@tag description="Page template" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@attribute name="title" fragment="true" %>
<%@attribute name="content" fragment="true" %>

<!doctype html>
<html ng-app="NewsManager">
<head>
    <meta http-equiv="Content-Type" content="text/html; UTF-8"/>
    <title><spring:message code="application.title"/></title>
    <c:set var="base">
        ${pageContext.request.scheme}://${pageContext.request.serverName}:${pageContext.request.serverPort}${pageContext.request.contextPath}
    </c:set>
    <spring:url value="/css/styles.css" var="mainCss"/>
    <spring:url value="/scripts/angular.js" var="angular"/>
    <spring:url value="/scripts/news.data.js" var="newsdata"/>
    <link rel="stylesheet" href="${mainCss}" type="text/css"/>
    <script src="${angular}"></script>
    <script src="${newsdata}"></script>
    <!--[if lt IE 9]>
    <script src="http://html5shiv.googlecode.com/svn/trunk/html5.js"></script>
    <![endif]-->
    <!--
    afflatus, a free CSS web template by ZyPOP (zypopwebtemplates.com/)

    Download: http://zypopwebtemplates.com/

    License: Creative Commons Attribution
    //-->
    <style>
        .error {
            font-size: 0.9em;
            color: red;
        }

        .leftstr, .rightstr {
            float: left;
            width: 50%;
        }

        .rightstr {
            text-align: right;
        }
    </style>
    <meta name="viewport" content="width=device-width, minimum-scale=1.0, maximum-scale=1.0"/>
</head>

<body>
<div ng-controller="NewsController">

<div id="sitename">
    <div class="width">
        <h1><a href="#"> <spring:message code="application.title"/> </a></h1>
        <nav>
            <ul>
                <c:set var="localeCode" value="${pageContext.response.locale}"/>
                <li ${localeCode=="ru"?"class='start selected'":"class='start'"}><a href="?lang=ru">Русский</a></li>
                <li ${localeCode=="en"?"class='end selected'":"class='end'"}><a href="?lang=en">English</a></li>
            </ul>
        </nav>
        <div class="clear"></div>
    </div>
</div>
<header>
    <div class="width">
        <h2>
            <jsp:invoke fragment="title"/>
        </h2>
    </div>
</header>
<section id="body" class="width clear">
    <aside id="sidebar" class="column-left">
        <ul>
            <li>
                <h4><spring:message code="application.common.navigate"/></h4>
                <ul class="blocklist">
                    <li class="{{form_class}}">
                        <a ng-click="createNews()">Add news</a>
                    </li>
                    <li class="{{view_class}}">
                        <a ng-click="getAllNews()">List news</a>
                    </li>
                </ul>
            </li>
        </ul>
    </aside>
    <section id="content" class="column-right">

        <jsp:invoke fragment="content"/>
    </section>

</section>
<footer class="clear">
    <div class="width">
        <p class="left">&copy; 2018 <spring:message code="application.title"/>.</p>
        <p class="right"><a href="http://zypopwebtemplates.com/">Free CSS Templates</a> by ZyPOP</p>
    </div>
</footer>
</div>
</body>
</html>
