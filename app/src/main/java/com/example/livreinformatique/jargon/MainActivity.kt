package com.example.login



import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.RecyclerView
import com.example.livreinformatique.R

class MainActivity : AppCompatActivity() {

    // on below line we are creating variables for
    // our swipe to refresh layout, recycler view,
    // adapter and list.
    lateinit var courseRV: RecyclerView
    lateinit var courseRVAdapter: CourseRVAdapter
    lateinit var courseList: ArrayList<CourseRVModal>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        // on below line we are initializing our views with their ids.
        courseRV = findViewById(R.id.idRVCourses)

        // on below line we are initializing our list
        courseList = ArrayList()

        // on below line we are initializing our adapter
        courseRVAdapter = CourseRVAdapter(courseList)

        // on below line we are setting adapter to our recycler view.
        courseRV.adapter = courseRVAdapter

        // on below line we are adding data to our list

        //courseList.add(CourseRVModal("activer ","" ))
        courseList.add(CourseRVModal(R.drawable.ip,"ADRESSE IP","Adresse unique d’un périphérique (ordinateur, tablette, imprimante, …) sur un réseau.\n" ))
        courseList.add(CourseRVModal(R.drawable.memoire,"ADRESSE MAC\n", "L’adresse MAC est une adresse physique d’un équipement réseau." ))
        courseList.add(CourseRVModal(R.drawable.antivirus,"ANTIVIRUS ", "Un antivirus est un logiciel qui protège contre ce risque. Il scrute le contenu de l’ordinateur, « soigne » ou isole les données infectées. "))
        courseList.add(CourseRVModal(R.drawable.application,"APPLICATION ","Une application est un outil informatique permettant de mener une action " ))
        courseList.add(CourseRVModal(R.drawable.android,"ANDROID ","Android est le système d'exploitation mobile crée par Google. Il équipe la majorité des téléphones portables du moment (smartphones)" ))
        courseList.add(CourseRVModal(R.drawable.bd,"BASE DE DONNEES","Système permettant l’enregistrement et le stockage de données. Les bases de données sont constituées de 1 ou plusieurs fichiers"))

        courseList.add(CourseRVModal(R.drawable.bande,"BANDE PASSANTE ","La bande passante est la mesure de la vitesse à laquelle les données informatiques vont pouvoir passer dans votre connexion Internet" ))
        courseList.add(CourseRVModal(R.drawable.bluetooth,"BLUETOOTH ","Le Bluetooth est un protocole de communication sans fil, visant à connecter des appareils mobiles entre eux" ))
        courseList.add(CourseRVModal(R.drawable.bios,"BIOS (Basic Input Output System : Système d’entrées/sorties de base) ","C’est le système qui permet de faire démarrer votre ordinateur. Ce système est très simple. C’est lui qui va lire les pistes de boot pour lancer l’OS." ))
        courseList.add(CourseRVModal(R.drawable.bureau,"BUREAU ","Le « bureau » est l’espace de rangement affiché à l’écran après le démarrage de l’ordinateur. " ))
        courseList.add(CourseRVModal(R.drawable.bureautique,"BUREAUTIQUE ","La bureautique est un terme qui regroupe les logiciels qui aident l'entreprise dans la rédaction de documents. Microsoft Office est une suite bureautique permettant entre autres d'écrire des lettres, rédiger des CV (avec Word), créer des présentations (avec PowerPoint), créer des tableaux de calcul et des graphiques (avec Excel)." ))
        courseList.add(CourseRVModal(R.drawable.memoire,"CARTE MEMOIRE ","La carte mémoire est un petit bloc de quelques centimètres permettant de stocker des données informatiques, comme une clé USB." ))


