
'use strict';
angular
	.module('app')
		.controller('ptCtrl', [	'$scope', '$http', '$localStorage', 
									'$timeout', '$translate', '$auth', 
									'$state' , '$stateParams', 'Restangular', 
									'toastr', '$rootScope', 'patientServices',
  function ptCtrl($scope, $http, $localStorage, 
		  			$timeout, $translate, $auth, 
		  			$state, $stateParams, Restangular, 
		  			toastr, $rootScope, patientServices) {
	
	$scope.$watch("init", function(){
		$scope.pt = {};
		$scope.patient = {};
		$scope._links = {};
		if('' == $rootScope.currentUser){
			$rootScope.unAuthorized();
		} else {
			$scope.getPatients();
			$scope.initPatientPtStudentByStudentId();
			
		}
	});
	
	$scope.uploadFile = function(){
		var file = $( "#file" );
		patientServices.ptUploadFile(file[0].files[0], $scope.pt, $rootScope.currentUser).then(function(response){
			toastr.success('uploaded');
			patientServices.genericGet($scope.pt._links.self.href).then(function(response){
				$state.go('app.pt',{},{reload:true});
			}).catch(function(response) {
				console.error('Error',response);
				toastr.error(response.data.message, 'Error');
		    });
		}).catch(function(response){
			console.error('Error',response);
			toastr.error(response.data.message, 'Error');
		});
	};
	
	$scope.getPatients = function(){
		var allPatient = '/ipe/api/ipePatientProfiles'
		patientServices.genericGet(allPatient).then(function(response){
			$scope.patients = response.data._embedded.ipePatientProfiles;
		}).catch(function(response) {
			console.error('Error',response);
			toastr.error(response.data.message, 'Error');
	    });
	};
	
	$scope.initPatientPtStudentByStudentId = function(){
		patientServices.getPatientPtByStudentId($rootScope.currentUser).then(function(response){
			console.log(response);
			$scope.pt = response.data;
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
			
			$scope.loadExaminate();
			$scope.loadConclude();
			$scope.loadGoal();
			$scope.loadNote();
		}).catch(function(response){
			//notfound mean not created
			if(404 == response.status){
				$scope.pt.studentId = $rootScope.currentUser;
				patientServices.addPatientPt($scope.pt).then(function(aResp){
					$scope.pt = aResp.data;
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
	
	$scope.patchPatientPt = function(pt, link){
		patientServices.genericPatch(pt, link).then(function(resp){
			toastr.success('saved');
		}).catch(function(resp){
			console.error('Error',resp);
			toastr.error(resp.data.message, 'Error');
		});
	};
	
	$scope.addExaminat = function(examinat, link){
		patientServices.addExamination(examinat).then(function(response){
			var data = response.data._links.self.href;
			patientServices.patchPatientParent(data, link).then(function(response){
				toastr.success('saved');
				$scope.loadExaminate();
			}).catch(function(response) {
				console.error('Error',response);
				toastr.error(response.data.message, 'Error');
		    });
		}).catch(function(response) {
			console.error('Error',response);
			toastr.error(response.data.message, 'Error');
	    });
	};
	
	$scope.loadExaminate = function(){
		$scope.genericGet($scope._links.examinations.href).then(function(response){
			$scope.examinations = response.data._embedded.ipePatientExaminations;
		});
	};
	$scope.delExaminat = function(ptId, examinatId){
		patientServices.ptDeleteExamination(ptId, examinatId).then(function(response){
			$scope.loadExaminate();
		}).catch(function(response) {
			console.error('Error',response);
			toastr.error(response.data.message, 'Error');
	    });
	};
	
	$scope.addConclude = function(conclude,link){
		patientServices.addConclude(conclude).then(function(response){
			var data = response.data._links.self.href;
			patientServices.patchPatientParent(data, link).then(function(response){
				toastr.success('saved');
				$scope.loadConclude();
			}).catch(function(response) {
				console.error('Error',response);
				toastr.error(response.data.message, 'Error');
		    });
		}).catch(function(response) {
			console.error('Error',response);
			toastr.error(response.data.message, 'Error');
	    });
	};
	
	$scope.loadConclude = function(){
		$scope.genericGet($scope._links.concludeAnalysis.href).then(function(response){
			$scope.concludeAnalysis = response.data._embedded.ipeConcludeAnalyses;
		});
	};
	$scope.delConclude = function(ptId, concludeId){
		patientServices.ptDeleteConclude(ptId, concludeId).then(function(response){
			$scope.loadConclude();
		}).catch(function(response) {
			console.error('Error',response);
			toastr.error(response.data.message, 'Error');
	    });
	};
	
	$scope.addGoal = function(goal,link){
		patientServices.addGoal(goal).then(function(response){
			var data = response.data._links.self.href;
			patientServices.patchPatientParent(data, link).then(function(response){
				toastr.success('saved');
				$scope.loadGoal();
			}).catch(function(response) {
				console.error('Error',response);
				toastr.error(response.data.message, 'Error');
		    });
		}).catch(function(response) {
			console.error('Error',response);
			toastr.error(response.data.message, 'Error');
	    });
	};
	
	$scope.loadGoal = function(){
		$scope.genericGet($scope._links.goals.href).then(function(response){
			$scope.goals = response.data._embedded.ipeGoalPlans;
		});
	};
	$scope.delGoal = function(ptId, goalId){
		patientServices.ptDeleteGoal(ptId, goalId).then(function(response){
			$scope.loadGoal();
		}).catch(function(response) {
			console.error('Error',response);
			toastr.error(response.data.message, 'Error');
	    });
	};
	
	$scope.addNote = function(note,link){
		patientServices.addNote(note).then(function(response){
			var data = response.data._links.self.href;
			patientServices.patchPatientParent(data, link).then(function(response){
				toastr.success('saved');
				$scope.loadNote();
			}).catch(function(response) {
				console.error('Error',response);
				toastr.error(response.data.message, 'Error');
		    });
		}).catch(function(response) {
			console.error('Error',response);
			toastr.error(response.data.message, 'Error');
	    });
	};
	
	$scope.loadNote = function(){
		$scope.genericGet($scope._links.notes.href).then(function(response){
			$scope.notes = response.data._embedded.ipeProgressNotes;
		});
	};
	$scope.delNote = function(ptId, noteId){
		patientServices.ptDeleteNote(ptId, noteId).then(function(response){
			$scope.loadNote();
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