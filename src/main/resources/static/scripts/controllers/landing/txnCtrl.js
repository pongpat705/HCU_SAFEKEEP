
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
		$scope.menuCode = $stateParams.menuCode;
	});
	
	$scope.patientProfile = {};
	
	$scope.saveTxn = function(txn){
		console.log(txn);
	};
	
	 var bTabs = [
	        { title: 'ข้อมูลติดตาม 1.1', content: 'views/app/landing/questionnair/W_01.html' },
	        { title: 'ข้อมูลติดตาม 1.2', content: 'views/app/landing/questionnair/W_02.html'},
	        { title: 'ข้อมูลติดตาม 1.3', content: "You can swipe left and right on a mobile device to change tabs."},
	        { title: 'ข้อมูลติดตาม 2.1', content: "You can bind the selected tab via the selected attribute on the md-tabs element."},
	        { title: 'ข้อมูลติดตาม 2.2', content: "If you set the selected tab binding to -1, it will leave no tab selected."},
	        { title: 'ข้อมูลติดตาม 3.1', content: "If you remove a tab, it will try to select a new one."},
	        { title: 'ข้อมูลติดตาม 3.2', content: "There's an ink bar that follows the selected tab, you can turn it off if you want."},
	        { title: 'ข้อมูลติดตาม 3.3', content: "If you set ng-disabled on a tab, it becomes unselectable. If the currently selected tab becomes disabled, it will try to select the next tab."},
	        { title: 'ข้อมูลติดตาม 4.1', content: "If you look at the source, you're using tabs to look at a demo for tabs. Recursion!"},
	        { title: 'ข้อมูลติดตาม 4.2', content: "If you set md-theme=\"green\" on the md-tabs element, you'll get green tabs."},
	        { title: 'ข้อมูลติดตาม 5.1', content: "If you're still reading this, you should just go check out the API docs for tabs!"},
	        { title: 'ข้อมูลติดตาม 5.2', content: "If you're still reading this, you should just go check out the API docs for tabs!"},
	        { title: 'ข้อมูลห้องปฏิบัติการ', content: "If you're still reading this, you should just go check out the API docs for tabs!"},
	        { title: 'ประจำวัน 1', content: "If you're still reading this, you should just go check out the API docs for tabs!"},
	        { title: 'ประจำวัน 2', content: "If you're still reading this, you should just go check out the API docs for tabs!"},
	        { title: 'ประจำวัน 3', content: "If you're still reading this, you should just go check out the API docs for tabs!"},
	        { title: 'ประจำวัน 4', content: "If you're still reading this, you should just go check out the API docs for tabs!"},
	        { title: 'ประจำวัน 5', content: "If you're still reading this, you should just go check out the API docs for tabs!"},
	        { title: 'ประจำวัน 6', content: "If you're still reading this, you should just go check out the API docs for tabs!"},
	        { title: 'ประจำวัน 7', content: "If you're still reading this, you should just go check out the API docs for tabs!"},
	        { title: 'ประจำวัน 8', content: "If you're still reading this, you should just go check out the API docs for tabs!"},
	        { title: 'ประจำวัน 9', content: "If you're still reading this, you should just go check out the API docs for tabs!"},
	        { title: 'ประจำวัน 10', content: "If you're still reading this, you should just go check out the API docs for tabs!"},
	        { title: 'เข่าเสื่อม  1', content: "If you're still reading this, you should just go check out the API docs for tabs!"},
	        { title: 'เข่าเสื่อม  2', content: "If you're still reading this, you should just go check out the API docs for tabs!"},
	        { title: 'เข่าเสื่อม  3', content: "If you're still reading this, you should just go check out the API docs for tabs!"},
	        { title: 'เข่าเสื่อม  4', content: "If you're still reading this, you should just go check out the API docs for tabs!"},
	        { title: 'เข่าเสื่อม  5', content: "If you're still reading this, you should just go check out the API docs for tabs!"},
	        { title: 'เข่าเสื่อม  6', content: "If you're still reading this, you should just go check out the API docs for tabs!"},
	        { title: 'เข่าเสื่อม  7', content: "If you're still reading this, you should just go check out the API docs for tabs!"},
	        { title: 'เข่าเสื่อม  8', content: "If you're still reading this, you should just go check out the API docs for tabs!"},
	        { title: 'เข่าเสื่อม  9', content: "If you're still reading this, you should just go check out the API docs for tabs!"},
	        { title: 'เข่าเสื่อม  10', content: "If you're still reading this, you should just go check out the API docs for tabs!"},
	        { title: 'เข่าเสื่อม  11', content: "If you're still reading this, you should just go check out the API docs for tabs!"},
	        { title: 'เข่าเสื่อม  12', content: "If you're still reading this, you should just go check out the API docs for tabs!"},
	        { title: 'ปวดข้อ  1', content: "If you're still reading this, you should just go check out the API docs for tabs!"},
	        { title: 'ปวดข้อ  2', content: "If you're still reading this, you should just go check out the API docs for tabs!"},
	        { title: 'ปวดข้อ  3', content: "If you're still reading this, you should just go check out the API docs for tabs!"},
	        { title: 'ปวดข้อ  4', content: "If you're still reading this, you should just go check out the API docs for tabs!"},
	        { title: 'ปวดข้อ  5', content: "If you're still reading this, you should just go check out the API docs for tabs!"},
	        { title: 'ข้อฝืด  1', content: "If you're still reading this, you should just go check out the API docs for tabs!"},
	        { title: 'ข้อฝืด  2', content: "If you're still reading this, you should just go check out the API docs for tabs!"},
	        { title: 'ใช้งานข้อ  1', content: "If you're still reading this, you should just go check out the API docs for tabs!"},
	        { title: 'ใช้งานข้อ  2', content: "If you're still reading this, you should just go check out the API docs for tabs!"},
	        { title: 'ใช้งานข้อ  3', content: "If you're still reading this, you should just go check out the API docs for tabs!"},
	        { title: 'ใช้งานข้อ  4', content: "If you're still reading this, you should just go check out the API docs for tabs!"},
	        { title: 'ใช้งานข้อ  5', content: "If you're still reading this, you should just go check out the API docs for tabs!"},
	        { title: 'ใช้งานข้อ  6', content: "If you're still reading this, you should just go check out the API docs for tabs!"},
	        { title: 'ใช้งานข้อ  7', content: "If you're still reading this, you should just go check out the API docs for tabs!"},
	        { title: 'ใช้งานข้อ  8', content: "If you're still reading this, you should just go check out the API docs for tabs!"},
	        { title: 'ใช้งานข้อ  9', content: "If you're still reading this, you should just go check out the API docs for tabs!"},
	        { title: 'ใช้งานข้อ  10', content: "If you're still reading this, you should just go check out the API docs for tabs!"},
	        { title: 'ใช้งานข้อ  11', content: "If you're still reading this, you should just go check out the API docs for tabs!"},
	        { title: 'ใช้งานข้อ  12', content: "If you're still reading this, you should just go check out the API docs for tabs!"},
	        { title: 'ใช้งานข้อ  13', content: "If you're still reading this, you should just go check out the API docs for tabs!"},
	        { title: 'ใช้งานข้อ  14', content: "If you're still reading this, you should just go check out the API docs for tabs!"},
	        { title: 'ใช้งานข้อ  15', content: "If you're still reading this, you should just go check out the API docs for tabs!"},
	      ],
	      bSelected = null,
	      bPrevious = null;
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