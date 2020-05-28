package io.github.jgingh7.swoosh.controller

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import io.github.jgingh7.swoosh.utilities.EXTRA_LEAGUE
import io.github.jgingh7.swoosh.R
import io.github.jgingh7.swoosh.utilities.EXTRA_SKILL
import kotlinx.android.synthetic.main.activity_skill.*

class SkillActivity : BaseActivity() {

    var league = ""
    var selectedSkill = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_skill)
        league = intent.getStringExtra(EXTRA_LEAGUE)
    }

    fun onSkillBeginnerClicked(view: View) {
        skillBallerBtn.isChecked = false
        selectedSkill = "beginner"
    }

    fun onSkillBallerClicked(view: View) {
        skillBeginnerBtn.isChecked = false
        selectedSkill = "baller"
    }

    fun onSkillFinishClicked(view: View) {
        if (selectedSkill != "") {
            val finishActivity = Intent(this, FinishActivity::class.java)
            finishActivity.putExtra(EXTRA_LEAGUE, league)
            finishActivity.putExtra(EXTRA_SKILL, selectedSkill)
            startActivity(finishActivity)
        } else {
            Toast.makeText(this, "Please select a skill.", Toast.LENGTH_SHORT).show()
        }
    }
}
