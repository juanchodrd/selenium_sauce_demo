@only
Feature: Añadir producto al carrito

  Scenario Outline: Añadir producto al carrito
    Given que estoy en la página de login
    When ingreso el usuario "standard_user" y la contraseña "secret_sauce"
    And verifico que el carrito se encuentre vacio
    And agrego al carrito el producto "<producto>"
    Then se muestra la opcion para remover el producto "<producto>" del carrito
    And el badge del carrito debe ser actualizado


    Examples:
      | producto                |
      | Sauce Labs Backpack     |
      | Sauce Labs Bolt T-Shirt |
      | Sauce Labs Bike Light   |
