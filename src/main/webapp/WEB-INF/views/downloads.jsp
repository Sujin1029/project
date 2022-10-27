<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title></title>
</head>
<body>
  <h2>자료실</h2>
  <ul>
    <c:forEach items="${list}" var="file">
      <li>${file.name} <span><a href="/downloads/${file.name}">[download]</a></span></li>
    </c:forEach>
  </ul>
</body>
</html>



