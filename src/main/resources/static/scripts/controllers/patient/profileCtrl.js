
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
		$scope.patient = $stateParams.patient;
		$scope.mode = $stateParams.mode;
		$scope._links = null != $stateParams.patient ? $stateParams.patient._links : null;
		
		$scope.getPatientByRole();
		
		$scope.combo = $rootScope.comboBox;
		$scope.param = $rootScope.param;
		
		$scope.drugListTmp = [];
		
		$scope.loadVisit();
		$scope.loadMember();
		$scope.loadUseDrug();
		$scope.loadLabs();
		
		$scope.drugList = {};
		
	});
	
	$scope.prevMenu = function(){
		$state.go($rootScope.prevState);
	};
	
	$scope.getPatientByRole = function(){
		var role = 'ROLE_PATIEN';
		
		patientServices.getPatientByRole(role, 0, 1000).then(function(response){
			$scope.userPatients = response.data._embedded.users;
		}).catch(function(response) {
			console.error('Error',response);
			toastr.error(response.data.message, 'Error');
	    });
	}
	
	$scope.loadVisit = function(){
		$scope.genericGet($scope._links.visits.href).then(function(response){
			$scope.visits = response.data._embedded.ipeVisitLogs;
		});
	};
	
	$scope.loadMember = function(){
		$scope.genericGet($scope._links.members.href).then(function(response){
			$scope.members = response.data._embedded.ipeFamilyMembers;
		});
	};
	
	$scope.loadUseDrug = function(){
		$scope.genericGet($scope._links.useDrugs.href).then(function(response){
			$scope.useDrugs = response.data._embedded.ipeUseDrugs;
		});
	};
	
	$scope.getDrugList = function(drug){
		$scope.genericGet(drug._links.drugList.href).then(function(response){
			$scope.drugList[drug.drugId] = response.data._embedded.ipeDrugLists;
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
	
	$scope.patchPatient = function(patient, link){
		patientServices.genericPatch(patient, link).then(function(response){
			toastr.success('saved');
		}).catch(function(response) {
			console.error('Error',response);
			toastr.error(response.data.message, 'Error');
	    });
	};
	
	$scope.delVisit = function(patientId, visitId){
		patientServices.patientDeleteVisits(patientId, visitId).then(function(response){
			$scope.loadVisit();
		}).catch(function(response) {
			console.error('Error',response);
			toastr.error(response.data.message, 'Error');
	    });
	};
	
	$scope.delMember = function(patientId, memberId){
		patientServices.patientDeleteMembers(patientId, memberId).then(function(response){
			$scope.loadMember();
		}).catch(function(response) {
			console.error('Error',response);
			toastr.error(response.data.message, 'Error');
	    });
	}
	
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
	
	$scope.addMember = function(member, link){
		patientServices.addFamilyMember(member).then(function(response){
			var data = response.data._links.self.href;
			patientServices.patchPatientParent(data, link).then(function(response){
				toastr.success('saved');
				$scope.loadMember();
			}).catch(function(response) {
				console.error('Error',response);
				toastr.error(response.data.message, 'Error');
		    });
		}).catch(function(response) {
			console.error('Error',response);
			toastr.error(response.data.message, 'Error');
	    });
	};
	
	$scope.addDrugList = function(drugList){
		var xx = {
					drugName : drugList.drugName,
					managing : drugList.managing,
					qty : drugList.qty
					};
		$scope.drugListTmp.push(xx);
		drugList = {};
	};
	
	$scope.addDrug = function(drug, link){
		
		patientServices.addUseDrug(drug).then(function(response){
			var data = response.data._links.self.href;
			var lAddDrugList = response.data._links.drugList.href;
			patientServices.patchPatientParent(data, link).then(function(response){
				toastr.success('saved');
			}).catch(function(response) {
				console.error('Error',response);
				toastr.error(response.data.message, 'Error');
		    });
			
			angular.forEach($scope.drugListTmp, function(value, key) {
				patientServices.addDrugList(value).then(function(xd){
					var dListdata = xd.data._links.self.href;
					patientServices.patchDrugParent(dListdata, lAddDrugList).then(function(xe){
						toastr.success('saved');
						$scope.loadUseDrug();
					}).catch(function(xe) {
						console.error('Error',xe);
						toastr.error(xe.data.message, 'Error');
				    });
				}).catch(function(xd) {
					console.error('Error',xd);
					toastr.error(xd.data.message, 'Error');
			    });
			});
			
		}).catch(function(response) {
			console.error('Error',response);
			toastr.error(response.data.message, 'Error');
	    });
	};
	
	$scope.delXDurgList = function(drugId, listId){
		patientServices.drugDeleteList(drugId, listId).then(function(response){
			$scope.loadUseDrug();
		}).catch(function(response) {
			console.error('Error',response);
			toastr.error(response.data.message, 'Error');
	    });
	};
	
	$scope.addXDrugList = function(newList, link){
		patientServices.addDrugList(newList).then(function(xd){
			var dListdata = xd.data._links.self.href;
			patientServices.patchDrugParent(dListdata, link).then(function(xe){
				toastr.success('saved');
				$scope.loadUseDrug();
			}).catch(function(xe) {
				console.error('Error',xe);
				toastr.error(xe.data.message, 'Error');
		    });
		}).catch(function(xd) {
			console.error('Error',xd);
			toastr.error(xd.data.message, 'Error');
	    });
	};
	
	$scope.saveXDrug = function(useDrug, link){
		patientServices.genericPatch(useDrug, link).then(function(xe){
			toastr.success('saved');
			$scope.loadUseDrug();
		}).catch(function(xe) {
			console.error('Error',xe);
			toastr.error(xe.data.message, 'Error');
	    });
	};
	
	$scope.delXDrug = function(patientId, drugId){
		patientServices.patientDeleteDrug(patientId, drugId).then(function(response){
			$scope.loadUseDrug();
		}).catch(function(response) {
			console.error('Error',response);
			toastr.error(response.data.message, 'Error');
	    });
	};
	//###
	$scope.loadLabs = function(){
		patientServices.genericGet($scope.patient._links.medical.href).then(function(response){
			$scope.labs = response.data._embedded.ipeMedicalTechnicals;
		}).catch(function(response) {
			console.error('Error',response);
			toastr.error(response.data.message, 'Error');
	    });
	};
	
	$scope.addMedic = function(lab, link){
		patientServices.addLab(lab).then(function(response){
			var data = response.data._links.self.href;
			patientServices.patchPatientParent(data, link).then(function(response){
				toastr.success('saved');
				$scope.loadLabs();
			}).catch(function(response) {
				console.error('Error',response);
				toastr.error(response.data.message, 'Error');
		    });
		}).catch(function(response) {
			console.error('Error',response);
			toastr.error(response.data.message, 'Error');
	    });
	};
	
	$scope.delMedic = function(patientId, labId){
		patientServices.patientDeleteLab(patientId, labId).then(function(response){
			$scope.loadLabs();
		}).catch(function(response) {
			console.error('Error',response);
			toastr.error(response.data.message, 'Error');
	    });
	};

	
	$scope.uploadMap = function(){
		var file = $( "#map" );
		patientServices.mapUploadFile(file[0].files[0], $scope.patient, $rootScope.currentUser).then(function(response){
			toastr.success('uploaded');
			patientServices.genericGet($scope.patient._links.self.href).then(function(response){
				$scope.patient = response.data;
				$state.go('app.profile',{},{reload:true});
			}).catch(function(response) {
				console.error('Error',response);
				toastr.error(response.data.message, 'Error');
		    });
		}).catch(function(response){
			console.error('Error',response);
			toastr.error(response.data.message, 'Error');
		});
	};
	
	$scope.uploadEco = function(){
		var file = $( "#eco" );
		patientServices.ecoMapUploadFile(file[0].files[0], $scope.patient, $rootScope.currentUser).then(function(response){
			toastr.success('uploaded');
			patientServices.genericGet($scope.patient._links.self.href).then(function(response){
				$scope.patient = response.data;
				$state.go('app.profile',{},{reload:true});
			}).catch(function(response) {
				console.error('Error',response);
				toastr.error(response.data.message, 'Error');
		    });
		}).catch(function(response){
			console.error('Error',response);
			toastr.error(response.data.message, 'Error');
		});
	};
	$scope.uploadGeno = function(){
		var file = $( "#geno" );
		patientServices.genoMapUploadFile(file[0].files[0], $scope.patient, $rootScope.currentUser).then(function(response){
			toastr.success('uploaded');
			patientServices.genericGet($scope.patient._links.self.href).then(function(response){
				$scope.patient = response.data;
				$state.go('app.profile',{},{reload:true});
			}).catch(function(response) {
				console.error('Error',response);
				toastr.error(response.data.message, 'Error');
		    });
		}).catch(function(response){
			console.error('Error',response);
			toastr.error(response.data.message, 'Error');
		});
	};
  }
]);