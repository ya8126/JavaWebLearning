<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>

<!DOCTYPE html>

<meta charset="utf-8">
<title>Include include1 Sample</title>

<%@include file="_header.jsp" %>
<div id="main">
	<p>ページ　その１</p>
	<p><a href="include2.jsp">次ページへ</a></p>
</div>
<%@include file="_footer.jsp" %>