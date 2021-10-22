Feature: Acciones al entrar a un bar

  Scenario: Dar mi saludo al entrar a un bar
    Given entro a un bar
    When encuentro personas
    Then las saludo

  Scenario: Tomar asiento
    Given entro a un bar
    When encuentro mesa libre
    Then tomo asiento

  Scenario: Pedir bebidas
    Given entro a un bar
    And tomo asiento
    When tengo sed
    Then pido una bebida
