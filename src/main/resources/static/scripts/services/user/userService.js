angular.module('app')
  .factory('UserService', ['$http', '$rootScope', function UserService($http, $rootScope) {
    return {
    	getAllUser: function(params) {
            return $http.get(CONTEXT+'/api/users',{params : params});
        },
        getUserByName: function(params) {
        	return $http.get(CONTEXT+'/api/users/search/findByUserNameContaining',{params : params});
        }
    };
  }])