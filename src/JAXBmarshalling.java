import java.io.File;
import java.io.FileReader;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.module.jaxb.JaxbAnnotationModule;

import model.HealthProfile;
import model.Person;
import dao.PeopleStore;

public class JAXBmarshalling {  	
	public static PeopleStore people = new PeopleStore();

	public static void main(String[] args) throws Exception {
		int argCount = args.length;
		if (argCount == 0) {
			System.out.println("I cannot marshalling, un-marshalling or create"
					+ " json file if not write what would you do.");
		} else {
			
			String method = args[0];
			JAXBContext jc = JAXBContext.newInstance(PeopleStore.class);
			
			if (method.equals("marshaling")) {
				
				newPerson();	
		        Marshaller m = jc.createMarshaller();
		        m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
		        System.out.println("Marshalling into a XML file(NEWpeople.xml)..... ");
		        m.marshal(people,new File("NEWpeople.xml")); // marshalling into a file
		        System.out.println();
		        System.out.println("NEWpeople.xml: ");
		        System.out.println();
		        m.marshal(people, System.out);	
		        
			}else if (method.equals("unmarshaling")){
				
		        System.out.println();
		        System.out.println("Output from our XML File: ");
		        Unmarshaller um = jc.createUnmarshaller();
		        PeopleStore people = (PeopleStore) um.unmarshal(new FileReader("NEWpeople.xml"));
		        List<Person> list = people.getData();
		        for (Person person : list) {
		        	System.out.println(person.toString());
		        }
		        
			} else if (method.equals("json")){
				
				newPerson();			
				ObjectMapper mapper = new ObjectMapper();
		        JaxbAnnotationModule module = new JaxbAnnotationModule();
		        
				mapper.registerModule(module);
				mapper.configure(SerializationFeature.INDENT_OUTPUT, true);
		        mapper.configure(SerializationFeature.ORDER_MAP_ENTRIES_BY_KEYS, true);
		        System.out.println("Write into a JSON file(NEWpeople.json).... ");
		        String result = mapper.writeValueAsString(people);
		        mapper.writeValue(new File("NEWpeople.json"), people);
		        System.out.println();
		        System.out.println("NEWpeople.json: ");
		        System.out.println();
		        System.out.println(result);
		        
				
			} else {
				System.out.println("The system did not find the method '"+method+"'");
			}
		}
    }
	
	//Function that creates three new people and save in PeopleStore
	public static void newPerson() {
		HealthProfile hp1 = new HealthProfile(80.0, 1.80);
		HealthProfile hp2 = new HealthProfile(85.0, 1.90);
		HealthProfile hp3 = new HealthProfile(70.0, 1.75);
		Person io = new Person("Michele", "Bof",hp1, "1993-08-07","0001");
		Person andrea = new Person("Andrea", "Orla",hp2, "1993-05-21","0002");
		Person davide = new Person("Davide", "Darrec",hp3, "1993-03-23","0003");

		people.getData().add(io);
		people.getData().add(andrea);
		people.getData().add(davide);
	}
}
