package edu.java.collection05;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

// Collection<E>
// |_ Set<E>
//		|_ HashSet<E>, TreeSet<E>

// Set<E>
// 1. 데이터의 저장 순서가 중요하지 않음 -> 인덱스가 없음
// 2. 중복된 데이터의 저장을 허용하지 않음
// 예) {1, 2, 2, 3, 3, 3} = {1, 2, 3}
//HashSet<E> : 검색을 빠르게 하기 위한 Hash 알고리즘이 적용된 Set
//TreeSet<E> : 정렬을 빠르게 하기 위한 Tree 알고리즘이 적용된 Set

public class CollectionMain05 {

	public static void main(String[] args) {
		Set<Integer> set = new HashSet<>();
		
		// Set에 데이터 저장 : add(element)
		set.add(300);
		set.add(200);
		set.add(100);
		set.add(200);
		set.add(300);
		System.out.println("size : " + set.size());
		
		// Set<E>은 인덱스로 데이터를 읽어올 수 있는 get() 메소드를 제공하지 않음

		for(Integer x : set) {
			System.out.println(x);
		}
		
		System.out.println();
		// Iterator(반복자)를 사용한 데이터 검색
		// - Iterator 인터페이스
		//   iterator() : Iterator 객체를 리턴
		//   hasNext() : Iterator 객체가 가리키는 위치에
		//				원소가 있는지(true), 없는지(false)를 리턴하는 메소드
		//   next() : Iterator 객체가 가리키는 위치를 다음 위치로 이동하고,
		//				원래 가리키고 있던 값을 리턴하는 메소드
		// 사용 이유 : 모든 컬렉션에서 공통으로 사용 가능
		
		Iterator<Integer> itr = set.iterator();
		while(itr.hasNext()) {
			System.out.println(itr.next());
		}
		
		List<Integer> list = new ArrayList<>();
		itr = list.iterator();
		
		// Set<E>의 원소를 삭제 : remove(element)
		// 인덱스가 아니라 요소로 삭제
		set.remove(300);
		for(Integer x : list) {
			System.out.println(x);
		}
		
		// 데이터 변경을 위한 set() 메소드를 제공하지 않음
		// Set<E>의 원소를 변경 : 데이터 삭제(remove) + 데이터 추가(add)
		set.remove(200);
		set.add(500);
		for(Integer x : set) {
			System.out.println(x);
		}
		
	}

}
