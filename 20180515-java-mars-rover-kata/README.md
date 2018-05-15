Mars Rover Kata
===============

You’re part of the team that explores Mars by sending remotely controlled vehicles to the surface of the planet. 
Develop an api that moves a rover around on a grid.

## Requirements
* You are given the initial starting point x,y of a rover and the 
direction (N,S,E,W) it is facing e.g. (0,0,N).
* The rover receives a character array of commands e.g. "RFFLF".
* Implement commands that move the rover one point forward/backward (F,B) in the current direction.
* Implement commands that turn the rover left/right (L,R).
* Implement wrapping from one edge of the grid to another. (planets are spheres after all)
* Implement obstacle detection before each move to a new square. 
* If a given sequence of commands encounters an obstacle, the rover moves up 
to the last possible point and reports the obstacle.

## Rules
* Hardcore TDD. No Excuses!
* Change roles (driver, navigator) after each TDD cycle.
* No red phases while refactoring.
* Be careful about edge cases and exceptions. We can not afford to lose a mars rover, just 
because the developers overlooked a null pointer.

## Source
- http://kata-log.rocks/mars-rover-kata
- https://github.com/vfarcic/mars-rover-kata-java
