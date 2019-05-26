package bompard.lancelot.iimdemo

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_comments.*

class CommentsFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_comments, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val commentName = arguments!!.getString("CommentName")
        val commentEmail = arguments!!.getString("CommentEmail")
        val commentBody = arguments!!.getString("CommentBody")
        comment_name.text = commentName
        comment_email.text = commentEmail
        comment_body.text = commentBody
    }
}