# tp_1_skunk

## Getting started

  ** Domain Model Concepts:
  ** Score
  ** Dice
  ** roll
  ** player
  ** Series
  ** Skunk
  ** penalty
  ** chip
  ** Kitty
  ** deuce
  ** accumulated score
  ** winner
  ** goal
  ** red chips
  ** blue chips
  ** game
  ** Die
  
> Skunk Domain class candidate:
	
	Tournament: one or more games..
	
	Game: one or more turns , each earnings points for a player, ending when one or more players>= 100 points
	
	Turn: zero or more rolls by a player, ending with decline or skunk, earning the player TurnScore and possibly  a TurnPenalty(chips)
	
	Roll: one throw of the dice by a player, with a point value that's added to the current TurnScore
	
