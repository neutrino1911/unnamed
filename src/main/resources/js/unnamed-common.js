;(function(angular) {
    'use strict';

    angular
        .module('unnamed.common', [])
        .controller('unnamedCtrl', unnamedCtrl);

    function unnamedCtrl($scope, $q, vendorService) {

        let $this = this;

        let vendorPromise;

        $this.getVendor = function(force) {
            if (vendorPromise == null || force) {
                vendorPromise = vendorService.get(1);
            }
            return vendorPromise;
        };

        $scope.loadVendor = function(force) {
            $this.getVendor(force).then((response) => {
                $scope.vendors.push(response.data);
            });
        };

        $scope.vendors = [];

        // $this.getVendor().then((response) => {
        //     $scope.vendors.push(response.data);
        // });

        $scope.showVendors = true;

    }

})(angular);