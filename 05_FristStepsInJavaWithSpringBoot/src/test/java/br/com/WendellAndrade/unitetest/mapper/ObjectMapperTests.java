package br.com.WendellAndrade.unitetest.mapper;
import static br.com.WendellAndrade.mapper.ObjectMapper.parseListObjects;
import static br.com.WendellAndrade.mapper.ObjectMapper.parseObject;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import br.com.WendellAndrade.data.dto.v1.PersonDTO;
import br.com.WendellAndrade.unitetest.mapper.mocks.MockPerson;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.com.WendellAndrade.model.Person;

public class ObjectMapperTests {
    MockPerson inputObject;

    @BeforeEach
    public void setUp() {
        inputObject = new MockPerson();
    }

    @Test
    public void parseEntityToDTOTest() {
        PersonDTO output = parseObject(inputObject.mockEntity(), PersonDTO.class);
        assertEquals(Long.valueOf(0L), output.getId());
        assertEquals("First Name Test0", output.getFristName());
        assertEquals("Last Name Test0", output.getLastName());
        assertEquals("Address Test0", output.getAndress());
        assertEquals("Male", output.getGender());
    }

    @Test
    public void parseEntityListToDTOListTest() {
        List<PersonDTO> outputList = parseListObjects(inputObject.mockEntityList(), PersonDTO.class);
        PersonDTO outputZero = outputList.get(0);

        assertEquals(Long.valueOf(0L), outputZero.getId());
        assertEquals("First Name Test0", outputZero.getFristName());
        assertEquals("Last Name Test0", outputZero.getLastName());
        assertEquals("Address Test0", outputZero.getAndress());
        assertEquals("Male", outputZero.getGender());

        PersonDTO outputSeven = outputList.get(7);

        assertEquals(Long.valueOf(7L), outputSeven.getId());
        assertEquals("First Name Test7", outputSeven.getFristName());
        assertEquals("Last Name Test7", outputSeven.getLastName());
        assertEquals("Address Test7", outputSeven.getAndress());
        assertEquals("Female", outputSeven.getGender());

        PersonDTO outputTwelve = outputList.get(12);

        assertEquals(Long.valueOf(12L), outputTwelve.getId());
        assertEquals("First Name Test12", outputTwelve.getFristName());
        assertEquals("Last Name Test12", outputTwelve.getLastName());
        assertEquals("Address Test12", outputTwelve.getAndress());
        assertEquals("Male", outputTwelve.getGender());
    }

    @Test
    public void parseDTOToEntityTest() {
        Person output = parseObject(inputObject.mockDTO(), Person.class);
        assertEquals(Long.valueOf(0L), output.getId());
        assertEquals("First Name Test0", output.getFristName());
        assertEquals("Last Name Test0", output.getLastName());
        assertEquals("Address Test0", output.getAndress());
        assertEquals("Male", output.getGender());
    }

    @Test
    public void parserDTOListToEntityListTest() {
        List<Person> outputList = parseListObjects(inputObject.mockDTOList(), Person.class);
        Person outputZero = outputList.get(0);

        assertEquals(Long.valueOf(0L), outputZero.getId());
        assertEquals("First Name Test0", outputZero.getFristName());
        assertEquals("Last Name Test0", outputZero.getLastName());
        assertEquals("Address Test0", outputZero.getAndress());
        assertEquals("Male", outputZero.getGender());

        Person outputSeven = outputList.get(7);

        assertEquals(Long.valueOf(7L), outputSeven.getId());
        assertEquals("First Name Test7", outputSeven.getFristName());
        assertEquals("Last Name Test7", outputSeven.getLastName());
        assertEquals("Address Test7", outputSeven.getAndress());
        assertEquals("Female", outputSeven.getGender());

        Person outputTwelve = outputList.get(12);

        assertEquals(Long.valueOf(12L), outputTwelve.getId());
        assertEquals("First Name Test12", outputTwelve.getFristName());
        assertEquals("Last Name Test12", outputTwelve.getLastName());
        assertEquals("Address Test12", outputTwelve.getAndress());
        assertEquals("Male", outputTwelve.getGender());
    }
}