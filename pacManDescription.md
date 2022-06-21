# PortfolioProjects

Purpose:
The purpose of this project is to create a PacMan-type text game using the java programming language.

Essentially, the main processing cycle consist of the grid being displayed after each command showing the effects of the command. Once the user input is read/accepted the implementation of the PacMan-type text game can be observed. 

NOTE:
1. If an invalid command is entered, an appropriate error message is displayed and the menu of commands and grid gets redisplayed. 
2. Process the command and add one to the number of commands entered if it is a move command.
3. If the user enters the Exit command, the program will display the number of commands and the average number of commands per cookie.
4. If the resulting move places the PacMan over a cookie, indicate the cookie was eaten and add one to the number of cookies eaten for the program statistics.


Program Specification:

1. A java program is created implementing a simple PacMan-type text game which contains the following functionalities:

A) 

At program startup, a 2-dimensional grid is constructed and displayed using standard array(s) with the size dynamically specified by the user (X and Y sizes can be different). 
The PacMan is iontially placed in the upper-left corner of the grid facing left.
All grid cells has the empty cell character of ‘.’ except for the start position of the PacMan which will have the appropriate PacMan symbol (see below). 
Also 15% of the grid (rounded down as necessary) contains cookies randomly located on the grid except for the initial PacMan position. 
The grid is displayed after each command.


B) 

The following symbols are used for the grid:
1. Cookie symbol – shows were cookies are in the grid ('O')
2. Empty symbol – shows empty unvisited grid cells ('.') (dot)
3. Visited symbol – shows grid cells where the PacMan has visited (' ') (space) 
4. PacMan symbol highlighted below depends on the current PacMan facing direction.
a. Left ‘>’
b. Up ‘V’
c. Right ‘<’
d. Down ‘^’


C) 

A menu of commands is provided and displayed when appropriate. 
The menu consists of the following commands (the command number is what
the user should enter to execute the command):

1. Menu – Display the menu of commands.

2. Turn Left – turns the PacMan left (counter-clockwise) but the PacMan stays in its current location.
a. Current: up, new: left
b. Current: right, new up
c. Current: down, new right
d. Current: left, new down

3. Turn Right – turns the PacMan right (clockwise) but the PacMan stays in its current location.
a. Current: up, new: right
b. Current: right, new down
c. Current: down, new left
d. Current: left, new up

4. Move – Moves the PacMan one grid location in the facing direction if possible.

5. Exit – exits the program displaying the game statistics of the number of total moves and the
average number of moves per cookie obtained.


