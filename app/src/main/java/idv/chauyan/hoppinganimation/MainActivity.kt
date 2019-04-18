package idv.chauyan.hoppinganimation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val animationHandler = Handler()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        animationHandler.post(object : Runnable {
            override fun run() {
                hopAnimation()
                animationHandler.postDelayed(this, 1500)
            }
        })
    }

    private fun hopAnimation() {
        val animation = bottomContainer
            .animate()
            .translationYBy(-40f)
            .alpha(0.9f)
            .setDuration(400)
        animation.withEndAction {
            bottomContainer
                .animate()
                .alpha(0.5f)
                .translationYBy(40f).duration = 400
        }
    }
}
