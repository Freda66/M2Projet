<h1>Optinum</h1>
<h1><small>Optimiseur de précision numérique</<small></h1>

<!-- ====================================================================== -->

<p>Outil de transformation source à source pour optimiser la précision des calculs flottants. Projet de Master 2 CHiPS (Calcul, Hautes Performances, Simultations) de l'UPVD (Université de Perpignan Via Dominitia). </p>

<!-- ====================================================================== -->

<h2>Sommaire</h2>
<ul>
    <li><a href="#technologies">Technologies</a></li>
    <li><a href="#modules">Modules</a></li>
    <li><a href="#mesures">Mesures</a></li>
    <li><a href="#bdd">Base de données</a></li>
    <ul>
        <li><a href="#mesure">Measurement</a></li>
        <li><a href="#resultat">Resultat</a></li>
    </ul>
</ul>

<!-- ====================================================================== -->

<h2 id="technologies">Technologies</h2>
<ul>
	<li>Entrée : C</li>
	<li>Traitement : Java</li>
	<li>Parser : JavaCC</li>
</ul>

<!-- ====================================================================== -->

<h2 id="modules">Modules</h2>
<ol>
	<li>Mesure des erreurs</li>
	<ul>
		<li>Mesure des ranges de chaque variables</li>
		<li>Précision du programme source</li>
	</ul>
	<li>Transformations des expression</li>
	<ul>
		<li><a href="https://github.com/Freda66/M2Projet/tree/master/dev/Expression">Liste des transformations</a></li>
	</ul>
	<li>Transformations des commandes</li>
	<ul>
		<li>Reprise du programme source en entrée</li>
		<li>Reprise des informations de la mesure des erreurs (lecture de fichier ou bdd)</li>
		<li>Appel le travail de l'optimiseur d'expression</li>
		<li>Optimise les commandes</li>
	</ul>
</ol>

<!-- ====================================================================== -->

<h2 id="mesures">Mesure</h2>

<p>
   Programme source -> Programme instrumenté : (chaque variable type float, print qui affiche la valeur/intervalle de la variable et sa ligne -> insert bdd
   1 : Lire fichier c -> Parser en arbre -> Recreer programme c
   2 : Parcour arbre -> insert bdd
</p>

<p>
Optimisation des expressions : (Critique)
   On prend une expressions, on renvoi des ranges
   On calcul une nouvelle expressions optimisé à partir des ranges récupérés
</p>
<p>
Optimisation des commandes : 
   Interface entre les deux autres modules
</p>

<!-- ====================================================================== -->
<h2 id="bdd">Base de données</h2>

<h3 id="mesure">Measurement</h3>

| Attribut      | Type      | Description           |
| ------------- | --------- | --------------------- |
| id            | PK integer| identification        |
| nomVar        | Text      | Nom de variable       |
| min           | Numeric   | Valeur minimale       |
| max           | Numeric   | Valeur maximale       |

<h3 id="resultat">Resultat</h3>

| Attribut      | Type      | Description           |
| ------------- | --------- | --------------------- |
| idRun         | PK integer| identification        |
| resultatInit  | Numeric   | Resultat initial      |
| resultatOpt   | Numeric   | Resultat optimal      |
| resultatMpfr  | Numeric   | Resultat après mpfr   |

<!-- ====================================================================== -->
<h2 id="library">Bibliothèques</h2>

<ul>
    <li><a href="https://github.com/kframework/mpfr-java">mpfr-java</a></li>
    <li><a href="https://github.com/timmolter/XChart">XChart</a></li>
    <li><a href="https://github.com/xerial/sqlite-jdbc">sqlite-jdbc</a></li>
</ul>
