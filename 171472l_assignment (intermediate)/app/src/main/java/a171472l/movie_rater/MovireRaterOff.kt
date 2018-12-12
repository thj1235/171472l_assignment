package a171472l.movie_rater

import a171472l.movie_rater.R.id.*
import android.support.v7.app.AppCompatActivity
import android.widget.Button
import kotlinx.android.synthetic.main.movie_rater_on.*
import android.os.Bundle
import android.view.Menu
import android.view.View
import android.widget.RadioButton
import android.widget.Toast


class MovireRaterOff :AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.movie_rater_on)
        var actionbar1 = supportActionBar
        actionbar1!!.title  = "Movie Rater"
        actionbar1.setDisplayHomeAsUpEnabled(true)
    }

    override fun onCreateOptionsMenu(menu: Menu?):
            Boolean {
        menuInflater.inflate(R.menu.movie_rater_menu,menu)
        return super.onCreateOptionsMenu(menu)
    }

    fun show(v: View) {
        if (special_ori.isChecked)
            specialgroup_ori.visibility = View.VISIBLE
        else
            specialgroup_ori.visibility = View.INVISIBLE
    }

    fun addMovie(v: View) {
        var movieInstance = detailsMovie()
        movieInstance.username = name_ori.text.toString()
        movieInstance.desc = description_ori.text.toString()
        movieInstance.reDate = releaseDate_ori.text.toString()

        var lange: RadioButton = R.id.langEnglish as RadioButton
        var langT: RadioButton = R.id.langTamil as RadioButton
        var langm: RadioButton = R.id.langMalay as RadioButton
        var langc: RadioButton = R.id.langChinese as RadioButton
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

        if (violence_ori.isChecked && languageU_ori.isChecked) {
            reason = "Violence" + "\n" + "Language Used"
        }
        else if (violence_ori.isChecked ) {
            reason = "violence"
        }

        else if (languageU_ori.isChecked) {
            reason = "language Used"
        }
        else {
            reason = "No Reason"
        }

        var everthing =
            "Name: " + movieInstance.username + "\n" + "Description: " + movieInstance.desc + "\n" + "Release Date: " + movieInstance.reDate + "\n" + "language choosen: " + "\n" + movieInstance.langChosen + "\n" + "Reason: " + reason


        if (movieInstance.username == "") {
            name_ori.error = "Empty Field"
        }
        if (movieInstance.desc == "") {
            description_ori.error = "Empty Field"
        }
        if (movieInstance.reDate == "") {
            releaseDate_ori.error = "Empty Field"
        }

        Toast.makeText(this, everthing, Toast.LENGTH_SHORT).show()

    }
}