import com.test.orm.puntoVenta;


public class ORM {

	public static void main(String[] args) throws IllegalArgumentException, IllegalAccessException{
		puntoVenta pto = new puntoVenta(1,"primavera","caldas");
		//pto.save();
                puntoVenta pto2 = new puntoVenta(2,"primavera","caldas");
                //pto2.save();
                //pto2.setDireccion("bolombolo");
                //pto2.update();
                pto.delete();
		//pto.direccion = "abc";
		//pto.update();
		//pto.delete();
	
		
	}

	/*static <T> void inspect(Class<T> klazz, puntoVenta pto) throws IllegalArgumentException, IllegalAccessException {
        Field[] fields = klazz.getDeclaredFields();
        System.out.printf("%d fields:%n", fields.length);
        for (Field field : fields) {
            System.out.printf("%s %s %s %s%n",
                Modifier.toString(field.getModifiers()),
                field.getType().getSimpleName(),
                field.getName(),
                field.get(pto)
            );
        }
    }*/

}
