package com.thymleafdemo.springbootthymleafdemo.globalexception;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class ResourceNotFoundException extends RuntimeException{

     private String resource;
     private String fieldname;
     private String value;

    /**
     * @param resource
     * @param fieldname
     * @param value
     */
    public ResourceNotFoundException(String resource,String fieldname,String value) {
        super(String.format("%s not found with %s : '%s'", resource, fieldname, value)); 
         
        this.resource=resource;
         this.fieldname=fieldname;
         this.value=value;
    }

    
    
}
