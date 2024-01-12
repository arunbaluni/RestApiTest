Feature: Verify List of Quotes

	@smoke
  Scenario Outline: Verify the random list of quotes
    Given Create a user session for "/api/session"
		When User searches for quotes from "/api/quotes"
		Then User gets random list of quotes
  
  Scenario Outline: Verify User can mark quote as favorite
    Given Create a user session for "/api/session"
		When User searches for quotes from "/api/quotes?filter=<filterValue>&type=<typeValue>"
		Then User gets filtered list of quotes for "<filterValue>" and "<typeValue>"
    Examples: 
    | TestType  				|  filterValue	|	typeValue	|
    | filterWithTag  		|  God				|	tag				|
    | filterWithAuthor	|  Mark Twain		|	author		|
    | QuoteFavoriteByMe		|  30185					|	user			|     

      