
'use strict';
angular
	.module('app')
		.controller('profileCtrl', [	'$scope', '$http', '$localStorage', 
									'$timeout', '$translate', '$auth', 
									'$state' , '$stateParams', 'Restangular', 
									'toastr', '$rootScope', 'patientServices',
  function profileCtrl($scope, $http, $localStorage, 
		  			$timeout, $translate, $auth, 
		  			$state, $stateParams, Restangular, 
		  			toastr, $rootScope, patientServices) {
	
	$scope.$watch("init", function(){
		if(undefined == $stateParams.patient){
			$state.go('app.patient',{},{reload:true});
		}
		console.log($stateParams.patient);
		$scope.patient = $stateParams.patient;
		$scope._links = $stateParams.patient._links;
		
		$scope.loadVisit();
		
	});
	
	$scope.loadVisit = function(){
		$scope.genericGet($scope._links.visits.href).then(function(response){
			$scope.visits = response.data._embedded.ipeVisitLogs;
		});
	}
	
	$scope.genericGet = function(link){
		var result = null;
		result = patientServices.genericGet(link).then(function(response){
			return response;
		}).catch(function(response) {
			console.error('Error',response);
			toastr.error(response.data.message, 'Error');
	    });
		return result;
	};
	
	$scope.patchPatient = function(patient, link){
		patientServices.patchPatient(patient, link).then(function(response){
			toastr.success('saved');
		}).catch(function(response) {
			console.error('Error',response);
			toastr.error(response.data.message, 'Error');
	    });
	};
	
	$scope.delVisit = function(link){
		patientServices.genericDel($scope._links.visits.href).then(function(response){
			patientServices.genericDel(link).then(function(response){
				$scope.loadVisit();
			}).catch(function(response) {
				console.error('Error',response);
				toastr.error(response.data.message, 'Error');
		    });
		}).catch(function(response) {
			console.error('Error',response);
			toastr.error(response.data.message, 'Error');
	    });
	};
	
	$scope.addVisit = function(visit, link){
		patientServices.addVisitLog(visit).then(function(response){
			var data = response.data._links.self.href;
			patientServices.patchPatientParent(data, link).then(function(response){
				toastr.success('saved');
				$scope.loadVisit();
			}).catch(function(response) {
				console.error('Error',response);
				toastr.error(response.data.message, 'Error');
		    });
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