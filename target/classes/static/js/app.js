var app = angular.module('myApp', ['ngResource']);

//app.controller('WordController', ['$scope', '$resource', function($scope, $resource) {
app.controller('WordController', ['$scope', '$resource', '$http', function($scope, $resource, $http) {
	
	var vm = this;
	
	vm.label1 = "";
	
//	$scope.showWord = function() {
//		
//		$scope.showword = $resource('http://localhost:8080/api/words'
//				).query(function(data){ return data;});
//	};
	
	$scope.wordsDetails = [];
	
	
	vm.word = function() {
		
		$http.get('/api/words').then(function(response) {
			
			vm.label1 = response.data;
		});
	};
	
	
//	$scope.getWords = function() {
//		
//		
//		$http.get('/words').success(function(response){
//			
//			$scope.words = response.data;
//		}).error(function(response){
//			
//			//
//		})
//	
//	};
	
	
//	$scope.getWords = function() {
//
//		
//		$http.get('words').success(function(response){
//			
//			$scope.getwords = response.data;
//		}).error(function){
//		
//		
////		wordService.getWords().then(
////		function(d) {
////			
////			$scope.wordsDetails = d;
//		});
//		
//	};
	
	
	
	$scope.show = function() {
		
		$scope.label = "lkjasd";
		
		return $scope.label;
	};
	
	
	
	
	$scope.create = function() {
		
		Word = $resource(
		
				"http://localhost:8080/api/create",
				{},
				{save: { method:'PUT', isArray:false}}
		);
		
		var word = {};
		
		word.id = $scope.wordForm.id;
		word.engword = $scope.wordForm.engword;
		word.plword = $scope.wordForm.plword;
		
		$scope.Message = Word.save(word);
		
		$scope.wordForm.id = "";
		$scope.wordForm.engword = "";
		$scope.wordForm.plword = "";
	};
}]);