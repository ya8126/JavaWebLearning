<%@page import="java.util.Date"%>
<%@page import="java.util.List"%>
<%@page import="jp.itagademy.samples.web.mvc.sympleboard.Contribution"%>
<%@page import="com.sun.xml.internal.bind.CycleRecoverable.Context"%>
<%@page import="jp.itagademy.samples.web.mvc.sympleboard.ContributionList"%>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>

<%
//	ContributionList contributionList = (ContributionList) application.getAttribute("contributionlist");
   	List<Contribution> contributionList =
   			((ContributionList) application.getAttribute("contributionlist")).getContributionList();
%>

<!DOCTYPE html>

<meta charset="utf-8">
<title>簡易掲示板</title>
<div style="width: 600px;">
<h1>かんいけいじばん</h1>
<%
	int i = 0;
	if (contributionList != null){
		for (Contribution contribution: contributionList){
			i++;
			String name = contribution.getName();
			String comment = contribution.getComment();
			Date date = contribution.getDate();
%>
			<pre><%= comment %></pre>
			<hr size="1px"  noshade>
			<p style="text-align:right"><%= name %> at <%= date %></p>
			<hr size="3px"  noshade>
<%
		}
	}
	if(i == 0){
%>
		<p>まだ書き込みはありません</p>
<%
	}
%>
	<form action="/JavaWebLearning/mvc/sympleBoard" method="post">
		<p>名前<input type="text"  name="name"  /></p>
		<p><textarea name="comment" rows="5" cols="50"></textarea></p>
		<p><input type="submit" value="投稿" /></p>
	</form>
</div>
