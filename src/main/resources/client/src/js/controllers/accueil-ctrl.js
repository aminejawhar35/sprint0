/**
 * Created by dosi on 2/16/17.
 */
angular.module("RDash").controller("AccueilCtrl", ["$scope", "StatistiqueSrv", function ($scope, StatistiqueSrv) {
    $scope.statistiques = {
        nbr_formations: 0,
        nbr_enseignant: 0,
        nbr_candidats: 0,
        nbr_etudiants: 0
    };
    StatistiqueSrv.getNombreDeFormation(function (nbr) {
        $scope.statistiques.nbr_formations = nbr;
    });
}]);