package ua.lviv.lgs;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ModelDao {
	private static String READ_ALL = "select * from models";
	private static String CREATE = "insert into models(`name`, `height', 'weight') values ('?','?','?')";
	private static String READ_BY_ID = "select * from models where id =?";
	private static String UPDATE_BY_ID = "update models set name=?, height = ?, weight=? where id = ?";
	private static String DELETE_BY_ID = "delete from models where id=?";

	private Connection connection;
	private PreparedStatement preparedStatement;

	public ModelDao(Connection connection) {
		this.connection = connection;
	}

	public void insert(Model model) throws SQLException {
		preparedStatement = connection.prepareStatement(CREATE);
		preparedStatement.setString(1, model.getName());
		preparedStatement.setInt(2, model.getHeight());
		preparedStatement.setInt(3, model.getWeight());
		preparedStatement.executeUpdate();
	}

	public Model read(int id) throws SQLException {
		preparedStatement = connection.prepareStatement(READ_BY_ID);
		preparedStatement.setInt(1, id);
		ResultSet result = preparedStatement.executeQuery();
		result.next();
		return ModelMapper.map(result);
	}

	public void update(Model model) throws SQLException {
		preparedStatement = connection.prepareStatement(UPDATE_BY_ID);
		preparedStatement.setInt(1, model.getId());
		preparedStatement.setString(2, model.getName());
		preparedStatement.setInt(3, model.getHeight());
		preparedStatement.setInt(4, model.getWeight());
		preparedStatement.executeUpdate();
	}

	public void delete(int id) throws SQLException {
		preparedStatement = connection.prepareStatement(DELETE_BY_ID);
		preparedStatement.setInt(1, id);
		preparedStatement.executeUpdate();
	}

	public List<Model> readAll() throws SQLException {
		List<Model> listOfModel = new ArrayList<>();
		preparedStatement = connection.prepareStatement(READ_ALL);
		ResultSet result = preparedStatement.executeQuery();
		while (result.next()) {
			listOfModel.add(ModelMapper.map(result));
		}
		return listOfModel;
	}

}
