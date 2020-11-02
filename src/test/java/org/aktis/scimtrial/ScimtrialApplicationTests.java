package org.aktis.scimtrial;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SpringBootTest
public class ScimtrialApplicationTests{

	@Test
	void contextLoads() {

				ObjectMapper mapper = new ObjectMapper();
				Person person = newPerson();

				try {
					mapper.writeValue(new File("person.json"), person);
					String jsonString = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(person);
					System.out.println(jsonString);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}

			Person newPerson() {
				Person person = new Person();

				List<String> hobbies = new ArrayList<>();
				hobbies.add("Football");
				hobbies.add("Cooking");
				hobbies.add("Swimming");

				Map<String, String> languages = new HashMap<>();
				languages.put("French", "Beginner");
				languages.put("German", "Intermediate");
				languages.put("Spanish", "Advanced");

				person.setName("David");
				person.setAge(30);
				person.setHobbies(hobbies);
				person.setLanguages(languages);

				return person;
			}

	public class Person {

		String name;
		Integer age;
		List<String> hobbies;
		Map<String, String> languages;

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public Integer getAge() {
			return age;
		}

		public void setAge(Integer age) {
			this.age = age;
		}

		public List<String> getHobbies() {
			return hobbies;
		}

		public void setHobbies(List<String> hobbies) {
			this.hobbies = hobbies;
		}

		public Map<String, String> getLanguages() {
			return languages;
		}

		public void setLanguages(Map<String, String> languages) {
			this.languages = languages;
		}
	}

}

