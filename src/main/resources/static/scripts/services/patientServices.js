
angular.module('app').factory('patientServices',
		['$http', '$filter', '$rootScope',
		 function patientServices
		 ($http, $filter,$rootScope) {
    return { 
      //system Auditing
      getProxyAutoComplete: function(proxyId) {
    	   
    	return $http.get(CONTEXT+'/api/proxyConsents/search/findFirst10ByProxyIdStartingWithAndIsDeletedAllIgnoreCase',{params:{proxyId:proxyId,isDeleted:'N'}});
      },
      getProxyType: function(proxyTypeId){
    	return $http.get(CONTEXT+'/api/sysParameters/'+proxyTypeId);
      },
      getProxyBlocks: function(proxyId){
    	  return $http.get(CONTEXT+'/api/proxyBlocks/search/findByProxyIdAndIsDeleted',{params:{proxyId:proxyId,isDeleted:'N'}});
      },
      getPatients: function(page, size){
          return $http.get(CONTEXT+'/api/ipePatientProfiles',{params:{'page':page, 'size':size}});
      },
      getRtpTransactionByRequesterProxyId: function(requesterProxyId, instructionDate, page, size){
    	  return $http.get(CONTEXT+'/api/rtpInstructions/search/findByRequesterProxyIdAndInstructionDate',{params:{requesterProxyId:requesterProxyId, instructionDate:instructionDate, page:page, size:size}});
      },
      getRtpTransactionByReceiverProxyId: function(receiverProxyId, instructionDate, page, size){
    	  return $http.get(CONTEXT+'/api/rtpInstructions/search/findByReceiverProxyIdAndInstructionDate',{params:{receiverProxyId:receiverProxyId, instructionDate:instructionDate, page:page, size:size}});
      }
    
    };
  }]);