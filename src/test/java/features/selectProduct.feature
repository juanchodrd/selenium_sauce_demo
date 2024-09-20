Feature: Selección de productos

  Scenario Outline: Selección de producto con exito
    Given que estoy en la página de login
    When ingreso el usuario "standard_user" y la contraseña "secret_sauce"
    And selecciono el producto "<producto>"
    Then debería ver el detalle del producto seleccionado "<producto>"

    Examples:
      | producto                |
      | Sauce Labs Backpack     |
      | Sauce Labs Bolt T-Shirt |
      | Sauce Labs Bike Light   |
