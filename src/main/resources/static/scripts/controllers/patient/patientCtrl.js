
'use strict';
angular
	.module('app')
		.controller('patientCtrl', [	'$scope', '$http', '$localStorage', 
									'$timeout', '$translate', '$auth', 
									'$state' , '$stateParams', 'Restangular', 
									'toastr', '$rootScope', 'patientServices',
  function patientCtrl($scope, $http, $localStorage, 
		  			$timeout, $translate, $auth, 
		  			$state, $stateParams, Restangular, 
		  			toastr, $rootScope, patientServices) {
	
	$scope.$watch("init", function(){
		$scope.getPatientProfileList();
	});
	var paginationOptions = {
	        pageNumber: 0,
	        pageSize: 20,
	        sort: null
    };
	
	$scope.combo = $rootScope.comboBox;
	$scope.param = $rootScope.param;
	
	$scope.getPatientProfileList = function(page, size){
		patientServices.getPatients(page, size).then(function(response){
			console.log(response.data);
			$scope.patientGridOptions.data = response.data._embedded.ipePatientProfiles;
			$scope.patientGridOptions.totalItems = response.data.page.totalElements;
		}).catch(function(response) {
			console.error('Error',response);
			toastr.error(response.data.message, 'Error');
	    });
	};
	
	$scope.addNewPatient = function(){
//		ui-sref="app.newpatient"
		var patient = 	{
							createdBy: $rootScope.currentUser,
							createdDate: new Date(),
							updatedBy: $rootScope.currentUser,
							updatedDate: new Date()
						};

		patientServices.addNewPatients(patient).then(function(response){
			$state.go('app.newpatient',{newPatient : response.data})
		}).catch(function(response) {
			console.error('Error',response);
			toastr.error(response.data.message, 'Error');
	    });
	};
	
	$scope.delPatient = function(id){
		patientServices.genericDel(id).then(function(response){
			$state.go('app.patient',{},{reload:true});
		}).catch(function(response) {
			console.error('Error',response);
			toastr.error(response.data.message, 'Error');
	    });
	}
	
	$scope.patientGridOptions = {
            paginationPageSizes: [5, 10, 20],
            paginationPageSize: paginationOptions.pageSize,
            enableColumnMenus:false,
            enableAutoFitColumns: true,
            useExternalPagination: true,
            columnDefs: [
                { name: 'name'},
    			{ name: 'age'},
    			{ name: 'mobile'},
    			{ name: 'houseNo'},
    			{ name: 'groupNo'},
    			{ name: 'district'},
    			{ name: 'prefecture'},
    			{ name: 'province'},
    			{ name: 'diagnose'},
    			{ name: 'createdDate'},
    			{ name: 'createdBy'},
    			{
                    name : 'Action',
                    cellTemplate : '<div class="ui-grid-cell-contents">' +
                                        '<button class="btn btn-xs btn-info" title="view transaction" ui-sref="app.transaction({patient: row.entity})" ><i class="fa fa-list-alt" aria-hidden="true"></i></button>' +
                                        '&nbsp;<button class="btn btn-xs btn-primary" title="view profile" ui-sref="app.profile({patient: row.entity})" ><i class="fa fa-info-circle" aria-hidden="true"></i></button>' +
                                        '&nbsp;<button class="btn btn-xs btn-danger" title="delete profile" ng-click="grid.appScope.delPatient(row.entity._links.self.href);" ><i class="fa fa-trash" aria-hidden="true"></i></button>' +
                                   '</div>',
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
                   
                   patientServices.getPatients(newPage-1, pageSize).then(function(response){
           			$scope.patientGridOptions.data = response.data._embedded.ipePatientProfiles;
           			$scope.patientGridOptions.totalItems = response.data.page.totalElements;
    	       		}).catch(function(response) {
    	       			console.error('Error',response);
    	       			toastr.error(response.data.message, 'Error');
    	       	    });
                });
            }
        };
	
	$scope.openModal = function(userId){
		$state.go('app.user.role.config', {userId:userId});
	}
	
  }
]);