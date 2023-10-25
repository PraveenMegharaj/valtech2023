package com.valtech.training.day4;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import CoreJava.Point3D;

public class SerialTest {

public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
	Point3D p = new Point3D(2,3,4);
	System.out.println(p);
	ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(new File("objects")));
	oos.writeObject(p);
	oos.flush();
	oos.close();
	ObjectInputStream ois = new ObjectInputStream(new FileInputStream(new File("objects")));
	Point3D p1 = (Point3D) ois.readObject();
	System.out.println(p1);
	System.out.println(p == p1);
}
}
