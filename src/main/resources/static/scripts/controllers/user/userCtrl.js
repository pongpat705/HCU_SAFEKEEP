
'use strict';
angular
	.module('app')
		.controller('userCtrl', [	'$scope', '$http', '$localStorage', 
									'$timeout', '$translate', '$auth', 
									'$state' , '$stateParams', 'Restangular', 
									'toastr', '$rootScope', 'UserService',
  function userCtrl($scope, $http, $localStorage, 
		  			$timeout, $translate, $auth, 
		  			$state, $stateParams, Restangular, 
		  			toastr, $rootScope, UserService) {
	
	$scope.$watch("init", function(){
	});
	
	
	$scope.openModal = function(stationId){
		$state.go('app.user.role.config', {stationId:stationId});
	}
	
  }
]);