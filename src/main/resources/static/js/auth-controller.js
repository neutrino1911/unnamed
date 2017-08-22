;(function(angular) {
    'use strict';

    angular
        .module('unnamed.common', [])
        .controller('authController', authController);

    function authController($scope, AuthService) {

        let $this = this;
        $scope.user = {};
        $scope.error = {
            state: false,
            text: ''
        };

        $scope.signup = function(user) {
            $scope.error.state = false;
            AuthService.signup(user)
                .then(function(response) {
                    location.replace('/');
                }, function(error) {
                    $scope.error.state = true;
                    $scope.error.text = error.data.text;
                });
        };

    }

})(angular);