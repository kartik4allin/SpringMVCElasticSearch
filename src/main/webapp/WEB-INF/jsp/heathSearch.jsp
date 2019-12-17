<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
 <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html lang="en">
<head>

	<!-- Access the bootstrap Css like this, 
		Spring boot will handle the resource mapping automcatically -->
	<link rel="stylesheet" type="text/css" href="webjars/bootstrap/3.3.7/css/bootstrap.min.css" />

	<!-- 
	<spring:url value="/css/main.css" var="springCss" />
	<link href="${springCss}" rel="stylesheet" />
	 -->
	<c:url value="/css/main.css" var="jstlCss" />
	<link href="${jstlCss}" rel="stylesheet" />

</head>
<body>

	<nav class="navbar navbar-inverse">
		<div class="container">
			<div class="navbar-header">
				<a class="navbar-brand" href="#">Spring Boot</a>
			</div>
			<div id="navbar" class="collapse navbar-collapse">
				<ul class="nav navbar-nav">
					<li class="active"><a href="#">Home</a></li>
					<li><a href="#about">About</a></li>
				</ul>
			</div>
		</div>
	</nav>

	<div class="container">


	
		
		<div class="col-lg-8">
			 <!--<div id="search-wrapper">   -->
	                	<form action="/searchHealthQuery" method="POST" class="form-inline">
	                    	<div class="form-group" >
	                    		<h1>Health Search</h1>
	                        	<!-- <input type="text" name="query" class="form-control" placeholder="Enter your search query" value="" /> -->
	                        	<input name="query" class="form-control form-control-lg" type="text" placeholder="Enter your query" value=""/>
	                        	<button type="submit" name="search-button" class="form-control glyphicon glyphicon-search"></button>
	                    	</div>
	               		 </form>
	         <!-- </div> -->
         </div>
         
      
		
		<!--  <div class="row">
        	<div class="col-xs-6 col-xs-offset-3">
            	<div id="search-wrapper">
                	<form action="/searchQuery" method="POST" class="form-inline">
                    	<div class="form-group">
                        	<input type="text" name="query" class="form-control" placeholder="Enter your search query" value="" />
                        	<button type="submit" name="search-button" class="form-control glyphicon glyphicon-search"></button>
                    	</div>
               		 </form>
            	</div>
        	</div>
    	</div> -->

	</div>
		
	 <c:if test="${fn:length(healthData) gt 0}">
		<div class="container"> 
			<div class="row">
				<div class="col-lg-8">
					<c:forEach items="${healthData}" var="data">
				       <div class="card" style="width: 75rem;">
						  <div class="card-body" style="border: 1px">
						    <h3 class="card-title"><a href="#" class="card-link"><b>Purpose Of Visit :</b>${data.purposeOfVisit}</a></h3>
						    <!-- <h6 class="card-subtitle mb-2 text-muted">Card subtitle</h6> -->
						   <h4 class="card-subtitle mb-2"><b>Age :</b> ${data.age}
						    <b>Main Complaint :</b> ${data.mainComplaint}
						    <b>Past Ocular History :</b> ${data.pastOcularHistory}
						    <b>Family History :</b> ${data.familyHistory}
						    <b>Allergy History :</b> ${data.allergyHistory}
						    <b>Current Medication :</b> ${data.currentMedication}</h4>
						   <!--  <a href="#" class="card-link">Card link</a> -->
						  </div>
						</div>
					</c:forEach>
				</div>
				<!-- <div class="col-lg-4">
					<div class="card" style="width: 18rem;">
					  <div class="card-body">
					    <h5 class="card-title">Card title</h5>
					    <p class="card-text">Some quick example text to build on the card title and make up the bulk of the card's content.</p>
					    <a href="#" class="card-link">Card link</a>
					  </div>
					</div>
				</div> -->
			</div>	
		 </div>
		</c:if>
	
	<script type="text/javascript" src="webjars/bootstrap/3.3.7/js/bootstrap.min.js"></script>

</body>

</html>