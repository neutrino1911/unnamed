;(function(angular) {
    'use strict';

    angular
        .module('unnamed.service', [])
        .service('UserService', UserService);

    function UserService($http) {

        let $this = this;

        $this.url = '/api/users/';

        $this.get = function(id) {
            return $http.get($this.url + id);
        };

        $this.add = function(data) {
            return $http.post($this.url, data);
        };

    }

})(angular);