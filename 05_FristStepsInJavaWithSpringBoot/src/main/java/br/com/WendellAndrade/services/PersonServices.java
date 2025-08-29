package br.com.WendellAndrade.services;


import br.com.WendellAndrade.Repository.PersonRepository;
import br.com.WendellAndrade.data.dto.v1.PersonDTO;
import br.com.WendellAndrade.data.dto.v2.PersonDTOV2;
import br.com.WendellAndrade.exception.ResourceNotFoundException;
import static br.com.WendellAndrade.mapper.ObjectMapper.parseListObjects;
import static br.com.WendellAndrade.mapper.ObjectMapper.parseObject;

import br.com.WendellAndrade.mapper.ObjectMapper;
import br.com.WendellAndrade.mapper.custom.PersonMapper;
import br.com.WendellAndrade.model.Person;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.concurrent.atomic.AtomicLong;


@Service
public class PersonServices {

    private final AtomicLong counter = new AtomicLong();
    private org.slf4j.Logger logger = LoggerFactory.getLogger(PersonServices.class.getName());

    @Autowired
    PersonRepository repository;

    @Autowired
    PersonMapper converter;

    public List<PersonDTO> findAll(){
        logger.info("Finding all person!");

        //Convertendo em DTO
        return parseListObjects(repository.findAll(), PersonDTO.class);
    }

    //Convertendo de Entidade para DTO
    public PersonDTO findById(Long id){
        logger.info("Finding one PersonDTO!");

        var entity = repository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("No record found for this ID!"));

        //Convertendo em DTO
        return ObjectMapper.parseObject(entity, PersonDTO.class);
    }

    //Convertento de DTO para entidade, pois o banco só entendo entidades
    public PersonDTO create(PersonDTO person){
        logger.info("Creating one person!");

        /*
         * Neste bloco recebemos o DTO e persisamos converter em Entidade antes de salvar no banco
         * já que o banco não reconhece se não for entidade, e ao final precisamos converter em DTO
         * novamente
         */

        var entity = parseObject(person, Person.class);
        return parseObject(repository.save(entity), PersonDTO.class);
    }

    public PersonDTO update(PersonDTO person){
        logger.info("Udpdating one person!");

        /*
         * Neste bloco já realizamos a conversão em entidade
         */

        Person entity = repository.findById(person.getId())
                .orElseThrow(()-> new ResourceNotFoundException("No found for this ID!"));

        entity.setFristName(person.getFristName());
        entity.setLastName(person.getLastName());
        entity.setAndress(person.getAndress());
        entity.setGender(person.getGender());

        //Quando salvar e retornar a entidade convertemos para DTO
        return parseObject(repository.save(entity), PersonDTO.class) ;
    }
    public void delete(Long id){
        logger.info("Delleting one person!");

        Person entity = repository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("No found for this ID!"));

        repository.delete(entity);

    }

    public PersonDTOV2 createv2(PersonDTOV2 person){
        logger.info("Create one person!");
       /*
        * Neste bloco recebemos o DTO e persisamos converter em Entidade antes de salvar no banco
        * já que o banco não reconhece se não for entidade, e ao final precisamos converter em DTO
        * novamente
        */
        var entity =  converter.convertDTOToEntity(person);
        return converter.convertEntityToDTO(repository.save(entity));

    }

}
