<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>

<!DOCTYPE html>

<meta charset="utf-8">
<title>Include include2 Sample</title>

<%@include file="_header.jsp" %>
<div id="main">
	<p>ページ　その２</p>
	<p><a href="include1.jsp">前ページへ</a></p>
</div>
<%@include file="_footer.jsp" %>