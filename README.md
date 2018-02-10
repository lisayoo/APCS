# APCS Final Design Project

## Overview

This program simulates a simple math game, with the aim of teaching basic arithmetic to the user. The game consists of three levels, and teaches simple integer addition and subtraction with increasing difficulty per level.

## Project Summary

On the most basic level of this programming problem, there are a few things that need to be done: to generate problems, to manipulate components of the game (points, level, number of trials), and to take user input and run the game. These became the foundation of our basic classes, ProblemGenerator, ScoreKeeper, and UserInteraction. Then, zooming in, there are three levels and different specifications for each of them, so we made a method for each level in the ProblemGenerator class. For the ScoreKeeper, we assigned methods to manipulate each of the game components. In UserInteraction, we ran the game in its entirety. Also, for the main method, we need a runner to implement the UserInteraction class, so we have the Tester class.

### (1) ProblemGenerator Class

This class uses the random method of the Math class to generate problems based on the user’s current level, with a separate method for each of the three levels. level1() returns a problem with two single-digit integers whose sum is less than 10. level2() returns a problem with two single-digit integers whose sum may be greater or equal to 10. level3() returns a problem with two single-digit integers with a positive difference.

### (2) ScoreKeeper Class

This class keeps track of the player’s score, current level, and number of attempts per problem. It has methods to reset the trials, score, and game (resetTrials(), resetScore(), and resetGame()), and to change the level (changeLevel()). It also has a checkAnswer() method to compare the actual answer to the user’s answer, and return a boolean.

### (3) UserInteraction Class

This class provides the structure of how the game will run, with the runGame() method. It takes user input, and proceeds according to whether their answer is correct. For every problem, the user gets two attempts to solve the problem correctly, and gain a point if they do, but get another problem if they don’t get it within the two tries. When the user gets five points, they advance to the next level, and win the game if they pass all three levels. 
