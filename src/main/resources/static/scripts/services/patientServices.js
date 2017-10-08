
angular.module('app').factory('patientServices',
		['$http', '$filter', '$rootScope',
		 function patientServices
		 ($http, $filter,$rootScope) {
    return { 
	  genericGet : function(link){
	  	  return $http.get(link);
	  },
	  genericPatch : function(generic,link){
    	  return $http.patch(link,generic);
      },
      genericDel : function(id){
    	  return $http.delete(id);
      },
	  getPatients: function(page, size){
          return $http.get(CONTEXT+'/api/ipePatientProfiles',{params:{'page':page, 'size':size}});
      },
      getPatientByRole : function(role){
    	  return $http.get(CONTEXT+'/api/users/search/findByRole',{params:{'role':role}});
      },
      getPatientByIndexName : function(indexName){
    	  return $http.get(CONTEXT+'/api/ipePatientProfiles/search/findByIndexName',{params:{'indexName':indexName}});
      },
      addNewPatients: function(patients){
    	  return $http.post(CONTEXT+'/api/ipePatientProfiles',patients);
      },
      patchPatientParent : function(patient,link){
    	  return $http.patch(link,patient, {headers:{'Content-Type': 'text/uri-list'}});
      },
      addVisitLog : function(visit){
    	  return $http.post(CONTEXT+'/api/ipeVisitLogs',visit);
      },
      patientDeleteVisits : function(patientId, visitId){
    	  return $http.delete(CONTEXT+'/api/ipePatientProfiles/'+patientId+'/visits/'+visitId);
      },
      addFamilyMember : function(member){
    	  return $http.post(CONTEXT+'/api/ipeFamilyMembers',member);
      },
      patientDeleteMembers : function(patientId, memberId){
    	  return $http.delete(CONTEXT+'/api/ipePatientProfiles/'+patientId+'/members/'+memberId);
      },
      addUseDrug : function(drug){
    	  return $http.post(CONTEXT+'/api/ipeUseDrugs',drug);
      },
      addDrugList : function(drugList){
    	  return $http.post(CONTEXT+'/api/ipeDrugLists',drugList);
      },
      drugDeleteList : function(drugId, listId){
    	  return $http.delete(CONTEXT+'/api/ipeUseDrugs/'+drugId+'/drugList/'+listId);
      },
      patchDrugParent : function(drugList,link){
    	  return $http.patch(link,drugList, {headers:{'Content-Type': 'text/uri-list'}});
      },
      patientDeleteDrug : function(patientId, drugId){
    	  return $http.delete(CONTEXT+'/api/ipePatientProfiles/'+patientId+'/useDrugs/'+drugId);
      },
      addPatientTransaction : function(txn){
    	  return $http.post(CONTEXT+'/api/ipePatientTransactions',txn);
      },
      findByCreatedDate : function(createdDate, indexName){
    	  return $http.get(CONTEXT+'/api/ipePatientTransactions/search/findByCreatedDate',{params:{'createdDate':createdDate, 'indexName': indexName}})
      },
      uploadFile : function(file, txn, user){
    	  var fd = new FormData();
          fd.append('file', file);
          return $http(
        		  {	url: CONTEXT+'/service/uploadImage/'+txn.transactionId+'/'+user,
        			method: 'POST',
        			data: fd,
        			headers: { 'Content-Type': undefined},
        			transformRequest: angular.identity
        		  });
      }
    
    };
  }]);