package com.example.a394hw.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.a394hw.GameDetailActivity
import com.example.a394hw.R
import com.example.a394hw.model.Game

class GameAdapter(private val data: List<Game>): RecyclerView.Adapter<GameAdapter.GameViewHolder>() {
    class GameViewHolder(private val view: View): RecyclerView.ViewHolder(view){

        private lateinit var game: Game

        val titleView: TextView = view.findViewById(R.id.titleTV)
        val descriptionView: TextView = view.findViewById(R.id.descriptionTV)
        init {
            view.setOnClickListener{
                val context = itemView.context
                val showUserIntent = Intent(context, GameDetailActivity::class.java)
                showUserIntent.putExtra(GameDetailActivity.GAME_TITLE, game.title)
                showUserIntent.putExtra(GameDetailActivity.GAME_DEVELOPER, game.developer)
                showUserIntent.putExtra(GameDetailActivity.GAME_DESCRIPTION, game.description)
                context.startActivity(showUserIntent)
            }
        }
        fun bind(game:Game){
            this.game = game
            titleView.text = game.title
            descriptionView.text = game.description
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GameViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.game_layout, parent, false)
        return GameViewHolder(view)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: GameViewHolder, position: Int) {
        val user = data[position]
        holder.bind(user)

    }
}