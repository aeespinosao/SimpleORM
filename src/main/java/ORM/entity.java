package ORM;
import java.lang.reflect.Field;

import Annotations.PK;
import Annotations.Table;


public class entity {
	
	
	public void save() throws IllegalArgumentException, IllegalAccessException {
		
		String tableName = this.getClass().getDeclaredAnnotation(Table.class).tableName();
		String columns = "(";
		String values = "(";
        
		Field[] fields = this.getClass().getDeclaredFields();
        for (int i=0;i<fields.length;i++) {
          
        	if(i>0) {
        		columns += ",";
        		values += ",";
        	}
        	columns += fields[i].getName();
        	values += String.format("\"%s\"",fields[i].get(this));
        }
        
        columns += ")";
		values += ")";
        
                
        dbConection.executeQuery(
                String.format("insert into %s %s values %s;%n",
                tableName,
                columns,
                values)
        );
    }
	
public void update() throws IllegalArgumentException, IllegalAccessException {
		
		String tableName = this.getClass().getDeclaredAnnotation(Table.class).tableName();
		String set = "";
		String pk = "";
       
		Field[] fields = this.getClass().getDeclaredFields();
        for (int i=0;i<fields.length;i++) {    	
        	if(fields[i].getAnnotation(PK.class) != null) {
        		pk = String.format("%s = \"%s\"", fields[i].getName(),fields[i].get(this));
        	} else {
        		set += String.format("%s = \"%s\"", fields[i].getName(),fields[i].get(this));
        		if(i != fields.length-1)
        			set += ",";
        	}
        }
        
        dbConection.executeQuery(
                String.format("update %s set %s where %s;%n",
                tableName,
                set,
                pk)
        );
    }

public void delete() throws IllegalArgumentException, IllegalAccessException {
	
	String tableName = this.getClass().getDeclaredAnnotation(Table.class).tableName();
	String pk = "";
    
	Field[] fields = this.getClass().getDeclaredFields();
    for (int i=0;i<fields.length;i++) {    	
    	if(fields[i].getAnnotation(PK.class) != null) {
    		pk = String.format("%s = \"%s\"", fields[i].getName(),fields[i].get(this));
    	}
    }
    
    dbConection.executeQuery(
                String.format("delete from %s where %s;%n",
            tableName,
            pk)
        );
}
}

