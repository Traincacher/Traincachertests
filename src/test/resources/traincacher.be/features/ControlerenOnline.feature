Feature: controleren of applicatie online of offline is

  Als treinreiziger
  Wil ik weten wanneer de applicatie online of offline draait.
  Zodat ik weet of mijn treinschema actueel is of gecached.

  Scenario: user is online
    Given ik sta op de online traincacher pagina
    When ik geen cloud logo zie
    Then weet de user dat hij online is

  Scenario: user is offline
    Given ik sta op de offline traincacher pagina
    When ik een cloud logo zie
    Then weet de user dat hij offline is