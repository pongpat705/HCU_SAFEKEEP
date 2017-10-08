
'use strict';
angular
	.module('app')
		.controller('txnCtrl', [	'$scope', '$http', '$localStorage', 
									'$timeout', '$translate', '$auth', 
									'$state' , '$stateParams', 'Restangular', 
									'toastr', '$rootScope', 'patientServices',
  function txnCtrl($scope, $http, $localStorage, 
		  			$timeout, $translate, $auth, 
		  			$state, $stateParams, Restangular, 
		  			toastr, $rootScope, patientServices) {
	
	$scope.$watch("init", function(){
		if(undefined == $stateParams.menuCode){
			$scope.param = $rootScope.param;
			$state.go('app.landing',{},{reload:true});
		}
		
	});
	var menuCode = $stateParams.menuCode;
	$scope.patientProfile = {};
	
	$scope.saveTxn = function(txn){
		console.log(txn);
	};
	
	var wTab = [
        { title: 'ข้อมูลติดตาม 1.1', content: 'views/app/landing/questionnair/W_01.html' },
        { title: 'ข้อมูลติดตาม 1.2', content: 'views/app/landing/questionnair/W_02.html'},
        { title: 'ข้อมูลติดตาม 1.3', content: 'views/app/landing/questionnair/W_03.html'}
	],  
	bSelected = null,
    bPrevious = null;
	
	var pTab = [
        { title: 'ข้อมูลติดตาม 2.1', content: 'views/app/landing/questionnair/P_01.html'},
        { title: 'ข้อมูลติดตาม 2.2', content: 'views/app/landing/questionnair/P_02.html'}
	],  
	bSelected = null,
    bPrevious = null;
	
	var uTab = [
        { title: 'ข้อมูลติดตาม 3.1', content: 'views/app/landing/questionnair/U_01.html'},
        { title: 'ข้อมูลติดตาม 3.2', content: 'views/app/landing/questionnair/U_02.html'},
        { title: 'ข้อมูลติดตาม 3.3', content: 'views/app/landing/questionnair/U_03.html'}
	],  
	bSelected = null,
    bPrevious = null;
	
	var sTab = [
        { title: 'ข้อมูลติดตาม 4.1', content: 'views/app/landing/questionnair/S_01.html'},
        { title: 'ข้อมูลติดตาม 4.2', content: 'views/app/landing/questionnair/S_02.html'}
	],  
	bSelected = null,
    bPrevious = null;
	
	var eTab = [
        { title: 'ข้อมูลติดตาม 5.1', content: 'views/app/landing/questionnair/E_01.html'},
        { title: 'ข้อมูลติดตาม 5.2', content: 'views/app/landing/questionnair/E_02.html'}
	],  
	bSelected = null,
    bPrevious = null;
	
	var labTab = [
		{ title: 'ข้อมูลห้องปฏิบัติการ', content: 'views/app/landing/questionnair/LAB.html'}
	],  
	bSelected = null,
    bPrevious = null;
	
	var daTab = [
        { title: 'ประจำวัน 1', content: 'views/app/landing/questionnair/DA_01.html'},
        { title: 'ประจำวัน 2', content: 'views/app/landing/questionnair/DA_02.html'},
        { title: 'ประจำวัน 3', content: 'views/app/landing/questionnair/DA_03.html'},
        { title: 'ประจำวัน 4', content: 'views/app/landing/questionnair/DA_04.html'},
        { title: 'ประจำวัน 5', content: 'views/app/landing/questionnair/DA_05.html'},
        { title: 'ประจำวัน 6', content: 'views/app/landing/questionnair/DA_06.html'},
        { title: 'ประจำวัน 7', content: 'views/app/landing/questionnair/DA_07.html'},
        { title: 'ประจำวัน 8', content: 'views/app/landing/questionnair/DA_08.html'},
        { title: 'ประจำวัน 9', content: 'views/app/landing/questionnair/DA_09.html'},
        { title: 'ประจำวัน 10', content: 'views/app/landing/questionnair/DA_10.html'}
	],  
	bSelected = null,
    bPrevious = null;
	
	var soTab = [
        { title: 'เข่าเสื่อม  1', content: 'views/app/landing/questionnair/SO_01.html'},
        { title: 'เข่าเสื่อม  2', content: 'views/app/landing/questionnair/SO_02.html'},
        { title: 'เข่าเสื่อม  3', content: 'views/app/landing/questionnair/SO_03.html'},
        { title: 'เข่าเสื่อม  4', content: 'views/app/landing/questionnair/SO_04.html'},
        { title: 'เข่าเสื่อม  5', content: 'views/app/landing/questionnair/SO_05.html'},
        { title: 'เข่าเสื่อม  6', content: 'views/app/landing/questionnair/SO_06.html'},
        { title: 'เข่าเสื่อม  7', content: 'views/app/landing/questionnair/SO_07.html'},
        { title: 'เข่าเสื่อม  8', content: 'views/app/landing/questionnair/SO_08.html'},
        { title: 'เข่าเสื่อม  9', content: 'views/app/landing/questionnair/SO_09.html'},
        { title: 'เข่าเสื่อม  10', content: 'views/app/landing/questionnair/SO_10.html'},
        { title: 'เข่าเสื่อม  11', content: 'views/app/landing/questionnair/SO_11.html'},
        { title: 'เข่าเสื่อม  12', content: 'views/app/landing/questionnair/SO_12.html'},
        
        { title: 'ปวดข้อ  1', content: 'views/app/landing/questionnair/PL_01.html'},
        { title: 'ปวดข้อ  2', content: 'views/app/landing/questionnair/PL_02.html'},
        { title: 'ปวดข้อ  3', content: 'views/app/landing/questionnair/PL_03.html'},
        { title: 'ปวดข้อ  4', content: 'views/app/landing/questionnair/PL_04.html'},
        { title: 'ปวดข้อ  5', content: 'views/app/landing/questionnair/PL_05.html'},
        
        { title: 'ข้อฝืด  1', content: 'views/app/landing/questionnair/SN_01.html'},
        { title: 'ข้อฝืด  2', content: 'views/app/landing/questionnair/SN_02.html'},
        
        { title: 'ใช้งานข้อ  1', content: 'views/app/landing/questionnair/KO_01.html'},
        { title: 'ใช้งานข้อ  2', content: 'views/app/landing/questionnair/KO_02.html'},
        { title: 'ใช้งานข้อ  3', content: 'views/app/landing/questionnair/KO_03.html'},
        { title: 'ใช้งานข้อ  4', content: 'views/app/landing/questionnair/KO_04.html'},
        { title: 'ใช้งานข้อ  5', content: 'views/app/landing/questionnair/KO_05.html'},
        { title: 'ใช้งานข้อ  6', content: 'views/app/landing/questionnair/KO_06.html'},
        { title: 'ใช้งานข้อ  7', content: 'views/app/landing/questionnair/KO_07.html'},
        { title: 'ใช้งานข้อ  8', content: 'views/app/landing/questionnair/KO_08.html'},
        { title: 'ใช้งานข้อ  9', content: 'views/app/landing/questionnair/KO_09.html'},
        { title: 'ใช้งานข้อ  10', content: 'views/app/landing/questionnair/KO_10.html'},
        { title: 'ใช้งานข้อ  11', content: 'views/app/landing/questionnair/KO_11.html'},
        { title: 'ใช้งานข้อ  12', content: 'views/app/landing/questionnair/KO_12.html'},
        { title: 'ใช้งานข้อ  13', content: 'views/app/landing/questionnair/KO_13.html'},
        { title: 'ใช้งานข้อ  14', content: 'views/app/landing/questionnair/KO_14.html'},
        { title: 'ใช้งานข้อ  15', content: 'views/app/landing/questionnair/KO_15.html'}
	],  
	bSelected = null,
    bPrevious = null;
	
	var plTab = [
        { title: 'ปวดข้อ  1', content: 'views/app/landing/questionnair/PL_01.html'},
        { title: 'ปวดข้อ  2', content: 'views/app/landing/questionnair/PL_02.html'},
        { title: 'ปวดข้อ  3', content: 'views/app/landing/questionnair/PL_03.html'},
        { title: 'ปวดข้อ  4', content: 'views/app/landing/questionnair/PL_04.html'},
        { title: 'ปวดข้อ  5', content: 'views/app/landing/questionnair/PL_05.html'}
	],  
	bSelected = null,
    bPrevious = null;
	
	var snTab = [
		{ title: 'ข้อฝืด  1', content: 'views/app/landing/questionnair/SN_01.html'},
        { title: 'ข้อฝืด  2', content: 'views/app/landing/questionnair/SN_02.html'}
	],  
	bSelected = null,
    bPrevious = null;
	
	var koTab = [
	 	{ title: 'ใช้งานข้อ  1', content: 'views/app/landing/questionnair/KO_01.html'},
        { title: 'ใช้งานข้อ  2', content: 'views/app/landing/questionnair/KO_02.html'},
        { title: 'ใช้งานข้อ  3', content: 'views/app/landing/questionnair/KO_03.html'},
        { title: 'ใช้งานข้อ  4', content: 'views/app/landing/questionnair/KO_04.html'},
        { title: 'ใช้งานข้อ  5', content: 'views/app/landing/questionnair/KO_05.html'},
        { title: 'ใช้งานข้อ  6', content: 'views/app/landing/questionnair/KO_06.html'},
        { title: 'ใช้งานข้อ  7', content: 'views/app/landing/questionnair/KO_07.html'},
        { title: 'ใช้งานข้อ  8', content: 'views/app/landing/questionnair/KO_08.html'},
        { title: 'ใช้งานข้อ  9', content: 'views/app/landing/questionnair/KO_09.html'},
        { title: 'ใช้งานข้อ  10', content: 'views/app/landing/questionnair/KO_10.html'},
        { title: 'ใช้งานข้อ  11', content: 'views/app/landing/questionnair/KO_11.html'},
        { title: 'ใช้งานข้อ  12', content: 'views/app/landing/questionnair/KO_12.html'},
        { title: 'ใช้งานข้อ  13', content: 'views/app/landing/questionnair/KO_13.html'},
        { title: 'ใช้งานข้อ  14', content: 'views/app/landing/questionnair/KO_14.html'},
        { title: 'ใช้งานข้อ  15', content: 'views/app/landing/questionnair/KO_15.html'}
	],  
	bSelected = null,
    bPrevious = null;
	var bTabs = null;
	
	if('TXN_01' === menuCode){
		bTabs = wTab;
	} else if('TXN_02' === menuCode){
		bTabs = pTab;
	} else if('TXN_03' === menuCode){
		bTabs = uTab;
	} else if('TXN_04' === menuCode){
		bTabs = sTab;
	} else if('TXN_05' === menuCode){
		bTabs = eTab;
	} else if('PM_02' === menuCode){
		bTabs = labTab;
	} else if('PM_03' === menuCode){
		bTabs = daTab;
	} else if('PM_04' === menuCode){
		bTabs = soTab;
	}
	 
	    
	    $scope.bTabs = bTabs;
	    $scope.bSelectedIndex = 0;
	    $scope.$watch('bSelectedIndex', function(current, old){
	    	bPrevious = bSelected;
	      bSelected = bTabs[current];
	      if ( old + 1 && (old != current)) console.log('Goodbye ' + bPrevious.title + '!');
	      if ( current + 1 )                console.log('Hello ' + bSelected.title + '!');
	    });
	    
	    
	    
	    
	    
//	    $scope.addTab = function (title, view) {
//	      view = view || title + " Content View";
//	      tabs.push({ title: title, content: view, disabled: false});
//	    };
//	    $scope.removeTab = function (tab) {
//	      var index = tabs.indexOf(tab);
//	      tabs.splice(index, 1);
//	    };
	
  }
]);