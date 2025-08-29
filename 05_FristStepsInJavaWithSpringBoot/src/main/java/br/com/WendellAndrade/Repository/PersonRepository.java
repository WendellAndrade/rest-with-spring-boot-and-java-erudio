package br.com.WendellAndrade.Repository;

import br.com.WendellAndrade.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person,Long> {
}
