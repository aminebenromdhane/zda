<!doctype html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html ng-app="MyApp">
<head>
	<title>Home</title>
	<script src="<c:url value='/resources/js/angular.js' />"></script>
	<script src="<c:url value='/resources/js/main.js' />"></script>
	<script src="<c:url value='/resources/js/EstimatorController.js' />"></script>
</head>
<body ng-controller="EstimatorController">
<div>
Input your house information : <br/>
Zip : <input type="text" ng-model="zip" /><br/>
Year Built : <input type="text" ng-model="yearBuilt" /><br/>
Style : <input type="text" ng-model="style" /><br/>
Type : <input type="text" ng-model="type" /><br/>
Acres : <input type="text" ng-model="acres" /><br/>
Bath : <input type="text" ng-model="bath" /><br/>
Bed : <input type="text" ng-model="bed" /><br/>
Sqft : <input type="text" ng-model="sqft" /><br/>
Garage : <input type="text" ng-model="garage" /><br/>
<br/>
choose the year when you want to estimate the sold price :  
<input type="text" ng-model="soldYear" /><br/>
<br/>
<button ng-click="getPrice()">Estimate</button>
<h3>{{price}}</h3>
</div>
</body>
</html>
 