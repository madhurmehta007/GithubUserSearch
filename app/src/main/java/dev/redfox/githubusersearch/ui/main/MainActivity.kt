package dev.redfox.githubusersearch.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import dev.redfox.githubusersearch.databinding.ActivityMainBinding
import dev.redfox.githubusersearch.ui.main.api.Repository
import dev.redfox.githubusersearch.ui.main.viewmodels.GithubViewModel
import dev.redfox.githubusersearch.ui.main.viewmodels.GithubViewModelFactory

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: GithubViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val repository = Repository()
        val viewModelFactory = GithubViewModelFactory(repository)
        viewModel = ViewModelProvider(this,viewModelFactory).get(GithubViewModel::class.java)
        val q = "debz-g"
        viewModel.getUsers(q)


        viewModel.gResponse.observe(this, Observer {
            binding.tvTest.text = it.body()!!.items[0].login
        })
    }
}