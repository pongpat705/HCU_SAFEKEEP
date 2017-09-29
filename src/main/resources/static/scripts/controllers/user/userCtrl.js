
'use strict';
angular
	.module('app')
		.controller('userCtrl', [	'$scope', '$http', '$localStorage', 
									'$timeout', '$translate', '$auth', 
									'$state' , '$stateParams', 'Restangular', 
									'toastr', '$rootScope', 'NgTableParams', 'UserService',
  function userCtrl($scope, $http, $localStorage, 
		  			$timeout, $translate, $auth, 
		  			$state, $stateParams, Restangular, 
		  			toastr, $rootScope, NgTableParams, UserService) {
	
	$scope.$watch("init", function(){
		$scope.users = {};
		$scope.page = 1;
		$scope.pageSize = 10;
		$scope.pageSizeArray = [10,20,50,100];
		$scope.DirectionArray = ['asc', 'desc'];
		$scope.sortColumn = '';
		$scope.sortDirection = '';
		$scope.search
		
		$scope.loadUsers();
	});
	
	$scope.loadUsers = function(){
  			UserService.getAllUser(
				{ 	size:$scope.pageSize, 
					page:$scope.page-1,
					sort:orderColumn+','+orderDirection
				}).then(function(response){
					
					$scope.users = response.data._embedded.users;
					params.total(response.data.page.totalElements);
				}).catch(function(error){
					console.error('Error',error);
					toastr.error(error.data.message, 'Error');
					if (403 == response.status){
						$rootScope.unAuthorized();
					}
				});
  			
//	  		UserService.getUserByName(
//				{
//					userName:params.filter().userName, 
//					size:params.count(), page:params.page()-1,
//					sort:orderColumn+','+orderDirection
//				}).then(function(response){
//					$scope.users = response.data._embedded.users;
//					params.total(response.data.page.totalElements);
//				}).catch(function(error){
//					console.error('Error',error);
//					toastr.error(error.data.message, 'Error');
//					if (403 == response.status){
//						$rootScope.unAuthorized();
//					}
//				});
		
	};
	
	$scope.openModal = function(stationId){
		$state.go('app.user.role.config', {stationId:stationId});
	}
	
  }
]);