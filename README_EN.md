# 🚂 Trains - Digital Board Game Implementation

[Play the game online](https://webinfo.iutmontp.univ-montp2.fr/~lainezw/trains)

## Overview

Trains is a digital implementation of the Japanese board game that simulates railway network construction around Tokyo or Osaka. This project was developed as part of my coursework at IUT Montpellier-Sète's Computer Science Department.

![Trains Game Screenshot](ressources/gui.png)

## Game Description

In Trains, players compete to build the most efficient railway network by:
- Placing rails and cities on the game board
- Managing their deck of cards strategically
- Expanding their network across the map
- Purchasing new cards to improve their capabilities

The game combines deck-building mechanics with railway route construction, creating an engaging strategy experience.

## Technical Features

### Core Technologies
- Backend: Java
- Frontend: Web-based interface
- Architecture: Object-Oriented Design with MVC pattern

### Key Implementation Highlights
- Complete digital adaptation of the physical board game
- Modular card system with 39 unique card types
- Interactive web interface for gameplay
- Real-time game state management
- Multi-player support

### Project Structure
The codebase is organized into three main packages:
- `fr.umontpellier.iut.gui`: Frontend interface components
- `fr.umontpellier.iut.trains`: Core game logic
- `fr.umontpellier.iut.trains.data`: Game data and state management

## How to Run

### Play Online
Visit [the game website](https://webinfo.iutmontp.univ-montp2.fr/~lainezw/trains) to play directly in your browser.

### Run Locally
1. Clone the repository
2. Run the `GameServer` class at `fr.umontpellier.iut.gui.GameServer`
3. Open `http://localhost:4242` in your browser
4. Start playing!

## Learning Outcomes

This project helped me develop skills in:
- Object-Oriented Programming
- Software Architecture Design
- Web Development
- Game Logic Implementation
- Testing and Quality Assurance
- Version Control (Git)

## Project Context

This implementation was created as part of University Projects SAE S2.01 and S2.02 at IUT Montpellier-Sète, focusing on object-oriented development, software quality, graph algorithms, and human-computer interfaces.

## Credits

Original board game created in Japan. Digital implementation developed as an educational project at IUT Montpellier-Sète.
