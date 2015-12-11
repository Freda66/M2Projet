#Projet M2
##Optimiseur de précision numérique

Outil de transformation source à source pour optimiser la précision.

Langage traité C, langage du code Java.
Utilisation du parser JavaCC.

3 modules :
- Mesure des erreurs
   - Mesure les ranges de chaque variables
   - Précision du programme source

- Transformation des expressions
   - ???

- Transformation des commandes
   - Reprise du programme source en entrée
   - Reprise des informations de la mesure des erreurs (lecture de fichier ou bdd)
   - Appel le travail de l'optimiseur d'expression
   - Optimise les commandes


Mesure :
   Programme source -> Programme instrumenté : (chaque variable type float, print qui affiche la valeur/intervalle de la variable et sa ligne -> insert bdd)
   
Optimisation des expressions : (Critique)
   On prend une expressions, on renvoi des ranges
   On calcul une nouvelle expressions optimisé à partir des ranges récupérés

Optimisation des commandes : 
   Interface entre les deux autres modules
   

BDD :
   Table :
      Measurement
         id : Integer AutoIncrement Pk
         numLigne : Integer
         nomVar : Varchar
         debutInt : Numeric
         finInt : Numeric
         val : Numeric
         valOpt : Numeric
