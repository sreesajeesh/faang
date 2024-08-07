package workspace;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import dev.mccue.guava.collect.ImmutableList;
import dev.mccue.guava.io.Resources;
import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Type;
import java.util.List;

public class PeopleData {

    public static List<Person> getPeople() throws IOException {
        InputStream inputStream = Resources.getResource("people.json")
                .openStream();
        String json = IOUtils.toString(inputStream);

        ObjectMapper objectMapper = new ObjectMapper();
        TypeReference<List<Person>> typeReference = new TypeReference<List<Person>>() {};
        List<Person> personList = objectMapper.readValue(json, typeReference);
        return personList;
    }
}
