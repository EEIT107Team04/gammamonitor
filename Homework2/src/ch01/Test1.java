package ch01;

import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Test1
 */
@WebServlet("/Test1")
public class Test1 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		System.out.println("Test1 doPost() method");
		// 設定輸入資料的編碼

		HttpSession session = request.getSession();
		Map<String, String> errorMessage = new HashMap<>();
		request.setAttribute("ErrorMsg", errorMessage);

		System.out.println("Test1 doPost() method-2");

		String place = request.getParameter("place");
		// 檢查使用者所輸入的資料
		if (place == null || place.trim().length() == 0) {
			errorMessage.put("place", "必須輸入");
			System.out.println(place);
		}

		System.out.println("Test1 doPost() method-3");

		String station = request.getParameter("station");
		// 檢查使用者所輸入的資料
		if (station == null || station.trim().length() == 0) {
			errorMessage.put("station", "欄必須輸入");
		}
		// 讀取使用者所輸入，由瀏覽器送來的 mName 欄位內的資料
		String measurements = request.getParameter("measurements");

		if (measurements == null || measurements.trim().length() == 0) {
			errorMessage.put("measurements", "欄必須輸入");
		}
		String live = request.getParameter("live");
		// 檢查使用者所輸入的資料
		if (live == null || live.trim().length() == 0) {
			errorMessage.put("live", "欄必須輸入");
		}

		String longitude = request.getParameter("longitude");

		if (longitude == null || longitude.trim().length() == 0) {
			errorMessage.put("longitude", "欄必須輸入");
		}

		String latitude = request.getParameter("latitude");
		// 檢查使用者所輸入的資料
		if (latitude == null || latitude.trim().length() == 0) {
			errorMessage.put("latitude", "欄必須輸入");
		}

		System.out.println("before !errorMessage.isEmpty()");

		if (!errorMessage.isEmpty()) {
			RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
			rd.forward(request, response);
			return;
		}
		// MemberBean 扮演封裝輸入資料的角色
		System.out.println("after !errorMessage.isEmpty()");

		MemberBean mb = new MemberBean(place, station, measurements, live, longitude, latitude);
		try {
			MemberService service = new MemberService();
			service.insertMember(mb);
			// 依照執行的結果挑選適當的view元件，送回相關訊息
			// 產生 RequestDispatcher 物件 rd
			session.setAttribute("MemberBean", mb);
			RequestDispatcher rd = request.getRequestDispatcher("successful.jsp");
			rd.forward(request, response);
			return;
		} catch (SQLException e) {
			if (e.getMessage().indexOf("重複的索引鍵") != -1 || e.getMessage().indexOf("Duplicate entry") != -1) {
				errorMessage.put("id", "帳號重複，請重新輸入帳號");
				e.printStackTrace();
			} else {
				errorMessage.put("exceptison", "資料庫存取錯誤:" + e.getMessage());
				e.printStackTrace();
			}
			RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
			rd.forward(request, response);
			return;
		}
	}// end of doPost method

}// end of Test1 class
