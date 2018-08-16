'use strict';


app.factory('wordService', function($http, $q) {
	
	return {
		
		getWords : function() {
			
			return $http.get('words')
			.then(
					function(response) {
						
						return response.data;
					},
					function(errResponse) {
						
						alert(errResponse.status + ':' + errResponse.statusText);
						return $q.reject(errResponse);
					});
			
			
		}
		
		
	};
	
});