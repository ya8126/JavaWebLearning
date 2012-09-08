<%@page import="com.sun.xml.internal.bind.CycleRecoverable.Context"%>
<%@page import="jp.itagademy.samples.web.mvc.sympleboard.Comments"%>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>

<% Comments comments = (Comments) application.getAttribute("comments"); %>

<!DOCTYPE html>

<meta charset="utf-8">
<title>簡易掲示板</title>
<h1>かんいけいじばん</h1>
<p>
<%
	int i = 0;
	if (comments != null){

	}
%>
