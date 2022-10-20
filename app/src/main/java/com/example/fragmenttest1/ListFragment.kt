package com.example.fragmenttest1

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.fragmenttest1.databinding.FragmentListBinding

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class ListFragment : Fragment() {
	var mainActivity: MainActivity? = null

	override fun onCreateView(
		inflater: LayoutInflater, container: ViewGroup?,
		savedInstanceState: Bundle?
	): View? { 
	// inflater : 레이아웃 파일을 로드하기 위한 레이아웃 인플레이터를 기본으로 제공
	// container : 프래그먼트 레이아웃이 배치되는 부모 레이아웃으로 엑티비티의 레이아웃을 의미
	// savedInstanceState : 상태 값 저장을 위한 보조도구로 액티비티의 onCreate() 함수의 파라미터와 동일하게 동작
		//return inflater.inflate(R.layout.fragment_list, container, false) 기본적으로 있는것인데 안씀
		val binding = FragmentListBinding.inflate(inflater, container, false)
		binding.txtName.text = arguments?.getString("name").toString()
		binding.txtNum.text = "${arguments?.getInt("num")}"
		binding.btnNext.setOnClickListener { mainActivity?.goDetail() } // 메인 엑티비티에 있는 goDetail함수 호출위해 mainActivity 변수선언
		return binding.root
		// OncreateView() 함수의 리턴값이 View이므로 binding의 root뷰를 리턴
	}

	override fun onAttach(context: Context) {
	// 프레그먼트 생성 트랜잭션의 commit() 함수가 실행될 때 호출되는 함수
		super.onAttach(context)

		if(context is MainActivity) 	mainActivity = context
		// 받아온 context가 MainActivity가 맞으면 mainActivity에 저장
	}

	companion object {
		@JvmStatic
		fun newInstance(param1: String, param2: String) =
			ListFragment().apply {
				arguments = Bundle().apply {
					putString(ARG_PARAM1, param1)
					putString(ARG_PARAM2, param2)
				}
			}
	}
}