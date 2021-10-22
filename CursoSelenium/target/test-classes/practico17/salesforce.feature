Feature: Salesforce

Scenario:
  Given estoy en la pagina de Salesforce
  When hago click en CRM
  Then ingreso a la pagina de CRM
  And encuentro informacion sonre los CRM

Scenario:
	Given estoy en la pagina de Salesforce
	When ingreso a la session de registrase 
	Then puedo completar todos los campos del registro
	
Scenario:
	Given estoy en la pagina de sa Salesforce
	When obtengo los H1s
	Then encuentro un solo h1