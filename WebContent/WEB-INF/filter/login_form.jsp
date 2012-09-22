<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@include file="_header.jsp" %>

<c:if test="${error != null}">
	<p class="error">${error}</p>
</c:if>

<form action="${pageContext.request.contextPath}/filter/login" method="post">
	<p>アカウント: <input type="text" name="account"></p>
	<p>パスワード： <input type="password" name="pass"></p>
	<p><input type="submit" value="ログイン"></p>
</form>

<%@include file="_footer.jsp" %>