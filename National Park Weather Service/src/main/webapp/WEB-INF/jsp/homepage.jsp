<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"  %>

<c:import url="/WEB-INF/jsp/common/header.jsp" />

	
	 <div class = "home-parks">
	 
		<table>
		<c:forEach items="${Park}" var="park">
			<tr>
		<c:url var="detail" value="/parkDetails">
				<c:param name="parkcode" value="${park.parkCode}"/>
		</c:url>
				<td>
			<a href="${detail}"><img class="images" src="img/parks/${park.parkCode}.jpg" alt="Park"></a>
				</td>
				<td>
			<p class = "title${park.parkCode}">
			<font color="black">
			<b><a href="${detail}"><c:out value="${park.parkName}" /></a></b>
			<b><i><c:out value="(${park.state})" /></i></b>
			<br>
			<font color="black">
			<c:out value="${park.parkDescription}" />
			</p>
				</td>
			<br>
			</tr>
		</c:forEach>
		</table>
	</div>
		
	

<c:import url="/WEB-INF/jsp/common/footer.jsp" />