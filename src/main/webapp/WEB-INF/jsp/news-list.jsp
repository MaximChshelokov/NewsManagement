<%@page contentType = "text/html;charset = UTF-8" language = "java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page isELIgnored = "false" %>
<html>
   <head>
      <title><spring:message code="application.title"/></title>
   </head>

   <body>
      <h2><spring:message code="application.news-list.title"/></h2>
      <table>
      <c:forEach items="${newsList}" var="news">
         <tr>
            <td><spring:message code="application.add-news.title"/></td>
            <td>${news.title}</td>
         </tr>
         <tr>
            <td><spring:message code="application.common.date"/></td>
            <td>${news.date}</td>
         </tr>
         <tr>
            <td><spring:message code="application.common.brief"/></td>
            <td>${news.brief}</td>
         </tr>
         <tr>
            <td><spring:message code="application.common.content"/></td>
            <td>${news.content}</td>
         </tr>
         </c:forEach>
      </table>

   </body>

</html>