package ua.lviv.lgs;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Application {
	public static void main(String[] args)
			throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {

		ModelDao modelDao = new ModelDao(ConnectionUtils.openConnection());

		// READ-ALL
		modelDao.readAll().forEach(System.out::println);
		System.out.println("************************************************\n");

		List<Model> listOfModel = new ArrayList<>();
		listOfModel.add(new Model("Zina Terry", 168, 62));
		listOfModel.add(new Model("Debra Willy", 185, 70));
		listOfModel.add(new Model("Nina Kinny", 172, 49));
		listOfModel.add(new Model("Ogha Rossi", 180, 72));
		listOfModel.add(new Model("Ruby Karima", 174, 60));

		
			for(Model m: listOfModel) {
				try {
					modelDao.insert(m);
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		// INSERT
//		listOfModel.forEach(model -> {
//			try {
//				modelDao.insert(model);
//			} catch (SQLException e) {
//				e.printStackTrace();
//			}
//		});

		// READ-ALL
		modelDao.readAll().forEach(System.out::println);
		System.out.println("************************************************\n");

		// READ-ById
		Model modelFromBD = modelDao.read(1);
		System.out.println(modelFromBD);

		// UPDATE - ById
		modelFromBD.setName(modelFromBD.getName() + "-Rossiny");
		modelDao.update(modelFromBD);

		// READ-ALL
		modelDao.readAll().forEach(System.out::println);
		System.out.println("************************************************\n");

		modelDao.delete(5);

		// READ-ALL
		modelDao.readAll().forEach(System.out::println);
		System.out.println("************************************************\n");

	}
}