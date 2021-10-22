Feature: Spotify

  Scenario: Spotify Title
    Given me encuentro en el sitio de spotify
    When consulto por el titulo de la pagina
    Then se muestra el titulo "Escuchar es todo - Spotify"

  Scenario: Registro Exitoso
    Given me encuentro en el sitio de spotify
    And hago click en Registrarme
    When completo el campo email con "testing@test.com"
    And completo  el campo password con "holamundo"
    And completo el alias con "selenium"
    And hago click en el boton de registrarme
    Then se crea la cuenta
    And se muestra un mensaje de exito



	
		

