package com.example.firstapp

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso


class ItemAdapter(private val mList: List<User>) : RecyclerView.Adapter<ItemAdapter.ViewHolder>(){
    // create new views
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        // inflates the card_view_design view
        // that is used to hold list item
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.card_view_design, parent, false)

        return ViewHolder(view)
    }

    // binds the list items to a view
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val item = mList[position]
        holder.userNameTextView.text = "${item.name.first} ${item.name.last}"
        if(item.picture != null){
            Picasso.get().load(item.picture.large).into(holder.imageView)
        }
        holder.userEmailTextView.text = item.email
        holder.userAddressTextView.text = "${item.location.city}, ${item.location.street.name} ${item.location.street.number}"

        holder.itemView.setOnClickListener {
            val context = holder.itemView.context
            val userIntent = Intent(context, DetailsActivity::class.java).apply {
                putExtra("name", holder.userNameTextView.text)
                putExtra("email", item.email)
                putExtra("pic", item.picture.large)
                putExtra("cell", item.cell)
            }
            context.startActivity(userIntent)
        }
    }

    // return the number of the items in the list
    override fun getItemCount(): Int {
        return mList.size
    }

    // Holds the views for adding it to image and text
    class ViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {
        val imageView: ImageView = itemView.findViewById(R.id.imageview)
        val userNameTextView: TextView = itemView.findViewById(R.id.userNameTextView)
        val userEmailTextView: TextView = itemView.findViewById(R.id.userEmailTextView)
        val userAddressTextView: TextView = itemView.findViewById(R.id.userAddressTextView)
    }

}