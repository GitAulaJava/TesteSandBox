'use strict';

// Declare app level module which depends on filters, and services
angular
        .module('ngdemo', [
            'ngdemo.rodapeDirective',
            'restangular',
            'ngCookies',
            'localDate'])

        .config(['$routeProvider', function ($routeProvider) {
                $routeProvider.when('/dummy', {templateUrl: 'views/main.html', controller: 'HeaderController'});
                $routeProvider.when('/login', {templateUrl: 'views/login.html', controller: 'HeaderController'});
                $routeProvider.when('/domicilios', {templateUrl: 'views/domicilios.html', controller: 'ControllerDomicilio'});
                $routeProvider.when('/pessoas', {templateUrl: 'views/pessoas.html', controller: 'ControllerPessoa'});
                $routeProvider.otherwise({redirectTo: '/dummy'});
            }])

        .config(function (RestangularProvider) {

            var newBaseUrl = "";
            if (window.location.hostname == "localhost") {
                newBaseUrl = "http://localhost:8080/app/api/";
            } else {
                var deployedAt = window.location.href.substring(0, window.location.href);
                newBaseUrl = deployedAt + "/api/";
            }
            RestangularProvider.setBaseUrl(newBaseUrl);
        });



