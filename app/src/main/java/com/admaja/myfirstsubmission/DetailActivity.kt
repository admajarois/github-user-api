package com.admaja.myfirstsubmission

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.admaja.myfirstsubmission.databinding.ActivityDetailBinding
import com.admaja.myfirstsubmission.models.Users
import com.bumptech.glide.Glide

class DetailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailBinding
  
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val user = intent.getParcelableExtra<Users>(EXTRA_USERS) as Users
        supportActionBar?.title = user.username
        binding.apply {
            tvName.text = user.name
            tvFollowers.text = StringBuilder().append(user.followers).append(" Followers")
            tvRepository.text = StringBuilder().append(user.repository).append(" Repository")
            tvFollowing.text = StringBuilder().append(user.following).append(" Following")
            tvWork.text = user.company
            tvLocation.text = user.location
        }

        Glide.with(binding.root)
            .load(user.photo)
            .circleCrop()
            .into(binding.ivPhoto)
    }

    companion object {
        const val EXTRA_USERS = "extra_users"
    }
}