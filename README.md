# tp_1_skunk

> Project one: Skunk game

## Getting started

This document describes the board game Skunk. Assume that you are implementing a computer program to allow two or more human players to play Skunk against one another, with the computer keeping score and enforcing the rules of the game.Skunk is a variant of Pig, which itself is an instance of a "press your luck" or "jeopardy" dice game. 

> Here are some links:https://boardgamegeek.com/boardgame/3425/skunkhttps://en.wikipedia.org/wiki/Pig_(dice_game)

The following rules to use for your Skunk implementation are copied verbatim from a 1950's commercial box version sold by the Minneapolis company Schaper Manufacturing. Note that an end goal of Skunk is to win the most chips after playing multiple games (== a tournament, as described below).

Note that I'll use a different vocabulary for some of the Skunk concepts (domain or conceptual classes) versus those that appear in the box rules.  Here's a brief guide to some important Skunk domain concepts:              

Vocabulary:

* Box RulesMy   Terminology
* Shake/Roll    Roll (== throw dice once)
* Series        Turn (== multiple Rolls until Skunk or decline to roll)
* Game          Game (same as Box: == multiple Turns until winner)
* ----          Tournament (== one or more Games, each earning chips)

Images of this box and its cover are posted at the end of this document. The following rules are repeat the rules from inside the box cover.

## Rules of Skunk

### DIRECTIONS FOR PLAYING

The object of the game is to accumulate a score of 100 points or more. A score is made by rolling the dice and combining the points on the two dice. For example: A 4 and 5 would be 9 points - if the player decides to take another roll of the dice and turns up a 3 and 5 (8 points), he would then have an accumulated total of 17 points for the two rolls. The player has the privilege of continuing to shake to increase his score or of passing the dice to wait for the next series, thus preventing the possibility of rolling a Skunk and losing his score.

### PENALTIES:

A skunk in any series voids the score for that series only and draws a penalty of 1 chip placed in the "kitty," and loss of dice.

A skunk and a deuce voids the score for that series only and draws a penalty of 2 chips placed in the "kitty," and loss of dice.

TWO skunks void the ENTIRE accumulated score and draws a penalty of 4 chips placed in the "kitty," and loss of dice. Player must again start to score from scratch.

Any number can play. [Assume at least two players!] The suggested number of chips to start is 50. There are sufficient chips in the box to allow 8 players to start with 50 chips by placing a par value of "one" on white chips, 5 for 1 on red chips and 10 for 1 on the blue chips.

The first player to accumulate a total of 100 or more points can continue to score as many points over 100 as he believes is needed to win. When he decides to stop, his total score is the “goal.” Each succeeding player receives one more chance to better the goal and end the game.The winner of each game collects all chips in "kitty" and in addition five chips from each losing player or 10 chips from any player without a score.

## Author

* **[Yann Mulonda](https://github.com/YannMjl)**

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE)© [Yann Mulonda](https://github.com/YannMjl) file for details.

