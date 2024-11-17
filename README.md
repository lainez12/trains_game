# 🚂 Trains - Implémentation Digitale d'un Jeu de Plateau

[Jouer au jeu en ligne](https://webinfo.iutmontp.univ-montp2.fr/~lainezw/trains)

## Présentation

Trains est une implémentation numérique du jeu de plateau japonais de construction de réseaux ferroviaires. Dans ce jeu, les joueurs construisent leur réseau ferroviaire autour de Tokyo ou d'Osaka en plaçant des rails et des gares sur le plateau.

<img style="max-width: 900px; height: auto; " src="ressources/gui.png">

## Caractéristiques Techniques

### Architecture du Projet

<img style="max-width: 600px; height: auto; " src="//www.plantuml.com/plantuml/png/XLHDJzj04BtxLunyAQNQ22fEA8f0AA2YG16at2Vsu2oiTztzGAqA_wVv7VbZ7NiJiebBUt7YzvxVp9iT-yHvj3xKAdDFKZTeiGPjIdBKmE7HGO9Qr4yTUdYGPGqMJrWHvDwYr6vGi0cv78R3SwDAigCH_Ce0SEPOK7We53e7Pwsg8m04bwdX6EwybRhAEkmJF9f0Tk-Ihy5-PFRPo9AfronxtHIDDRThiIZMkAJ0jz6Dd3-NMkwrJZDZ5A5UCJPeHbD_lchZYNNUSsFceNNgr6UjBq73VHQoGKNmFKYebhyjWK9eE9IaGPIIPuiYFc2NYuVbmf8keaw5LWeyMo3jfLyk7D-0-e1DesI1NXeDGYJQphFLivyfPATmu8nc5wCBCBLqp9R8g28e9LPyKZN_MpVXObyJX7gvy7F3H8nEpeDAq9rqvN9HAEvylXEHTDcDQJFlU5P_FzG8eQquBwDI-nNK6FxlRb4gjuNhsILvpfWowMPCJR3fkRL48mst6U5kmNPm7NrQUYAT7tQQqKfKaRyhZAMfyQWwYzZCQxjl_JLl57h2qDjpWEuI9p8DKj4AVjl3UrbIRmyZYnpDasqpxpqUhmQwQYMHpT7r9NqtJdGzkq1BBecptd00qg66wS-6fcJRJ4cVDvFJBzVZjzkhhzVJqui4E9-ClzsFrsuxUVjs0ZoNWUEqsZiFtqkbQEjH7IDSuO-OeK_T64Va4hPlUqNhlUnpOs_aJirdL1HiVsRR0OLu6KLamy7mHOWaIf-9tKGyAP-OSR5uh91_7WoE078Xzhjlq1f-x7xFJB2eVJuK8cM5bTNSYr4Urnxsy_WozFYI7Z0uzmz5_9QFDRl_JtHBHI3tlgf6gJTi5aSYbCZtspVOIKqkZ_dNd1WnPr4g9g9RTaAw3BNw0m00"  width=1300 alt="diagramme de classes">

Dans le diagramme ci-dessus, sont représentés seulement les méthodes et attributs contribuant à la compréhension de la modélisation orientée objet du jeu

Le projet est structuré en trois packages principaux qui démontrent une séparation claire des responsabilités :

- `fr.umontpellier.iut.gui` : Interface utilisateur
  - Gestion de l'affichage web
  - Communication client-serveur
  - Rendu des états de jeu

- `fr.umontpellier.iut.trains` : Logique métier
  - Implémentation des règles du jeu
  - Gestion des tours de jeu
  - Système de cartes et actions
  - Manipulation des états de jeu

- `fr.umontpellier.iut.trains.data` : Gestion des données
  - Structures de données du jeu
  - Persistance des états

### Compétences Techniques Démontrées

#### Programmation Orientée Objet
- Conception et implémentation d'une hiérarchie de classes complexe
- Utilisation avancée de l'héritage et du polymorphisme
- Encapsulation des données et comportements
- Pattern MVC pour la séparation des responsabilités

#### Gestion du Code
- Tests unitaires pour la validation du comportement
- Versioning avec Git
- Documentation du code
- Architecture modulaire et maintenable

#### Algorithmes et Structures de Données
- Implémentation d'algorithmes de graphes pour la gestion du réseau ferroviaire
- Gestion efficace des collections pour les cartes et les joueurs
- Optimisation des parcours et des recherches

#### Interface Utilisateur
- Développement d'une interface web interactive
- Communication client-serveur
- Gestion des événements utilisateur
- Rendu dynamique des états de jeu

## Fonctionnalités du Jeu

### Système de Cartes
- 39 types de cartes uniques
- Gestion de différents types : Train, Rail, Gare, Action, Victoire, Ferraille
- Implémentation des effets spéciaux pour chaque carte

### Gestion des Joueurs
- Système de tours de jeu
- Gestion des ressources et des actions
- Pile de cartes personnalisée pour chaque joueur
- Système de points et de victoire

### Plateau de Jeu
- Placement dynamique des rails et des gares
- Validation des constructions
- Calcul des scores et des bonus

## Installation et Exécution

### Pour Jouer en Ligne
Visitez [le site du jeu](https://webinfo.iutmontp.univ-montp2.fr/~lainezw/trains)

### Pour Exécuter Localement
1. Cloner le dépôt
2. Exécuter la classe `GameServer` dans `fr.umontpellier.iut.gui`
3. Ouvrir `http://localhost:4242` dans un navigateur

## Contexte du Projet

Ce projet a été développé dans le cadre des SAÉ S2.01 et S2.02 du BUT Informatique à l'IUT Montpellier-Sète. Il démontre la maîtrise de compétences essentielles en développement logiciel, de la conception à l'implémentation, en passant par les tests et la documentation.

## Conclusion

Ce projet illustre ma capacité à :
- Concevoir et implémenter une application complexe en Java
- Créer une architecture logicielle robuste et maintenable
- Développer des interfaces utilisateur interactives
- Gérer un projet de développement complet
- Travailler avec des algorithmes et structures de données complexes
