
'use strict';
angular
	.module('app')
		.controller('physicCtrl', [	'$scope', '$http', '$localStorage', 
									'$timeout', '$translate', '$auth', 
									'$state' , '$stateParams', 'Restangular', 
									'toastr', '$rootScope', 'patientServices',
  function physicCtrl($scope, $http, $localStorage, 
		  			$timeout, $translate, $auth, 
		  			$state, $stateParams, Restangular, 
		  			toastr, $rootScope, patientServices) {
	
	$scope.$watch("init", function(){
		if('' == $rootScope.currentUser){
			$rootScope.unAuthorized();
		} else {
			$scope.patient = $stateParams.patient;
//			$scope.getPtByPatientId($scope.patient.patientId, 0, 20);
			$scope.getPtInfo($scope.patient._links.ptStudent.href);
		}
	});
	var paginationOptions = {
	        pageNumber: 0,
	        pageSize: 20,
	        sort: null
    };
	
	
	$scope.combo = $rootScope.comboBox;
	$scope.param = $rootScope.param;
	$scope.pt = null;
	
	$scope.prevMenu = function(){
		$state.go($rootScope.prevState);
	};
	
	$scope.getPtByPatientId = function(patientId, page, size){
		patientServices.getPtByPatientId(patientId, page, size).then(function(response){
			$scope.ptGridOption.data = response.data._embedded.ipePatientPtStudents;
			$scope.ptGridOption.totalItems = response.data.page.totalElements;
		}).catch(function(response) {
			console.error('Error',response);
			toastr.error(response.data.message, 'Error');
	    });
	};
	
	$scope.getPtInfo = function(link){
		$scope.genericGet(link).then(function(response){
			var pt = response.data;
			console.log(pt);
			$scope.showDetail(pt);
		});
	};
	
	$scope.ptGridOption = {
            paginationPageSizes: [5, 10, 20],
            paginationPageSize: paginationOptions.pageSize,
            enableColumnMenus:false,
            enableAutoFitColumns: true,
            useExternalPagination: true,
            columnDefs: [
                { name: 'ผู้ประเมิน', field:'studentId', width: 100},
    			{
                    name : 'รายละเอียด',
                    cellTemplate : '<div class="ui-grid-cell-contents">' +
                                        '<button class="btn btn-xs btn-primary" title="ดูข้อมูล" ng-click="grid.appScope.showDetail(row.entity)" ><i class="fa fa-search" aria-hidden="true"></i> ดูข้อมูลประเมิน</button>' +
                                   '</div>',
                                   width: 130,
                    enableCellEdit : false
                }
    			
            ],
            onRegisterApi: function(gridApi) {
               $scope.gridApi = gridApi;
               gridApi.pagination.on.paginationChanged(
                 $scope, 
                 function (newPage, pageSize) {
                   paginationOptions.pageNumber = newPage;
                   paginationOptions.pageSize = pageSize;
                   
                   patientServices.getPtByPatientId($scope.patient.patientId, newPage-1, pageSize).then(function(response){
           			$scope.ptGridOption.data = response.data._embedded.ipePatientPtStudents;
           			$scope.ptGridOption.totalItems = response.data.page.totalElements;
    	       		}).catch(function(response) {
    	       			console.error('Error',response);
    	       			toastr.error(response.data.message, 'Error');
    	       	    });
                });
            }
        };
	
	$scope.showDetail = function(pt){
		$scope.pt = pt;
		$scope._links = $scope.pt._links;
		
//		if($rootScope.checkPermission('ROLE_PROF')){
			$scope.loadExaminate();
			$scope.loadConclude();
			$scope.loadGoal();
			$scope.loadNote();
//		}
		
	};
	
	$scope.loadExaminate = function(){
		$scope.genericGet($scope._links.examinations.href).then(function(response){
			$scope.examinations = response.data._embedded.ipePatientExaminations;
		});
	};
	$scope.loadConclude = function(){
		$scope.genericGet($scope._links.concludeAnalysis.href).then(function(response){
			$scope.concludeAnalysis = response.data._embedded.ipeConcludeAnalyses;
		});
	};
	$scope.loadGoal = function(){
		$scope.genericGet($scope._links.goals.href).then(function(response){
			$scope.goals = response.data._embedded.ipeGoalPlans;
		});
	};
	$scope.loadNote = function(){
		$scope.genericGet($scope._links.notes.href).then(function(response){
			$scope.notes = response.data._embedded.ipeProgressNotes;
		});
	};
	
	$scope.genericGet = function(link){
		var result = null;
		result = patientServices.genericGet(link).then(function(response){
			return response;
		}).catch(function(response) {
			if(404 == response.status){
				toastr.error('ไม่พบข้อมูล', 'Error');
			}else{
				console.error('Error',response);
				toastr.error(response.data.message, 'Error');
			}
			
	    });
		return result;
	};
	
  }
]);