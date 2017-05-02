angular.module('alurapic', ['minhasDiretivas', 'ngAnimate', 'ngRoute'])
    .config(function($routeProvider) {

        $locationProvider.html5Mode(true);

        $routeProvider.when('/fotos', {
            templateUrl: 'partials/principal.html',
            controller: 'FotosController'
        });

        // foto no singular!

        $routeProvider.when('/fotos/new', {
            templateUrl: 'partials/foto.html'
        });
        $routeProvider.otherwise({redirectTo: '/fotos'});

    });

