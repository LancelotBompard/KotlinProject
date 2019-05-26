package bompard.lancelot.iimdemo

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.*

import bompard.lancelot.iimdemo.model.Post
import bompard.lancelot.iimdemo.model.User
import bompard.lancelot.iimdemo.model.Comment
import bompard.lancelot.iimdemo.model.API

class MainActivity : AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recycleView.layoutManager = LinearLayoutManager(this)
        val adapter = MyListAdapter()
        recycleView.adapter = adapter



        val retrofit = Retrofit.Builder()
            .baseUrl("https://jsonplaceholder.typicode.com")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val api = retrofit.create<API>()

        api.getPosts().enqueue(object : Callback<List<Post>> { //JSon Post
            override fun onFailure(call: Call<List<Post>>, t: Throwable) { //Post Fail
                Log.e("DL", "Download failed! : ${t.message}")
            }

            override fun onResponse(call: Call<List<Post>>, response: Response<List<Post>>) { //Post Success
                val posts = response.body()!!

                api.getUsers().enqueue(object : Callback<List<User>> { //JSon User
                    override fun onFailure(call: Call<List<User>>, t: Throwable) { //User Fail
                        Log.e("DL", "Download failed! : ${t.message}")
                    }

                    override fun onResponse(call: Call<List<User>>, response: Response<List<User>>) { //User Success
                        val users = response.body()!!

                        api.getComments().enqueue(object : Callback<List<Comment>> { //JSon Comment
                            override fun onFailure(call: Call<List<Comment>>, t: Throwable) { //Comment Fail
                                Log.e("DL", "Download failed! : ${t.message}")
                            }

                            override fun onResponse(call: Call<List<Comment>>, response: Response<List<Comment>>) {//Comment Success
                                val comments = response.body()!!

                                adapter.posts = posts
                                adapter.users = users
                                adapter.comments = comments
                                adapter.notifyDataSetChanged()
                            }
                        })
                    }
                })
            }
        })

    }
}
