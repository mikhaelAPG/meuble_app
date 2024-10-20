package com.example.meubleapps

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.meubleapps.adapter.ArticleAdapter
import com.example.meubleapps.model.Article

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var articleAdapter: ArticleAdapter

    private val articles = listOf(
        Article("Aryal", R.drawable.aryal, "Description for Aryal : Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nulla finibus vehicula ante, id volutpat tellus. Praesent facilisis porttitor iaculis. Phasellus suscipit turpis est, ut hendrerit diam semper sit amet. Morbi sodales sem in diam blandit volutpat. Sed lobortis elementum viverra. Maecenas at luctus tortor. Nulla eleifend faucibus massa nec pretium. Sed luctus enim in ullamcorper fermentum. Morbi et nisl erat. Aenean egestas, risus vitae convallis faucibus, tortor dui congue lectus, id euismod ex dolor quis mauris. In ultricies a elit eu ultricies. Ut lobortis consectetur lectus, ac scelerisque nunc egestas vitae. Suspendisse sapien nisl, dignissim nec felis in, malesuada ultricies nibh. Duis tempus viverra varius. Mauris tristique euismod tortor quis varius. Duis accumsan erat purus."),
        Article("Liberadzki", R.drawable.liberadzki, "Description for Liberadzki : Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nulla finibus vehicula ante, id volutpat tellus. Praesent facilisis porttitor iaculis. Phasellus suscipit turpis est, ut hendrerit diam semper sit amet. Morbi sodales sem in diam blandit volutpat. Sed lobortis elementum viverra. Maecenas at luctus tortor. Nulla eleifend faucibus massa nec pretium. Sed luctus enim in ullamcorper fermentum. Morbi et nisl erat. Aenean egestas, risus vitae convallis faucibus, tortor dui congue lectus, id euismod ex dolor quis mauris. In ultricies a elit eu ultricies. Ut lobortis consectetur lectus, ac scelerisque nunc egestas vitae. Suspendisse sapien nisl, dignissim nec felis in, malesuada ultricies nibh. Duis tempus viverra varius. Mauris tristique euismod tortor quis varius. Duis accumsan erat purus."),
        Article("Fertiq", R.drawable.fertig, "Description for Fertig : Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nulla finibus vehicula ante, id volutpat tellus. Praesent facilisis porttitor iaculis. Phasellus suscipit turpis est, ut hendrerit diam semper sit amet. Morbi sodales sem in diam blandit volutpat. Sed lobortis elementum viverra. Maecenas at luctus tortor. Nulla eleifend faucibus massa nec pretium. Sed luctus enim in ullamcorper fermentum. Morbi et nisl erat. Aenean egestas, risus vitae convallis faucibus, tortor dui congue lectus, id euismod ex dolor quis mauris. In ultricies a elit eu ultricies. Ut lobortis consectetur lectus, ac scelerisque nunc egestas vitae. Suspendisse sapien nisl, dignissim nec felis in, malesuada ultricies nibh. Duis tempus viverra varius. Mauris tristique euismod tortor quis varius. Duis accumsan erat purus."),
        Article("Jolly", R.drawable.jolly, "Description for Jolly : Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nulla finibus vehicula ante, id volutpat tellus. Praesent facilisis porttitor iaculis. Phasellus suscipit turpis est, ut hendrerit diam semper sit amet. Morbi sodales sem in diam blandit volutpat. Sed lobortis elementum viverra. Maecenas at luctus tortor. Nulla eleifend faucibus massa nec pretium. Sed luctus enim in ullamcorper fermentum. Morbi et nisl erat. Aenean egestas, risus vitae convallis faucibus, tortor dui congue lectus, id euismod ex dolor quis mauris. In ultricies a elit eu ultricies. Ut lobortis consectetur lectus, ac scelerisque nunc egestas vitae. Suspendisse sapien nisl, dignissim nec felis in, malesuada ultricies nibh. Duis tempus viverra varius. Mauris tristique euismod tortor quis varius. Duis accumsan erat purus."),
        Article("Rumman", R.drawable.rumman, "Description for Rumman : Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nulla finibus vehicula ante, id volutpat tellus. Praesent facilisis porttitor iaculis. Phasellus suscipit turpis est, ut hendrerit diam semper sit amet. Morbi sodales sem in diam blandit volutpat. Sed lobortis elementum viverra. Maecenas at luctus tortor. Nulla eleifend faucibus massa nec pretium. Sed luctus enim in ullamcorper fermentum. Morbi et nisl erat. Aenean egestas, risus vitae convallis faucibus, tortor dui congue lectus, id euismod ex dolor quis mauris. In ultricies a elit eu ultricies. Ut lobortis consectetur lectus, ac scelerisque nunc egestas vitae. Suspendisse sapien nisl, dignissim nec felis in, malesuada ultricies nibh. Duis tempus viverra varius. Mauris tristique euismod tortor quis varius. Duis accumsan erat purus."),
        Article("Bardash", R.drawable.bardash, "Description for Bardash : Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nulla finibus vehicula ante, id volutpat tellus. Praesent facilisis porttitor iaculis. Phasellus suscipit turpis est, ut hendrerit diam semper sit amet. Morbi sodales sem in diam blandit volutpat. Sed lobortis elementum viverra. Maecenas at luctus tortor. Nulla eleifend faucibus massa nec pretium. Sed luctus enim in ullamcorper fermentum. Morbi et nisl erat. Aenean egestas, risus vitae convallis faucibus, tortor dui congue lectus, id euismod ex dolor quis mauris. In ultricies a elit eu ultricies. Ut lobortis consectetur lectus, ac scelerisque nunc egestas vitae. Suspendisse sapien nisl, dignissim nec felis in, malesuada ultricies nibh. Duis tempus viverra varius. Mauris tristique euismod tortor quis varius. Duis accumsan erat purus."),
        Article("Dorweiler", R.drawable.dorweiler, "Description for Dorweiler : Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nulla finibus vehicula ante, id volutpat tellus. Praesent facilisis porttitor iaculis. Phasellus suscipit turpis est, ut hendrerit diam semper sit amet. Morbi sodales sem in diam blandit volutpat. Sed lobortis elementum viverra. Maecenas at luctus tortor. Nulla eleifend faucibus massa nec pretium. Sed luctus enim in ullamcorper fermentum. Morbi et nisl erat. Aenean egestas, risus vitae convallis faucibus, tortor dui congue lectus, id euismod ex dolor quis mauris. In ultricies a elit eu ultricies. Ut lobortis consectetur lectus, ac scelerisque nunc egestas vitae. Suspendisse sapien nisl, dignissim nec felis in, malesuada ultricies nibh. Duis tempus viverra varius. Mauris tristique euismod tortor quis varius. Duis accumsan erat purus."),
        Article("Olena", R.drawable.olena, "Description for Hospital Bed : Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nulla finibus vehicula ante, id volutpat tellus. Praesent facilisis porttitor iaculis. Phasellus suscipit turpis est, ut hendrerit diam semper sit amet. Morbi sodales sem in diam blandit volutpat. Sed lobortis elementum viverra. Maecenas at luctus tortor. Nulla eleifend faucibus massa nec pretium. Sed luctus enim in ullamcorper fermentum. Morbi et nisl erat. Aenean egestas, risus vitae convallis faucibus, tortor dui congue lectus, id euismod ex dolor quis mauris. In ultricies a elit eu ultricies. Ut lobortis consectetur lectus, ac scelerisque nunc egestas vitae. Suspendisse sapien nisl, dignissim nec felis in, malesuada ultricies nibh. Duis tempus viverra varius. Mauris tristique euismod tortor quis varius. Duis accumsan erat purus."),
        Article("Bohovyk", R.drawable.bohovyk, "Description for Bohovyk : Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nulla finibus vehicula ante, id volutpat tellus. Praesent facilisis porttitor iaculis. Phasellus suscipit turpis est, ut hendrerit diam semper sit amet. Morbi sodales sem in diam blandit volutpat. Sed lobortis elementum viverra. Maecenas at luctus tortor. Nulla eleifend faucibus massa nec pretium. Sed luctus enim in ullamcorper fermentum. Morbi et nisl erat. Aenean egestas, risus vitae convallis faucibus, tortor dui congue lectus, id euismod ex dolor quis mauris. In ultricies a elit eu ultricies. Ut lobortis consectetur lectus, ac scelerisque nunc egestas vitae. Suspendisse sapien nisl, dignissim nec felis in, malesuada ultricies nibh. Duis tempus viverra varius. Mauris tristique euismod tortor quis varius. Duis accumsan erat purus."),
        Article("Sikkema", R.drawable.sikkema, "Description for Sikkema : Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nulla finibus vehicula ante, id volutpat tellus. Praesent facilisis porttitor iaculis. Phasellus suscipit turpis est, ut hendrerit diam semper sit amet. Morbi sodales sem in diam blandit volutpat. Sed lobortis elementum viverra. Maecenas at luctus tortor. Nulla eleifend faucibus massa nec pretium. Sed luctus enim in ullamcorper fermentum. Morbi et nisl erat. Aenean egestas, risus vitae convallis faucibus, tortor dui congue lectus, id euismod ex dolor quis mauris. In ultricies a elit eu ultricies. Ut lobortis consectetur lectus, ac scelerisque nunc egestas vitae. Suspendisse sapien nisl, dignissim nec felis in, malesuada ultricies nibh. Duis tempus viverra varius. Mauris tristique euismod tortor quis varius. Duis accumsan erat purus.")
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recycler_view)
        recyclerView.layoutManager = LinearLayoutManager(this)
        articleAdapter = ArticleAdapter(articles) { article ->
            val intent = Intent(this, DetailActivity::class.java)
            intent.putExtra("article", article) // Pass the Article object
            startActivity(intent)
        }
        recyclerView.adapter = articleAdapter
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_about -> {
                startActivity(Intent(this, AboutActivity::class.java))
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}
