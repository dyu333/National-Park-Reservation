<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>National Park Geek</title>
    <c:url value="/css/NationalParks.css" var="cssHref" />
    <link rel="stylesheet" href="${cssHref}">
</head>


<body>
    <header>
    		<c:url value="/homepage" var="homePageHref" />
    		<c:url value="/img/logo.png" var="logoSrc" />
        <a href="${homePageHref}">
        		<img class="headerImage" src="${logoSrc}" alt="National Park logo" />
        </a>
    </header>
    <nav>
        
        <ul>
        	<c:url var="home" value="/homepage" />
        	<c:url var="survey" value="/survey" />
        	<c:url var="surveyResults" value="/surveyResults" />

        
            <li><a href="${home}">Home</a></li>
            <li><a href="${survey}">Survey</a></li>
            <li><a href="${surveyResults}">Favorite Parks</a></li>
       
        </ul>
    </nav>
    <section id = "main-content">
    
    <h1 id = "pageheader">${param.pageView}</h1>