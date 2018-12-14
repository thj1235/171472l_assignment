package a171472l.movie_rater

import a171472l.movie_rater.R.id.*
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.RadioButton
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_movie_rater.*



class MovieRater :AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_rater)
        var actionbar1 = supportActionBar
        actionbar1!!.title  = "Movie Rater"
        actionbar1.setDisplayHomeAsUpEnabled(true)
    }

    override fun onCreateOptionsMenu(menu: Menu?):
            Boolean {
       menuInflater.inflate(R.menu.movie_rater_ori,menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        if(item?.itemId == R.id.add)
        {

            movieObj.username = name.text.toString()
            movieObj.desc =description.text.toString()
            movieObj.reDate = releaseDate.text.toString()

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
                movieObj.langChosen = lange.text.toString()
            if (langm.isChecked)
                movieObj.langChosen = langm.text.toString()
            if (langc.isChecked)
                movieObj.langChosen = langc.text.toString()
            if (langT.isChecked)
                movieObj.langChosen = langT.text.toString()

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
                "Name: " + movieObj.username + "\n" + "Description: " + movieObj.desc + "\n" + "Release Date: " + movieObj.reDate + "\n" + "language choosen: " + "\n" + movieObj.langChosen + "\n" + "Reason: " + reason

            if (movieObj.username == "") {
                name.error = "Empty Field"
            }
            if (movieObj.desc == "") {
                description.error = "Empty Field"
            }
            if (movieObj.reDate == "") {
                releaseDate.error = "Empty Field"
            }
//            Toast.makeText(this,everthing,Toast.LENGTH_SHORT).show()
            var page2 = Intent(this, moviewReview::class.java)
            startActivity(page2)

        }
        if(item?.itemId == R.id.clearEn){
            name.setText("")
            description.setText("")
            releaseDate.setText("")
            special.isChecked  = false
            langEnglish.isChecked= false
            langChinese.isChecked= false
            langTamil.isChecked= false
            langMalay.isChecked= false


        }
        return super.onOptionsItemSelected(item)
    }

    fun show(v: View) {
        if (special.isChecked)
            specialgroup.visibility = View.VISIBLE
        else
            specialgroup.visibility = View.INVISIBLE
    }

}


