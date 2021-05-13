package ru.android.randomdogmvvm.presentation.home

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isGone
import androidx.core.view.isVisible
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_home.*
import org.koin.androidx.viewmodel.ext.android.viewModel
import ru.android.randomdogmvvm.R
import ru.android.randomdogmvvm.base.setImageFitPlaceholderWithGlide
import ru.android.randomdogmvvm.databinding.FragmentHomeBinding
import ru.android.randomdogmvvm.presentation.sealed.DogVS

class HomeFragment : Fragment() {

    private val viewModel: HomeViewModel by viewModel()


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = DataBindingUtil.inflate<FragmentHomeBinding>(
            inflater,
            R.layout.fragment_home,
            container,
            false
        )
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
        observeViewModel()
    }

    private fun initView() {
        viewModel.getDog()
        buttonNext.setOnClickListener {
            imageView.isGone = true
            viewModel.getDog()
        }
    }

    private fun observeViewModel() {

        viewModel.viewState.observe(viewLifecycleOwner, {
            when (it) {
                is DogVS.Post -> {
                    imageView.setImageFitPlaceholderWithGlide(
                        imageUrl = it.postVM.message
                    )
                }
                is DogVS.ShowLoader -> {
                    if (it.showLoader) {
                        pbPost.visibility = View.VISIBLE
                    } else {
                        imageView.isVisible = true
                        pbPost.visibility = View.GONE
                    }
                    Log.i("ShowLoader", it.showLoader.toString())
                }
                is DogVS.Error -> {
                    it.message?.let { message -> Log.i("Error", message) }
                }
            }
        })
    }

}