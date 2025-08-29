package br.com.WendellAndrade.mapper;

import com.github.dozermapper.core.DozerBeanMapperBuilder;
import com.github.dozermapper.core.Mapper;

import java.util.ArrayList;
import java.util.List;


//Classe responsável por mapear o DTO(Data Transfer Object)
public class ObjectMapper {

    private static Mapper mapper = DozerBeanMapperBuilder.buildDefault();

    /*
       Metodo que irá converter a irigem no detino (de um DTO a uma Entity ou Entity em um DTO)
    */
   public static <O, D> D parseObject(O origin, Class<D> destination){
      // return mapper.map(origin, destination);
       return mapper.map(origin, destination);
   }

   /*
      Metodo que irá converter a irigem no detino (de um DTO a uma Entity ou Entity em um DTO) - Lista
   */
    public static <O, D> List<D> parseListObjects(List<O> origin, Class<D> destination){

        List<D> destinationObjects = new ArrayList<D>();

        for(Object o : origin){
           /*
            * Como 'o' está inteirando em cima de origin que recebe uma lista de entidades  é preciso usar o
            * metodo mapper.map utilizando 'o' pois usando o origin ele irá retornar o jason com carga null.
            * Exemplo: destinationObjects.add(mapper.map(origin, destination));
            */

            destinationObjects.add(mapper.map(o, destination));
        }
        return destinationObjects;
    }
}
