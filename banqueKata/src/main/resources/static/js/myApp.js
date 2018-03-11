angular.module('myBanqueApp', [])
  .controller('myBanqueController', function($scope,$http) {
	  $scope.compte=null;
	  $scope.pageOperations=null;
      $scope.codeCompte=null;
	  $scope.operation={type:"versement",montant:0,codeEmp:"E1"};
	  $scope.pageCourante=0;
	  $scope.pageSize=3;
	  $scope.errorMsg=null;
	  $scope.emptyCpt=null;
	  
  	    $scope.chargerCompte=function(){
  		$http.get("/comptes/"+$scope.codeCompte)
  		.success(function(data){
  			$scope.compte=data;
  			 $scope.chargerOperations();
  			 $scope.emptyCpt=null;
  	    		
  		})
  		.error(function(data){
  			 $scope.emptyCpt=data.message;
	      });
  	
		  
	  };
	  $scope.chargerOperations=function(){
    		$http.get("/operations?codeCompte="+$scope.codeCompte+"&page="+$scope.pageCourante+"&size="+$scope.pageSize)
    		.success(function(data){
    			$scope.pageOperations=data;
    			$scope.pages=new Array(data.totalPages);
    		});
    	};
    	   
    	$scope.goToPage=function(p){
    		$scope.pageCourante=p;
    		$scope.chargerOperations();
    	}
    	
    	$scope.saveOperation=function(){
    		var params="";
    		if($scope.operation.type=='virement')
    			{
    			   params="code1="+$scope.codeCompte+"&code2="+$scope.operation.cpt2+"&montant="+$scope.operation.montant+"&codeEmp="+$scope.operation.codeEmp;
    			}
    		else
    			{
    			 params="code="+$scope.codeCompte+"&montant="+$scope.operation.montant+"&codeEmp="+$scope.operation.codeEmp;
    			}
    		$http({
    			    method:'PUT',
    			    url:$scope.operation.type,
    			    data:params,
    			    headers:{'Content-type':'application/x-www-form-urlencoded'}
    			
    		      })
    		      .success(function(data){
    		    	  $scope.chargerCompte();
    		    	  $scope.chargerOperations();
    		    	  $scope.operation.montant=0;
    		    	  $scope.operation.cpt2=0;
    		    	  $scope.errorMsg=null;
    		      })
    		      .error(function(data){
    		    	  $scope.errorMsg=data.message;
    		      });
    		    		
    		    		  
    	};
    	
});