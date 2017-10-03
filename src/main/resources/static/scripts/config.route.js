'use strict';
angular.module('app').run(['$rootScope', '$state', '$stateParams',
  function($rootScope, $state, $stateParams) {
    $rootScope.$state = $state;
    $rootScope.$stateParams = $stateParams;
    $rootScope.$on('$stateChangeSuccess', function() {
      window.scrollTo(0, 0);
    });
    FastClick.attach(document.body);
  },
]).config(['$stateProvider', '$urlRouterProvider', '$injector',
  function($stateProvider, $urlRouterProvider, $injector) {
    $urlRouterProvider.otherwise( function($injector) {
    	var $state = $injector.get("$state");
    	$state.go('app.landing');
    });
    
    // Application routes
    $stateProvider.state('app', {
        abstract: true,
        templateUrl: './views/common/layout.html'
      }).state('app.landing',{
    	  url: '/landing',
            templateUrl: './views/app/landing/landing.html',
            controller: 'landingCtrl',
        	resolve: {
                deps: ['$ocLazyLoad', function($ocLazyLoad) {
                  return $ocLazyLoad.load([{
                      files: [
                              './scripts/controllers/landing/landingCtrl.js'
                              ]
                    }]);
                }]
              }
      }).state('app.user', {
            url: '/user',
            templateUrl: './views/app/user/user.html',
            controller: 'userCtrl',
        	resolve: {
                deps: ['$ocLazyLoad', function($ocLazyLoad) {
                  return $ocLazyLoad.load([{
                      files: [
                    	  	  './scripts/services/user/userService.js',
                              './scripts/controllers/user/userCtrl.js'
                              ]
                    }]);
                }]
              },
	          data: {
	              permissions: {
	                only: ['ROLE_ADMIN'],
	                redirectTo: 'user.signin'
	              }
	            }
        }).state('app.user.role',{
	      	url: '/{userId:int}',
	      	onEnter:['$uibModal', '$state', '$stateParams', function($uibModal, $state, $stateParams){
	      		$uibModal.open({
	      			template : '<div ui-view="modal"></div>',
	      			size: 'lg'
	      		}).result.finally(function(){
	      			$state.go('app.user',{},{reload:true});
	      		});
	      	}],
	    	resolve: {
	            deps: ['$ocLazyLoad', function($ocLazyLoad) {
	              return $ocLazyLoad.load([{
	                  files: [	'./scripts/controllers/user/roleCtrl.js'
	                	  		]
	                }]);
	            }]
	          }
	      }).state('app.user.role.config',{
		      	url: '/config',
		      	views:{
		      		'modal@':{
		      			templateUrl:'views/app/user/role.html',
		      			controller: 'roleCtrl'
		      		}
		      	}
		      }).state('app.parameters',{
			    	url: '/parameters',
			        templateUrl: './views/app/parameter/parameter.html',
			        controller: 'paramCtrl',
			    	resolve: {
			            deps: ['$ocLazyLoad', function($ocLazyLoad) {
			              return $ocLazyLoad.load([{
			                  files: [
			                	  		'./scripts/services/parameter/parameterService.js',
			                	  		'./scripts/controllers/parameter/paramCtrl.js'
			                          ]
			                }]);
			            }]
			          },
			          data: {
			              permissions: {
			                only: ['ROLE_ADMIN'],
			                redirectTo: 'user.signin'
			              }
			            }
			    }).state('app.patient',{
			    	url: '/patient',
			    	templateUrl: './views/app/patient/patient.html',
			        controller: 'patientCtrl',
			        resolve: {
			            deps: ['$ocLazyLoad', function($ocLazyLoad) {
			              return $ocLazyLoad.load([{
			                  files: [
			                	  	  './scripts/services/patientServices.js',
			                          './scripts/controllers/patient/patientCtrl.js'
			                          ]
			                }]);
			            }]
			          },
			        data: {
			            permissions: {
			                only: ['ROLE_PROF'],
			                redirectTo: 'user.signin'
			              }
			            }
			    }).state('app.newpatient',{
			    	url: '/newpatient',
			    	params : {newPatient:null},
			    	templateUrl: './views/app/patient/newpatient.html',
			        controller: 'newPatientCtrl',
			        resolve: {
			            deps: ['$ocLazyLoad', function($ocLazyLoad) {
			              return $ocLazyLoad.load([{
			                  files: [
			                	  	  './scripts/services/patientServices.js',
			                          './scripts/controllers/patient/newPatientCtrl.js'
			                          ]
			                }]);
			            }]
			          },
			        data: {
			            permissions: {
			                only: ['ROLE_PROF'],
			                redirectTo: 'user.signin'
			              }
			            }
			    }).state('app.profile',{
			    	url: '/patient-profile',
			    	params : {patient:null},
			    	templateUrl: './views/app/patient/newpatient.html',
			        controller: 'profileCtrl',
			        resolve: {
			            deps: ['$ocLazyLoad', function($ocLazyLoad) {
			              return $ocLazyLoad.load([{
			                  files: [
			                	  	  './scripts/services/patientServices.js',
			                          './scripts/controllers/patient/profileCtrl.js'
			                          ]
			                }]);
			            }]
			          },
			        data: {
			            permissions: {
			                only: ['ROLE_PROF'],
			                redirectTo: 'user.signin'
			              }
			            }
			    })
			    .state('user', {
			        templateUrl: './views/common/session.html',
			      }).state('user.signin', {
			        url: '/signin',
			        templateUrl: './views/signin.html',
			        controller:'sessionCtrl',
			        resolve: {
			          deps: ['$ocLazyLoad', function($ocLazyLoad) {
			            return $ocLazyLoad.load('./scripts/controllers/session.js');
			          }]
			        },
			        data: {
			          appClasses: 'signin usersession',
			          contentClasses: 'session-wrapper'
			        }
			      }).state('user.signout',{
			    	  url:'/signout',
			    	  templateUrl:'./views/signin.html',
			    	  controller:'logoutCtrl',
			          resolve: {
			              deps: ['$ocLazyLoad', function($ocLazyLoad) {
			                return $ocLazyLoad.load('./scripts/controllers/logout.js');
			              }]
			            },
			            data: {
			              appClasses: 'signin usersession',
			              contentClasses: 'session-wrapper'
			            }
			      })
      
     ;
  }
]).config(['$ocLazyLoadProvider', function($ocLazyLoadProvider) {
  $ocLazyLoadProvider.config({
    debug: false,
    events: false
  });
}]);
