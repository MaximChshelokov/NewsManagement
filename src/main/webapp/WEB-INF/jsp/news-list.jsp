<%@page contentType = "text/html;charset = UTF-8" language = "java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page isELIgnored = "false" %>
<html>
   <head>
      <title>News manager</title>
   </head>

   <body>
      <h2>News List</h2>
      <table>
      <c:forEach items="${newsList}" var="news">
         <tr>
            <td>Title</td>
            <td>${news.title}</td>
         </tr>
         <tr>
            <td>Date</td>
            <td>${news.date}</td>
         </tr>
         <tr>
            <td>Brief</td>
            <td>${news.brief}</td>
         </tr>
         <tr>
            <td>Content</td>
            <td>${news.content}</td>
         </tr>
         </c:forEach>
      </table>

   </body>

</html>