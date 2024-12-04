package week3.day3.assignment;

public class DatabaseConnections implements DatabseConnection{

	@Override
	public void connect() {
		System.out.println("Connection established");
	}

	@Override
	public void disconnect() {
		System.out.println("disconnected");
	}

	@Override
	public void executeUpdate() {
		System.out.println("updated records");
	}
	
	public static void main(String[] args) {
		//Using class
		DatabaseConnections db = new DatabaseConnections();
		db.connect();
		db.executeUpdate();
		db.disconnect();
		
		//Using interface reference
		DatabseConnection iDb = new DatabaseConnections();
		iDb.connect();
		iDb.executeUpdate();
		iDb.disconnect();
	}
}
