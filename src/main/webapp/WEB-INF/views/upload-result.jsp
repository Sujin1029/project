<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title></title>
</head>
<body>
  <h2>파일 업로드 결과</h2>
  <ul>
    <c:forEach items="${list}" var="fileParam">
      <li>${fileParam.fileName}</li>
    </c:forEach>
  </ul>
</body>
</html>