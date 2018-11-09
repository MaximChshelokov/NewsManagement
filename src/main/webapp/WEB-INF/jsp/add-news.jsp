<%@taglib uri = "http://www.springframework.org/tags/form" prefix = "form"%>
<html>
   <head>
      <title>News manager</title>
   </head>

   <body>
      <h2>Add news</h2>
      <form:form method = "POST" action = "./add-news.do" modelAttribute="news">
         <table>
            <tr>
               <td><form:label path = "title">News Title</form:label></td>
               <td><form:input path = "title" /></td>
               <td><form:errors path="title" /></td>
            </tr>
            <tr>
               <td><form:label path = "date">News Date</form:label></td>
               <td><form:input type="date" path = "date" /></td>
               <td><form:errors path="date" /></td>

            </tr>
            <tr>
               <td><form:label path = "brief">Brief</form:label></td>
               <td><form:textarea path = "brief" rows = "5"/></td>
               <td><form:errors path="brief" /></td>
            </tr>
            <tr>
               <td><form:label path = "content">Content</form:label></td>
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