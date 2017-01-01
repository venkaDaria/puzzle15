<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<c:if test="${sessionScope.solved}">
	<h4 id="winTitle">Вы выиграли за ${sessionScope.num} ходов! Поздравляем! </h4>
</c:if>
<c:if test="${!sessionScope.solved}">
	<h4 id="winTitle">Ходов: ${sessionScope.num}</h4>
</c:if>