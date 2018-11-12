<%@page contentType = "text/html;charset = UTF-8" language = "java" %>
<%@page isELIgnored = "false" %>
<html>
   <head>
      <title><spring:message code="application.title"/></title>
   </head>

   <body>
      <h2><spring:message code="application.view-news.title"/></h2>
      <table>
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
      </table>
   </body>

</html>