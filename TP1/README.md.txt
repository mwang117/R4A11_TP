Q1 : Où se trouve ce fichier ?

	app/res/layout/activity_main.xml



Q2 : Qu’avez-vous modifié ?

	Dans le fichier "activity_main.xml", j'ai modifié la ligne :
		android:text="Hello World !"   -->    android:text="Coucou j'ai trouvé comment faire"



Q3 : Qu’avez-vous modifié pour changer l’icône ?

	Dans le fichier "AndroidManifest.xml", modifié dans la balise "Application"
		Les attributs android:icon et android:roundIcon
		Rajouter dans le dossier "res/mipmap" une nouvelle image avec l'outil Image Asset.



Q4 : Est-ce nécessaire de cliquer sur le bouton valider pour afficher le texte saisi sur la seconde activité ? Pourquoi ?

	Non, le texte est transmis à la seconde activité via l'Intent déclenché par le bouton. Le bouton "Valider" ne fait que mettre à jour le TextView dans MainActivity, mais n’intervient pas dans le transfert des données.



Q5 : Le comportement de la question 4 vous semble-t-il normal ?

	Oui, la transmission des données d'une activité à une autre via un Intent est indépendante. Ca va permetttre une grande flexibilité.



Q6 : Comment faire pour ne pas afficher le nouveau texte sur la deuxième activité tant que le bouton valider n’a pas été cliqué ?

	Modifier le clic sur "Aller à la deuxième page" dans "MainActivity" :
	buttonNext.setOnClickListener {
 	   val validatedText = displayText.text.toString()
 	   if (validatedText.isNotEmpty()) {
        	val intent = Intent(this, MainActivity2::class.java)
        	intent.putExtra(EXTRA_TEXT, validatedText)
        	startActivity(intent)
    	   } else {
        	Toast.makeText(this, "Veuillez d'abord valider le texte", Toast.LENGTH_SHORT).show()
    	   }
	}