package io.github.jgingh7.swoosh.controller

import android.os.Bundle
import io.github.jgingh7.swoosh.R
import io.github.jgingh7.swoosh.utilities.EXTRA_LEAGUE
import io.github.jgingh7.swoosh.utilities.EXTRA_SKILL
import kotlinx.android.synthetic.main.activity_finish.*

class FinishActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_finish)

        val league = intent.getStringExtra(EXTRA_LEAGUE)
        val skill = intent.getStringExtra(EXTRA_SKILL)

        searchLeaguesText.text = "Looking for $league $skill league near you..."
    }
}
