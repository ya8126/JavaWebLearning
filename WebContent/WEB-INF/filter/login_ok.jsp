<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>

<%@include file="_header.jsp" %>

<p>ログインしました。ようこそ ${account} さん。</p>
<p><a href="${pageContext.request.contextPath}/filter/memberOnly/page1">ページ１へ</a></p>
<p><a href="${pageContext.request.contextPath}/filter/memberOnly/page2">ページ２へ</a></p>

<%@include file="_footer.jsp" %>