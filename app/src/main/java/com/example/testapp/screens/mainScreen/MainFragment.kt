package com.example.testapp.screens.mainScreen

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.testapp.R
import com.example.testapp.adapters.MovieAdapter
import com.example.testapp.adapters.PagerAdapterForPoster
import com.example.testapp.custom.CustomChip
import com.example.testapp.databinding.FragmentMainScreenBinding
import com.google.android.material.chip.ChipGroup
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainFragment : Fragment() {

    private var _binding: FragmentMainScreenBinding? = null
    private lateinit var pagerAdapter: PagerAdapterForPoster
    private lateinit var movieAdapter: MovieAdapter
    private val binding get() = _binding!!
    private val mainScreenVM: MainScreenVM by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMainScreenBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initPager()
        initRecyclerMovie()
        loadData()
    }


    private fun initPager() {
        pagerAdapter = PagerAdapterForPoster()
        binding.recyclerForPosters.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        binding.recyclerForPosters.adapter = pagerAdapter
    }

    private fun initRecyclerMovie() {
        binding.recyclerMovies.layoutManager = LinearLayoutManager(requireContext())
        movieAdapter = MovieAdapter(requireContext())
        binding.recyclerMovies.adapter = movieAdapter
    }

    private fun loadData() {
        viewLifecycleOwner.lifecycleScope.launch {
            mainScreenVM.mainScreenUiState.collect {
                if (it.error != null) {
                    Toast.makeText(requireContext(), it.error, Toast.LENGTH_SHORT).show()
                }
                pagerAdapter.setImageList(it.posters)
                movieAdapter.setList(it.movies)
                it.tags.forEach { tagName ->
                    val chip = CustomChip(requireContext())
                    chip.setTextColor(ContextCompat.getColor(requireContext(), R.color.black))
                    binding.chipGroup.addChip(requireContext(), tagName)
                }
            }
        }
    }

    private fun ChipGroup.addChip(context: Context, label: String) {
        CustomChip(context).apply {
            id = View.generateViewId()
            text = label
            isClickable = true
            isCheckable = true
            isCheckedIconVisible = false
            isFocusable = true
            addView(this)
            setOnClickListener {
                if (isChecked) {
                    mainScreenVM.getMovies2(label)
                }
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}