package com.example.livreinformatique

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
//import kotlinx.coroutines.flow.internal.NoOpContinuation.context
import org.xmlpull.v1.XmlPullParser
import org.xmlpull.v1.XmlPullParserFactory
//import kotlin.coroutines.jvm.internal.CompletedContinuation.context


class test_Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test)

//        val quizs : Array<String> = resources.getStringArray(R..quiz)
//        var quiz : Array<String>  = resources.getResourceName(R.xml.quiz) getResources().getXml(R.xml.books)
    var quiz : Array<String>
//        val parser  = resources.getXml(R.xml.test)

        data class Person(val name: String, val age: String, val email: String)

        val people = ArrayList<Person>()

//        val parser = resources.getXml(R.xml.test)


        class Book(var title: String?, var author: String?, var published: String?)
        val books = mutableListOf<Book>()

// Créer un nouvel objet XmlPullParser
//        val parser = XmlPullParserFactory.newInstance().newPullParser()

// Configurer le parser avec le fichier XML à lire
//        val inputStream = context.assets.open("file2.xml")
//        parser.setInput(inputStream, null)

// Variables pour stocker les informations de chaque livre

        var title: String? = null
        var author: String? = null
        var published: String? = null
        val parser = resources.getXml(R.xml.file2)
// Boucle pour parcourir le fichier XML et extraire les informations de chaque livre
        while (parser.next() != XmlPullParser.END_DOCUMENT) {
            when (parser.eventType) {
                XmlPullParser.START_TAG -> {
                    when (parser.name) {
                        "book" -> {
                            // Nouveau livre trouvé, réinitialiser les variables
                            title = null
                            author = null
                            published = null
                        }
                        "title" -> {
                            // Récupérer le titre du livre

                            title = parser.nextText()
                        }
                        "author" -> {
                            // Récupérer l'auteur du livre
                            author = parser.nextText()
                        }
                        "published" -> {
                            // Récupérer la date de publication du livre
                            published = parser.nextText()
                        }
                    }
                }
                XmlPullParser.END_TAG -> {
                    if (parser.name == "book") {
                        // Fin du livre, ajouter un nouvel objet Book à la liste
                        books.add(Book(title, author, published))
                    }
                }
            }
        }

        books





//        class Book(var title: String?, var author: String?, var published: String?)

//        fun parseXml(inputStream: InputStream): List<Book> {
//            val books = mutableListOf<Book>()
//
//            val factory = XmlPullParserFactory.newInstance()
//            factory.isNamespaceAware = true
//            val parser = factory.newPullParser()
//
//            parser.setInput(inputStream, null)
//
//            var eventType = parser.eventType
//            var currentBook: Book? = null
//
//            while (eventType != XmlPullParser.END_DOCUMENT) {
//                when (eventType) {
//                    XmlPullParser.START_TAG -> {
//                        when (parser.name) {
//                            "book" -> {
//                                currentBook = Book(null, null, null)
//                            }
//                            "title" -> {
//                                currentBook?.title = parser.nextText()
//                            }
//                            "author" -> {
//                                currentBook?.author = parser.nextText()
//                            }
//                            "published" -> {
//                                currentBook?.published = parser.nextText()
//                            }
//                        }
//                    }
//                    XmlPullParser.END_TAG -> {
//                        if (parser.name == "book") {
//                            currentBook?.let {
//                                books.add(it)
//                            }
//                            currentBook = null
//                        }
//                    }
//                }
//                eventType = parser.next()
//            }
//
//            return books
//        }






//        while (parser.eventType != XmlPullParser.END_DOCUMENT) {
//            if (parser.name == "person") {
//                val name = parser.getAttributeValue(null, "name")
//                val age = parser.getAttributeValue(null, "age").toInt()
//                val email = parser.getAttributeValue(null, "email")
//                val person = Person(name, age, email)
//                people.add(person)
//            }
//            parser.next()
//        }

        people


//        val `is`: InputStream = assets.open("file.xml")
//
//        val dbFactory: DocumentBuilderFactory = DocumentBuilderFactory.newInstance()
//        val dBuilder: DocumentBuilder = dbFactory.newDocumentBuilder()
//        val doc: Document = dBuilder.parse(`is`)
//
//        val element: Element = doc.getDocumentElement()
//        element.normalize()
//
//        val nList: NodeList = doc.getElementsByTagName("employee")
//
//        for (i in 0 until nList.getLength()) {
//            val node: Node = nList.item(i)
//            if (node.getNodeType() === Node.ELEMENT_NODE) {
//                val element2: Element = node as Element
//                tv1.setText(tv1.getText() + "\nName : " + getValue("name", element2) + "\n")
//                tv1.setText(tv1.getText() + "Surname : " + getValue("surname", element2) + "\n")
//                tv1.setText(tv1.getText() + "-----------------------")
//            }
//        }


    }
}