        courseList.add(CourseRVModal(R.drawable.cartemere,"CARTE MERE ","La carte mère est le composant principal de l'unité centrale. Le rôle de la carte mère est de centraliser et traiter les données échangées dans un ordinateur à l'aide du processeur, qui est fixé dessus. " ))
        courseList.add(CourseRVModal(R.drawable.cloud,"CLOUD COMPUTING ","Le Cloud Computing, littéralement : l'informatique dans les nuages, est un concept qui commence à s'imposer : plutôt que d'installer un logiciel sur votre ordinateur, qui va prendre de la place, la tendance veut désormais que les choses se fassent en ligne, sans avoir besoin de télécharger" ))
        courseList.add(CourseRVModal(R.drawable.corbeille,"CORBEILLE ","La corbeille Windows recense tous les fichiers et dossiers que vous avez supprimés antérieurement" ))
        courseList.add(CourseRVModal(R.drawable.disque,"DISQUE DUR ","Le disque dur est l’un des principaux composants d'un ordinateur. Son rôle est de stocker des données informatiques " ))
        courseList.add(CourseRVModal(R.drawable.dvd,"DVD ","Le DVD (Digital Versatile Disc) est le successeur du CD. Sa plus grande capacité permet de stocker des films, des logiciels, jeux ou encore des données informatiques" ))
        courseList.add(CourseRVModal(R.drawable.commerce,"E-COMMERCE ","Désigne un site marchand sur lequel on peut acheter en ligne : l'internaute choisit ses produits par catégories ou avec un moteur de recherche et paie en ligne avec sa carte bancaire par virement sécurisé couplé à une banque" ))
        courseList.add(CourseRVModal(R.drawable.elearning,"E-LEARNING ","L'E-learning est un anglicisme désignant la méthode d'apprentissage en ligne, sur Internet." ))
        courseList.add(CourseRVModal(R.drawable.mail_24,"EMAIL ","Un e-mail est un anglicisme du mot courrier électronique, que l'on peut contracter en courriel en français" ))
        courseList.add(CourseRVModal(R.drawable.ecran,"ECRAN ","L'écran est la partie de l'ordinateur qui va afficher un contenu" ))

        courseList.add(CourseRVModal(R.drawable.facebook,"FACEBOOK ","Facebook est le plus gros réseau social du moment avec plusieurs centaines de millions de personnes inscrites. Facebook vous permet de rester en contact avec vos amis et votre famille, de partager vos moments, photos, vidéos, vos humeurs et consulter ceux de vos contacts." ))
        courseList.add(CourseRVModal(R.drawable.fenetre,"FENETRE   ","Facebook est le plus gros réseau social du moment avec plusieurs centaines de millions de personnes inscrites. Facebook vous permet de rester en contact avec vos amis et votre famille, de partager vos moments, photos, vidéos, vos humeurs et consulter ceux de vos contacts." ))
        courseList.add(CourseRVModal(R.drawable.fichier,"FICHIER"," Un fichier correspond à un enregistrement de données informatiques stockées dans votre ordinateur" ))
        courseList.add(CourseRVModal(R.drawable.fibre,"FIBRE OPTIQUE"," La fibre optique est un câble transportant de la lumière, au lieu de l’électricité, ce qui permet d’être bien plus efficace et perdre beaucoup moins de données sur les longues distances. Cela permet donc des connexions et des débits beaucoup plus importants." ))

        courseList.add(CourseRVModal(R.drawable.fai,"FOURNISSEUR D'ACCES INTERNET ","Les Fournisseurs d'Accès à Internet (plus communément : FAI) vous permettent de bénéficier d'Internet chez vous . Parmi les FAI on retrouve : Orange,MTN, CAMTEL, " ))

       courseList.add(CourseRVModal(R.drawable.google,"GOOGLE"," Google est le principal moteur de recherche du marché et également une des plus grosses entreprises informatique du monde. www.google.fr vous permet de faire une recherche sur la globalité des sites du monde entier afin de trouver des sites, des images, des vidéos et des actualités, le tout classé par pertinence.\n" +
               "Google s’impose sur le marché Européen et Américain avec plus de 95% de parts de marché.\n" ))

        courseList.add(CourseRVModal(R.drawable.gps, "GPS ","Un GPS est un appareil mobile capable de vous guider d'un point A à un point B" ))

        courseList.add(CourseRVModal(R.drawable.hdmi, "HDMI ","HDMI est une connectique pour relier des appareils Haute Définition entre eux. " ))

        courseList.add(CourseRVModal(R.drawable.icloud, "iCLOUD ","iCloud est le service dans les nuages d'Apple (Cloud) qui vous permet de synchroniser vos données entre tous vos appareils : iPhone, iPad et Macs." ))

