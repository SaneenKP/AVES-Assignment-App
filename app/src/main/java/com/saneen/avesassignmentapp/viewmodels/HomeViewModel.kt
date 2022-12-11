package com.saneen.avesassignmentapp.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.saneen.avesassignmentapp.repository.HomeRepository
import com.saneen.avesassignmentapp.retrofit.ResponseWrapper
import kotlinx.coroutines.launch
import com.saneen.avesassignmentapp.models.Result

class HomeViewModel : ViewModel() {

    private val repository : HomeRepository = HomeRepository()
    val dataResponse : MutableLiveData<ResponseWrapper<List<Result>>> = MutableLiveData()

    fun getData(){
        viewModelScope.launch {
            dataResponse.value = ResponseWrapper.loading()
            val result = repository.getData()
            if (result != null){
                dataResponse.value = result!!
            }else{
                dataResponse.value = ResponseWrapper.error("No data")
            }
        }
    }
}
