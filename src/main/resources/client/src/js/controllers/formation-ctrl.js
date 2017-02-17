/**
 * Created by dosi on 2/16/17.
 */
angular.module("RDash").controller("FormationCtrl", ["$scope", "FormationSrv", "$state", function ($scope, FormationSrv, $state) {

    $scope.formations = [];

    FormationSrv.getToutesLesFormations(function (formations) {
        $scope.formations = formations;
    });

    $scope.supprimerFormation = function (codeFormation) {
        FormationSrv.supprimerFormation(codeFormation, function () {
            $state.go("formations");
        });
    };
}]);

/**
 * Created by dosi on 2/16/17.
 */

angular.module("RDash").controller("AjouterFormationCtrl", ["$scope", "FormationSrv", "$state", function ($scope, FormationSrv, $state) {
    $scope.formation = {
        estUnDoubleDiplome: "true",
        diplome: "M",
        numeroAnnee: "1"
    };

    $scope.ajouterFormation = function () {
        FormationSrv.ajouterFormation($scope.formation, function () {
            $state.go("formations");
        });
    };
}]);

angular.module("RDash").controller("DetailsFormationCtrl", ["$scope", "FormationSrv", "$stateParams", function ($scope, FormationSrv, $stateParams) {
    FormationSrv.getOneFormation($stateParams.codeFormation, function (formation) {
        $scope.formation = formation;
    })
}]);


angular.module("RDash").controller("ModifierFormation", ["$scope", "FormationSrv", "$stateParams", "$state", function ($scope, FormationSrv, $stateParams, $state) {
    $scope.formation = {
        diplome: 1
    };
    $scope.empecherModificationCode = true;
    $scope.modifierFormation = function () {
        FormationSrv.modifierFormation($scope.formation, function () {
            $state.go("formations");
        });
    };

    FormationSrv.getOneFormation($stateParams.codeFormation, function (formation) {
        if (formation.estUnDoubleDiplome === true) {
            formation.estUnDoubleDiplome = "true";
        }
        else {
            formation.estUnDoubleDiplome = "false";
        }
        switch (formation.numeroAnnee) {
            case 1:
                formation.numeroAnnee = "1";
                break;
            case 2:
                formation.numeroAnnee = "2";
                break;
            case 3:
                formation.numeroAnnee = "3";
                break;
        }
        $scope.formation = formation;
    });
}]);