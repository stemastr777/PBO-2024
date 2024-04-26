package person;

public class Person {
	protected String name;
	protected String address;
	protected String hoby;
	
	
	public void identity()
	{
		System.out.println("Nama: "+name);
		System.out.println("Alamat: "+address);
	}

	public String getHobi() {
		return this.hoby;
	}

}
