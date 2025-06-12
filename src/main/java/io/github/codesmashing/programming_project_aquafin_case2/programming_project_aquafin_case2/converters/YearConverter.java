package io.github.codesmashing.programming_project_aquafin_case2.programming_project_aquafin_case2.converters;

import java.time.Year;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter
public class YearConverter implements AttributeConverter<Year, String> {

    @Override
    public String convertToDatabaseColumn(Year attribute) {
        return (attribute != null) ? String.valueOf(attribute.getValue()) : null;
    }

    @Override
    public Year convertToEntityAttribute(String dbData) {
        if(dbData == null){
            return null;
        }

        int year;
        try{
            year = Integer.parseInt(dbData);
        } catch (NumberFormatException e){
            // log.error("Failed to parse {} to Integer", dbData);
            throw new IllegalArgumentException(dbData + " is not a valid value.");
        }
        return Year.of(year);
    }
}