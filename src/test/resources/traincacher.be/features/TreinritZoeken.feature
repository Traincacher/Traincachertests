Feature: Route tussen twee treinstations bekijken

  Als treinreiziger
  Wil ik online een treintraject tussen 2 stations kunnen opzoeken
  Zodat ik weet om hoelaat ik een trein kan nemen

  Scenario: treintraject is mogelijk tussen 2 stations
    Given ik sta op de Traincacher homepagina
    When ik "Zellik" in het From veld ingeef
    When ik "Asse" in het To veld ingeef
    When ik op de Search-knop druk
    Then zie ik de mogelijke treintrajecten tussen "Zellik" en "Asse"

  Scenario: treintraject is niet mogelijk tussen 2 stations
    Given ik sta op de Traincacher homepagina
    When ik "Bazel" in het From veld ingeef
    When ik "Asse" in het To veld ingeef
    When ik op de Search-knop druk
    Then krijg ik geen mogelijke treintrajecten