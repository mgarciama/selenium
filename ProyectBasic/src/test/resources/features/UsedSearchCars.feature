@usando-Busqueda-cars
Feature: validamos la pagina de cars de busqueda
  En orden para validar la busqueda de automovil
  I navigate http://www.carsguide.com.au

  @usuando-Busqueda-cars-positive
  Scenario: usando busqueda para el nuevo automavil
    Given Estamos en la pagina "http://www.carsguide.com.au" del sitio web CARSGUIDE
    When Nos movemos por el menu
      | Menu       |
      | buy + sell |
    And hacemos click a "Used" para el menu used
    Then verificamos que estemos en la pagina "Used Cars For Sale" used
    And Y seleccionamos Any Make por "Audi" used
    And select car model used
      | carModel |
      | A4       |
      | A3       |
    And Seleccionamos Any Location as "ACT - All" used
    And Selecionamos Price por "$10,000" used
    And Hacemos click a Find_My_Next_Cars used
    #Then Deberia ver la lista de los coches buscados
    And pagina deberia aparecer "Used Audi A4 Under 10000 for Sale ACT | carsguide" used
