
Feature: caculadora

@Calculadora
  Scenario: Sumar dos numeros
    Given tengo una calculadora
    When suma 4 y 6
    Then se muestra suma 10

@Calculadora
 Scenario: resta dos numeros
    Given tengo una calculadora
    When resta 5 y 3
    Then se muestra resta 2