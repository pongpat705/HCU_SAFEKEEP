
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
		} else {
			$scope.getPatientProfileList();
		}
		
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
			$state.go('app.profile',{patient : response.data, mode : 'add'})
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
                { name: 'ชื่อ', field: 'name', width: 150},
    			{ name: 'อายุ', field: 'age', width: 50},
    			{ name: 'เบอร์โทรศัพท์เคลื่อนที่', field: 'mobile', width: 100},
    			{ name: 'อาการ', field: 'diagnose', width: 100},
    			{
                    name : 'ข้อมูลพื้นฐานผู้ป่วย',
                    cellTemplate : '<div class="ui-grid-cell-contents">' +
                                       '<button class="btn btn-xs btn-primary" title="ข้อมูลพื้นฐาน" ui-sref="app.profile({patient: row.entity, mode:null})" ><i class="fa fa-info-circle" aria-hidden="true"></i> ข้อมูลผู้ป่วย</button>' +
                                       '&nbsp;<button class="btn btn-xs btn-warning" title="ข้อมูลกายภาพบำบัด" ui-sref="app.physic({patient: row.entity})"><i class="fa fa-odnoklassniki" aria-hidden="true"></i> ข้อมูลผู้ป่วย(กายภาพบำบัด)</button>' +
                                       '&nbsp;<button class="btn btn-xs btn-info" title="ข้อมูลเภสัชวิทยา" ui-sref="app.pharmachy({patient: row.entity})" ><i class="fa fa-medkit" aria-hidden="true"></i> ข้อมูลผู้ป่วย(เภสัชศาสตร์)</button>' +
                                   '</div>',
                                   width: 415,
                    enableCellEdit : false
                },
                {
                	name : 'ข้อมูลผู้ป่วยรายวัน',
                    cellTemplate : '<div class="ui-grid-cell-contents">' +
                                        '<button class="btn btn-xs btn-white" title="ข้อมูลผู้ป่วยประจำวัน" ui-sref="app.transaction({patient: row.entity})"><i class="fa fa-wheelchair" aria-hidden="true"></i> ข้อมูลผู้ป่วยประจำวัน</button>' +
                                   '</div>',
                                   width: 140,
                    enableCellEdit : false
                },
                {
                    name : 'ลบข้อมูล',
                    cellTemplate : '<div class="ui-grid-cell-contents">' +
                                        '<button class="btn btn-xs btn-danger" title="ลบข้อมูลนี้" ng-click="grid.appScope.delPatient(row.entity._links.self.href);" ><i class="fa fa-trash-o" aria-hidden="true"></i> ลบข้อมูลผู้ป่วย</button>' +
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