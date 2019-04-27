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
                args.putString("PostBody", post.body)
                textFragment.arguments = args

                supportFragmentManager.beginTransaction()
                    .replace(R.id.fragment_layout, textFragment)
                    .commit()
            }

            R.id.navigation_comments -> {
                val textFragment = TextFragment()
                val args = Bundle()
                args.putString("PostBody", post.body)
                textFragment.arguments = args

                supportFragmentManager.beginTransaction()
                    .replace(R.id.fragment_layout, textFragment)
                    .commit()
            }

            R.id.navigation_author -> {

                val authorFragment = AuthorFragment()
                val args = Bundle()
                args.putString("AuteurName", user.name)
                args.putString("AuteurUserName", user.username)
                args.putString("AuteurEmail", user.email)
                args.putString("AuteurPhone", user.phone)
                args.putString("AuteurWebsite", user.website)

                args.putString("AuteurAdrStreet", user.address.street)
                args.putString("AuteurAdrSuite", user.address.suite)
                args.putString("AuteurAdrCity", user.address.city)
                args.putString("AuteurAdrZipcode", user.address.zipcode)
                args.putString("AuteurAdrLat", user.address.geo.lat)
                args.putString("AuteurAdrLng", user.address.geo.lng)

                args.putString("AuteurCpnName", user.company.name)
                args.putString("AuteurCpnCatchPhrase", user.company.catchPhrase)
                args.putString("AuteurCpnBs", user.company.bs)
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
        user = intent.getSerializableExtra("user") as User

        setContentView(R.layout.activity_post)
        val navView: BottomNavigationView = findViewById(R.id.nav_view)
        navView.setOnNavigationItemSelectedListener(onNavigationItemSelectedListener)

        val textFragment = TextFragment()
        val args = Bundle()
        args.putString("PostBody", post.body)
        textFragment.arguments = args
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_layout, textFragment)
            .commit()

        this.title = post.title
    }
}
