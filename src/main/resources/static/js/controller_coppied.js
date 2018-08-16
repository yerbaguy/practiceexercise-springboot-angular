//var app = angular.module('app', []);
//
//app.controller('getcontroller', function($scope, $http, $location) {
//	
//	$scope.getfuntion = function(){
//		
//		var url = $location.absUrl() + "api/words";
//		
//		$http.get(url).then(function (response) {
//			
//			$scope.getDivAvailable = true;
//			
//			$scope.response = response.data;
//			
//		}, function error(response) {
//			
//			$scope.postResultMessage = "Error Status" + response.statusText;
//			
//		});
//		
//	}
//	
//	
//});






var app = angular.module('app', []);
app.controller('postcontroller', function($scope, $http, $location) {
	$scope.submitForm = function(){
	//	var url = $location.absUrl() + "postcustomer";
		
		var url = $location.absUrl() + "api/create";
		
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
      engword: $scope.engword,
      plword: $scope.plword
  };

		
		
		
		$http.post(url, data, config).then(function (response) {
			$scope.postResultMessage = response.data;
		}, function error(response) {
			$scope.postResultMessage = "Error with status: " +  response.statusText;
		});
		
		$scope.engword = "";
		$scope.plword = "";
	}
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
		
//		var url = $location.absUrl() + "words";
//		
//		$http.get(url).then(function (response) {
//			console.log("response:" + response);
//			$scope.response = response.data
//		}, function error(response) {
//			
//			$scope.postResultMessage = "Words Error" + response.statusText;
//		});	
		
		return $scope.label = "lkjasdf";

	};

		
//		$http({
//		
//			method: "GET",
//			url: 'http://localhost:8080/words'
//		}).then(function(response) {
//			
//			$scope.words_data = response.data;
//			console.log("Success" + response.data);
//		
//		}, function(response) {
//			
//			$scope.state = true
//			console.log("Failure");
//		});
//		
//	};
	

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
	      typedengword: $scope.typedengword
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
