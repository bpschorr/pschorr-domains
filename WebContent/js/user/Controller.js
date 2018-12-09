application.controller("DomainRegistrationController",
		function($scope, $http) {
			$scope.domainForm = {};
			$scope.plansList = null;
			$scope.domainForm.domainName = null;
			$scope.domainForm.domainExtension = null;
			$scope.domainForm.customerName = null;
			$scope.domainForm.duration = null;
			$scope.domainForm.plan = null;
			$scope.domainForm.adsRequired = false;
			$scope.domainForm.message = null;
			
			$scope.getDomainPlans = function() {
				$scope.domainForm.message = null;
				$http.get(URI + "Domains/fetchDomainPlans").then(
						function(response) {						
							$scope.plansList = response.data;
							$scope.domainForm.message = null;
						}, function(response) {
							$scope.domainForm.message = response.data.message;
							$scope.plansList = null;
						});
			};

			$scope.domainForm.submitTheForm = function() {
				$scope.domainForm.message = null;
				var data = JSON.stringify($scope.domainForm)
				$http.post(URI + "Domains/RegisterDomain", data).then(function(response) {
					$scope.domainForm.message = response.data.message;
				}, function(response) {
					$scope.domainForm.message = response.data.message;
				});
			};
		});