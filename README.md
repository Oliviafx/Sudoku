# Sudoku

This both is a sudoku solver and a way for the user to play the game themselves. 


## Labeling (for own notes)

Blocks are the 3x3 grid of tiles that form a square in which numbers can't be repeated. They are labeled in the following way:

Col 1 | Col 2 | Col 3
:---:|:---:|:---:
 0 | 1 | 2 
 3 | 4 | 5 
 6 | 7 | 8 

Rows are labeled 0-8 from top to bottom, columns are labeled 0-8 from left to right. As such, the tile on the left top corner would be tile at row 0, column 0. 

## Notes
+ A grid is the Sudoku board :octocat:
+ A grid is made up of 9 blocks, each block is a 3x3 grid of tiles
+ Each tile holds an individual number
+ As per classic sudoku rules, in each row, column, and block can only have each of the numbers 1-9 once, without repeats. 
