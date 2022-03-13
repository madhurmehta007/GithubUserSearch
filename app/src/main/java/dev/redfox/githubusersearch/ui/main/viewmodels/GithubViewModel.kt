package dev.redfox.githubusersearch.ui.main.viewmodels

import androidx.lifecycle.*
import dev.redfox.githubusersearch.ui.main.api.GtihubResponse
import dev.redfox.githubusersearch.ui.main.api.Repository
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Response

class GithubViewModel(private val repository: Repository): ViewModel(){

    private val _gResponse = MutableLiveData<Response<GtihubResponse>>()
    val gResponse: LiveData<Response<GtihubResponse>> get()= _gResponse
    fun getUsers(q: String){

        viewModelScope.launch {
            val response: Response<GtihubResponse> = repository.getUsers(q)
            _gResponse.value = response
        }
    }
}

class GithubViewModelFactory(val repository: Repository): ViewModelProvider.Factory{
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return GithubViewModel(repository) as T
    }

}