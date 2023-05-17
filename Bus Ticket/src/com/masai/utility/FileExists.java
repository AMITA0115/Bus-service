package com.masai.utility;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.masai.entities.Passenger;
import com.masai.entities.Bus;
import com.masai.entities.Transaction;

public class FileExists {



	public static Map<Integer, Bus> busFile() {

		Map<Integer, Bus> bFile = null;

		File f = new File("Bus.ser");
		boolean flag = false;
		try {
			if (!f.exists()) {
				f.createNewFile();
				flag = true;
			}

			if (flag) {

				bFile = new LinkedHashMap<>();
				ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(f));
				oos.writeObject(bFile);
				return bFile;

			} else {

				ObjectInputStream ois = new ObjectInputStream(new FileInputStream(f));
				bFile = (Map<Integer, Bus>) ois.readObject();

				return bFile;

			}

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		return bFile;
	}

	public static Map<String, Passenger> passengerFile() {

		Map<String, Passenger> pFile = null;

		File f = new File("passenger.ser");
		boolean flag = false;
		try {
			if (!f.exists()) {
				f.createNewFile();
				flag = true;
			}

			if (flag) {
				
				pFile = new LinkedHashMap<>();
				ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(f));
				oos.writeObject(pFile);
				return pFile;

			} else {
				
				ObjectInputStream ois = new ObjectInputStream(new FileInputStream(f));
				pFile = (Map<String, Passenger>) ois.readObject();

				return pFile;

			}

		} catch (Exception e) {
			// TODO: handle exception

			System.out.println(e.getMessage());
		}
		return pFile;

	}

	public static List<Transaction> transactionFile() {

		List<Transaction> tFile = new ArrayList<>();

		File f = new File("Transactions.ser");
		boolean flag = false;
		try {
			if (!f.exists()) {
				f.createNewFile();
				flag = true;
			}

			if (flag) {
				tFile =  new ArrayList<>();
				ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(f));
				oos.writeObject(tFile);

				return tFile;

			} else {

				ObjectInputStream ois = new ObjectInputStream(new FileInputStream(f));
				tFile = (List<Transaction>) ois.readObject();
				return tFile;

			}

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}

		return tFile;

	}

}
