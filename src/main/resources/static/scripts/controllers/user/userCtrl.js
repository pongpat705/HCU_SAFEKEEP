
'use strict';
angular
	.module('app')
		.controller('userCtrl', [	'$scope', '$http', '$localStorage', 
									'$timeout', '$translate', '$auth', 
									'$state' , '$stateParams', 'Restangular', 
									'toastr', '$rootScope', 'NgTableParams',
  function userCtrl($scope, $http, $localStorage, 
		  			$timeout, $translate, $auth, 
		  			$state, $stateParams, Restangular, 
		  			toastr, $rootScope, NgTableParams) {
	
	$scope.$watch("init", function(){
//		$scope.loadUsers();
	});
	
	$scope.users = {};
	
	$scope.tableParams = new NgTableParams({
		 page: 1, // show first page
	     count: 10, // count per page
	     counts: [5,10]
	},{
	     filterDelay: 300,
	     getData: function(params) {
	    	  
    	  	var userService = Restangular.all(CONTEXT+'/api/users');
    	  	var findByUserNameService = Restangular.all(CONTEXT+'/api/users/search/findByUserName');
    	  	var findByUserNameService = Restangular.one(CONTEXT+'/api/users/search/findByUserName');
    	  	console.log(params.filter());
    	  	console.log(params.sorting());
    	  	console.log(params.orderBy());
    	  	
    	  	if(undefined != params.filter().userName){
    	  		return findByUserNameService.get({userName:params.filter().userName}).then(function(response){
    	  			return response;
    	  		}).catch(function(response) {
    	  			console.error('Error',response);
    	  			toastr.error(response.data.message, 'Error');
    	  			if (403 == response.status){
    	  				$rootScope.unAuthorized();
    	  			}
    	  		});
    	  	} else if(undefined != params.filter().password){
    	  		
    	  	} else {
    	  		return userService.getList({size:params.count(),page:params.page()-1}).then(function(response){
    	  			params.total(response.paging.totalElements);
    	  			return response;
    	  		}).catch(function(response) {
    	  			console.error('Error',response);
    	  			toastr.error(response.data.message, 'Error');
    	  			if (403 == response.status){
    	  				$rootScope.unAuthorized();
    	  			}
    	  		});
    	  	}
	  		
	     }
	});
	
	$scope.loadUsers = function(){
		
		
	};
	
	$scope.openModal = function(stationId){
		$state.go('app.user.role.config', {stationId:stationId});
	}
	
  }
]);