<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<c:import url="/WEB-INF/jsp/common/header.jsp">
<c:param name="pageView" value="National Park Geek Survey" />
</c:import>

<p>
Hey park lovers!  What a great opportunity to share with your fellow adventurers about the great discoveries you've experienced.
Please take a few moments to vote on your favorite park below.  Afterwards you can see a list of the top-voted parks in the land!
</p>
<br>
<p></p>



<c:url var="addSurveyWithPostWithModelMap" value="/addSurveyWithPostWithModelMap" />
<form:form action="${addSurveyWithPostWithModelMap}" method="POST" modelAttribute="survey">
	<div class="formInputGroup">
		<label for="parkCode">Favorite National Park:</label>
		<select name="parkCode"	id="parkCode">
			<option value="CVNP">Cuyahoga Valley National Park</option>
			<option value="ENP">Everglades National Park</option>
			<option value="GNP">Glacier National Park</option>
			<option value="GCNP">Grand Canyon National Park</option>
			<option value="GTNP">Grand Teton National Park</option>
			<option value="GSMNP">Great Smoky Mountains National Park</option>
			<option value="MRNP">Mount Rainier National Park</option>
			<option value="RMNP">Rocky Mountain National Park</option>
			<option value="YNP">Yellowstone National Park</option>
			<option value="YNP2">Yosemite National Park</option>
		</select>
	</div>
	<br>
	<div class="formInputGroup">
		<label for="emailAddress">Your email:</label> 
		<form:input type="text" path="emailAddress" id="email"/>
		<form:errors path="emailAddress" cssClass="error" />
	</div>
	<br>
	<div class="formInputGroup">
		<label for="state">State of residence:</label>
		<select name="state" id="state">
			<option value="alabama">AL</option>
			<option value="alaska">AK</option>
			<option value="arizona">AZ</option>
			<option value="arkansas">AR</option>
			<option value="california">CA</option>
			<option value="colorado">CO</option>
			<option value="connecticut">CT</option>
			<option value="delaware">DE</option>
			<option value="florida">FL</option>
			<option value="georgia">GA</option>
			<option value="hawaii">HI</option>
			<option value="idaho">ID</option>
			<option value="illinois">IL</option>
			<option value="indiana">IN</option>
			<option value="iowa">IA</option>
			<option value="kansas">KS</option>
			<option value="kentucky">KY</option>
			<option value="louisiana">LA</option>
			<option value="maine">ME</option>
			<option value="maryland">MD</option>
			<option value="massachusetts">MA</option>
			<option value="michigan">MI</option>
			<option value="minnesota">MN</option>
			<option value="mississippi">MS</option>
			<option value="missouri">MO</option>
			<option value="montana">MT</option>
			<option value="nebraska">NE</option>
			<option value="nevada">NV</option>
			<option value="newHampshire">NH</option>
			<option value="newJersey">NJ</option>
			<option value="newMexico">NM</option>
			<option value="newYork">NY</option>
			<option value="northCarolina">NC</option>
			<option value="northDakota">ND</option>
			<option value="ohio">OH</option>
			<option value="oklahoma">OK</option>
			<option value="oregon">OR</option>
			<option value="pennsylvania">PA</option>
			<option value="rhodeIsland">RI</option>
			<option value="southCarolina">SC</option>
			<option value="southDakota">SD</option>
			<option value="tennessee">TN</option>
			<option value="texas">TX</option>
			<option value="utah">UT</option>
			<option value="vermont">VT</option>
			<option value="virginia">VA</option>
			<option value="washington">WA</option>
			<option value="westVirginia">WV</option>
			<option value="wisconsin">WI</option>
			<option value="wyoming">WY</option>
		</select>
	</div>
	<br>
	<div class="formInputGroup">
			<label for="radio">Activity Level:</label>
 			<input type="radio" id="inactive" name="activityLevel" value="Inactive" checked="checked"/>
			<label for="activityLevel"> Inactive </label>
		
			<input type="radio" id="sedentary" name="activityLevel" value="Sedentary"/>
			<label for="activityLevel"> Sedentary </label>
		
			<input type="radio" id="active" name="activityLevel" value="Active"/>
			<label for="activityLevel"> Active </label>
		
			<input type="radio" id="extremelyActive" name="activityLevel" value="Extremely Active"/>
			<label for="activityLevel"> Extremely Active </label>

	</div>
	<br>
			<input class="submit" type="submit" value="Submit" />
</form:form>
	
<c:import url="/WEB-INF/jsp/common/footer.jsp" />