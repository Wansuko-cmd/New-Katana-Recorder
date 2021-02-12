package com.wsr.katanarecorder.main.list.detail.show

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.wsr.katanarecorder.R
import com.wsr.katanarecorder.databinding.FragmentListDetailShowBinding
import com.wsr.katanarecorder.main.list.ListViewModel

class ListShowFragment : Fragment() {

    private var _binding: FragmentListDetailShowBinding? = null
    private val binding get() = _binding!!

    private lateinit var listShowAdapter: ListShowAdapter
    private lateinit var listViewModel: ListViewModel

    private val args: ListShowFragmentArgs by navArgs()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.list_detail_show_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when(item.itemId){
            R.id.show_edit_menu -> {
                val action = ListShowFragmentDirections.showDetailToEditDetail(args.id)
                findNavController().navigate(action)
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
        _binding = FragmentListDetailShowBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val id = args.id
        val recyclerView = binding.listDetailShowRecyclerView
        listShowAdapter = ListShowAdapter()

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
            adapter = listShowAdapter
        }

        listViewModel.sampleModel.observe(viewLifecycleOwner, { list ->
            list.find{it.id == id}?.let{
                listShowAdapter.setData(it)
            }
        })
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}