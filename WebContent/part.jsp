<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<c:forEach var="blockLine" items="${sessionScope.puzzle.blocks}"
	varStatus="loopW">
	<tr>
		<c:forEach var="block" items="${blockLine}" varStatus="loopH">
			<c:if test="${sessionScope.solved}">
				<td><c:if test="${block != 0}">
							${block}
						</c:if></td>
			</c:if>
			<c:if test="${!sessionScope.solved}">
				<td onclick="move(${loopW.index}, ${loopH.index})"><c:if
						test="${block != 0}">
							${block}
						</c:if></td>
			</c:if>
		</c:forEach>
	</tr>
</c:forEach>