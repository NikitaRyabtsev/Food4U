package by.htp.netcracker.foodfactory.Helper;


import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.time.LocalDateTime;
import java.util.Date;

@Converter(autoApply = true)
public class DateTimeConverter implements AttributeConverter<LocalDateTime, Date> {

    @Override
    public Date convertToDatabaseColumn(LocalDateTime localDateTime) {
        if(localDateTime == null){
            return null;
        }
        return java.sql.Timestamp.valueOf(localDateTime);
    }

    @Override
    public LocalDateTime convertToEntityAttribute(Date date) {
        if (date == null){
            return null;
        }
        return new java.sql.Timestamp(
                date.getTime()).toLocalDateTime();
    }
}
