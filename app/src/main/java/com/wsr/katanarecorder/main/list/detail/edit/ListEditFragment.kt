package com.wsr.katanarecorder.main.list.detail.edit

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.wsr.katanarecorder.R
import com.wsr.katanarecorder.databinding.FragmentListDetailEditBinding
import com.wsr.katanarecorder.main.list.ListViewModel

class ListEditFragment : Fragment() {

    private var _binding: FragmentListDetailEditBinding? = null
    private val binding get() = _binding!!

    private lateinit var listEditAdapter: ListEditAdapter
    private lateinit var listViewModel: ListViewModel

    private val args: ListEditFragmentArgs by navArgs()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.list_detail_edit_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when(item.itemId){
            R.id.edit_save_menu -> {
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentListDetailEditBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val id = args.id
        val recyclerView = binding.detailEditRecyclerView
        listEditAdapter = ListEditAdapter()

        listViewModel = ViewModelProvider(
                this,
                ViewModelProvider.NewInstanceFactory()
        ).get(ListViewModel::class.java)

        val divider = DividerItemDecoration(
                requireContext(),
                LinearLayoutManager(requireContext()).orientation
        )

        recyclerView.apply{
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(context)
            addItemDecoration(divider)
            adapter = listEditAdapter
        }

        listViewModel.sampleModel.observe(viewLifecycleOwner, { list ->
            list.find{it.id == id}?.let{
                listEditAdapter.setData(it)
            }
        })

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}