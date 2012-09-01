<%@page import="jp.itagademy.samples.web.mvc.counter.Counter"%>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>

<% Counter counter = (Counter) application.getAttribute("counter"); %>
<!DOCTYPE html >

<meta charset="utf-8">
<title>カウンター</title>

<p>訪問回数： <%= counter.getNum() %> 回</p>