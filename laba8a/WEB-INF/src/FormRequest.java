package chapt18;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;


public class FormRequest extends HttpServlet
{
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException
    {
        performTask(req, resp);
    }

    private void performTask(HttpServletRequest req, HttpServletResponse resp)
    {
            try {
            String name, value, result = "", radiob = "";
            int a = 0, b = 0, c = 0, d = 0, e = 0;
            int flag = 0;
            resp.setContentType("text/html; charset=utf-8");
            PrintWriter out = resp.getWriter();

            out.print("<HTML><HEAD>");
            out.print("<TITLE>Result</TITLE>");
            out.print("</HEAD><BODY>");
			out.print("<H3>" + "Result:" + "<H3>");
			
			radiob = req.getParameter("v");
            Enumeration names = req.getParameterNames();

            while (names.hasMoreElements())
            {
                name = (String) names.nextElement();
                value = req.getParameterValues(name)[0];
/*	
name = new String(name.getBytes("ISO-8859-1"), "utf-8");
value = new String(value.getBytes("ISO-8859-1"), "utf-8");
*/
                if (name.equals("a")) a = Integer.parseInt(value);
                if (name.equals("b")) b = Integer.parseInt(value);
                if (name.equals("c")) c = Integer.parseInt(value);
                if (name.equals("d")) d = Integer.parseInt(value);
                if (name.equals("e")) e = Integer.parseInt(value);

			if ((a !=0 && b !=0 && c!=0) || radiob.equals("4") || radiob.equals("5") || (a != 0 && (radiob.equals("2") || radiob.equals("3")))) break;
            }
	
            if (radiob.equals("1"))
            {
             result = Double.toString(a*b*c);
            }
            if (radiob.equals("2"))
            {
                result = Double.toString(Math.pow(a, 3) * Math.pow(2, 1./2) / 12);
            }
            if (radiob.equals("3"))
            {
                result = Double.toString(Math.pow(a, 3));
            }
            if (radiob.equals("4"))
            {
				d = Integer.parseInt(req.getParameter("d"));
                result = Double.toString(4 * 3.14 * Math.pow(d, 3) / 3);
            }
            if (radiob.equals("5"))
            {
				e = Integer.parseInt(req.getParameter("e"));
				d = Integer.parseInt(req.getParameter("d"));
                result = Double.toString(2 * Math.pow(3.14, 2) * d * Math.pow(e, 2) );
            }
			
            out.print("<TR>");
			out.print("<TABLE BORDER=3>");
            out.print("<TD>Result</TD>");
            out.print("<TD>" + result + "</TD>");
            out.print("</TR>");
            out.print("</TABLE></BODY></HTML>");
            out.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

