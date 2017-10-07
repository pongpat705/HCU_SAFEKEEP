
'use strict';
angular
	.module('app')
		.controller('landingCtrl', [	'$scope', '$http', '$localStorage', 
									'$timeout', '$translate', '$auth', 
									'$state' , '$stateParams', 'Restangular', 
									'toastr', '$rootScope', 'patientServices',
  function landingCtrl($scope, $http, $localStorage, 
		  			$timeout, $translate, $auth, 
		  			$state, $stateParams, Restangular, 
		  			toastr, $rootScope, patientServices) {
	
	$scope.$watch("init", function(){
		$scope.param = $rootScope.param;
			$scope.getPatientProfileList(0, 1000);
	});
	
	$scope.patientProfile = {};
	$scope.patient = {};
	
	$scope.getPatientProfileList = function(page, size){
		patientServices.getPatients(page, size).then(function(response){
			$scope.patient.data = response.data._embedded.ipePatientProfiles;
			$scope.patient.totalItems = response.data.page.totalElements;
		}).catch(function(response) {
			console.error('Error',response);
			toastr.error(response.data.message, 'Error');
	    });
	};
	
	
	$scope.selectPatient = function(){
		$state.go('app.track')
	};
	
	
  }
]);