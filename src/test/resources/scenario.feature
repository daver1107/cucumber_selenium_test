Feature: cart test
  Scenario: add item to cart
  Given hm url 'https://www2.hm.com/ru_ru/index.html'
  When I am on main page I accept all cookies
  Then I type 'ремень' in search filed
  Then I pick first item
  And I choose size
  Then click add to cart button