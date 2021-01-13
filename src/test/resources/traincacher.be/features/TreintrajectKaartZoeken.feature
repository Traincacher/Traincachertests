Feature: Online treintraject via kaart opzoeken

  Als treinreiziger
  Wil ik via de kaart in de app stations opzoeken
  Zodat ik weet waar er verschillende stations zich bevinden rondom mij

  Scenario: succesvol  kaart opendoen
    Given ik ben op de homepagina
    When ik op de “kaart” knop klik
    Then zie ik een kaart die alle stations in mijn regio toont

  Scenario: succesvol treintraject opzoeken via kaart
    Given ik ben op de homepagina
    When ik op de “kaart” knop klik
    When het station “Landegem” aanduid als beginpunt
    When het station “Gentbrugge” aanduid als eindpunt
    Then zie ik succesvol de resultaat van de treintraject