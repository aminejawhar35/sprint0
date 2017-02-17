"use strict";

/**
 * Route configuration for the RDash module.
 */
angular.module("RDash").config(["$stateProvider", "$urlRouterProvider",
    function ($stateProvider, $urlRouterProvider) {

        // For unmatched routes
        $urlRouterProvider.otherwise("/");

        // Application routes
        $stateProvider
            .state("index", {
                url: "/",
                templateUrl: "templates/accueil.html",
                controller: "AccueilCtrl"
            })
            .state("tables", {
                url: "/tables",
                templateUrl: "templates/tables.html"
            })
            .state("formations", {
                url: "/listedesformations",
                templateUrl: "templates/formation/listeformations.html",
                controller: "FormationCtrl",
            })
            .state("ajouterformation", {
                url: "/ajouterformation",
                templateUrl: "templates/formation/ajouterformation.html",
                controller: "AjouterFormationCtrl",
            })
            .state("detailsformation", {
                url: "/detailsformation/:codeFormation",
                templateUrl: "templates/formation/detailsformation.html",
                controller: "DetailsFormationCtrl"
            }).state("modifierformation", {
            url: "/modifierformation/:codeFormation",
            templateUrl: "templates/formation/modifierformation.html",
            controller: "ModifierFormation"
        })
        ;
    }
]);