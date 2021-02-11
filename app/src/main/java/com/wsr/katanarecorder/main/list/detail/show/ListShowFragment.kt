package com.wsr.katanarecorder.main.list.detail.show

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.wsr.katanarecorder.databinding.FragmentListDetailShowBinding

class ListShowFragment : Fragment() {

    private var _binding: FragmentListDetailShowBinding? = null
    private val binding get() = _binding!!

    private val args: ListShowFragmentArgs by navArgs()

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
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}