        courseList.add(CourseRVModal(R.drawable.icone, "ICONE ","Une icône est un pictogramme accompagné d'un nom et représentant un élément : dossiers, fichiers, logiciels, raccourcis..." ))
        courseList.add(CourseRVModal(R.drawable.imprimante, "IMPRIMANTE ","L'imprimante permet de sortir sur papier un document, une photographie initialement présente ou créée sur un ordinateur" ))
        courseList.add(CourseRVModal(R.drawable.ico, "INFORMATIQUE ","L'informatique regroupe tout ce qui traite autour du traitement automatique de l'information : Internet, les ordinateurs, les télécommunications." ))
        courseList.add(CourseRVModal(R.drawable.cortana, "INTELLIGENCE ARTIFICIELLE ","Une intelligence artificielle est un programme informatique / robot capable de réfléchir et penser par lui-même au-delà de sa programmation initiale." ))
        courseList.add(CourseRVModal(R.drawable.internet_reseau, "INTERNET ","Internet regroupe tous les réseaux interconnectés (câblés et sans-fil) du monde et les sites web" ))
        courseList.add(CourseRVModal(R.drawable.internet_explorer, "INTERNET EXPLORER ","Internet Explorer est le logiciel phare de Microsoft dans la navigation sur Internet" ))
        courseList.add(CourseRVModal(R.drawable.intranet, "INTRANET ","Un Intranet est un site accessible seulement à une entreprise et réalisé dans le but de partager des informations et des documents internes." ))
        courseList.add(CourseRVModal(R.drawable.iphone, "IOS ","iOS est le système d'exploitation d'Apple qui équipe actuellement les smartphones iPhone et les tablettes iPad." ))
        courseList.add(CourseRVModal(R.drawable.iwork, "iWORK ","iWork est la suite bureautique exclusive à Apple et donc seulement compatible sur la gamme de Mac." ))


        courseList.add(CourseRVModal(R.drawable.lan, "LAN ","Local Arena Network : en anglais un réseau local. Ce terme est utilisé par les Gamers (les joueurs) pour désigner une partie de jeu en réseau entre amis" ))
        courseList.add(CourseRVModal(R.drawable.lecteur_reseau, "LECTEUR RESEAU ","Le lecteur réseau est une icône située dans le dossier Ordinateur et qui permet d'accéder à un dossier du serveur en entreprise." ))
        courseList.add(CourseRVModal(R.drawable.licence, "LICENCE ","Une licence est un droit d'utilisation accordé à un utilisateur pour un logiciel donné. " ))
        courseList.add(CourseRVModal(R.drawable.lien, "LIEN ","Un lien est un texte, un bouton ou une image sur lesquels il est possible de cliquer afin d'être amené sur une nouvelle page ou vers un nouveau contenu." ))
        courseList.add(CourseRVModal(R.drawable.linux, "LINUX ","Linux est un concurrent de Windows et Apple sur le marché des systèmes d'exploitation créé par Linus Torvalds." ))
        courseList.add(CourseRVModal(R.drawable.application, "LOGICIEL ","Un logiciel est un programme qui apporte à l'ordinateur un lot de fonctionnalités supplémentaires, qui ne sont pas forcément présentes à l'origine. " ))

        courseList.add(CourseRVModal(R.drawable.application, "LOGICIEL D'APPLICATION ","Le logiciel d'application est un programme ou un groupe de programmes conçu pour les utilisateurs finaux " ))
        courseList.add(CourseRVModal(R.drawable.application, "LOGICIEL SYSTEME "," Le logiciel système est un ensemble de programmes informatiques et de bibliothèques logicielles qui fournit un environnement permettant de créer et d'exécuter des logiciels applicatifs" ))



        courseList.add(CourseRVModal(R.drawable.logiciel_libre, "LOGICIEL LIBRE ","Un logiciel libre (free software, en anglais) est un programme qui peut être librement utilisé, modifié et redistribué, avec une seule restriction " ))
        courseList.add(CourseRVModal(R.drawable.logiciel_libre, "LOGICIEL SYSTEME "," " ))

