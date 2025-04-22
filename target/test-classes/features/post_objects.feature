Feature: Criar objetos

  Scenario: Criar um novo objeto com POST
    Given que estou preparado para fazer uma requisição POST
    When eu envio os dados com o objeto Gal teste
    Then a resposta deve conter o status 200 e o nome "Gal teste"


  Scenario: Criar um novo objeto com POST com ano 2020
    Given que estou preparado para fazer uma requisição POST
    When eu envio os dados com o objeto 2020
    Then a resposta deve conter o status 200 e o ano 2020

  Scenario: Enviar dados inválidos e receber erro 400
    Given que estou preparado para fazer uma requisição POST
    When eu envio dados inválidos para o endpoint
    Then a resposta deve conter o status 400
