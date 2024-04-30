<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title><%= "title" %></title>
</head>
<body>
<%= "Hello, World!" %>
<br/>
<%!
    // 메서드 정의
    int minus(int a, int b) {
        return a - b;
    }
%>

<%
    int a = 3;
    int b = 2;

    if (a > b) {
        out.println(minus(a, b));
    }
%>

<table>
    <tr>
        <% for (int i = 0; i < 10; i++) { %>
        <td><%= i + 1 %></td>
        <% } %>
    </tr>
</table>

<% int x = -1;%>

<% if (x < 0) { %>
<p>negative</p>
<% } else { %>
<p>zero or positive</p>
<% } %>

</body>
</html>