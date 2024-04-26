package person;

import java.util.Scanner;

public class Student extends Person{
	String nim;
	private double spp;
	private double sks;
	private double modul;

	public Student() {
		Scanner inp = new Scanner(System.in);
		
		try {
			System.out.println("Input nama:");
			super.name = inp.next();
			
			System.out.println("Input alamat:");
			super.address = inp.next();
			
			System.out.println("Input NIM:");
			this.nim = inp.next();

			System.out.println("SPP:");
			this.spp = inp.nextDouble();

			System.out.println("SKS:");
			this.sks = inp.nextDouble();

			System.out.println("Modul:");
			this.modul = inp.nextDouble();
		
		} finally {
			inp.close();
		}
	}
	
	public String getNim() {
		return nim;
	}

	public double hitungPembayaran() {
		return this.modul + this.sks + this.spp;
	}
	
	@Override
	public void identity()
	{
		System.out.println("NIM: "+getNim());
		super.identity(); // Output nama dan alamat
		System.out.println("SPP: "+this.spp);
		System.out.println("SKS: "+this.sks);
		System.out.println("Modul: "+this.modul);
		System.out.println("Total pembayaran: "+hitungPembayaran());
		
	}
		
}
