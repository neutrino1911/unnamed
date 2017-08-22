;(function(angular) {
    'use strict';

    angular
        .module('unnamed.service', [])
        .service('AuthService', AuthService);

    function AuthService($http) {

        let $this = this;

        $this.url = '/api/auth/';

        $this.signup = function(data) {
            return $http.post($this.url + 'signup', data);
        };

    }

})(angular);