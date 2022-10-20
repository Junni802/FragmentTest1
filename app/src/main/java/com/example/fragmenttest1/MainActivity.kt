package com.example.fragmenttest1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.fragmenttest1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
	val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(binding.root)
	
		setFragment()	// 프레그먼트를 엑티비에 삽입하는 함수 호출
	}
	
	fun setFragment() {
	// 엑티비티에 미리 생성해 놓은 프레그먼트 (ListFragment)를 삽입시키는 함수
		val listFragment: ListFragment = ListFragment()
		
		var bundle = Bundle() 	// 프래그먼트로 데이터를 보낼 때 사용되며 intent와 비슷
		bundle.putString("name", "List Fragment")
		bundle.putInt("num", 20221020)
		// 프래그먼트로 전송할 데이터들을 bundle에 저장
		listFragment.arguments = bundle

		// 프레그먼트를 엑티비티에 넣는 과정은 트렌젝션으로 처리됨
		val trans = supportFragmentManager.beginTransaction()
		// 트렌젝션 객체 생성 후 트렌잭션 시작
		trans.add(R.id.frameLayout, listFragment)
		// add(레이아웃, 프레그먼트) : 지정한 프레그먼트를 지정한 프레그먼트 레이아웃 객체의 위치에 추가
		// replace(레이아웃, 프레그먼트) : 지정한 프레그먼트 레이아웃 객체에 있는 기존 프레그먼트를 지정한 새 프레그먼트로 교체
		// remove(프레그먼트) : 지정한 프레그먼트 삭제
		trans.commit()
	}
	
	fun goDetail(){
		// btnNext버튼 클릭시 DetailFragment를 생성하여 엑티비티의 framgeLayout에 삽입시킬 함수
		val detailFragment: DetailFragment = DetailFragment()

		val trans = supportFragmentManager.beginTransaction()
		trans.add(R.id.frameLayout, detailFragment)
		trans.addToBackStack("detail")
		// 현재 보이는 프래그먼트 기록을 스택에 넣겠다는 의미로 폰의 '뒤로 가기'가 가능해짐
		// addToBackStack()을 사용하지 않고 '뒤로 가기'를 하면 엑티비티가 종료됨(프레임으로 덮여져있는거여서 엑티비티는 1개이기 때문에)
		trans.commit()
	}

	fun goBack(){
	// btnBack 버튼 클릭시 뒤로가기 기능의 함수
		onBackPressed() // 뒤로 가기용 엑티비티 기본 함수
	}
}