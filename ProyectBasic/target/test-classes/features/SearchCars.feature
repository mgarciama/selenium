
@Busqueda-cars
Feature: validamos la pagina de cars de busqueda
  En orden para validar la busqueda de automovil
  I navigate http://www.carsguide.com.au
@Busqueda-cars-positive
  Scenario: buscamos para el nuevo automavil
    Given Estamos en la pagina "http://www.carsguide.com.au" del sitio web CARSGUIDE
    When Nos movemos por el menu
      | Menu       |
      | buy + sell |
    And hacemos click a "Search Cars"
    Then verificamos que estemos en la pagina SerchCars
    And Y seleccionamos Any Make por "BMW"
    And Volvemos a selecionar Select Model por "1 Series M"
    And Seleccionamos Any Location as "ACT - All"
    And Selecionamos Price por "$1,000"
    And Hacemos click a Find_My_Next_Cars
    Then Deberia ver la lista de los coches buscados
    And la pagina deberia aparecer "Bmw 1 Series M Under 1000 for Sale ACT | carsguide"
