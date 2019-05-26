package bompard.lancelot.iimdemo

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import bompard.lancelot.iimdemo.model.Post
import bompard.lancelot.iimdemo.model.User
import bompard.lancelot.iimdemo.model.Comment
import kotlinx.android.synthetic.main.cell.view.*


class MyListAdapter : RecyclerView.Adapter<MyListAdapter.ViewHolder>(){

      var posts: List<Post> = emptyList()
      var users: List<User> = emptyList()
      var comments: List<Comment> = emptyList()

      override fun getItemCount(): Int = posts.size

      override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
          val inflater = LayoutInflater.from(parent.context)
          val view = inflater.inflate(R.layout.cell, parent, false)
          return ViewHolder(view)
      }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val post = posts[position]
        val user = users[post.userId - 1]
        val comment = comments.first{it.postId == post.id}
//        val comment = comments.filter{it.postId == post.id}

        holder.itemView.cellTitle.text = post.title
        holder.itemView.cellUser.text =  users.first{it.id == post.userId} .name

        holder.itemView.setOnClickListener {
            val intent = Intent(holder.itemView.context, PostActivity::class.java)
            intent.putExtra("user", post)
            intent.putExtra("user", user)
            intent.putExtra("comment", comment)
            println(intent.putExtra("post", post))
            println("test-first" + comments.first{it.postId == post.id})
            println("test-filter" + comments.filter{it.postId == post.id})
            holder.itemView.context.startActivity(intent)
        }
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)



  }