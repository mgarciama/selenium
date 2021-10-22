Feature: Linkedin login

  Background:
  Given estoy en la pagina de linkedin 
  
  Scenario: Likedin login exitoso
    When ingreso mi email correctamente
    And ingreso mi contrasena correctamente
    Then entro a la cuenta
    
  Scenario: Likedin login con email invalido
    When ingreso mi email incorrectamente
    And ingreso mi contrasena correctamente
    Then se despliega un error de login "Email invalido"
    
 	Scenario: Likedin login con email y password invalido
    When ingreso mi email incorrectamente
    And ingreso mi contrasena incorrectamente
    Then se despliega un error de login