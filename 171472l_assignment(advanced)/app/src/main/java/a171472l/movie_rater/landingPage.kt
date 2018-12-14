package a171472l.movie_rater

import a171472l.movie_rater.R.id.*
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.ContextMenu
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.*
import kotlinx.android.synthetic.main.landing_page.*
import kotlinx.android.synthetic.main.view_movie.*


class landingPage :AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.landing_page)
        val listView = findViewById<ListView>(R.id.listviewO)
        val listItems = arrayOfNulls<String>(arraylist11.size)
        var listOnly: String = ""
        for (i in 0 until arraylist11.size) {
            val reviewSucc = arraylist11[i]
            listItems[i] = reviewSucc.username
        }
//        nameonon.text = listOnly
        val itemsAdapter = ArrayAdapter(this,android.R.layout.simple_list_item_1 , listItems)
        listView.adapter = itemsAdapter
        registerForContextMenu(listviewO)

    }
    override fun onCreateOptionsMenu(menu: Menu?):
            Boolean {
        menuInflater.inflate(R.menu.landing_menu,menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        if(item?.itemId == R.id.landingAdd)
        {
            var trail = Intent(this, MovieRater::class.java)
            startActivity(trail)
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onCreateContextMenu(menu: ContextMenu?, v: View?, menuInfo: ContextMenu.ContextMenuInfo?) {
        super.onCreateContextMenu(menu, v, menuInfo)
//        AdapterView.menu
//        if (.getId() == R.id.list_item)
        var itemsss = menuInfo as AdapterView.AdapterContextMenuInfo
        val index = itemsss.position
        val listViewItem = listviewO.getItemAtPosition(index)
        if(v?.id == R.id.listviewO) {
            menu?.add(1, 1001, 1, "Edit item")
        }
    }

    override fun onContextItemSelected(item: MenuItem?): Boolean {
        if(item?.itemId == 1001){
            var nextPage = Intent(this,MovireRaterOff::class.java)
            startActivity(nextPage)
        }
        return super.onContextItemSelected(item)
    }

}