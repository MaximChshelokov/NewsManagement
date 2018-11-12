<%@page contentType = "text/html;charset = UTF-8" language = "java" pageEncoding="UTF-8" %>
<%@taglib uri = "http://www.springframework.org/tags/form" prefix = "form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<html>
   <head>
      <meta charset="UTF-8">
      <title><spring:message code="application.title"/></title>
   </head>

   <body>
      <h2><spring:message code="application.add-news.title"/></h2>
      <spring:url value="./edit-news.do" var="url">
            <spring:param name="id" value="${news.id}"/>
      </spring:url>
      <form:form method = "POST" action = "${url}" modelAttribute="news">
         <table>
            <tr>
               <td><form:label path = "title"><spring:message code="application.common.title"/></form:label></td>
               <td><form:input path = "title" /></td>
               <td><form:errors path="title" /></td>
            </tr>
            <tr>
               <td><form:label path = "date"><spring:message code="application.common.date"/></form:label></td>
               <td><form:input type="date" path = "date" /></td>
               <td><form:errors path="date" /></td>

            </tr>
            <tr>
               <td><form:label path = "brief"><spring:message code="application.common.brief"/></form:label></td>
               <td><form:textarea path = "brief" rows = "5"/></td>
               <td><form:errors path="brief" /></td>
            </tr>
            <tr>
               <td><form:label path = "content"><spring:message code="application.common.content"/></form:label></td>
               <td><form:textarea path = "content" rows="10"/></td>
               <td><form:errors path="content" /></td>
            </tr>
            <tr>
               <td colspan = "2">
                  <input type = "submit" value = "Submit"/>
               </td>
            </tr>
         </table>
      </form:form>
   </body>

</html>