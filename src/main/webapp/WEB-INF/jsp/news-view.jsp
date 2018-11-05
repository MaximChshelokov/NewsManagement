<%@page contentType = "text/html;charset = UTF-8" language = "java" %>
<%@page isELIgnored = "false" %>
<html>
   <head>
      <title>News manager</title>
   </head>

   <body>
      <h2>News View</h2>
      <table>
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
      </table>
   </body>

</html>