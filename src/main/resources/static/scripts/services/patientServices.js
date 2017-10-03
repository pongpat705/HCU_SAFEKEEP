
angular.module('app').factory('patientServices',
		['$http', '$filter', '$rootScope',
		 function patientServices
		 ($http, $filter,$rootScope) {
    return { 
      getPatients: function(page, size){
          return $http.get(CONTEXT+'/api/ipePatientProfiles',{params:{'page':page, 'size':size}});
      },
      addNewPatients: function(patients){
    	  return $http.post(CONTEXT+'/api/ipePatientProfiles',patients);
      },
      patchPatient : function(patient,link){
    	  return $http.patch(link,patient);
      },
      patchPatientParent : function(patient,link){
    	  return $http.patch(link,patient, {headers:{'Content-Type': 'text/uri-list'}});
      },
      addVisitLog : function(visit){
    	  return $http.post(CONTEXT+'/api/ipeVisitLogs',visit);
      },
      genericGet : function(link){
    	  return $http.get(link);
      },
      genericDel : function(id){
    	  return $http.delete(id);
      }
//      getRtpTransactionByRequesterProxyId: function(requesterProxyId, instructionDate, page, size){
//    	  return $http.get(CONTEXT+'/api/rtpInstructions/search/findByRequesterProxyIdAndInstructionDate',{params:{requesterProxyId:requesterProxyId, instructionDate:instructionDate, page:page, size:size}});
//      },
//      getRtpTransactionByReceiverProxyId: function(receiverProxyId, instructionDate, page, size){
//    	  return $http.get(CONTEXT+'/api/rtpInstructions/search/findByReceiverProxyIdAndInstructionDate',{params:{receiverProxyId:receiverProxyId, instructionDate:instructionDate, page:page, size:size}});
//      }
    
    };
  }]);