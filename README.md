# Tower of Hanoi powered by Java

This project contains an algorithm to play the Tower of Hanoi game. In this game, there are three towers or rods, and an arbitrary number of disks. Each disk is a different size. Initially, all the disks are on the left tower with the largest disk on the bottom and the smallest on the top. The purpose of the game is to move all the disks from the left tower to the right tower. There are a couple of rules:

1. Only the top disk on a tower may be moved.
1. A larger disk must not be placed on top of a smaller disk.

The minimum number of moves required to solve the game is 2^n-1 where n is the number of disks (or tower height).

# Strategy

## Game classes

The game is represented by three classes:

* A disk class (class hanoi.model.Disk).
* A tower class (class hanoi.model.Tower).
* A game board class that contains the three towers (class hanoi.model.HanoiTowers).

## Player class

There is a player class that performs the moves (class hanoi.game.HanoiPlayer). 

## Runnable class

Class hanoi.TowerOfHanoi contains the main method. This method starts Spring Boot in standalone (non-Web) mode. It then runs the game. It is difficult to read command-line arguments and pass them to Spring-managed Beans so the tower height is specified in src/main/resources/application.yaml.

# About the project

## Spring Boot

The project uses the Spring Boot application framework. Spring Boot is an opinionated framework built on top of the Spring Inversion of Control (IoC) framework. See hanoi.TowerOfHanoi in src/main/java to see how Spring Boot starts up. Spring Boot reads configuration from application.yaml (or .properties) found in src/main/resources.

## Maven

The project uses Maven as a dependency manager. All of Maven's configuration is found in pom.xml.

## Eclipse

The project was developed using the Eclipse IDE so the .project and .classpath configuration files are included. If you use another IDE you will need to import the project as a Maven project.
