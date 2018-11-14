package a171472l.movie_rater

import a171472l.movie_rater.R.id.message
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.RadioButton
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_movie_rater.*

class MovieRater : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_rater)
    }
    fun show(v: View){
        if (special.isChecked)
            specialgroup.setVisibility(View.VISIBLE)
        else
            specialgroup.setVisibility(View.INVISIBLE)
    }

    fun addMovie (v: View) {
        var nameonly: String = name.text.toString()
        var descr: String = description.text.toString()
        var dater: String = releaseDate.text.toString()
        var lange: RadioButton = langEnglish as RadioButton
        var langT: RadioButton = langTamil as RadioButton
        var langm: RadioButton = langMalay as RadioButton
        var langc: RadioButton = langChinese as RadioButton
        var langChoosen = ""
        var reason = ""

        if (lange.isChecked)
            langChoosen = lange.text.toString()
        if (langm.isChecked)
            langChoosen = langm.text.toString()
        if (langc.isChecked)
            langChoosen = langc.text.toString()
        if (langT.isChecked)
            langChoosen = langT.text.toString()



        if (violence.isChecked) {
            reason = "violence"
        }
        if (violence.isChecked && languageU.isChecked) {
            reason = "Violence" + "\n" + "Language Used"
        }
        if (languageU.isChecked){
            reason = "language Used"
        }
        else {
            reason = "No Reason"
        }

        var everthing = "Name: " + nameonly +"\n"+ "Description: " + descr + "\n" + "Release Date: " + dater + "\n" + "language choosen: "  + langChoosen + "\n" + "Reason: " + reason


        if (nameonly == "") {
            name.setError("Empty Field")
        }
        if (descr == "") {
            description.setError("Empty Field")
        }
        if (dater == "") {
            releaseDate.setError("Empty Field")
        }

        btnMyButton.setOnClickListener(){
            Toast.makeText(this, everthing, Toast.LENGTH_SHORT).show()
        }


    }



//        fun show(v: View){
//            specialgroup.visibility= true
//            var play =
//            play.isClickable=false
//            play.visibility=view.visibility.inv()
        }

//    override fun setVisible(visible: Boolean) {
//        super.setVisible(visible)
//        languageU.visibility = visib
//        violence.visibility  = false
//

//    }

