package ua.lviv.lgs;

public class Model {
	private int id;
	private String name;
	private int height;
	private int weight;

	public Model(int id, String name, int height, int weight) {
		this.id = id;
		this.name = name;
		this.height = height;
		this.weight = weight;
	}

	public Model(String name, int height, int weight) {
		super();
		this.name = name;
		this.height = height;
		this.weight = weight;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	@Override
	public String toString() {
		return "Model [id=" + id + ", name=" + name + ", height=" + height + ", weight=" + weight + "]";
	}
}