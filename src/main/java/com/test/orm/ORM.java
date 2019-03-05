import com.test.orm.puntoVenta;


public class ORM {

	public static void main(String[] args) throws IllegalArgumentException, IllegalAccessException{
		puntoVenta pto = new puntoVenta(1,"primavera","caldas");
		pto.save();
                puntoVenta pto2 = new puntoVenta(2,"primavera","caldas");
                pto2.save();
                pto2.setDireccion("bolombolo");
                pto2.update();
                //pto.delete();
		//pto.direccion = "abc";
		//pto.update();
		//pto.delete();
	
		
	}

	
}
