                        ## Project TestSelenium ##

Ce projet Maven contient dans son pom.xml les dépendances nécessaires pour selenium

Dans les ressources de test, je vous ai créez un script sh permettant de télécharger et décompresser dans /tmp/ geckodriver.

Geckodriver est un soft produit par mozilla permettant de lancer une instance de firefox et d'envoyer au navigateur
les différentes commandes selenium des tests.

Pour compiler le projet et exécuter le test, un petit mvn clean install à la racine du projet est suffisant :)