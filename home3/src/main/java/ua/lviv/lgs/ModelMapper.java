package ua.lviv.lgs;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ModelMapper {
	public static Model map(ResultSet result) throws SQLException {
		int id = result.getInt("id");
		String name = result.getString("name");
		int height = result.getInt("height");
		int weight = result.getInt("weight");

		return new Model(id, name, height, weight);
	}

}
