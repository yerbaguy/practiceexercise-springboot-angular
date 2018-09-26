var app = angular.module('app', []);
app.controller('postcontroller', function($scope, $http, $location) {
	$scope.submitForm = function(){
	//	var url = $location.absUrl() + "postcustomer";
		
	//	var url = $location.absUrl() + "api/create";
		var url = $location.absUrl() + "api/posteng";
		
		var config = {
                headers : {
                    'Accept': 'text/plain'
                }
        }
	
//		var data = {
//            firstname: $scope.firstname,
//            lastname: $scope.lastname
//        };
		
		var data = {
		typedengword: $scope.typedengword		
     // engword: $scope.engword,
     // plword: $scope.plword
  };

		
		
		
		$http.post(url, data, config).then(function (response) {
			$scope.postResultMessage = response.data;
		}, function error(response) {
			$scope.postResultMessage = "Error with status: " +  response.statusText;
		});
		
		
		$scope.typedengword = "";
		
	//	$scope.engword = "";
	//	$scope.plword = "";
	}
	
	
	

//	$scope.randplfunction = {
//		
//		var url = $location.absUrl() + "api/getrandpl";
//		
//		$http.get(url).then(function (response) {
//		
//			$scope.response = response.data;
//		}, function error(response) {
//			
//			$scope.postResultMessage = "Error with status:" + response.statusText;
//		});
//		
//	};
//	
//	
//	
//	$scope.getwordnumberfunction = {
//			
//			var url = $location.absUrl() + "api/getwordnumber";
//			
//			$http.get(url).then(function (response) {
//				
//				$scope.response = response.data;
//			}, function error(response) {
//				
//				$scope.postResultMessage = "Error with status:" + response.statusText;
//			});
//			
//		};
//	
//	
//	
//	
//	$scope.comparefunction = function() {
//		
//		$scope.result = angular.equals($scope.getcomparefunction, $scope.randplfunction);
//	};
//	
	
	
	$scope.onedigit = 5;
	$scope.anotherdigit = 5;
	
	$scope.comparefunction = function() {
		
		$scope.result = angular.equals($scope.onedigit, $scope.anotherdigit);
	};
	
	
	
//	$scope.comp = function() {
//		
//		if (onedigit == anotherdigit)
//		    return "OK"
//		    else
//		    	return "NO
//	};
	
	
	
	
	
	
});

app.controller('getcontroller', function($scope, $http, $location) {
	$scope.getfunction = function(){
		var url = $location.absUrl() + "getallcustomer";
		
		$http.get(url).then(function (response) {
			$scope.response = response.data
		}, function error(response) {
			$scope.postResultMessage = "Error with status: " +  response.statusText;
		});
	}
});


app.controller('getcomparecontroller', function($scope, $http, $location) {
	
	$scope.getcomparefunction = function() {
		
		var url = $location.absUrl() + "api/getcompare";
		
		$http.get(url).then(function (response) {
			
			$scope.response = response.data;
		}, function error(response) {
			
			$scope.postResultMessage = "Error with status:" + response.statusText;
		});
			
	}
	
	
	$scope.randplfunction = function() {
		
		var url = $location.absUrl() + "api/getrandpl";
		
		$http.get(url).then(function (response) {
		
			$scope.response = response.data;
		}, function error(response) {
			
			$scope.postResultMessage = "Error with status:" + response.statusText;
		});
		
	}
	
	
	$scope.comparefunction = function() {
		
		$scope.result = angular.equals($scope.getcomparefunction(), $scope.randplfunction());
	};
	
	
	$scope.getwordnumberfunction = function() {
		
		var url = $location.absUrl() + "api/getwordnumber";
		
		$http.get(url).then(function (response) {
			
			$scope.response = response.data;
		}, function error(response) {
			
			$scope.postResultMessage = "Error with status:" + response.statusText;
		});
		
	}
	
});



app.controller('getwordscontroller', function($scope, $http, $location) {

	
	var data = {
			
			engword: $scope.engword,
	        plword: $scope.plword
	};
	
	$scope.getwordsfunction = function() {
		
		var url = $location.absUrl() + "api/word";
		
		$http.get(url).then(function (response) {
		
			$scope.response = response.data;
		
		}, function error(response) {
			
			$scope.postResultMessage = "Error with status:" + response.statusText;
		});
	}
});




app.controller('getwordcontroller', function($scope, $http, $location) {

	
	$scope.label = "";
	
	$scope.getwordfunction = function() {
		

		
		return $scope.label = "lkjasdf";

	};

		

	

	app.controller('postengcontroller', function($scope, $http, $location) {
		$scope.submitengwordForm = function(){
		//	var url = $location.absUrl() + "postcustomer";
			
			var url = $location.absUrl() + "api/getengword";
			
			var config = {
	                headers : {
	                    'Accept': 'text/plain'
	                }
	        }
		
//			var data = {
//	            firstname: $scope.firstname,
//	            lastname: $scope.lastname
//	        };
			
			var data = {
	      typedengword: $scope.typedengword,
	  //    plword: $scope.plword
	  };

			
			
			
			$http.post(url, data, config).then(function (response) {
				$scope.postResultMessage = response.data;
			}, function error(response) {
				$scope.postResultMessage = "Error with status: " +  response.statusText;
			});
			
			
			$scope.typedengword = "";
		//	$scope.plword = "";
		}
	});
	
	
	
	
	
	
	
	
	
	
});