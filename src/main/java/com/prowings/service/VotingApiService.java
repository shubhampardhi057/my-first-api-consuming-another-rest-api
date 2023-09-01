package com.prowings.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.prowings.interceptors.MyRequestLoggerInterceptor;
import com.prowings.model.Person;
import com.prowings.model.Student;
import com.prowings.model.Subjects;

@Service
public class VotingApiService {

	@Autowired
	RestTemplate restTemplate;
	
	
	public ResponseEntity<String> doVoting()
	{
		Person person = new Person(10,"Ram",19,"India");
		
		ResponseEntity<String> result = new ResponseEntity<>(HttpStatus.CREATED);
		
		result = restTemplate.postForEntity("http://localhost:8080/my-first-rest-api-using-spring-mvc/vote", person, String.class);
		
		return result;
	}
	
	public ResponseEntity<List<Student>> getAllStudents()
	{
		String url = "http://localhost:8080/my-second-rest-api-using-spring-mvc/students";
		
//		restTemplate.setInterceptors(Collections.singletonList(new MyRequestLoggerInterceptor()));
		
		List<ClientHttpRequestInterceptor> myList = new ArrayList<>();
		myList.add(new MyRequestLoggerInterceptor());
		
		restTemplate.setInterceptors(myList);
		
		List<Student> list = restTemplate.getForObject(url,List.class);
		
//		ResponseEntity<Student[]>  response = restTemplate.exchange(url,HttpMethod.GET,null,Student[].class);
		
		
		HttpHeaders resHeaders = new HttpHeaders();
		resHeaders.add("XYZ","123");
		resHeaders.add("PQR","456");
		
//		ResponseEntity<List<Student>> res = new ResponseEntity<List<Student>>(list, resHeaders, HttpStatus.OK);
		
		return ResponseEntity.ok().headers(resHeaders).body(list);
	}
	
	public ResponseEntity<Student> createStudent(Student std)
	{
		String url = "http://localhost:8080/my-second-rest-api-using-spring-mvc/students";
		
		List<ClientHttpRequestInterceptor> myList = new ArrayList<>();
		myList.add(new MyRequestLoggerInterceptor());
		
		restTemplate.setInterceptors(myList);
		
		Student retrievedStd = restTemplate.postForObject(url, std,Student.class);
	
		HttpHeaders resHeaders = new HttpHeaders();
		resHeaders.add("XYZ","123");
		resHeaders.add("PQR","456");
		
		return ResponseEntity.ok().body(retrievedStd);
		
	}
	
	public ResponseEntity<List<Student>> getAllStudentsWithPerticularSubject(String sub)
	{
		
		String url = "http://localhost:8080/my-second-rest-api-using-spring-mvc/students";
		
		Student [] studentArray = restTemplate.getForObject(url,Student[].class);
		
		List<Student>  filteredStudents = new ArrayList<>();
		
		for(Student s : studentArray)
		{
			for(Subjects subject : s.getSubjects())
			{
				if(subject.getSubjectName().equalsIgnoreCase(sub))
				{
					filteredStudents.add(s);
				}
			}
		}
		
		return ResponseEntity.ok().body(filteredStudents);
		
		
	}

	public ResponseEntity<String> updateStudent(Student std) {
		
		String url = "http://localhost:8080/my-second-rest-api-using-spring-mvc/students";
		
		try {
			restTemplate.put(url, std);
			
			
			
		}catch (RestClientException e) {

			System.out.println("Exception while calling update");
			
			return new ResponseEntity<String>("Error While Updating Student !!",HttpStatus.INTERNAL_SERVER_ERROR);
			
		}
		
		HttpHeaders resHeaders = new HttpHeaders();
		resHeaders.add("XYZ","123");
		resHeaders.add("PQR","456");
		
		return ResponseEntity.ok().headers(resHeaders).body("Updated Successfully !!!");
	
	}
	public ResponseEntity<String> deleteStudent(int  id) {
		
		String url = "http://localhost:8080/my-second-rest-api-using-spring-mvc/students/{id}";
		
		try {
			restTemplate.delete(url, id);
		}catch (RestClientException e) {
			
			System.out.println("Exception while calling update");
			
			return new ResponseEntity<String>("Error While Updating Student !!",HttpStatus.INTERNAL_SERVER_ERROR);
			
		}
		
		HttpHeaders resHeaders = new HttpHeaders();
		resHeaders.add("XYZ","123");
		resHeaders.add("PQR","456");
		
		return ResponseEntity.ok().headers(resHeaders).body("Deleted Successfully !!!");
		
	}
	
}
