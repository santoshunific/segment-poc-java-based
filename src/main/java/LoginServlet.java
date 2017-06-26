
import com.segment.analytics.Analytics ;
import com.segment.analytics.messages.TrackMessage ;
import com.segment.analytics.messages.IdentifyMessage;

import java.util.HashMap ;
import java.util.Map ;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		request.getRequestDispatcher("link.html").include(request, response);
		
		String name=request.getParameter("name");
		String password=request.getParameter("password");
		


		Map<String, String> itemBought = new HashMap<String, String>();
        	itemBought.put("Banana", "25");
        	itemBought.put("Guava",  "48");

		if(password.equals("admin123"))
		{
			//My Work Spave Earth
		      	Analytics analytics = Analytics.builder("aOo8OQMQvfVCTOtUAZ2Ws0VldLMoi0EV").build();
	
			//Unific Work Space
			//Analytics analytics = Analytics.builder("PYBCpzHAU8oK3lMpVfoRnvr7OwxsTvXv").build();


			//Below Commented Code is working.
			      	
				analytics.enqueue(TrackMessage.builder("unific_item_event")
		    			.userId( name )
					.properties(itemBought)

				//Not get any solution mailing with Sement Support
				/*
				    .properties(ImmutableMap.builder()
					.put("ip", "12.212.12.49")
					.put("language", "en-us")
					.build()
				    )
				*/
				);

                        analytics.flush() ;

			out.print("Welcome, "+name);
			HttpSession session=request.getSession();
			session.setAttribute("name",name);
		}
		else{
			out.print("Sorry, username or password error!");
			request.getRequestDispatcher("login.html").include(request, response);
		}
		out.close();
	}

}
