<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<c:import url="/WEB-INF/jsp/common/header.jsp" />


	<div class = "parkdetailsimage">
		
 		<c:url var="parkCode" value="/parkDetails">
				<c:param name="parkcode" value="${park.parkCode}"/>
			</c:url>
			
			<img class="parkdetailsimages" src="img/parks/${park.parkCode}.jpg" alt="Park" width="95%">
			<br>
		<div class = "parkdetailsinfo">
			<b><c:out value="${park.parkName}" /></b>
			<i><c:out value="(${park.state})" /></i>
			<br>
			<c:out value="${park.parkDescription}" />
			<br>
			<br>
			<i><c:out value="${park.inspirationalQuote}" /></i>
			<br>
			<i><c:out value="- ${park.inspirationalQuoteSource}" /></i>
			<br>
			<br>
			<b><c:out value ="Total Acreage: "/></b>
			<c:out value="${park.acreage}"/>
			<br>
			<b><c:out value ="Park Elevation (in feet): "/></b>
			<c:out value="${park.elevationInFeet}" />
			<br>
			<b><c:out value ="Miles of Trail: "/></b>
			<c:out value="${park.milesOfTrail}" />
			<br>
			<b><c:out value ="Number of Campsites: "/></b>
			<c:out value="${park.numberOfCampsites}" />
			<br>
			<b><c:out value ="Climate: "/></b>
			<c:out value="${park.climate}" />
			<br>
			<b><c:out value ="Year Founded: "/></b>
			<c:out value="${park.yearFounded}" />
			<br>
			<b><c:out value ="Annual Visitors: "/></b>
			<c:out value="${park.annualVisitorCount}" />
			<br>
			<b><c:out value ="Entry Fee: "/></b>
			<c:out value="$${park.entryFee}" />
			<br>
			<b><c:out value ="Number of Animal Species: "/></b>
			<c:out value="${park.numberOfAnimalSpecies}" />
			<br>
		</div>
		
	</div>
	

	<div class="weather">
	<c:set var="weather" value="${weatherList[0]}" />
	<c:url var="weatherImg" value="/img/weather/${weather.forecast}.png" />
	<c:choose>
		<c:when test="${isCelsius}">
			<c:set var="highTemp" value="${(weather.high - 32) / 1.8}" />
			<c:set var="lowTemp" value="${(weather.low - 32) / 1.8}" />
			<c:set var="tempScale" value="°C" />
		</c:when>
		<c:otherwise>
			<c:set var="highTemp" value="${weather.high}" />
			<c:set var="lowTemp" value="${weather.low}" />
			<c:set var="tempScale" value="°F" />
	
		</c:otherwise>
	</c:choose>
	<c:choose>
		<c:when test="${weather.forecast == 'snow'}">
			<c:set var="weatherMessage" value="Be sure to pack snow shoes!" />
		</c:when>
		<c:when test="${weather.forecast == 'rain'}">
			<c:set var="weatherMessage" value="Be sure to pack rain gear and wear waterproof shoes!" />
		</c:when>
		<c:when test="${weather.forecast == 'thunderstorms'}">
			<c:set var="weatherMessage" value="Be sure to seek shelter and avoid hiking on exposed ridges!" />
		</c:when>
		<c:when test="${weather.forecast == 'sunny'}">
			<c:set var="weatherMessage" value="Be sure to bring sunblock!" />
		</c:when>
		<c:otherwise>
			<c:set var="weatherMessage" value="" />
		</c:otherwise>
	</c:choose>
	<c:choose>
		<c:when test="${weather.high > 75}">
			<c:set var="tempMessage" value="Bring an extra gallon of water." />
		</c:when>
		<c:when test="${weather.low < 20}">
			<c:set var="tempMessage" value="Be aware of dangerous, frigid temperatures." />
		</c:when>
		<c:when test="${(weather.high - weather.low) > 20}">
			<c:set var="tempMessage" value="Wear breathable layers." />
		</c:when>
		<c:when test="${weather.high > 75 && (weather.high - weather.low) > 20}">
			<c:set var="tempMessage" value="Bring an extra gallon of water and wear breathable layers." />
		</c:when>
		<c:when test="${weather.low < 20 && (weather.high - weather.low) > 20}">
			<c:set var="tempMessage" value="Be aware of dangerous, frigid temperatures and wear breathable layers." />
		</c:when>
		<c:when test="${weather.low < 20 && weather.high > 75}">
			<c:set var="tempMessage" value="The weather sucks, prepare for anything." />
		</c:when>
		<c:otherwise>
			<c:set var="tempMessage" value="" />
		</c:otherwise>
	</c:choose>
	
	<c:url var="actionUrl" value="/parkDetails?parkcode=${park.parkCode}"/>
	<div class="tempScale">
	
	<form method="POST" action="${actionUrl}">
		<select name="isCelsius">
			<option value="false" ${isCelsius ? '' : 'selected'}>Fahrenheit</option>
			<option value="true" ${isCelsius ? 'selected' : ''}>Celsius</option>
		</select>
		<input type="submit" name="submit" class="btn btn-success" value="Go"/>
	</form>
	</div>
	<div class="today">
		<h3 id="todayheader">Today</h3>
		<img id="weathertoday" src="${weatherImg}" height="75%" width="75%" />
		<br>
		<h7>High: <fmt:formatNumber maxFractionDigits="0" value="${highTemp}" /><c:out value="${tempScale}" /></h7> | <h7>Low: <fmt:formatNumber maxFractionDigits="0" value="${lowTemp}" /><c:out value="${tempScale}" /></h7>
		<p><c:out value="${weatherMessage}" /> <c:out value="${tempMessage}" /></p>
	</div>
	<h5 id="forecastheader">Next 4 Days</h5>
	<c:forEach varStatus="loop" var="weather" items="${weatherList}" begin="1">
		<c:set var="weather" value="${weatherList[loop.index]}" />
			<c:choose>
			<c:when test="${isCelsius}">
				<c:set var="highTemp" value="${(weather.high - 32) / 1.8}" />
				<c:set var="lowTemp" value="${(weather.low - 32) / 1.8}" />
				<c:set var="tempScale" value="°C" />
			</c:when>
			<c:otherwise>
				<c:set var="highTemp" value="${weather.high}" />
				<c:set var="lowTemp" value="${weather.low}" />
				<c:set var="tempScale" value="°F" />
			</c:otherwise>
			</c:choose>

		<h4 class = "container">
		<c:url var="weatherImg" value="/img/weather/${weather.forecast}.png" />
		<div class="forecast" style="font-size:10px">
			<img src="${weatherImg}" height="50%" width="50%"/>
			<br>
			<h7>High: <fmt:formatNumber maxFractionDigits="0" value="${highTemp}" /><c:out value="${tempScale}" /></h7> | <h7>Low: <fmt:formatNumber maxFractionDigits="0" value="${lowTemp}" /><c:out value="${tempScale}" /></h7>
		</div>
		</h4>

	</c:forEach>
	
	</div>

	

<c:import url="/WEB-INF/jsp/common/footer.jsp" />