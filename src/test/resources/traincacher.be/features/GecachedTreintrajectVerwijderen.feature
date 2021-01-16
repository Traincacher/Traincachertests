Feature: Offline favoriete treintraject verwijderen

  Als treinreiziger
  Wil ik offline een treintraject verwijderen
  Zodat ik enkel een lijst heb van treintrajecten waarvoor ik een voorkeur heb

  Scenario: treintraject verwijderen is succesvol
    Given ik sta op de favorite rides pagina
    When ik offline een treintraject op de knop X klik
    Then wordt de treintraject offline verwijdert uit de lijst