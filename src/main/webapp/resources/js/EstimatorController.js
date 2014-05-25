function EstimatorController($scope,$http) {
	$scope.price = "";
	$scope.yearBuilt=1983;
	$scope.zip=84094;
	$scope.style="2-Story";
	$scope.type="Single Family";
	$scope.acres=0.16;
	$scope.bath=3;
	$scope.bed=3;
	$scope.sqft=2002;
	$scope.garage=2;
	$scope.getPrice= function(){
		$http.get('/zd/estimator/estimate?yearBuilt='+$scope.yearBuilt+'&zip='+$scope.zip+"&style="+$scope.style+"&type="+$scope.type+"&acres="+$scope.acres+"&bath="+$scope.bath+"&bed="+$scope.bed+"&sqft="+$scope.sqft+"&garage="+$scope.garage+"&soldYear="+$scope.soldYear).success(function(res){
	  		$scope.price = res;
		});
	};
}