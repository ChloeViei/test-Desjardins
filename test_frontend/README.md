# Guide d'exécution de l'application Angular

## Exécuter l'application

1. **Installation des prérequis :**

   Assurez-vous d'avoir Node.js installé sur votre système. Vous pouvez le télécharger depuis [nodejs.org](https://nodejs.org/). Une fois Node.js installé, installez Angular CLI en ouvrant une fenêtre de terminal et en exécutant la commande suivante :

```bash
 npm install -g @angular/cli
 ```


2. **Récupération du projet :**

Récupérer le projet Angular sur votre machine locale et le dézipper.

3. **Installation des dépendances :**

Dans le répertoire racine de votre projet Angular, installez les dépendances en exécutant la commande suivante :

```bash
npm install
```


4. **Démarrage du serveur de développement :**

Lancez le serveur de développement en utilisant la commande suivante :

```bash
 ng serve
 ```

L'application sera accessible à l'adresse : http://localhost:4200/



## Exécuter les tests

1. **Exécution des tests unitaires :**

Pour exécuter les tests unitaires, utilisez la commande suivante dans votre terminal :

```bash
npm run test
```


Cela lancera Karma pour exécuter les tests et affichera les résultats dans votre terminal.

2. **Générer un rapport de couverture de code :**

Si vous souhaitez générer un rapport de couverture de code, utilisez la commande suivante :

```bash
npm run test -- --code-coverage
```