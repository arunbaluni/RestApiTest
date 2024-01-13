Feature: Verify Fav Quote API

	@smoke
  Scenario Outline: Verify User can mark quote as favorite
    Given Create a user session for "/api/session"
		When User sets quote "/api/quotes/<quote_id>/fav" to favorite
		Then favorite is marked "<favoriteAdded>" in API response for quote
    Examples: 
    | TestCase  		| 	quote_id	|	favoriteAdded	|
    | PositiveTest  | 	27598			|	true					|
    | ErrorCode-404	|		00000			|	404						|     

 
   
  Scenario Outline: Verify User can unmark a quote
    Given Create a user session for "/api/session" with "<login>" and "<password>"
		When User sets quote "/api/quotes/<quote_id>/unfav" to favorite
		Then favorite is set "<favorite>" in API response for quote
    Examples: 
    | TestType  		| login  									| password 			|	quote_id	|	favorite	|
    | Unmark_Quote  | mrarunbaluni@gmail.com 	| 3372d3f6688b 	|	27598			|	false					|