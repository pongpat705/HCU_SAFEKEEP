
'use strict';
angular
	.module('app')
		.controller('landingCtrl', [	'$scope', '$http', '$localStorage', 
									'$timeout', '$translate', '$auth', 
									'$state' , '$stateParams', 'Restangular', 
									'toastr', '$rootScope', 'patientServices',
  function landingCtrl($scope, $http, $localStorage, 
		  			$timeout, $translate, $auth, 
		  			$state, $stateParams, Restangular, 
		  			toastr, $rootScope, patientServices) {
	
	$scope.$watch("init", function(){
		if('' == $rootScope.currentUser){
			$state.go('user.signout');
		}
		$scope.param = $rootScope.param;
			$scope.findPatientTransaction();
	});
	
	$scope.patientProfile = {};
	$scope.patient = {};
	
	$scope.findPatientTransaction = function(){
		patientServices.getPatientByIndexName($rootScope.currentUser).then(function(response){
			$scope.patient = response.data;
			var currentDate = new Date();
			var day = currentDate.getDate();
			var month = currentDate.getMonth()+1;
			var year = currentDate.getFullYear();
			var formatedDate = year+'/'+month+'/'+day;
			patientServices.findByCreatedDate(formatedDate, $rootScope.currentUser).then(function(response){
				console.log(response);
				if(response.data._embedded.ipePatientTransactions.length>0){
					$scope.txn = response.data._embedded.ipePatientTransactions[0];
					
				} else {
					//create
					var createdDate =year+'-'+month+'-'+day;
					var txn = { createdDate: createdDate, indexName : $rootScope.currentUser};
					
					patientServices.addPatientTransaction(txn).then(function(cresponse){
						//patch relate with profile
						console.log(cresponse);
						$scope.txn = cresponse.data;
						$scope.patchPatient($scope.txn._links.self.href, $scope.patient._links.transactions.href);
					}).catch(function(cresponse){
						console.error('Error',cresponse);
						toastr.error(cresponse.data.message, 'Error');
					});
				}
				
			}).catch(function(response) {
				console.error('Error',response);
				toastr.error(response.data.message, 'Error');
		    });
		}).catch(function(response){
			console.error('Error',response);
			toastr.error(response.data.message, 'Error');
		});
	};
	
	$scope.patchPatient = function(patient, link){
		patientServices.patchPatientParent(patient, link).then(function(response){
			toastr.success('saved');
		}).catch(function(response) {
			console.error('Error',response);
			toastr.error(response.data.message, 'Error');
	    });
	};
	
	
	$scope.selecTrack = function(){
		$state.go('app.track',{txn:$scope.txn})
	};
	
	$scope.selectMenu = function(menuCode){
		$state.go('app.txn',{menuCode: menuCode, txn:$scope.txn})
	};
	
	
  }
]);