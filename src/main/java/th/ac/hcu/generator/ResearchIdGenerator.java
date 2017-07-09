package th.ac.hcu.generator;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.Date;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SessionImplementor;
import org.hibernate.id.IdentifierGenerator;

public class ResearchIdGenerator implements IdentifierGenerator{

	String prefix = "MR";
	
	@Override
	public Serializable generate(SessionImplementor session, Object object) throws HibernateException {
		
		Date date = new Date();
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		int year = calendar.get(Calendar.YEAR);
		
		try {
			Connection connection = session.connection();
			PreparedStatement ps = connection .prepareStatement("SELECT sequence_next_hi_value as value from hibernate_sequences where upper(sequence_name) = upper('master_research') ");
			ResultSet rs = ps.executeQuery();
			int initId = 1;
			String initIdStr = String.format("%04d", initId);
			String code = prefix + year + initIdStr;
			if (rs.next()) {
				int id = rs.getInt("value");
				id++;
				String idStr = String.format("%04d", id);
	            code = prefix + year + idStr;
	            System.out.println("Generated Stock Code: " + code);
	            StringBuilder sb = new StringBuilder();
	        	sb.append(" UPDATE hibernate_sequences SET sequence_next_hi_value = '"+id+"'  WHERE upper(sequence_name) = upper('master_research') ");
	        	PreparedStatement update = connection .prepareStatement(sb.toString());
	        	update.executeUpdate();
	        } else {
	        	StringBuilder sb = new StringBuilder();
	        	sb.append(" INSERT INTO hibernate_sequences (sequence_name, sequence_next_hi_value) VALUES('master_research', '1') ");
	        	PreparedStatement insert = connection .prepareStatement(sb.toString());
	        	insert.executeUpdate();
	        }
			
			return code;
		} catch (SQLException e) {
			e.printStackTrace();
		}

       
		return null;
	}

}
