
'use strict';
angular
	.module('app')
		.controller('newPatientCtrl', [	'$scope', '$http', '$localStorage', 
									'$timeout', '$translate', '$auth', 
									'$state' , '$stateParams', 'Restangular', 
									'toastr', '$rootScope', 'patientServices',
  function newPatientCtrl($scope, $http, $localStorage, 
		  			$timeout, $translate, $auth, 
		  			$state, $stateParams, Restangular, 
		  			toastr, $rootScope, patientServices) {
	
	$scope.$watch("init", function(){
		if(undefined == $stateParams.newPatient){
			$state.go('app.patient',{},{reload:true});
		}
		console.log($stateParams.newPatient);
		$scope._links = $stateParams.newPatient._links;
	});
	
	$scope.patchPatient = function(patient, link){
		patientServices.patchPatient(patient, link).then(function(response){
			toastr.success('saved');
		}).catch(function(response) {
			console.error('Error',response);
			toastr.error(response.data.message, 'Error');
	    });
	};

	$scope.openModal = function(userId){
		$state.go('app.user.role.config', {userId:userId});
	}
	
  }
]);