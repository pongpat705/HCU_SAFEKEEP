
'use strict';
angular
	.module('app')
		.controller('trayCtrl', [	'$scope', '$http', '$localStorage', 
									'$timeout', '$translate', '$auth', 
									'$state' , '$stateParams', 'Restangular', 
									'toastr', '$rootScope',
  function trayCtrl($scope, $http, $localStorage, 
		  			$timeout, $translate, $auth, 
		  			$state, $stateParams, Restangular, 
		  			toastr, $rootScope) {
	
	$scope.$watch("init", function(){
//		$scope.loadStations();
	});
	
	$scope.stations = {};
	
	$scope.loadStations = function(){
		var stationServices = Restangular.all('/dashboard/api/stations');
		
		stationServices.getList({size:1000}).then(function(response){
			$scope.stations = response;
		}).catch(function(response) {
			console.error('Error',response);
			toastr.error(response.data.message, 'Error');
			if (403 == response.status){
				$rootScope.unAuthorized();
			}
		});
	};
	
	$scope.openModal = function(userId){
		$state.go('app.user.role.config', {userId:userId});
	}
	
  }
]);