        courseList.add(CourseRVModal(R.drawable.microsoft, "MICROSOFT "," Microsoft est une multinationale qui développe entre autres les systèmes Windows. Fondée par Bill Gates en 1975 et située à Redmond aux Etats-Unis," ))
        courseList.add(CourseRVModal(R.drawable.box_internet, "MODEM ","Un modem est un boitier qui permet d'établir une connexion à Internet." ))
        courseList.add(CourseRVModal(R.drawable.nom_utilisateur, "MOT DE PASSE ","Le mot de passe permet de sécuriser les accès à votre ordinateur, sites web et applications. " ))
        courseList.add(CourseRVModal(R.drawable.moteur, "MOTEUR DE RECHERCHE ","Un moteur de recherche est un site indexant tous les autres sites Internet et vous permet de poser une question ou taper des mots pour faire une recherche." ))
        courseList.add(CourseRVModal(R.drawable.navigateur_internet, "NAVIGATEUR INTERNET ","Le navigateur Internet est un logiciel vous permettant d'afficher des sites Internet, télécharger des fichiers et faire des recherches." ))

        courseList.add(CourseRVModal(R.drawable.objets_connectes, "OBJET CONNECTE ","Le terme objet connecté désigne tout objet de la vie courante possédant la capacité de se connecter à Internet et donc améliorer ses possibilités." ))
        courseList.add(CourseRVModal(R.drawable.octet, "OCTET ","L'octet est l'unité de taille informatique qui mesure la taille d'un fichier, son poids." ))
        courseList.add(CourseRVModal(R.drawable.onglet, "ONGLET ","Les onglets permettent de naviguer sur plusieurs sites en même temps." ))
        courseList.add(CourseRVModal(R.drawable.ecran, "ORDINATEUR ","L'ordinateur désigne l'unité centrale et les périphériques qu'elle contient. " ))
        courseList.add(CourseRVModal(R.drawable.panneau, "PANNEAU DE CONFIGURATION ","Le panneau de configuration est une interface permettant de modifier les paramètres de Windows" ))
        courseList.add(CourseRVModal(R.drawable.reglages, "PARAMETRES ","Les paramètres servent à configurer les outils que vous utilisez afin de mieux répondre à vos besoins." ))
        courseList.add(CourseRVModal(R.drawable.pare_feu, "PARE-FEU ","Le pare-feu (en anglais firewall) est une protection située à l'entrée du réseau et sur les ordinateurs, visant à empêcher toute intrusion sur le réseau. " ))

        courseList.add(CourseRVModal(R.drawable.peripherique, "PERIPHERIQUE ","Un périphérique est un matériel informatique qui vient se relier à un ordinateur. " ))
        courseList.add(CourseRVModal(R.drawable.pixel, "PIXEL ","Le pixel est un petit carré composant l'écran et qui affiche une couleur à la fois." ))
        courseList.add(CourseRVModal(R.drawable.plugin, "PLUGIN ","Un plugin étend les fonctionnalités de base d'un logiciel. En français on les appelle Extensions." ))
        courseList.add(CourseRVModal(R.drawable.processeur, "PROCESSEUR "," Partie d'un ordinateur qui interprète et exécute les instructions." ))
        courseList.add(CourseRVModal(R.drawable.code_source , "PROGRAMMATION  "," La programmation est le fait d'écrire des lignes de code (commandes en anglais) qui seront interprétées par l'ordinateur" ))


