package com.billings.app.infrastructure.adapters.persitence.mapper;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import com.billings.app.domain.models.Invoice;
import com.billings.app.infrastructure.adapters.persitence.entity.InvoiceEntity;
@Mapper(componentModel= "spring")
public interface IInvoiceRepositoryMapper {


      // Método para convertir List<String> (dominio) a String (entidad)
    @Named("listToString")
    default String map(List<String> value) {
        if (value == null) {
            return null;
        }
        // Unimos los elementos de la lista en una sola cadena, separados por comas
        return String.join(";", value); // Usamos ';' para evitar conflictos con comas dentro de los nombres
    }

    // Método para convertir String (entidad) a List<String> (dominio)
    @Named("stringToList")
    default List<String> map(String value) {
        if (value == null || value.isEmpty()) {
            return null;
        }
        // Dividimos la cadena por el separador y la convertimos en una lista
        return Arrays.stream(value.split(";"))
                     .map(String::trim)
                     .collect(Collectors.toList());
    }

    // Mapeo de dominio a entidad, usando el método named para 'items'
    @Mapping(target = "items", source = "items", qualifiedByName = "listToString")
    InvoiceEntity toEntity(Invoice invoice);

    // Mapeo de entidad a dominio, usando el método named para 'items'
    @Mapping(target = "items", source = "items", qualifiedByName = "stringToList")
    Invoice toDomain(InvoiceEntity invoiceEntity);

    List<Invoice> toDomainList(List<InvoiceEntity> invoiceEntities);

}


