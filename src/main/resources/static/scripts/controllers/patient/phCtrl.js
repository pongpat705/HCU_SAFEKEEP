
'use strict';
angular
	.module('app')
		.controller('phCtrl', [	'$scope', '$http', '$localStorage', 
									'$timeout', '$translate', '$auth', 
									'$state' , '$stateParams', 'Restangular', 
									'toastr', '$rootScope', 'patientServices',
  function phCtrl($scope, $http, $localStorage, 
		  			$timeout, $translate, $auth, 
		  			$state, $stateParams, Restangular, 
		  			toastr, $rootScope, patientServices) {
	
	$scope.$watch("init", function(){
		$scope.ph = {};
		$scope.patient = {};
		$scope._links = {};
		$scope.combo = $rootScope.comboBox;
		
		if('' == $rootScope.currentUser){
			$rootScope.unAuthorized();
		} else {
			$scope.getPatients();			
			$scope.initPatientPhStudentByStudentId();
		}
		
	});
	
	$scope.getPatients = function(){
		var allPatient = '/ipe/api/ipePatientProfiles'
		patientServices.genericGet(allPatient).then(function(response){
			$scope.patients = response.data._embedded.ipePatientProfiles;
		}).catch(function(response) {
			console.error('Error',response);
			toastr.error(response.data.message, 'Error');
	    });
	};
	
	$scope.initPatientPhStudentByStudentId = function(){
		patientServices.getPatientPhByStudentId($rootScope.currentUser).then(function(response){
			console.log(response);
			$scope.ph = response.data;
			$scope._links = response.data._links;
			patientServices.genericGet($scope._links.patient.href).then(function(pResp){
				$scope.patient = pResp.data;
			}).catch(function(pResp) {
				if(404 == pResp.status){
					toastr.warning('รายการนี้ยังไม่ถูกผูกกับผู้ป่วย', 'Waring');
				} else {
					console.error('Error',pResp);
					toastr.error(pResp.data.message, 'Error');
				}
		    });
			//load default
			$scope.loadCompliance();
			$scope.loadDrp();
			$scope.loadReconcil();
		}).catch(function(response){
			//notfound mean not created
			if(404 == response.status){
				$scope.ph.studentId = $rootScope.currentUser;
				patientServices.addPatientPh($scope.ph).then(function(aResp){
					$scope.ph = aResp.data;
					$scope._links = aResp.data._links;
				}).catch(function(aResp){
					console.error('Error',aResp);
					toastr.error(aResp.data.message, 'Error');
				});
			}else{
				console.error('Error',response);
				toastr.error(response.data.message, 'Error');
			}
			
		});
	};
	
	$scope.changePatient = function(patient){
		patientServices.genericPutUrl(patient._links.self.href,$scope._links.patient.href).then(function(resp){
			console.log(resp)
		}).catch(function(resp){
			console.error('Error',resp);
			toastr.error(resp.data.message, 'Error');
		});
	};
	
	$scope.addCompliance = function(compliance,link){
		patientServices.addCompliance(compliance).then(function(response){
			var data = response.data._links.self.href;
			patientServices.patchPatientParent(data, link).then(function(response){
				toastr.success('saved');
				$scope.loadCompliance();
			}).catch(function(response) {
				console.error('Error',response);
				toastr.error(response.data.message, 'Error');
		    });
		}).catch(function(response) {
			console.error('Error',response);
			toastr.error(response.data.message, 'Error');
	    });
	};
	
	$scope.loadCompliance = function(){
		$scope.genericGet($scope._links.compliances.href).then(function(response){
			$scope.compliances = response.data._embedded.ipePhCompliances;
		});
	};
	$scope.delCompliance = function(phId, complianceId){
		patientServices.phDeleteCompliance(phId, complianceId).then(function(response){
			$scope.loadCompliance();
		}).catch(function(response) {
			console.error('Error',response);
			toastr.error(response.data.message, 'Error');
	    });
	};
	
	$scope.addDrp = function(drp,link){
		patientServices.addDrp(drp).then(function(response){
			var data = response.data._links.self.href;
			patientServices.patchPatientParent(data, link).then(function(response){
				toastr.success('saved');
				$scope.loadDrp();
			}).catch(function(response) {
				console.error('Error',response);
				toastr.error(response.data.message, 'Error');
		    });
		}).catch(function(response) {
			console.error('Error',response);
			toastr.error(response.data.message, 'Error');
	    });
	};
	$scope.loadDrp = function(){
		$scope.genericGet($scope._links.drpReports.href).then(function(response){
			$scope.drps = response.data._embedded.ipeDrpReports;
		});
	};
	$scope.delDrp = function(phId, drpId){
		patientServices.phDeleteDrp(phId, drpId).then(function(response){
			$scope.loadDrp();
		}).catch(function(response) {
			console.error('Error',response);
			toastr.error(response.data.message, 'Error');
	    });
	};
	
	$scope.addReconcil = function(reconcil,link){
		patientServices.addReconcil(reconcil).then(function(response){
			var data = response.data._links.self.href;
			patientServices.patchPatientParent(data, link).then(function(response){
				toastr.success('saved');
				$scope.loadReconcil();
			}).catch(function(response) {
				console.error('Error',response);
				toastr.error(response.data.message, 'Error');
		    });
		}).catch(function(response) {
			console.error('Error',response);
			toastr.error(response.data.message, 'Error');
	    });
	};
	$scope.loadReconcil = function(){
		$scope.genericGet($scope._links.reconcils.href).then(function(response){
			$scope.reconcils = response.data._embedded.ipeMedReconcils;
		});
	};
	$scope.delReconcil = function(phId, medId){
		patientServices.phDeleteReconcil(phId, medId).then(function(response){
			$scope.loadReconcil();
		}).catch(function(response) {
			console.error('Error',response);
			toastr.error(response.data.message, 'Error');
	    });
	};
	
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
	
	$scope.genericPatch = function(generic, link){
		patientServices.genericPatch(generic, link).then(function(response){
			toastr.success('saved');
		}).catch(function(response) {
			console.error('Error',response);
			toastr.error(response.data.message, 'Error');
	    });
	};
  }
]);