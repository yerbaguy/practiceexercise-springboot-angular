'use strict';

App.controller('wordController', ['$scope', '$rootScope', '$wordService', '$http', function($scope, $rootScope, $wordService, $http) {
	
    $scope.getWords = function() {
    	
    	$scope.word = "lkjasd";
    	
    	return $scope.word;
    	
    }	
	
	
	
}])