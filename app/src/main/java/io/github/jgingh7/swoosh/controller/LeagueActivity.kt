package io.github.jgingh7.swoosh.controller

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import io.github.jgingh7.swoosh.R
import io.github.jgingh7.swoosh.model.Player
import io.github.jgingh7.swoosh.utilities.EXTRA_PLAYER
import kotlinx.android.synthetic.main.activity_league.*

class LeagueActivity : BaseActivity() {

    var player = Player("","")

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putParcelable(EXTRA_PLAYER, player)
    }

//    override fun onSaveInstanceState(outState: Bundle?) {
//        super.onSaveInstanceState(outState)
//        outState?.putParcelable(EXTRA_PLAYER, player)
//    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_league)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        player = savedInstanceState.getParcelable<Player>(EXTRA_PLAYER)!!
    }

//    override fun onRestoreInstanceState(savedInstanceState: Bundle?) {
//        super.onRestoreInstanceState(savedInstanceState)
//        if (savedInstanceState != null) {
//            player = savedInstanceState.getParcelable(EXTRA_PLAYER)
//        }
//    }

    fun onMensClicked(view: View) {
        womensBtn.isChecked = false
        coedBtn.isChecked = false

        player.league = "mens"
    }

    fun onWomensClicked(view: View) {
        mensBtn.isChecked = false
        coedBtn.isChecked = false

        player.league = "womens"
    }

    fun onCoedClicked(view: View) {
        mensBtn.isChecked = false
        womensBtn.isChecked = false

        player.league = "coed"
    }

    fun leagueNextClicked(view: View) {
        if (player.league != "") {
            val skillActivity = Intent(this, SkillActivity::class.java)
            skillActivity.putExtra(EXTRA_PLAYER, player)
            startActivity(skillActivity)
        } else {
           Toast.makeText(this, "Please select a league.", Toast.LENGTH_SHORT).show()
        }
    }

}
