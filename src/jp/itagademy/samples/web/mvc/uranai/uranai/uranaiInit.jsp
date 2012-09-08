<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>

<!DOCTYPE html>

<meta charset="UTF-8">
<title>血液型占い</title>

<h1>血液型占い</h1>
<% 
	String error = request.getParameter("error");
	if (error != null){
		out.println(error);
	}
%>
<p>あなたの今日の運勢は？</p>
<form action="/JavaWebLearning/mvc/uranai" method="post">
	<p>血液型を選択してください</p>
	<p><select name="bloodtype">
		<option value="A" selected="selected">A型</option>
		<option value="B">B型</option>
		<option value="O">O型</option>
		<option value="AB">AB型</option>
	</select></p>
	<input type="submit" value="占う">
</form>
