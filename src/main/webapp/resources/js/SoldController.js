function SoldController($scope,$http) {
	
	$scope.isrun = false;
	$scope.work = false;
	$scope.remain = "";
	
	refreshAll = function(){
		$http.get('/zd/sold/isrun').success(function(res){
			$scope.isrun = (res == "true");
		});
		$http.get('/zd/sold/stat').success(function(res){
			$scope.work = (res == "true");
		});
		$http.get('/zd/sold/remain').success(function(res){
			$scope.remain = res;
		});
	};

	refresh = function(){
		refreshAll();
	};
	$scope.scrap = function(){
		$http.get('/zd/sold/scrap').success(function(res){});
	};
	$scope.start = function(){
		$http.get('/zd/sold/start').success(function(res){});
	};
	$scope.stop = function(){
		$http.get('/zd/sold/stop').success(function(res){});
	};
	setInterval(refresh,500);
}