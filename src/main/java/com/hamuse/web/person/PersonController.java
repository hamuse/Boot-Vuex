package com.hamuse.web.person;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hamuse.web.util.Printer;


@RestController
@CrossOrigin(origins = "http://localhost:8081")
public class PersonController {
	@Autowired
	private PersonRepository personRepository;
	@Autowired
	private Printer printer;
	@Autowired
	private PersonService pesronService;
	@Autowired
	private Person person;
	
	@Autowired
	ModelMapper modelMapper;
	@Bean public ModelMapper modelMapper() {return new ModelMapper();} //json 하고 교환할수 있게 해준다. 
	
	@RequestMapping("/")
	public String index() {
		Iterable<Person> all = personRepository.findAll();
		StringBuilder sb = new StringBuilder();
		all.forEach(p -> sb.append(p.getName()+" "));
		return sb.toString();
	}
	@PostMapping("/login")
	public HashMap<String,Object> login(@RequestBody Person person) {
		HashMap<String,Object> map = new HashMap<>();
		printer.accept("로그인 진입");
		printer.accept(String.format("USERID: %s", person.getUserid()));
		printer.accept(String.format("PASSWD: %s", person.getPasswd()));
		person = personRepository.findByUseridAndPasswd(
				person.getUserid(),
				person.getPasswd());
		if(person != null) {
			printer.accept("로그인성공 2020");
			map.put("result", "True");
			map.put("person",person);
		}else {
			map.put("result", "False");
			map.put("person",person);
		}
		return map;
	}
	
	@PostMapping("/join")
	public HashMap<String,Object> join(@RequestBody Person person){
		HashMap<String,Object> map = new HashMap<>();
		/* DateFormat dateformat = new SimpleDateFormat(); */
		/*
		 * printer.accept("조인 컨트롤러 진입"); printer.accept(person.getUserid());
		 * printer.accept(person.getPasswd()); printer.accept(person.getName());
		 */
		/* printer.accept(person.getBirthday()); 불러왔을때 형식이 데이터 형식이라 아예 안불러 오던가 스트링 형식으로 바껴야 저장이된다. */
		/*
		 * String birthday = String.valueOf(person.getBirthday());
		 * printer.accept(birthday);
		 */
		
		personRepository.save(person);
		
		
		
		return map;
	}
	//userid,passwd,name,birthday
	
	@DeleteMapping("/withdrawal/{userid}")
	public void withdrawal(@PathVariable String userid) {
		/*
		 * printer.accept("withdrawal 컨트롤러 들어옴"); printer.accept(person.getUserid());
		 * printer.accept(person.getPasswd());
		 */
		/* personRepository.delete(person); */
		
		personRepository
		.delete(personRepository
				.findByUserid(userid));
	}
	@PostMapping("/update")
	public void update(@RequestBody Person person){
		
		/* DateFormat dateformat = new SimpleDateFormat(); */
		/*
		 * printer.accept("조인 컨트롤러 진입"); printer.accept(person.getUserid());
		 * printer.accept(person.getPasswd()); printer.accept(person.getName());
		 */
		/* printer.accept(person.getBirthday()); 불러왔을때 형식이 데이터 형식이라 아예 안불러 오던가 스트링 형식으로 바껴야 저장이된다. */
		/*
		 * String birthday = String.valueOf(person.getBirthday());
		 * printer.accept(birthday);
		 */
		
		printer.accept("update 컨트롤러"+person.getPersonid()); 
		 personRepository.save(person);
		/* personRepository.save(param); */
		 	}
	
	
	@GetMapping("/students")
	public List<Person> list(){
		//Iterable<Person> entites=personRepository.findByRole("student"); 
		Iterable<Person> entites = personRepository.findAll();
		List<Person> list = new ArrayList<>();
		for(Person p: entites) {
			Person dto = modelMapper.map(p, Person.class);
			list.add(dto);
		}
		list.stream()
			.filter(role-> role.getRole().equals("student"));
		return list.stream()
				.sorted(Comparator.comparing(Person::getPersonid)
						.reversed()).collect(Collectors.toList());
	}
	
	
	@GetMapping("/students/search/{searchWord}")
	public Stream<Person> findSome(@PathVariable String searchWord){
		printer.accept("넘어온 검색어"+searchWord);
		String switchkey = "";
		switch(searchWord) {
		case "namesOfStudents": break;
		case "streamToArray": break;
		case "streamToMap": break;
		case "theNumberOfStudents": break;
		case "totalScore": break;
		case "topStudent": break;
		case "getStat": break;
		case "nameList": break;
		case "남학생": case "여학생":
			switchkey = (searchWord == "남")?"partioningByMale":"partioningByFemale";
			 
			break;
		case "partioningCountPerGender": break;
		case "partioningTopPerGender": break;
		case "partioningRejectPerGender": break;
		case "groupingByBan": break;
		case "groupingByGrade": break;
		case "groupingByCountByLevel": break;
		case "groupingByHakAndBan": break;
		case "3학년 목록": 
			switchkey = "groupingByHak";
			break;
		case "groupingTopByHakAndBan": break;
		case "groupingByStat": break;
		
		}
		/*
		 * // Iterable<Person> entites= personReopsitory.findByRole("student")
		 * Iterable<Person> entites = personRepository.findAll(); List<Person> list =
		 * new ArrayList<>(); for(Person p : entites) { Person dto =
		 * modelMapper.map(p, Person.class); list.add(dto); }
		 * printer.accept("list count"+list.size()); return
		 * list.stream().filter(role->role.getRole().equals("student"));
		 */
		switch(switchkey) {
		case "namesOfStudents": break;
		case "streamToArray": break;
		case "streamToMap": break;
		case "theNumberOfStudents": break;
		case "totalScore": break;
		case "topStudent": break;
		case "getStat": break;
		case "nameList": break;
		case "partioningByMale" : 
			List<Person> list = pesronService.partioningByGender(true);
			break;
		
		case "partioningCountPerGender": break;
		case "partioningTopPerGender": break;
		case "partioningRejectPerGender": break;
		case "groupingByBan": break;
		case "groupingByGrade": break;
		case "groupingByCountByLevel": break;
		case "groupingByHakAndBan": break;
		case "groupingByHak":
			
			
			break;
		case "groupingTopByHakAndBan": break;
		case "groupingByStat": break;
		
		}
		
		return null;
	}
}
