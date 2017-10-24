
'use strict';
angular
	.module('app')
		.controller('userCtrl', [	'$scope', '$http', '$localStorage', 
									'$timeout', '$translate', '$auth', 
									'$state' , '$stateParams', 'Restangular', 
									'toastr', '$rootScope', 'userService',
									'$mdDialog',
  function userCtrl($scope, $http, $localStorage, 
		  			$timeout, $translate, $auth, 
		  			$state, $stateParams, Restangular, 
		  			toastr, $rootScope, userService,
		  			$mdDialog) {
	
	$scope.$watch("init", function(){
		if('' == $rootScope.currentUser){
			$state.go('user.signout');
		} else {
			$scope.getAllUser(0, 20);
		}
		
	});
	
	var paginationOptions = {
	        pageNumber: 0,
	        pageSize: 20,
	        sort: null
    };
	
	var isRoleAdmin = $rootScope.checkPermission('ROLE_ADMIN');
	
	$scope.getAllUser = function(page, size){
		userService.getAllUser(page, size).then(function(response){
			$scope.userGridOptions.data = response.data._embedded.users;
			$scope.userGridOptions.totalItems = response.data.page.totalElements;
		}).catch(function(response) {
			console.error('Error',response);
			toastr.error(response.data.message, 'Error');
	    });
	};
	$scope.addNewUser = function(ev){
		$mdDialog.show({
		      controller: DialogController,
		      templateUrl: 'views/app/user/dialog.html',
		      parent: angular.element(document.body),
		      targetEvent: ev,
		      clickOutsideToClose:true,
		      fullscreen: $scope.customFullscreen // Only for -xs, -sm breakpoints.
		    })
		    .then(function(answer) {
		      $scope.status = 'You said the information was "' + answer + '".';
		    }, function() {
		      $scope.status = 'You cancelled the dialog.';
		    });
	}
	$scope.del = function(e, link, ev){
		// Appending dialog to document.body to cover sidenav in docs app
	    var confirm = $mdDialog.confirm()
	          .title('Would you like to delete this user?')
	          .textContent('this action can not recovery.')
	          .ariaLabel('Lucky day')
	          .targetEvent(ev)
	          .ok('OK!')
	          .cancel('CANCEL');

	    $mdDialog.show(confirm).then(function() {
	      $scope.status = 'You decided to get rid of your debt.';
	    }, function() {
	      $scope.status = 'You decided to keep your debt.';
	    });
	};
	
	$scope.userGridOptions = {
            paginationPageSizes: [5, 10, 20],
            paginationPageSize: paginationOptions.pageSize,
            enableColumnMenus:false,
            enableAutoFitColumns: true,
            useExternalPagination: true,
            columnDefs: [
                { name: 'userName', width: 150},
    			{ name: 'name', width: 50},
    			{ name: 'studentId', width: 100},
    			{ name: 'major', width: 100},
    			{ name: 'years', width: 100},
    			{ name: 'advisor', width: 100},
    			{ name: 'hospital', width: 100},
                {
                    name : 'Delete',
                    cellTemplate : '<div class="ui-grid-cell-contents">' +
                                        '<button class="btn btn-xs btn-danger" title="delete this" ng-click="grid.appScope.del(row.entity._links.self.href, $event);" ><i class="fa fa-trash-o" aria-hidden="true"></i> Delete</button>' +
                                   '</div>',
                                   width: 100,
                    enableCellEdit : false,
                    visible : isRoleAdmin
                }
    			
            ],
            onRegisterApi: function(gridApi) {
               $scope.gridApi = gridApi;
               gridApi.pagination.on.paginationChanged(
                 $scope, 
                 function (newPage, pageSize) {
                   paginationOptions.pageNumber = newPage;
                   paginationOptions.pageSize = pageSize;
                   
                   userService.getAllUser(newPage-1, pageSize).then(function(response){
           			$scope.userGridOptions.data = response.data._embedded.users;
           			$scope.userGridOptions.totalItems = response.data.page.totalElements;
    	       		}).catch(function(response) {
    	       			console.error('Error',response);
    	       			toastr.error(response.data.message, 'Error');
    	       	    });
                });
            }
        };
	
	function DialogController($scope, $rootScope, $mdDialog, userService, toastr) {
		$scope.combo = $rootScope.comboBox;
		$scope.param = $rootScope.param;
		
	    $scope.hide = function() {
	      $mdDialog.hide();
	    };

	    $scope.cancel = function() {
	      $mdDialog.cancel();
	    };

	    $scope.add = function(user) {
	    	console.log(user);
	    	userService.addUser(user).then(function(response){
	    		toastr.success('Added', 'Info');
	    		$scope.hide();
			}).catch(function(response) {
				console.error('Error',response);
				toastr.error(response.data.message, 'Error');
				$scope.hide();
		    });
	      
	    };
	  }
  }
]);