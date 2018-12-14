package a171472l.movie_rater

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import a171472l.movie_rater.R.id.*
import android.content.Intent
import android.opengl.Visibility
import android.view.ContextMenu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.view_movie.*

class moviewReview: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.view_movie)
        var actionbar1 = supportActionBar
        actionbar1!!.title  = "Review page"
        actionbar1.setDisplayHomeAsUpEnabled(true)
        titleDisplay.text = movieObj.username
        overviewDisplay.text = movieObj.desc
        languageDisplay.text = movieObj.langChosen
        releaseDateDisplay.text = movieObj.reDate
        if (movieObj.reviewsStar == -1F) {
            ratingResult.visibility = View.GONE
            reviewsDisplay.text = "No Reviews yet." + "\n" + "Long Press here to add your review"

        }
        else{
            ratingResult.visibility = View.VISIBLE
            ratingResult.rating = movieObj.reviewsStar
        }
//        else {
//
//        }

        registerForContextMenu(reviewsDisplay)


    }
    override fun onCreateContextMenu(menu: ContextMenu?, v: View?, menuInfo: ContextMenu.ContextMenuInfo?) {
        super.onCreateContextMenu(menu, v, menuInfo)
        if (v?.id == R.id.reviewsDisplay && reviewsDisplay.text != "" ) {

            menu?.add(1, 1001, 1, "Add Review")
        }
    }

    override fun onContextItemSelected(item: MenuItem?): Boolean {
        if (item?.itemId == 1001) {
            var reviewStars = Intent(this,reviewStars ::class.java)
            startActivity(reviewStars)
        }
        return super.onContextItemSelected(item)
    }
//        movieObj.username = titleOnly.text.toString()
}
