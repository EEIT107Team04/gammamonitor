package ch01;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.List;
import java.util.Vector;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import java.sql.Connection;

public class MemberDao {

	DataSource ds = null;

	public MemberDao() {
		try {
			System.out.println("MemberDao contructor.");
			Context context = new InitialContext();
			ds = (DataSource) context.lookup("java:comp/env/jdbc/MemberDB");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}

	private static final String SELECT_BY_ID = "Select place, station, measurements, live, logitude, latitude from station where place = ?";

	public MemberBean select(String id) {
		MemberBean result = null;
		try (

				Connection conn = ds.getConnection();
				PreparedStatement stmt = conn.prepareStatement(SELECT_BY_ID);) {
			stmt.setString(1, id);
			try (ResultSet rset = stmt.executeQuery();) {
				if (rset.next()) {
					result = new MemberBean();
					result.setPlace(rset.getString("place"));
					result.setStation(rset.getString("station"));
					result.setMeasurements(rset.getString("measurements"));
					result.setLive(rset.getString("live"));
					result.setLongitude(rset.getString("longitude"));
					result.setLatitude(rset.getString("latitude"));

				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	private static final String SELECT_ALL = "Select place, station, meausrements, live, longitude, latitude from station";

	public List<MemberBean> select() {
		List<MemberBean> result = null;
		try (Connection conn = ds.getConnection();
				PreparedStatement stmt = conn.prepareStatement(SELECT_ALL);
				ResultSet rset = stmt.executeQuery();) {
			result = new Vector<>();
			while (rset.next()) {
				MemberBean temp = new MemberBean();
				temp.setPlace(rset.getString("place"));
				temp.setStation(rset.getString("station"));
				temp.setMeasurements(rset.getString("measurements"));
				temp.setLive(rset.getString("live"));
				temp.setLongitude(rset.getString("longitude"));
				temp.setLatitude(rset.getString("latitude"));

				result.add(temp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	private static final String INSERT = "Insert into station (place, station, measurements, live, longitude, latitude) values (?, ?, ?, ?, ?, ?)";

	public MemberBean insertMember(MemberBean bean) throws SQLException {
		MemberBean result = null;
		try (Connection conn = ds.getConnection(); PreparedStatement stmt = conn.prepareStatement(INSERT);) {
			stmt.setString(1, bean.getPlace());
			stmt.setString(2, bean.getStation());
			stmt.setString(3, bean.getMeasurements());
			stmt.setString(4, bean.getLive());
			stmt.setString(5, bean.getLongitude());
			stmt.setString(6, bean.getLatitude());

			int i = stmt.executeUpdate();
			if (i == 1) {
				result = this.select(bean.getPlace());
			}

		}
		return result;
	}

	private static final String DELETE = "Delete from station where place=?";

	public int delete(String place) {
		int result = 0;
		try (Connection conn = ds.getConnection(); PreparedStatement stmt = conn.prepareStatement(DELETE);) {
			stmt.setString(1, place);
			result = stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
}