        courseList.add(CourseRVModal(R.drawable.raccourci, "RACCOURCI ","Un raccourci est une icône qui se place n'importe où et qui permet d'accéder rapidement à un logiciel ou un endroit de l'ordinateur. " ))
        courseList.add(CourseRVModal(R.drawable.ram, "RAM ","La RAM est un type de mémoire qui équipe tout ordinateur et qui permet de stocker des informations provisoires." ))
        courseList.add(CourseRVModal(R.drawable.lan, "RESEAU ","Un réseau désigne l'interconnexion entre plusieurs ordinateurs qui permet l'échange et le partage d'informations. " ))
        courseList.add(CourseRVModal(R.drawable.resolution, "RESOLUTION ","C'est le nombre de pixels affichés en largeur et en hauteur sur un écran. " ))
        courseList.add(CourseRVModal(R.drawable.box_internet, "ROUTEUR ","Un routeur est un appareil capable de gérer un petit réseau" ))
        courseList.add(CourseRVModal(R.drawable.scanner, "SCANNER ","Le scanner permet de numériser un document papier. " ))
        courseList.add(CourseRVModal(R.drawable.serveur, "SERVEUR ","Le serveur en entreprise est un ordinateur plus puissant qui va s'occuper du partage des fichiers, de faire des sauvegardes des données régulièrement, . " ))
        courseList.add(CourseRVModal(R.drawable.souris, "SOURIS ","Une souris est un dispositif de pointage qui se relie à l'ordinateur." ))
        courseList.add(CourseRVModal(R.drawable.systemes, "SYSTEME D'EXPLOITATION ","Une souris est un dispositif de pointage qui se relie à l'ordinateur." ))
        courseList.add(CourseRVModal(R.drawable.tableur, "TABLEUR ","Un tableur est un logiciel permettant de traiter des informations sous forme de tableau." ))
        courseList.add(CourseRVModal(R.drawable.telecharger, "TELECHARGER ","Télécharger désigne le fait de copier un fichier situé sur Internet ou chez quelqu'un d'autre sur son ordinateur." ))
        courseList.add(CourseRVModal(R.drawable.traitement_texte, "TRAITEMENT DE TEXTE ","La notion traitement de texte désigne les logiciels permettant de rédiger un contenu, de créer des documents de texte (lettres, livres, CV, courrier...). " ))
        courseList.add(CourseRVModal(R.drawable.unite, "UNIE CENTRALE ","L'unité centrale est le boitier contenant tout le matériel électronique permettant à l'ordinateur de fonctionner. " ))
        courseList.add(CourseRVModal(R.drawable.url, "URL ","L'URL désigne l'adresse d'un site Internet du type \"http://www.xyoos.fr\". " ))
        courseList.add(CourseRVModal(R.drawable.vga, "VGA ","Le câble VGA permet de relier l'écran à l'unité centrale. " ))
        courseList.add(CourseRVModal(R.drawable.webcam, "WEBCAM ","Webcam est la contraction de caméra et Web. C'est une petite caméra  qui vous permet de faire des vidéoconférences " ))
        courseList.add(CourseRVModal(R.drawable.wifi, "WI-FI ","Le Wi-Fi désigne une connexion sans fil à Internet, entre un ordinateur et un routeur." ))
        courseList.add(CourseRVModal(R.drawable.zone, "ZONE DE  NOTIFICATION ","La zone de notification se situe dans la barre des tâches, en bas à droite de l'écran. " ))
        //courseList.add(CourseRVModal(R.drawable.gps, "activer ","" ))




        // on below line we are notifying adapter
        // that data has been updated.
        courseRVAdapter.notifyDataSetChanged()



    }

    // calling on create option menu
    // layout to inflate our menu file.
    override fun onCreateOptionsMenu(menu: Menu): Boolean {




        // below line is to get our inflater
        val inflater = menuInflater

        // inside inflater we are inflating our menu file.
        inflater.inflate(R.menu.search_menu, menu)

        // below line is to get our menu item.
        val searchItem: MenuItem = menu.findItem(R.id.actionSearch)

        // getting search view of our item.
        val searchView: SearchView = searchItem.getActionView() as SearchView


        // below line is to call set on query text listener method.
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener,
            android.widget.SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(p0: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(msg: String): Boolean {
                // inside on query text change method we are
                // calling a method to filter our recycler view.
                filter(msg)
                return false
            }
        })
        return true
    }

    private fun filter(text: String) {
        // creating a new array list to filter our data.
        val filteredlist: ArrayList<CourseRVModal> = ArrayList()

        // running a for loop to compare elements.
        for (item in courseList) {
            // checking if the entered string matched with any item of our recycler view.
            if (item.courseName.lowercase().contains(text.lowercase()) || item.courseImg.lowercase().contains(text.lowercase())) {
                // if the item is matched we are
                // adding it to our filtered list.
                filteredlist.add(item)
            }
        }
        if (filteredlist.isEmpty()) {
            // if no item is added in filtered list we are
            // displaying a toast message as no data found.
            Toast.makeText(this, "le mot n'existe pas..", Toast.LENGTH_SHORT).show()
        } else {
            // at last we are passing that filtered
            // list to our adapter class.
            courseRVAdapter.filterList(filteredlist)
        }
    }
}
