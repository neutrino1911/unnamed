;(function(angular) {
    'use strict';

    angular
        .module('unnamed.common', [])
        .controller('unnamedCtrl', unnamedCtrl);

    function unnamedCtrl($scope, $q, vendorService) {

        let $this = this;

        let vendorPromise;

        $this.getVendor = function() {
            if (vendorPromise == null) {
                vendorPromise = vendorService.get(1);
            }
            return vendorPromise;
        };

        $scope.vendors = [];

        $this.getVendor().then((response) => {
            $scope.vendors[0] = response.data;
        });

        $this.getVendor().then((response) => {
            $scope.vendors[1] = response.data;
        });

        $this.deferred = $q.defer();

        setTimeout(function() {
            $this.deferred.resolve();
        }, 3000);

        $scope.showVendors = false;

        $q.all([$this.getVendor(), $this.deferred.promise]).then(function() {
            $scope.showVendors = true;
            vendorService.new({
                name: 'Texet',
                country: 'China',
                warranty: 12
            }).then(function(response) {
                $scope.vendors.push(response.data);
            });
        });

    }

})(angular);