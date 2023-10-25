package CoreJava;

public class Point3D extends Point {
	
	public static final Point3D ORIGIN = new Point3D();
	
	private int z;
	
//	@Override
//	public double distance() {
//		return Math.sqrt(x*x + y*y + z*z);
//	}
	
	public Point3D(int x, int y, int z) {
		super(x,y);
		System.out.println("Point3D");
		this.z = z;
	}
	 
	
	public Point3D() {
		// TODO Auto-generated constructor stub
	}


	public double distance() {
		
		System.out.println("Point 3D Distance");
		return Math.sqrt(x*x + y*y + z*z);
		
	}
	
	public static void main(String[] args) {
		
		ORIGIN.x = 10;
		System.out.println(Point.ORIGIN.distance());
		System.out.println(ORIGIN.distance());
		Point3D p = new Point3D(10,20,30);
		double dis = p.distance(new Point(20,30));
		System.out.println(p);
	}

}
