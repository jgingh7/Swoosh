package io.github.jgingh7.swoosh.controller

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import io.github.jgingh7.swoosh.R
import io.github.jgingh7.swoosh.model.Player
import io.github.jgingh7.swoosh.utilities.EXTRA_PLAYER
import kotlinx.android.synthetic.main.activity_skill.*

class SkillActivity : BaseActivity() {

    lateinit var player: Player

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putParcelable(EXTRA_PLAYER, player)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_skill)
        player = intent.getParcelableExtra(EXTRA_PLAYER)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        player = savedInstanceState.getParcelable<Player>(EXTRA_PLAYER)!!
    }

    fun onSkillBeginnerClicked(view: View) {
        skillBallerBtn.isChecked = false
        player.skill = "beginner"
    }

    fun onSkillBallerClicked(view: View) {
        skillBeginnerBtn.isChecked = false
        player.skill = "baller"
    }

    fun onSkillFinishClicked(view: View) {
        if (player.skill != "") {
            val finishActivity = Intent(this, FinishActivity::class.java)
            finishActivity.putExtra(EXTRA_PLAYER, player)
            startActivity(finishActivity)
        } else {
            Toast.makeText(this, "Please select a skill.", Toast.LENGTH_SHORT).show()
        }
    }
}
