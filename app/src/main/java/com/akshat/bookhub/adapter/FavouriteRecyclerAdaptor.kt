package com.akshat.bookhub.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.akshat.bookhub.R
import com.akshat.bookhub.activity.FavDescriptionActivity
import com.akshat.bookhub.database.BookEntity
import com.squareup.picasso.Picasso

class FavouriteRecyclerAdaptor(val context: Context, val bookList: List<BookEntity>) : RecyclerView.Adapter<FavouriteRecyclerAdaptor.FavouriteViewHolder>() {

    class FavouriteViewHolder(view: View) : RecyclerView.ViewHolder(view){
        val txtFavBookTitle : TextView = view.findViewById(R.id.txtFavBookTitle)
        val txtFavBookAuthor : TextView = view.findViewById(R.id.txtFavBookAuthor)
        val txtFavBookPrice : TextView = view.findViewById(R.id.txtFavBookPrice)
        val txtFavBookRating : TextView = view.findViewById(R.id.txtFavBookRating)
        val imgFavBookImage : ImageView = view.findViewById(R.id.imgFavBookImage)
        val llFavContent : LinearLayout = view.findViewById(R.id.llFavContent)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavouriteViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.recycler_favorite_single_row,parent,false)
        return FavouriteViewHolder(view)
    }

    override fun onBindViewHolder(holder: FavouriteViewHolder, position: Int) {
        val book = bookList[position]
        holder.txtFavBookTitle.text = book.bookName
        holder.txtFavBookAuthor.text = book.bookAuthor
        holder.txtFavBookPrice.text = book.bookPrice
        holder.txtFavBookRating.text = book.bookRating
        //holder.imgBookImage.setImageResource(book.bookImage)
        Picasso.get().load(book.bookImage).error(R.drawable.default_book_cover).into(holder.imgFavBookImage)

        holder.llFavContent.setOnClickListener{
            val intent = Intent(context, FavDescriptionActivity::class.java)
            intent.putExtra("book_id",book.book_id)
            context.startActivity(intent)
        }

    }

    override fun getItemCount(): Int {
        return bookList.size
    }
}