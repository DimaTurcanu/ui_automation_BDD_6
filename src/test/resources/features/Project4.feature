@Project04
  Feature: Practices for BDD components
    Background:
      Given the user is on "https://techglobal-training.com/frontend/project-4"

    @Case01
    Scenario: Validate the default content of the inventory table
      Then the user should see the "Inventory" heading
      And the user should see the table with the headers below

        | Quantity |
        |Product |
        |Price $ |
        |Total $ |
      And the user should see the table with the rows below

        | 1 |
        |iPhone |
        |1,000 |
        |1,000 |
        |3 |
        |Airpods |
        | 100 |
        |300   |
        | 2 |
        | iPad |
        | 500 |
        |1,000 |
      And the user should see the "ADD PRODUCT" button is enabled
      And the user should see the "Total = $2,300" text displayed

      When the user clicks on the "ADD PRODUCT" button
      Then the user should see the "Add New Product" modal with its heading
      When the user clicks on the "X" button
      Then the user should not see the "Add New Product" modal

      #  Task04

      When the user clicks on the "ADD PRODUCT" button
      And the user enters the quantity as "2"
      And the user enters the product as "Mouse"
      And the user enters the price as "100"
      And the user clicks on the "SUBMIT" button
      Then the user should see the table with the new row below
        | 2     |
        | Mouse |
        | 100   |
        | 200   |
      And the user should see the "Total = $2,500" text displayed