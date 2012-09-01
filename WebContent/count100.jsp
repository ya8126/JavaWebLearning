<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>

<!DOCTYPE html>

<meta charset=utf-8">

<title>Count 100 JSP</title>

<ul>
<% 
for(int i= 1; i<=100; i++) {
%>
  <li> <%= i %></li>
<%
}
%>
</ul>