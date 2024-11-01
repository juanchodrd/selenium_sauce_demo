@only
Feature: Añadir productos al carrito

  Scenario: Añadir tres productos al carrito
    Given que estoy en la página de login
    When ingreso el usuario "standard_user" y la contraseña "secret_sauce"
    And verifico que el carrito se encuentre vacio
    And agrego al carrito el producto "Sauce Labs Backpack"
    And agrego al carrito el producto "Sauce Labs Bolt T-Shirt"
    And agrego al carrito el producto "Sauce Labs Bike Light"
    Then se muestra la opcion para remover el producto "Sauce Labs Backpack" del carrito
    And se muestra la opcion para remover el producto "Sauce Labs Bolt T-Shirt" del carrito
    And se muestra la opcion para remover el producto "Sauce Labs Bike Light" del carrito
    And el badge del carrito debe ser actualizado
