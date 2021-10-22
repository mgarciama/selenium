Feature: Outlined Scenarios
	
	Scenario Outline: Compras
	Given tengo <valor_inicial> dolares
	When gasto <valor_compra> dolares
	Then me sobran <valor_final> dolares
	
	Examples:
	|valor_inicial| valor_compra | valor_final|
	|		10        |     5        |   5        |
	|   20        |     8        |  12        |
	|   120       |    20        | 100        |
	
	Scenario Outline: verficar usernames
	Given estoy en un sitio web
	And me encontre en la pagina principal
	When busco el nombre del usuario <username>
	Then recibo un mensaje <mensaje>
	
	Examples:
	|username |          mensaje             |
	| MTPE13  | no se encuentra en el sistema|
	| ROX52   | nombre de usuario invalido   |
	| MGDL    | nombre de usuario valido     |
	
	Scenario Outline: spotify email validations
	Given estoy en la pagina de registro de spotify
	When completo el campo email con <email>
	Then se muestra el mensaje <mensaje>
	
	Examples:
	|email| mensaje|
	| test@test.com| este correo electrónico ya está conectado a una cuenta|