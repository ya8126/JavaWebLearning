<%@page import="jp.itagademy.samples.web.mvc.uranai.Unsei"%>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>

<% Unsei unsei = (Unsei) request.getAttribute("unsei"); %>

<!DOCTYPE html>

<meta charset="utf-8">
<title>血液型占い</title>
<h1>あなたの運勢は？ </h1>
<p><%= unsei.getBloodType() %> 型の今日の運勢は、<%= unsei.getUnsei() %>です。</p>