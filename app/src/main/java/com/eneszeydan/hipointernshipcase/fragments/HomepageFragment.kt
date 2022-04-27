package com.eneszeydan.hipointernshipcase.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView


import androidx.fragment.app.viewModels
import com.eneszeydan.hipointernshipcase.MainActivity
import com.eneszeydan.hipointernshipcase.R
import com.eneszeydan.hipointernshipcase.adapter.MembersAdapter
import com.eneszeydan.hipointernshipcase.databinding.FragmentHomepageBinding
import com.eneszeydan.hipointernshipcase.viewmodels.HomepageFragmentViewModel


class HomepageFragment : Fragment() {

    private lateinit var binding: FragmentHomepageBinding
    private lateinit var viewModel: HomepageFragmentViewModel
    private lateinit var adapter: MembersAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomepageBinding.inflate(inflater, container, false)


        binding.toolbar.apply {
            title = "Members"
        }

        viewModel.getAllMembers(requireContext())
        viewModel.membersList.observe(viewLifecycleOwner) { membersList ->
            adapter = MembersAdapter(requireContext(), membersList)
            binding.rv.adapter = adapter
        }

        binding.fab.setOnClickListener {
            viewModel.addNewMember()
        }

        binding.searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String): Boolean {
                adapter = MembersAdapter(requireContext(), viewModel.searchMembers(query))
                binding.rv.adapter = adapter
                return true
            }

            override fun onQueryTextChange(newText: String): Boolean {
                adapter = MembersAdapter(requireContext(), viewModel.searchMembers(newText))
                binding.rv.adapter = adapter
                return true
            }

        })

        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val tempViewModel: HomepageFragmentViewModel by viewModels()
        viewModel = tempViewModel
    }

}