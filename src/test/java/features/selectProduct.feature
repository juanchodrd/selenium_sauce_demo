Feature: Selección de productos

  Scenario: Selección de producto con exito
    Given que estoy en la página de login
    When ingreso el usuario "standard_user" y la contraseña "secret_sauce"
    And selecciono el producto "Sauce Labs Backpack"
    Then debería ver el detalle del producto seleccionado "Sauce Labs Backpack"
