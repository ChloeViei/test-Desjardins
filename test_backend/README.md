# Backend Java avec Base de données H2

Ce projet constitue un backend Java qui utilise une base de données H2 intégrée. Il fournit une API REST pour interagir avec les données.

## Prérequis

Assurez-vous d'avoir installé Java JDK et Maven sur votre machine.

- Java JDK 21
- Maven

## Installation et Exécution

1. **Récupération du Projet :**

Vous devez dézipper le projet.

2. **Lancement de l'application :**

Utilisez Maven pour démarrer l'application:

``` bash 
mvn spring-boot:run
```

Cela va compiler le projet, télécharger les dépendances nécessaires et lancer le serveur backend sur http://localhost:8080.


3. **Accès à la console H2 (Base de données):**

Une fois le backend démarré, vous pouvez accéder à la console H2 pour interagir avec la base de données. 
Ouvrez votre navigateur et allez à l'URL suivante : http://localhost:8080/h2-console
    
    
Utilisez les paramètres suivants pour vous connecter :

JDBC URL : jdbc:h2:mem:testdb
Nom d'utilisateur : admin
Mot de passe : password
Cliquez sur le bouton Connecter pour accéder à la base de données H2.


# Documentation de l'API

Pour interagir avec l'API, vous pouvez utiliser la collection Postman suivante :
https://planetary-trinity-106087.postman.co/workspace/Mearn~6b21d136-6038-4fc0-93c1-2e5496d55826/collection/5697659-f7502d9d-d228-4823-b91f-b5561af553b9?action=share&creator=5697659


Cette collection Postman contient des exemples de requêtes pour tester et interagir avec les différentes routes de l'API REST.

