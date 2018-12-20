<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:import url="/WEB-INF/jsp/common/header.jsp">
	<c:param name="pageView" value="National Park Geek's Top Voted Parks" />
</c:import>

<p>
Hey park lovers!  Looking for your next adventure?  National Park Geek has the perfect place for your to start!
Below you will find a listing of the top voted parks in the nation.  Voted on by fellow explorers, you know these vote count!
Take a look and discover your next trek!  And if you have the time, submit your own vote today!
</p>
<br>
<p></p>


<div>
	<table id="surveyresults">
	
	<c:forEach var = "park" items = "${surveyResults.keySet()}" varStatus = "loop">
	
		<c:url var="detail" value="/parkDetails">
				<c:param name="parkcode" value="${park.parkCode}"/>
		</c:url>
		
		<tr>
		<td id="surveyimage"><a href="${detail}"><img class="surveyimages" src="img/parks/${park.parkCode}.jpg" alt="Park" height="30%" width="30%"></a></td>
		<td id="surveyparkname"><a href="${detail}"><c:out value="${park.parkName}" /></a></td>
		<td><b><font color="red"><c:out value="(${surveyResults.get(park)} Votes)" /></b></td>
		</tr>
	</c:forEach>
	
	</table>
</div>

<c:import url="/WEB-INF/jsp/common/footer.jsp" />
