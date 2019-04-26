package derchain.aymeric.iimdemo

import android.os.Bundle
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import derchain.aymeric.iimdemo.model.Post

class PostActivity : AppCompatActivity() {

    lateinit var post : Post

    private val onNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.navigation_text -> {
                val textFragment = TextFragment()
                val args = Bundle()
                args.putString("text", post.body)
                textFragment.arguments = args
                supportFragmentManager.beginTransaction()
                    .replace(R.id.fragment_layout, textFragment)
                    .commit()
            }
            R.id.navigation_comments -> {
                supportFragmentManager.beginTransaction()
                    .replace(R.id.fragment_layout, CommentsFragment())
                    .commit()
            }
            R.id.navigation_author -> {
                supportFragmentManager.beginTransaction()
                    .replace(R.id.fragment_layout, AuthorFragment())
                    .commit()
            }
        }
        true
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        post = intent.getSerializableExtra("post") as Post

        setContentView(R.layout.activity_post)
        val navView: BottomNavigationView = findViewById(R.id.nav_view)
        navView.setOnNavigationItemSelectedListener(onNavigationItemSelectedListener)

        val textFragment = TextFragment()
        val args = Bundle()
        args.putString("text", post.body)
        textFragment.arguments = args
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_layout, textFragment)
            .commit()
    }
}
