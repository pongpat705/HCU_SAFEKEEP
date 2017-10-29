
'use strict';
angular
	.module('app')
		.controller('pharmaCtrl', [	'$scope', '$http', '$localStorage', 
									'$timeout', '$translate', '$auth', 
									'$state' , '$stateParams', 'Restangular', 
									'toastr', '$rootScope', 'patientServices',
  function pharmaCtrl($scope, $http, $localStorage, 
		  			$timeout, $translate, $auth, 
		  			$state, $stateParams, Restangular, 
		  			toastr, $rootScope, patientServices) {
	
	$scope.$watch("init", function(){
		if('' == $rootScope.currentUser){
			$rootScope.unAuthorized();
		} else {
			$scope.patient = $stateParams.patient;
//			$scope.getPhByPatientId($scope.patient.patientId, 0, 20);
			$scope.getPhInfo($scope.patient._links.phStudent.href);
		}
	});
	var paginationOptions = {
	        pageNumber: 0,
	        pageSize: 20,
	        sort: null
    };
	
	
	$scope.combo = $rootScope.comboBox;
	$scope.param = $rootScope.param;
	$scope.ph = null;
	
	
	$scope.prevMenu = function(){
		$state.go($rootScope.prevState);
	};
	
	$scope.getPhByPatientId = function(patientId, page, size){
		patientServices.getPhByPatientId(patientId, page, size).then(function(response){
			$scope.phGridOption.data = response.data._embedded.ipePatientPhStudents;
			$scope.phGridOption.totalItems = response.data.page.totalElements;
		}).catch(function(response) {
			console.error('Error',response);
			toastr.error(response.data.message, 'Error');
	    });
	};
	
	$scope.getPhInfo = function(link){
		$scope.genericGet(link).then(function(response){
			var ph = response.data;
			console.log(ph);
			$scope.showDetail(ph);
		});
	};
	
	$scope.phGridOption = {
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
                   
                   patientServices.getPhByPatientId($scope.patient.patientId, newPage-1, pageSize).then(function(response){
           			$scope.phGridOption.data = response.data._embedded.ipePatientPtStudents;
           			$scope.phGridOption.totalItems = response.data.page.totalElements;
    	       		}).catch(function(response) {
    	       			console.error('Error',response);
    	       			toastr.error(response.data.message, 'Error');
    	       	    });
                });
            }
        };
	
	$scope.showDetail = function(ph){
		$scope.ph = ph;
		$scope._links = $scope.ph._links;
		
		if($rootScope.checkPermission('ROLE_PROF')){
			$scope.loadCompliance();
			$scope.loadDrp();
			$scope.loadReconcil();
		}
		
	};
	
	$scope.loadCompliance = function(){
		$scope.genericGet($scope._links.compliances.href).then(function(response){
			$scope.compliances = response.data._embedded.ipePhCompliances;
		});
	};
	$scope.loadDrp = function(){
		$scope.genericGet($scope._links.drpReports.href).then(function(response){
			$scope.drps = response.data._embedded.ipeDrpReports;
		});
	};
	$scope.loadReconcil = function(){
		$scope.genericGet($scope._links.reconcils.href).then(function(response){
			$scope.reconcils = response.data._embedded.ipeMedReconcils;
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