Feature: User Order Mechanism Test

  Scenario Outline: Multiple Order Placing Validation
    Given <user> place <order> for <company>
    When Adding <product> & <plan>
    Then system validate order :
      | for order                                 | Rules   |
      | <user> <order> <product> <plan> <company> | <rules> |

    @User1-Scenario
    Examples: 
      | user     | order  | product | plan     | company     | rules                                         |
      | "User 1" | "O001" | "P1"    | "Plan A" | "CompanyV1" | "Success"                                     |
      | "User 1" | "O001" | "P1"    | "Plan A" | "CompanyV2" | "One User One Company Only.."                 |
      | "User 1" | "O002" | "P2"    | "Plan B" | "CompanyV1" | "Success"                                     |
      | "User 1" | "O003" | "P3"    | "Plan C" | "CompanyV1" | "Success"                                     |
      | "User 1" | "O004" | "P4"    | "Plan D" | "CompanyV1" | "Maximum order Reached User ..."              |
      | "User 1" | "O003" | "P3"    | "Plan C" | "CompanyV1" | "Product & Plan Already Exist for this Order" |

    @User2-Scenario
    Examples: 
      | user     | order  | plan     | product | company     | rules                                         |
      | "User 2" | "O001" | "Plan A" | "P1"    | "CompanyV2" | "Success"                                     |
      | "User 2" | "O001" | "Plan A" | "P1"    | "CompanyV1" | "One User One Company Only.."                 |
      | "User 2" | "O002" | "Plan B" | "P2"    | "CompanyV2" | "Success"                                     |
      | "User 2" | "O003" | "Plan C" | "P3"    | "CompanyV2" | "Success"                                     |
      | "User 2" | "O003" | "Plan C" | "P3"    | "CompanyV2" | "Product & Plan Already Exist for this Order" |
