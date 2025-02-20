package za.ac.TextSpectaclesServelet;

import ac.za.tut.exception.EmptyValueException;
import ac.za.tut.exception.MessageContainsDigitsException;
import ac.za.tut.textspectaclessb.lb.TextSpectaclesEJBLocal;
import java.io.IOException;
import java.util.Map;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TextSpectaclesServelet extends HttpServlet {

    @EJB
    private TextSpectaclesEJBLocal sb;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String message = request.getParameter("text");

        try {
            Map<String, Integer> wordsOccurenceMap = sb.frequencyWordsOccurrence(message);
           request.setAttribute("wordsOcdcurenceMap", wordsOccurenceMap);
            fowardRequest(request, response);
        } catch (EmptyValueException ex) {

            sendErrorMesssage(request,response, ex);

        } catch (MessageContainsDigitsException ex) {
           sendErrorMesssage(request,response, ex);
        } catch (Exception ex) {
            sendErrorMesssage(request,response, ex);
        }

    }

    private void sendErrorMesssage(HttpServletRequest request,HttpServletResponse response, Exception e) throws ServletException, IOException {
        
        request.setAttribute("errorMessage", e);
        fowardErrorRequest(request,response);
    }

    private void fowardRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher disp = request.getRequestDispatcher("Outcome.jsp");
        disp.forward(request, response);
    }
        private void fowardErrorRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher disp = request.getRequestDispatcher("error.jsp");
        disp.forward(request, response);
    }
}
