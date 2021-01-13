Feature: Offline favoriete gecached treintraject bekijken

  Als treinreiziger wil ik offline de treintrajecten bekijken
  Wil ik gecached treintrajecten bekijken
  Zodat ik offline nog steeds het juiste treintraject kan opvolgen

  Scenario: cached treintrajectenlijst bekijken
    Given ik ben offline op de traincacher homepagina
    When ik op de “favorite rides” knop klik
    Then krijg ik een lijst van alle treintrajecten die gecached werden voor mij