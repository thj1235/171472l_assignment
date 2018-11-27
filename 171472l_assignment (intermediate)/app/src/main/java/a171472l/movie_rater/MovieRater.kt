package a171472l.movie_rater

import a171472l.movie_rater.R.id.*
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.View
import android.widget.Button
import android.widget.RadioButton
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_movie_rater.*





class MovieRater :AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_rater)
    }

    override fun onCreateOptionsMenu(menu: Menu?):
            Boolean {
       menuInflater.inflate(R.menu.movie_rater_menu,menu)
        return super.onCreateOptionsMenu(menu)
    }

    fun show(v: View) {
        if (special.isChecked)
            specialgroup.setVisibility(View.VISIBLE)
        else
            specialgroup.setVisibility(View.INVISIBLE)
    }

    fun addMovie(v: View) {
        var movieInstance = movieDetails(name.text.toString(),description.text.toString(),releaseDate.text.toString())

        var lange: RadioButton = langEnglish as RadioButton
        var langT: RadioButton = langTamil as RadioButton
        var langm: RadioButton = langMalay as RadioButton
        var langc: RadioButton = langChinese as RadioButton
        var langChoosen = ""
        var reason = ""

        /*if (lange.isChecked)
            langChoosen = lange.text.toString()
        if (langm.isChecked)
            langChoosen = langm.text.toString()
        if (langc.isChecked)
            langChoosen = langc.text.toString()
        if (langT.isChecked)
            langChoosen = langT.text.toString()*/
        if (lange.isChecked)
            movieInstance.langChosen = lange.text.toString()
        if (langm.isChecked)
            movieInstance.langChosen = langm.text.toString()
        if (langc.isChecked)
            movieInstance.langChosen = langc.text.toString()
        if (langT.isChecked)
            movieInstance.langChosen = langT.text.toString()

        if (violence.isChecked && languageU.isChecked) {
            reason = "Violence" + "\n" + "Language Used"
        }
        else if (violence.isChecked ) {
            reason = "violence"
        }

        else if (languageU.isChecked) {
            reason = "language Used"
        }
        else {
            reason = "No Reason"
        }

        var everthing =
            "Name: " + movieInstance.username + "\n" + "Description: " + movieInstance.desc + "\n" + "Release Date: " + movieInstance.reDate + "\n" + "language choosen: " + "\n" + movieInstance.langChosen + "\n" + "Reason: " + reason


        if (movieInstance.username == "") {
            name.setError("Empty Field")
        }
        if (movieInstance.desc == "") {
            description.setError("Empty Field")
        }
        if (movieInstance.reDate == "") {
            releaseDate.setError("Empty Field")
        }
        Toast.makeText(this, everthing, Toast.LENGTH_SHORT).show()

    }
}


