package com.example.fragmenttest1

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.fragmenttest1.databinding.FragmentDetailBinding
import com.example.fragmenttest1.databinding.FragmentListBinding

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class DetailFragment : Fragment() {
	var mainActivity : MainActivity? = null

	override fun onCreateView(
		inflater: LayoutInflater, container: ViewGroup?,
		savedInstanceState: Bundle?
	): View? {
		var binding = FragmentDetailBinding.inflate(inflater, container, false)
		binding.btnBack.setOnClickListener { mainActivity?.goBack() }
		return binding.root
	}

	override fun onAttach(context: Context) {
		super.onAttach(context)
		if(context is MainActivity)		mainActivity = context
	}

	companion object {
		@JvmStatic
		fun newInstance(param1: String, param2: String) =
			DetailFragment().apply {
				arguments = Bundle().apply {
					putString(ARG_PARAM1, param1)
					putString(ARG_PARAM2, param2)
				}
			}
	}
}