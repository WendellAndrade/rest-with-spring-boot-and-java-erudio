package br.com.WendellAndrade.mapper.custom;

import br.com.WendellAndrade.data.dto.v2.PersonDTOV2;
import br.com.WendellAndrade.model.Person;
import org.springframework.stereotype.Service;

import java.util.Date;

/*Para essa classe ser utilizada no controller ou outros blocos de códigos é preciso usar o @Service,
 ele irá dar permissão, porém, onde for ser utilizado percisa ser usado o @Autowired para dar permissão*/
@Service
public class PersonMapper {

    /*Metodo que converte uma entidade em um DTO*/
    public PersonDTOV2 convertEntityToDTO (Person person){

        PersonDTOV2 dot = new PersonDTOV2();

        dot.setId(person.getId());
        dot.setFristName(person.getFristName());
        dot.setLastName(person.getLastName());
        dot.setAndress(person.getAndress());
        dot.setGender(person.getGender());
        dot.setBirthDay(new Date());

        return dot;
    }

    /*Metodo que converte de DTO para entidade*/
    public Person convertDTOToEntity(PersonDTOV2 person){
        Person entity = new Person();

        entity.setId(person.getId());
        entity.setFristName(person.getFristName());
        entity.setLastName(person.getLastName());
        entity.setAndress(person.getAndress());
        entity.setGender(person.getGender());

        return entity;
    }
}
