;(function(angular) {
    'use strict';

    angular
        .module('unnamed.service', [])
        .service('vendorService', vendorService);

    function vendorService($http) {

        let $this = this;

        $this.url = '/api/vendors/';

        $this.get = function(id) {
            return $http.get($this.url + id);
        };

        $this.new = function(data) {
            return $http.post($this.url + 'new', data);
        }

    }

})(angular);