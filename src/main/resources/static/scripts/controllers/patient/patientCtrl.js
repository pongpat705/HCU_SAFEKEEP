
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
		if('' == $rootScope.currentUser){
			$state.go('user.signout');
		}
		$scope.getPatientProfileList();
	});
	var paginationOptions = {
	        pageNumber: 0,
	        pageSize: 20,
	        sort: null
    };
	
	var isRoleProf = $rootScope.checkPermission('ROLE_PROF');
	
	$scope.combo = $rootScope.comboBox;
	$scope.param = $rootScope.param;
	
	$scope.getPatientProfileList = function(page, size){
		patientServices.getPatients(page, size).then(function(response){
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
			$state.go('app.profile',{patient : response.data})
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
	
	$scope.checkRolePermission = function(role){
		return $rootScope.checkPermission(role);
	}
	
	$scope.patientGridOptions = {
            paginationPageSizes: [5, 10, 20],
            paginationPageSize: paginationOptions.pageSize,
            enableColumnMenus:false,
            enableAutoFitColumns: true,
            useExternalPagination: true,
            columnDefs: [
                { name: 'name', width: 150},
    			{ name: 'age', width: 50},
    			{ name: 'mobile', width: 100},
    			{ name: 'diagnose', width: 100},
    			{
                    name : 'Action',
                    cellTemplate : '<div class="ui-grid-cell-contents">' +
                                        '<button class="btn btn-xs btn-info" title="view transaction" ui-sref="app.transaction({patient: row.entity})" >ข้อมูลประจำวันผู้ป่วย</button>' +
                                        '&nbsp;<button class="btn btn-xs btn-primary" title="view profile" ui-sref="app.profile({patient: row.entity})" >ข้อมูลผู้ป่วย</button>' +
                                   '</div>',
                                   width: 210,
                    enableCellEdit : false
                },
                {
                    name : 'Delete',
                    cellTemplate : '<div class="ui-grid-cell-contents">' +
                                        '<button class="btn btn-xs btn-danger" title="delete profile" ng-click="grid.appScope.delPatient(row.entity._links.self.href);" >ลบข้อมูลผู้ป่วย</button>' +
                                   '</div>',
                                   width: 100,
                    enableCellEdit : false,
                    visible : isRoleProf
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