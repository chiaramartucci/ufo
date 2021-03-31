package it.polito.tdp.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SightingDAO {
	// classe nella quale si metteranno i metodi di accesso al
	// database
	
	String jdbcURL = "jdbc:mysql://localhost/ufo_sightings?user=root&password=chiara";
	
	public List <String> readShapes(){
		try {
		Connection conn = DriverManager.getConnection(jdbcURL);
		
		String sql = "SELECT DISTINCT shape"
				+ " FROM sighting"
				+ " WHERE shape<>''"
				+ " ORDER BY shape ASC";
		
		PreparedStatement st = conn.prepareStatement(sql);
		
		ResultSet res = st.executeQuery(sql);
		
		List<String> formeUFO = new ArrayList<>();
		while (res.next()) {
			String forma = res.getString("shape");
			formeUFO.add(forma);
		}
		st.close();
		
		return formeUFO;
	} catch(SQLException e) {
		throw new RuntimeException("Database error in readShapes", e);
	}
	
	public ing countByShape (String shape) {
		
	}
}
