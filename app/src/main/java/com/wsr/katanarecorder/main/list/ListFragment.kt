package com.wsr.katanarecorder.main.list

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.wsr.katanarecorder.databinding.FragmentListBinding
import com.wsr.katanarecorder.main.list.detail.DetailActivity

class ListFragment() : Fragment() {

    private var _binding: FragmentListBinding? = null
    private val binding get() = _binding!!

    private lateinit var listAdapter: ListAdapter
    private lateinit var listViewModel: ListViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val recyclerView = binding.listRecyclerView

        listAdapter = ListAdapter()
        listAdapter.clickTitleOnListener = this.clickTitleOnListener

        listViewModel = ViewModelProvider(
                this,
                ViewModelProvider.NewInstanceFactory()
        ).get(ListViewModel::class.java)

        recyclerView.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(context)
            adapter = listAdapter
        }

        listViewModel.sampleModel.observe(viewLifecycleOwner, {
            it?.let{
                listAdapter.setData(it)
            }
        })
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private val clickTitleOnListener: (Int) -> Unit = { id ->
        val intent = Intent(requireContext(), DetailActivity::class.java)
        //intent.putExtra("ID", -1)
        startActivity(intent)
    }
}