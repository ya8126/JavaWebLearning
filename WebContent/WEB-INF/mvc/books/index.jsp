<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html >

<meta charset="utf-8">
<title>書籍一覧</title>
<style>
#books{
	border-collapse:collapse;
}
#books th, #books td{
	padding: 4px;
	border: solid 1px #999;
}
.soldout {
	color: #ccc;
}
</style>

<table id="books">
	<tr>
		<th>書籍名</th>
		<th>著者名</th>
		<th>価格</th>
		<th>在庫数</th>
	</tr>
<c:forEach var="book" items="${books}">
	<tr<c:if test="${book.quentity == 0}"> class="soldout"</c:if>>
		<td><c:out value="${book.title}"></c:out></td>
		<td><c:out value="${book.author.lastName} ${book.author.firstName}"></c:out></td>
		<td>${book.price} 円</td>
		<td>${book.quentity} 冊</td>
	</tr>
</c:forEach>
</table>