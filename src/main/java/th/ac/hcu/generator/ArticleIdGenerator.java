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

public class ArticleIdGenerator implements IdentifierGenerator{

	String prefix = "MA";
	
	@Override
	public Serializable generate(SessionImplementor session, Object object) throws HibernateException {
		
		Date date = new Date();
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		int year = calendar.get(Calendar.YEAR);
		
		try {
			Connection connection = session.connection();
			PreparedStatement ps = connection .prepareStatement("SELECT sequence_next_hi_value as value from hibernate_sequences where upper(sequence_name) = upper('master_article') ");
			ResultSet rs = ps.executeQuery();
			int initId = 1;
			String initIdStr = new Integer(initId).toString();
			initIdStr = ("0000"+initIdStr).substring(initIdStr.length());
			String code = prefix + year + initIdStr;
			if (rs.next()) {
				int id = rs.getInt("value");
				id++;
				String idStr = new Integer(id).toString();
				idStr = ("0000"+idStr).substring(idStr.length());
	            code = prefix + year + idStr;
	            System.out.println("Generated Stock Code: " + code);
	            StringBuilder sb = new StringBuilder();
	        	sb.append(" UPDATE hibernate_sequences SET sequence_next_hi_value = '"+id+"'  WHERE upper(sequence_name) = upper('master_article') ");
	        	PreparedStatement update = connection .prepareStatement(sb.toString());
	        	update.executeUpdate();
	        } else {
	        	StringBuilder sb = new StringBuilder();
	        	sb.append(" INSERT INTO hibernate_sequences (sequence_name, sequence_next_hi_value) VALUES('master_article', '1') ");
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