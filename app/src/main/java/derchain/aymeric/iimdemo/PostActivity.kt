package derchain.aymeric.iimdemo

import android.os.Bundle
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import derchain.aymeric.iimdemo.model.Post
import derchain.aymeric.iimdemo.model.User

class PostActivity : AppCompatActivity() {

    lateinit var post : Post
    lateinit var user : User

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
//                val commentsFragment = CommentsFragment()
//                val args = Bundle()
//                args.putString("text", post.body)
//                commentsFragment.arguments = args

//                supportFragmentManager.beginTransaction()
//                    .replace(R.id.fragment_layout, commentsFragment)
//                    .commit()
            }


//            holder.itemView.cellTitle.text = post.title
//            holder.itemView.cellUser.text =  users.first{it.id == post.userId} .name


            R.id.navigation_author -> {

                val authorFragment = AuthorFragment()
                val args = Bundle()
                args.putString("name", user.name)
                authorFragment.arguments = args

                supportFragmentManager.beginTransaction()
                    .replace(R.id.fragment_layout, authorFragment)
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

        this.title = post.title
    }
}
