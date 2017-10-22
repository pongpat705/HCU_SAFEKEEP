
'use strict';
angular
	.module('app')
		.controller('transactionCtrl', [	'$scope', '$http', '$localStorage', 
									'$timeout', '$translate', '$auth', 
									'$state' , '$stateParams', 'Restangular', 
									'toastr', '$rootScope', 'patientServices',
  function transactionCtrl($scope, $http, $localStorage, 
		  			$timeout, $translate, $auth, 
		  			$state, $stateParams, Restangular, 
		  			toastr, $rootScope, patientServices) {
	
	$scope.$watch("init", function(){
		if('' == $rootScope.currentUser){
			$rootScope.unAuthorized();
		} else {
			$scope.patient = $stateParams.patient;
			$scope.getPatientTransaction($scope.patient.patientId, 0, 20);
		}
	});
	var paginationOptions = {
	        pageNumber: 0,
	        pageSize: 20,
	        sort: null
    };
	
	
	$scope.combo = $rootScope.comboBox;
	$scope.param = $rootScope.param;
	
	$scope.txn = null;
	
	$scope.prevMenu = function(){
		$state.go($rootScope.prevState);
	};
	
	$scope.getPatientTransaction = function(patientId, page, size){
		patientServices.getPatienTransactions(patientId, page, size).then(function(response){
			$scope.patientGridOptions.data = response.data._embedded.ipePatientTransactions;
			$scope.patientGridOptions.totalItems = response.data.page.totalElements;
		}).catch(function(response) {
			console.error('Error',response);
			toastr.error(response.data.message, 'Error');
	    });
	};
	
	$scope.saveEstimate = function(estimate){
		estimate.userId = $rootScope.currentUser;
		if(null == estimate.estimateId){
			patientServices.addEstimate(estimate).then(function(response){
				var data = response.data._links.self.href;
				var link = $scope.txn._links.estimates.href;
				patientServices.patchPatientParent(data, link).then(function(response){
					toastr.success('saved');
				}).catch(function(response) {
					console.error('Error',response);
					toastr.error(response.data.message, 'Error');
			    });
			}).catch(function(response) {
				console.error('Error',response);
				toastr.error(response.data.message, 'Error');
		    });
		} else {
			patientServices.genericPatch(estimate, estimate._links.self.href).then(function(response){
				toastr.success('saved');
			}).catch(function(response) {
				console.error('Error',response);
				toastr.error(response.data.message, 'Error');
		    });
		}
	};
	
	
	$scope.showDetail = function(txn){
		$scope.txn = txn;
		
		if(!$rootScope.checkPermission('ROLE_PROF')){
			patientServices.getEstimateByUserId($rootScope.currentUser).then(function(response){
				$scope.estimate = response.data;
			}).catch(function(response) {
				console.error('Error',response);
				if(404 == response.status){
					toastr.info($scope.param.MESSAGE.DATA_NOTFOUND.infoTh, 'Error');
				} else {
					toastr.error(response.data.message, 'Error');
				}
		    });
		}
		
		$scope.loadLabs();
		
		if($rootScope.checkPermission('ROLE_PROF')){
			$scope.genericGet($scope.txn._links.estimates.href).then(function(response){
				$scope.estimateList = response.data._embedded.ipeStudentEstimates;
			});
		}
		
	};
	
	$scope.loadLabs = function(){
		patientServices.genericGet($scope.txn._links.medical.href).then(function(response){
			$scope.labs = response.data._embedded.ipeMedicalTechnicals;
		}).catch(function(response) {
			console.error('Error',response);
			if(404 == response.status){
				toastr.info($scope.param.MESSAGE.DATA_NOTFOUND.infoTh, 'Error');
			} else {
				toastr.error(response.data.message, 'Error');
			}
	    });
	};
	
	$scope.patientGridOptions = {
            paginationPageSizes: [5, 10, 20],
            paginationPageSize: paginationOptions.pageSize,
            enableColumnMenus:false,
            enableAutoFitColumns: true,
            useExternalPagination: true,
            columnDefs: [
                { name: 'วันที่', field:'createdDate', width: 100,  type : 'date', cellFilter : 'date:"dd/MM/yyyy"',},
    			{
                    name : 'ดูข้อมูล',
                    cellTemplate : '<div class="ui-grid-cell-contents">' +
                                        '<button class="btn btn-xs btn-primary" title="full view" ng-click="grid.appScope.showDetail(row.entity)" >ดูข้อมูลประจำวัน</button>' +
                                   '</div>',
                                   width: 100,
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
                   
                   patientServices.getPatienTransactions($scope.patient.patientId, newPage-1, pageSize).then(function(response){
           			$scope.patientGridOptions.data = response.data._embedded.ipePatientTransactions;
           			$scope.patientGridOptions.totalItems = response.data.page.totalElements;
    	       		}).catch(function(response) {
    	       			console.error('Error',response);
    	       			toastr.error(response.data.message, 'Error');
    	       	    });
                });
            }
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
	
  }
]);