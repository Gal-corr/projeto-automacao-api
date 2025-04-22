Feature: Buscar objetos por ID

  Scenario: Buscar os objetos com os IDs 3, 5 e 10
    Given que estou preparado para fazer uma requisição GET
    When eu busco os objetos com os IDs 3, 5 e 10
    Then a resposta deve conter os objetos com os IDs 3, 5 e 10

  Scenario: Buscar apenas com objeto ID 7
    Given que estou preparado para fazer uma requisição GET
    When eu busco o objeto com o ID 7
    Then a resposta deve conter o objeto com o ID 7
